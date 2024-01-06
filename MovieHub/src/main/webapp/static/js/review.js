const review_comment = document.querySelector('#review_comment');

review_comment.addEventListener('click', function () {
    const replyLists = document.querySelector('.replyLists');

    if (replyLists.classList.contains('hide')) {
        replyLists.classList.remove('hide');
    } else {
        replyLists.classList.add('hide');
    }
});

const replyModal = document.querySelector('.replyModal');
const comment_btn = document.querySelector('.comment_btn');
const close = document.querySelector('.close');
const textarea = document.querySelector('textarea');
let charCountSpan = document.querySelector('.charCount');

textarea.addEventListener('click', function (event) {
    event.stopPropagation();
});

comment_btn.addEventListener('click', function () {
    if (replyModal.classList.contains('noShow')) {
        replyModal.classList.remove('noShow');
    } else {
        replyModal.classList.add('noShow');
    }
});
close.addEventListener('click', function () {
    if (replyModal.classList.contains('noShow')) {
        replyModal.classList.remove('noShow');
    } else {
        replyModal.classList.add('noShow');
    }
});
textarea.addEventListener('keyup', function () {
    let charCount = textarea.value.length;

    charCountSpan.textContent = charCount;
});
