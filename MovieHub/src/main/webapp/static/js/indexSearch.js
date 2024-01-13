$('#searchKeyword').on("keyup", function (){
	let searchKeyword = $(this).val();
	if (searchKeyword === '') {
        $('.search_ul').html(''); 
        return;
    }

    $.ajax({
        type: "get",
        url: "getSearchMovieTitle.do",
        data: {"searchKeyword": searchKeyword},
        success: function(data) {
            let html = '';
            $.each(data, function (index, movie) {
                html += '<li>' + movie + '</li>';
            });

            $('.search_ul').html(html);
        },
        error: function(error) {
            console.log(error);
        }
    });
});

$('#searchKeyword').on("change", function (){
    $('.ajaxData').html('');
});

// $('#search_btn').on("click", searchFunc);