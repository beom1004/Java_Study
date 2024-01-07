function commentFunc(){
	document.querySelector('.commentModal').classList.remove('comment_hide');
}
document.querySelector('#comment_close').addEventListener('click', function () {
    document.querySelector('.commentModal').classList.add('comment_hide');
});
document.querySelector('.comment_white-bg').addEventListener('click', function (event) {
    event.stopPropagation();
});
document.querySelector('.comment_black-bg').addEventListener('click', function () {
    document.querySelector('.commentModal').classList.add('comment_hide');
});