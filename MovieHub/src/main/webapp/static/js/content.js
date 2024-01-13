function modifyComment(){
	document.querySelector('.commentModifyModal').classList.remove('commentModify_hide');
}
function deleteComment(event){
	event.preventDefault();
	if(confirm("정말 삭제하시겠습니까?")){
		const url = document.querySelector("#comment_remove a").getAttribute("href");
		window.location.href=url;
	}
}
document.querySelector('#comment_remove').addEventListener("click", deleteComment);

function loginRequire(){
	alert('로그인 후 이용해주세요');
	return false;
}
const text_1 = document.querySelector('#text_1');
let charCount_1 = document.querySelector('.charCount_1');
const text_2 = document.querySelector('#text_2');
let charCount_2 = document.querySelector('.charCount_2');

text_1.addEventListener('keyup', function () {
    let charCount = text_1.value.length;

    charCount_1.textContent = charCount;
});

text_2.addEventListener('keyup', function () {
    let charCount = text_2.value.length;

    charCount_2.textContent = charCount;
});

function commentFunc(){
	document.querySelector('.commentModal').classList.remove('comment_hide');
}
document.querySelector('.comment_white-bg').addEventListener('click', function (event) {
    event.stopPropagation();
});
document.querySelector('.commentModify_white-bg').addEventListener('click', function (event) {
    event.stopPropagation();
});

document.querySelector('.comment_black-bg').addEventListener('click', function () {
    document.querySelector('.commentModal').classList.add('comment_hide');
});
document.querySelector('.commentModify_black-bg').addEventListener('click', function () {
    document.querySelector('.commentModifyModal').classList.add('commentModify_hide');
});
document.querySelector('#commentModify_close').addEventListener('click', function () {
    document.querySelector('.commentModifyModal').classList.add('commentModify_hide');
});
document.querySelector('#comment_close').addEventListener('click', function () {
    document.querySelector('.commentModal').classList.add('comment_hide');
});

