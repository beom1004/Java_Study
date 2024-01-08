function loginRequire(){
	alert('로그인 후 이용해주세요');
}
window.addEventListener('scroll', function () {
    const headerInner = document.querySelector('.header_inner');
    const header_icon = document.querySelector('.header_icon');
    const header_container = document.querySelector('.header_container');

    if (window.scrollY >= 99) {
        headerInner.style.backgroundColor = 'white';
        header_container.style.borderBottom = '1px solid #ccc';
    } else {
        headerInner.style.backgroundColor = 'transparent';
        header_container.style.borderBottom = 'none';
    }

    headerInner.style.transition = 'all 1s ease';
});

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

function commentModify(){
	document.querySelector('.commentModifyModal').classList.remove('commentModify_hide');
}
document.querySelector('#commentModify_close').addEventListener('click', function () {
    document.querySelector('.commentModifyModal').classList.add('commentModify_hide');
});
document.querySelector('.commentModify_white-bg').addEventListener('click', function (event) {
    event.stopPropagation();
});
document.querySelector('.commentModify_black-bg').addEventListener('click', function () {
    document.querySelector('.commentModifyModal').classList.add('commentModify_hide');
});
