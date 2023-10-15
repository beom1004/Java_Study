let bigPic = document.querySelector('#cup');
let smallPic = document.querySelectorAll('.small');

for (let i = 0; i < smallPic.length; i++) {
    smallPic[i].addEventListener('click', change);
}

function change() {
    let newPic = this.src;
    bigPic.src = newPic;
}
