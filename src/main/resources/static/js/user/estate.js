let findbtn = document.querySelector("#findbtn");
let findtype =document.querySelector("#findtype");
let findkey =document.querySelector("#findkey");

findbtn?.addEventListener('click',(e) => {
    if (findkey.value === '') {
        alert('검색어를 입력하세요!!!');
    } else {
        let params = `findtype=${findtype.value}&findkey=${findkey.value}`;
        location.href = `/estate/search?${params}`;
    }
});

