// 매물 수정 폼 제출
const submitEstateModifyFrm = async (frm) => {
    /*// Web Crypto API로 비밀번호 암호화
    frm.passwd.value = await hashPassword(frm.passwd.value);*/

    const formData = new FormData(frm);

    fetch('/admin/product_modifyOk', {
        method: 'post',
        body: formData
    }).then(async response => {
        if (response.ok) {
            alert('매물 수정을 성공했습니다.')
            location.href = '/admin/product'
        } else if (response.status === 400){
            alert(await response.text());
        } else {
            alert('매물 수정에 실패했습니다. 다시 시도해 주세요')
        }
    }).catch(error => {
        console.error('join error:', error)
        alert('서버와 통신 실패!')
    });
} // submitEstateModifyFrm
