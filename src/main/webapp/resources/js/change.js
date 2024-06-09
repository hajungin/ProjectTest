$(document).ready(function() {
    // "변경" 버튼 클릭 이벤트 핸들러
    $("#saveChanges").on("click", function() {
        // 폼 필드의 값들을 가져옴
        var writingDate = $("#writingDate").val();
        var customerName = $("#customerName").val();
        var realNumber = $("#realNumber").val();
        var email = $("#email").val();
        var phoneNumber = $("#phoneNumber").val();
        var mobileNumber = $("#mobileNumber").val();
        var job = $("#job").val();
        var address = $("#address").val();

        // 가져온 값들을 객체로 만듦
        var customerDto = {
        	last_mdfcn_dt: writingDate,
        	cust_nm: customerName,
        	pridtf_no: realNumber,
        	eml_addr: email,
        	home_telno: phoneNumber,
        	mbl_telno: mobileNumber,
        	cr_nm: job,
        	road_nm_addr: address
        };

        // AJAX 요청으로 서버에 데이터 전송
        $.ajax({
            url: "/saveCustomerData",
            type: "post",
            data: JSON.stringify(customerDto),
            contentType: "application/json",
            success: function(response) {
                alert("고객 정보가 성공적으로 저장되었습니다.");
            },
            error: function(error) {
                alert("고객 정보 저장 중 오류가 발생했습니다.");
            }
        });
    });
});
