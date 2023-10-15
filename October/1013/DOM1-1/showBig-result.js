var pic = document.querySelector('#pic');

pic.addEventListener('mouseover', changePic, false);
// 			①	②	③

function changePic() {
    pic.src = 'images/boy.png';
}
function originPic() {
    pic.src = 'images/girl.png';
}
