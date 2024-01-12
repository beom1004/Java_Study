document.querySelector('.reply_btn').addEventListener('click', function () {
    document.querySelector('.replyModal').classList.remove('replyModal_hide');
});

document.querySelector('.replyModal_white-bg').addEventListener('click', function (event) {
    event.stopPropagation();
});
// document.querySelector('.replyModifyModal_white-bg').addEventListener('click', function (event) {
//     event.stopPropagation();
// });

document.querySelector('.replyModal_black-bg').addEventListener('click', function () {
    document.querySelector('.replyModal').classList.add('replyModal_hide');
});
// document.querySelector('.replyModalModify_black-bg').addEventListener('click', function () {
//     document.querySelector('.replyModifyModal').classList.add('replyModifyModal_hide');
// });
document.querySelector('#replyModal_close').addEventListener('click', function () {
    document.querySelector('.replyModal').classList.add('replyModal_hide');
});
// document.querySelector('#replyModifyModal_close').addEventListener('click', function () {
//     document.querySelector('.replyModalModal').classList.add('replyModifyModal_hide');
// });