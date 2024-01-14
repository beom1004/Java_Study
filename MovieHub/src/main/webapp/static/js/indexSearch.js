$('#searchKeyword').on("keyup", function (){
	let searchKeyword = $(this).val();
	let searchUl = $('.search_ul');
	
	if (searchKeyword === '') {
        searchUl.addClass('search_hide');
        return;
    }

    $.ajax({
        type: "get",
        url: "getSearchMovieTitle.do",
        data: {"searchKeyword": searchKeyword},
        dataType: "json",
        success: function(data) {
        	searchUl.removeClass('search_hide');
            let html = '';
            let movies = Array.isArray(data) ? data : [data];
            
            $.each(movies, function (index, movie) {
            	html += '<li class="search-movie" data-movie-id="' + movie.movie_id + '">' + movie.title + '</li>';
            });

            searchUl.html(html);
        },
        error: function(error) {
            console.log(error);
            searchUl.addClass('search_hide');
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
