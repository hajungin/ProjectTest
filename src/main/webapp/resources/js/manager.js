$(document).ready(function() {
    // 담당자 이름 클릭 이벤트 처리
    $(".manager-name").on("click", function(e) {
        e.preventDefault(); // 기본 이벤트 동작 방지
        
        // 클릭한 담당자 이름 가져오기
        var selectedManagerName = $(this).data("id");
        
        // POST 요청을 보내고 윈도우 창 닫기
        $.ajax({
            url: '/SelectedManager',
            type: 'POST',
            data: { id: selectedManagerName },
            success: function(data) {
                // POST 요청 완료 후 실행될 코드 작성
                console.log("POST 요청 완료");
                // 윈도우 창 닫기
                window.close();
            },
            error: function(xhr, status, error) {
                console.error("POST 요청 오류:", xhr);
            }
        });
    });
});
