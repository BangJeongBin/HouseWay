// 상황별 에러메세지 출력(정규표현식 사용)
const loginMessages = [
    '아이디를 올바르게 입력하세요',
    '비밀번호를 올바르게 입력하세요',
]; // loginMessages



// 상황별 에러메세지 출력(정규표현식 사용)
const checkPwdMessages = [
    '이메일을 올바르게 입력하세요',
]; // checkPwdMessages


// 상황별 에러메세지 출력(정규표현식 사용)
const resetMessages = [
    '재설정할 비밀번호를 입력하세요',
    '확인 비밀번호를 입력하세요',
]; // resetMessages



// 모든 error-message 요소의 내용을 초기화
function clearErrorMessages() {
    document.querySelectorAll(".error-message")
        .forEach(error => error.textContent = '');
} // clearErrorMessages



// 오류메세지 출력
const displayErrorMessages = (input, message) => {
    let error = document.createElement('div');  // error-messaga가 들어갈 <div> 요소 생성
    error.className = 'error-message'   // 생성한 <div> 요소 class 지정 - css 적용을 위함
    error.textContent = message; // 에러메세지 지정
    input.parentElement.appendChild(error); // 지정한 위치에 자식요소로 추가
} // displayErrorMessages



// 로그인 폼 유효성 검사
const validLogin = (form) => {
    let isValid = true;

    // 로그인 폼 안에 모든 input 요소 수집
    const inputs = form.querySelectorAll('input');
    inputs.forEach((input, idx) => {    // input 요소를 하나씩 순회하며 검사
        if (!input.checkValidity()) {    // html5 태그를 이용한 유효성 검사
            displayErrorMessages(input, loginMessages[idx]);
            isValid = false;
        }
    });

    return isValid;
} // validLogin



// 로그인 폼 제출
const submitLoginFrm = async (frm) => {
    /*// Web Crypto API로 비밀번호 암호화
    frm.passwd.value = await hashPassword(frm.passwd.value);*/

    const formData = new FormData(frm);

    fetch('/admin/login', {
        method: 'post',
        body: formData
    }).then(async response => {
        if (response.ok) {  // 로그인을 성공했다면
            alert('관리자 로그인을 성공했습니다.')
            location.href = '/admin/index'
        } else if (response.status === 400){
            alert(await response.text());
        } else {
            alert('로그인에 실패했습니다. 다시 시도해 주세요')
        }
    }).catch(error => {
        console.error('join error:', error)
        alert('서버와 통신 실패!')
    });
} // submitLoginFrm



// 비밀번호 체크 폼 유효성 검사
const validCheckPwd = (form) => {
    let isValid = true;

    // 로그인 폼 안에 모든 input 요소 수집
    const inputs = form.querySelectorAll('input');
    inputs.forEach((input, idx) => {    // input 요소를 하나씩 순회하며 검사
        if (!input.checkValidity()) {    // html5 태그를 이용한 유효성 검사
            displayErrorMessages(input, checkPwdMessages[idx]);
            isValid = false;
        }
    });

    return isValid;
} // validResetPwd



// 비밀번호 체크 폼 유효성 검사
const validReset = (form) => {
    let isValid = true;

    // 로그인 폼 안에 모든 input 요소 수집
    const inputs = form.querySelectorAll('input');
    inputs.forEach((input, idx) => {    // input 요소를 하나씩 순회하며 검사
        if (!input.checkValidity()) {    // html5 태그를 이용한 유효성 검사
            displayErrorMessages(input, resetMessages[idx]);
            isValid = false;
        }
    });

    return isValid;
} // validLogin
