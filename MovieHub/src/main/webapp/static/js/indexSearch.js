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
        dataType: "json",
        success: function(data) {
            let html = '';
            let movies = Array.isArray(data) ? data : [data];
            
            $.each(movies, function (index, movie) {
            	html += '<li class="search-movie" data-movie-id="' + movie.movie_id + '">' + movie.title + '</li>';
            });

            $('.search_ul').html(html);
        },
        error: function(error) {
            console.log(error);
        }
    });
});

$('.search_ul').on("click", ".search-movie", function () {
    let selectedMovieId = $(this).data('movie-id');
    window.location.href = 'content.do?movie_id=' + selectedMovieId;
});

$('#searchKeyword').on("change", function (){
    $('.ajaxData').html('');
});
