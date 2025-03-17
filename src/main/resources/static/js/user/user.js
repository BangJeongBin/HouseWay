// let chgNavUser = document.getElementById('userLoginNav');
// let chgNavAgent = document.getElementById('agentLoginNav');
// let userLoginElement = document.getElementById('login_Frm');
// let agentLoginElement = document.getElementById('login_Frm2');
//
// // 공인중개사 로그인 메뉴 클릭 시
// chgNavAgent?.addEventListener('click', (e) => {
//     agentLoginElement.classList.remove('d-none');
//     chgNavUser.classList.remove('active');
//     chgNavAgent.classList.add('active');
//     userLoginElement.replaceWith(agentLoginElement);
// });
// // 일반 로그인 메뉴 클릭 시
// chgNavUser?.addEventListener('click', (e) => {
//     chgNavAgent.classList.remove('active');
//     chgNavUser.classList.add('active');
//     agentLoginElement.replaceWith(userLoginElement)
// });
//
// // 로그인 화면에서 회원가입 버튼 클릭 시 회원가입 페이지 이동
// let gojoinFrm = document.querySelector('.join');
// gojoinFrm?.addEventListener('click', (e) => {
//     location.href = 'join';
// });
//
// // 아이디 찾기 버튼 클릭 시 팝업 찯
// let findID = document.getElementById('find_id');
// findID?.addEventListener('click', (e) => {
//     let ret = window.open('/joinForm.html', '_blank', 'width=500,height=500');
// });
//
// // 비밀번호 찾기 클릭 시 팝업 창
// let findPWd = document.getElementById('find_pwd');
// findPWd?.addEventListener('click', (e) => {
//     let ret = window.open('/joinForm.html', '_blank', 'width=500,height=500');
// });


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
    /^[a-z][a-z0-9]{5,17}$/,  // 아이디 패턴
    /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{6,18}$/,  // 비밀번호 패턴
    /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+$/, // 이메일 패턴
    /^[가-힣|a-zA-Z]+$/ // 이름 패턴 (영문/한글)
];

// 모든 error-message 요소의 내용을 초기화
function clearMessages() {
    document.querySelectorAll(".error-message")
        .forEach(error => error.textContent = '');
}

// 회원가입 유효성 검사
const validInputs = (form) => {
    let isValid = true;

    // 회원가입 폼 안의 모든 input 요소 수집
    const inputs = form.querySelectorAll('input');
    console.log(inputs);

    // 비밀번호와 비밀번호 확인 필드를 명확하게 구분
    const passwordInput = inputs[2];  // 비밀번호 입력 필드 (3번째)
    const confirmPasswordInput = inputs[3];  // 비밀번호 확인 필드 (4번째)

    // 비밀번호 유효성 검사 (패턴을 사용)
    if (!patterns[1].test(passwordInput.value)) {
        displayErrorsMessages(passwordInput, errorMessages[2]);  // 3번째 오류 메시지
        isValid = false;
    }

    // 비밀번호 확인이 비밀번호와 일치하는지 확인
    if (passwordInput.value !== confirmPasswordInput.value) {
        displayErrorsMessages(confirmPasswordInput, errorMessages[3]);  // 4번째 오류 메시지
        isValid = false;
    }

    // 나머지 입력값 유효성 검사
    inputs.forEach((input, idx) => {
        // 비밀번호와 비밀번호 확인 필드를 제외
        if (idx !== 2 && idx !== 3 && !input.checkValidity()) {
            displayErrorsMessages(input, errorMessages[idx]);
            isValid = false;
        }
    });

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
    const encoder = new TextEncoder();
    const data = encoder.encode(passwd);

    const hashBuffer = await crypto.subtle.digest('SHA-256', data);

    const hashArray = Array.from(new Uint8Array(hashBuffer));
    const hashHex = hashArray.map(byte => byte.toString(16).padStart(2, '0')).join('');

    return hashHex;
}

// 회원가입 폼 제출 - 비동기 처리
const submitJoinfrm = async (frm) => {
    frm.user_password.value = await hashPassword(frm.user_password.value);

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

const loginfrm = document.querySelector('#login_Frm');

// 로그인 버튼 눌렀을 때
loginfrm?.addEventListener("submit", (e) => {
    e.preventDefault();

    clearMessages(); //에러메세지 초기화

    // 입력 요소 유효성 검사
    let isValid = validLogin(e.target);
    if(isValid) submitLoginfrm(e.target);
});

// 로그인 화면 유효성 메세지
const loginMessages = [
    '아이디를 올바르게 입력하세요',
    '비밀번호를 올바르게 입력하세요'
];

// 로그인 폼 유효성 검사
const validLogin = (form) => {
    let isValid = true;

    //로그인 폼 안의 모든 input 요소 수집
    const inputs = form.querySelectorAll('input');

    inputs.forEach((input, idx) => {
        if (!input.checkValidity()) {
            console.log('asdf');
            displayErrorsMessages(input, loginMessages[idx]);
            isValid = false;
        }
    });
    return isValid;
}


//로그인 폼 제출 - 비동기
const submitLoginfrm = async (frm) => {
    frm.user_password.value = await hashPassword(frm.user_password.value);

    const formData = new FormData(frm);

    fetch('/user/login', {
        method : 'post',
        body : formData
    }).then(async response => {
        if(response.ok) {// 로그인이 성공했다면
            alert('로그인에 성공했습니다.');
            location.href = '/user/index_demo';
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

// --------------------

// // 로그인 버튼 눌렀을 때
// agentLoginElement?.addEventListener("submit", (e) => {
//     e.preventDefault();
//
//     clearMessages(); //에러메세지 초기화
//
//     // 입력 요소 유효성 검사
//     let isValid = validAgentLogin(e.target);
//     if(isValid) submitAgentLoginfrm(e.target);
// });

// 로그인 화면 유효성 메세지
const AgentloginMessages = [
    '이름을 올바르게 입력하세요',
    '공인중개사 번호를 올바르게 입력하세요'
];

// 로그인 폼 유효성 검사
const validAgentLogin = (form) => {
    let isValid = true;

    //로그인 폼 안의 모든 input 요소 수집
    const inputs = form.querySelectorAll('input');

    console.log(inputs);
    inputs.forEach((input, idx) => {
        if (!input.checkValidity()) {
            displayErrorsMessages(input, AgentloginMessages[idx]);
            isValid = false;
        }
    });
    return isValid;
}

const submitAgentLoginfrm = async (frm) => {
    const formData2 = new FormData(frm);

    fetch('/agent/agent_login', {
        method : 'post',
        body : formData2
    }).then(async response => {
        if(response.ok) {// 로그인이 성공했다면
            alert('공인중개사 로그인에 성공했습니다.');
            location.href = '/user/index_demo';
        }else if(response.status === 400){
            alert(await response.text());
        }else {//로그인에 실패했다면
            alert('공인중개사 로그인에 실패했습니다. 다시 시도해 주세요');
        }
    }).catch(error => {
        console.error('login error : ', error);
        alert('서버와 통신중 오류가 발생했습니다. 관리자에게 문의하세요.');
    });
}

// -------- mypage

// 내 정보 변경하기 버튼 클릭 시
let ChgMyinfoBtn = document.getElementById('ChgMyinfoBtn');

ChgMyinfoBtn?.addEventListener('click', (e) => {

});

// 탭 전환 시 데이터 로드
function loadTabContent(tabId) {

}

// document.addEventListener("DOMContentLoaded", (e) => {
//     // let userid = [[${user.user_id}]]
//     const currentTabContent = document.body.getAttribute('data-page');
//     if (currentTabContent=='myPage') {
//         console.log("DOMContentLoaded 실행됨"); // 콘솔 출력 확인
//         console.log(userId);
//
//         const tabs = document.querySelectorAll(".nav-link");
//
//         tabs.forEach(tab => {
//             tab.addEventListener("shown.bs.tab", (e) => { // "shown.bs.tab" 사용
//                 console.log("탭 전환됨:", e.target.textContent); // 콘솔 출력
//                 // console.log(tab.id);
//                 fetch(`user/mypage/${tab.id}`,{
//                     method : 'post',
//                     headers : {
//                         'content-type': 'application/json'
//                     } ,
//                     body : JSON.stringify({user_id: userId})
//                 }).then(response => {
//                     if(response.ok) {
//                         alert('tab : ' + tab.id);
//                     }else {
//
//                     }
//                 }).catch(error => {
//                     console.log(error);
//                 });
//             });
//         });
//     }
// });

