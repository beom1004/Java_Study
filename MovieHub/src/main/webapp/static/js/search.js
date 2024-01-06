document.addEventListener('click', function (e) {
    const textBox = document.querySelector('#textBox');
    const searchTrend = document.querySelector('.search_trend');

    if (!(textBox.contains(e.target) || searchTrend.contains(e.target))) {
        searchTrend.style.display = 'none';
    }
});

document.querySelector('#textBox').addEventListener('click', function (e) {
    e.stopPropagation();
    document.querySelector('.search_trend').style.display = 'block';
});

document.querySelector('#close').addEventListener('click', function () {
    document.querySelector('.search_trend').style.display = 'none';
});
