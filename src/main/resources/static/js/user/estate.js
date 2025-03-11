let findbtn = document.querySelector("#findbtn");
let findtype =document.querySelector("#findtype");
let findkey =document.querySelector("#findkey");

findbtn?.addEventListener('click',(e) => {
    if (findkey.value === '') {
        // 검색어가 비어 있을 경우, 전체 매물 목록을 보여줍니다.
        let params = `findtype=${findtype.value}`;
        location.href = `/estate/list?${params}`; // 전체 매물 조회
    } else {
        let params = `findtype=${findtype.value}&findkey=${findkey.value}`;
        console.log(params);
        location.href = `/estate/search?${params}`;
    }


// 지역구 선택 시 검색어 자동 입력
    findtype?.addEventListener("change", function () {
        const selectedValue = this.value;

        // '지역구 선택'이 아닌 경우 입력창에 값 설정
        if (selectedValue !== "all") {
            findkey.value = selectedValue;
        } else {
            findkey.value = ""; // 기본값으로 초기화
        }
    });
});