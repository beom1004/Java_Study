$(function () {
    let isInitialLoad = true;

    function getExistingRating() {
        let rating = $("input[name='rating']").val();
        console.log("jsp에서 hidden으로 보낸 rating: " + rating);
        return parseFloat(rating);
    }

    // input 필드에서 초기 별점 값 가져오기
    let initialRatingFromInput = getExistingRating();
    console.log('Input에서 가져온 초기 별점: ' + initialRatingFromInput);

    // 'insertStar.do' 요청 보내기
    let movie_id = $("input[name='movie_id']").val();
    $.ajax({
        url: 'insertStar.do',
        type: 'POST',
        data: {
            rating: 0, // 초기값으로 0을 보내거나 필요에 따라 조절
            movie_id: movie_id
        },
        dataType: "text",
        success: function (initialRating) {
            console.log('서버에서 가져온 초기 별점: ' + initialRating);
            // 요청이 성공하면 초기 별점을 설정하고 RateYo 초기화
            initRateYo(parseFloat(initialRating));
        },
        error: function (error) {
            console.error('에러 발생 : ', error);
        }
    });

    function initRateYo(initialRating) {
        console.log('RateYo에 설정된 초기 별점: ' + initialRating);
        $('.half-star-ratings').rateYo({
            rating: initialRating, // 초기 별점
            numStars: 5, // 총 별의 개수
            precision: 2, // 소수점 자리수
            halfStar: true, // 반 별까지 허용할지 여부
            starWidth: "45px",
            ratedFill: "#E74C3C",
            onChange: function (rating, rateYoInstance) {
                console.log('별점 변경: ' + rating);
                const formattedRating = rating % 1 === 0 ? rating.toFixed(1) : rating;
                let movie_id = $("input[name='movie_id']").val();

                // Ajax 요청 보내기
                $.ajax({
                    url: 'insertStar.do',
                    type: 'POST',
                    data: {
                        rating: formattedRating,
                        movie_id: movie_id
                    },
                    dataType: "text",
                    success: function (updatedRating) {
                        console.log('서버에서 가져온 업데이트된 별점: ' + updatedRating);
                        rateYoInstance.rating(parseFloat(updatedRating));
                    },
                    error: function (error) {
                        console.error('에러 발생 : ', error);
                    }
                });
            }
        });
    }
});
