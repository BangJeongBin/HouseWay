let chgNavUser = document.getElementById('userLoginNav');
let chgNavAgent = document.getElementById('agentLoginNav');
let userLoginElement = document.querySelector('.form1');
let agentLoginElement = document.querySelector('.form2');

// 공인중개사 로그인 메뉴 클릭 시
chgNavAgent?.addEventListener('click', (e) => {
    agentLoginElement.classList.remove('d-none');
    chgNavUser.classList.remove('active');
    chgNavAgent.classList.add('active');
    userLoginElement.replaceWith(agentLoginElement);
});
// 일반 로그인 메뉴 클릭 시
chgNavUser?.addEventListener('click', (e) => {
    chgNavAgent.classList.remove('active');
    chgNavUser.classList.add('active');
    agentLoginElement.replaceWith(userLoginElement)
});

// 로그인 화면에서 회원가입 버튼 클릭 시
let gojoinFrm = document.querySelector('.join');
gojoinFrm?.addEventListener('click', (e) => {
    location.href = 'join';
});

// 로그인 버튼 클릭 시 유효성 검사
let gologin = document.querySelector('.login');
let id = document.getElementById('userid');
let pwd = document.getElementById('userpwd');
gologin?.addEventListener('click', (e) => {
    if (id.value== '') { alert('아이디를 입력해주세요'); }
    else if (pwd.value == '') { alert('비밀번호를 입력해주세요') }
})

// 아이디 찾기 버튼 클릭 시 팝업 찯
let findID = document.getElementById('find_id');
findID?.addEventListener('click', (e) => {
    let ret = window.open('/joinForm.html', '_blank', 'width=500,height=500');
});

// 비밀번호 찾기 클릭 시 팝업 창
let findPWd = document.getElementById('find_pwd');
findPWd?.addEventListener('click', (e) => {
    let ret = window.open('/joinForm.html', '_blank', 'width=500,height=500');
});

// 유효성 검사


//------------------------------ joinForm
// 회원가입 버튼
const joinfrm = document.querySelector('#joinform');

// 회원가입 버튼 눌렀을 때
joinfrm?.addEventListener("submit", (e) => {
    e.preventDefault();

    clearMessages();

    // 입력 요소 유효성 검사
    let isValid = validInputs(joinfrm);
    if(isValid) submitJoinfrm(joinfrm);
});

const errorMessages = [
    '아이디는 소문자로 시작하고, 영문자와 숫자만 사용 가능합니다 (최소 6자 ~ 최대 18자)',
    '이름을 입력하세요',
    '비밀번호는 영문 대소문자, 숫자, 특수문자를 포함해야 합니다 (최소 6자 ~ 최대 18자)',
    '비밀번호가 일치하지 않습니다',
    '올바른 이메일 형식이 아닙니다',
    '휴대전화 번호를 입력하세요',
    '주소를 입력하세요',
];
// 입력 패턴
const patterns = [
    /^[a-z][a-z0-9]{5,17}$/,
    /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{6,18}$/,
    /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{6,18}$/,
    /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+$/,
    /^[가-힣]|[a-zA-Z]$/
];

// 모든 error-message 요소의 내용을 초기화
function clearMessages() {
    document.querySelectorAll(".error-message")
        .forEach(error => error.textContent = '');
}

// 회원가입 유효성 검사
const validInputs = (form) => {
    let isValid = true;

    //회원가입 폼 안의 모든 input 요소 수집
    const inputs = form.querySelectorAll('input');
    console.log(inputs);
    inputs.forEach((input, idx) => {//input 요소를 하나씩 검사
        if (!input.checkValidity()) {//html5 태그를 이용한 유효성 검사
            displayErrorsMessages(input, errorMessages[idx]);
            isValid = false;
        }
    });

    //일치여부 검사
    if (inputs[1].value !== inputs[2].value) {
        displayErrorsMessages(inputs[2], errorMessages[2]);
        isValid = false;
    }

    return isValid;
}

// 에러메세지 출력될 요소 생성
const displayErrorsMessages = (input, message) => {
    let error = document.createElement('div');
    error.className = 'error-message';
    error.textContent = message;
    input.parentElement.appendChild(error);
}

// 비밀번호 해싱 처리
const hashPassword = async (passwd) => {
    const encoder = new TextEncoder();  // TextEncoder 객체 생성
    const data = encoder.encode(passwd); // 비밀번호를 Uint8Array로 변환

    const hashBuffer = await crypto.subtle.digest('SHA-256', data);

    const hashArray = Array.from(new Uint8Array(hashBuffer)); // Uint8Array를 배열로 변환
    const hashHex = hashArray.map(byte => byte.toString(16).padStart(2, '0')).join(''); // 16진수 문자열로 변환

    return hashHex;
}

// 회원가입 시 데이터 비동기 처리
const submitJoinfrm = async (frm) => {
    alert('asdf');
    frm.user_password.value = await hashPassword(frm.user_password.value);
    console.log(frm.user_password.value);

    const formData = new FormData(frm);

    fetch('/user/join', {
        method : 'post',
        body : formData
    }).then(async response => {
        if(response.ok) {// 회원가입이 정상적으로 처리됬다면
            alert('회원가입이 완료되었습니다.');
            location.href = '/user/login';
        }else if(response.status === 400){
            alert(await response.text());
        }else {
            alert('회원가입에 실패했습니다. 다시 시도해 주세요');
        }
    }).catch(error => {
        console.error('join error : ', error);
        alert('서버와 통신중 오류가 발생했습니다. 관리자에게 문의하세요.');
    });
}

// ------------------


//로그인 폼 제출
const submitLoginfrm = async (frm) => {
    frm.passwd.value = await hashPassword(frm.user_password.value);
    const formData = new FormData(frm);

    fetch('/member/login', {
        method : 'post',
        body : formData
    }).then(async response => {
        if(response.ok) {// 로그인이 성공했다면
            alert('로그인에 성공했습니다.');
            location.href = '/member/myinfo';
        }else if(response.status === 400){
            alert(await response.text());
        }else {//로그인에 실패했다면
            alert('로그인에 실패했습니다. 다시 시도해 주세요');
        }
    }).catch(error => {
        console.error('login error : ', error);
        alert('서버와 통신중 오류가 발생했습니다. 관리자에게 문의하세요.');
    });
}
