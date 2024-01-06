const menuList = document.querySelector('.menu_list');
const initialMenu = document.querySelector('.information');
let curMenu = null;

initialMenu.style.color = 'rgb(45, 56, 70)';
curMenu = initialMenu;

menuList.addEventListener('click', function (event) {
    const menu = event.target;

    if (curMenu !== null) {
        curMenu.style.color = 'gray';
    }

    if (menu.classList.contains('information')) {
        menu.style.color = 'rgb(45,56,70)';
        showInfo('.setting_info');
        hideInfo('.password_info');
        hideInfo('.withdrawl_info');
        
    } else if (menu.classList.contains('pw_confirm')) {
        menu.style.color = 'rgb(45,56,70)';
        hideInfo('.setting_info');
        showInfo('.password_info');
        
        hideInfo('.withdrawl_info');
    } else if (menu.classList.contains('delete_info')) {
        menu.style.color = 'rgb(45,56,70)';
        hideInfo('.setting_info');
        hideInfo('.password_info');
        showInfo('.withdrawl_info');
    }
    curMenu = menu;
});

function showInfo(selector) {
    const infoElement = document.querySelector(selector);
    infoElement.classList.remove('hide');
}

function hideInfo(selector) {
    const infoElement = document.querySelector(selector);
    infoElement.classList.add('hide');
}

const pwBtns = document.querySelectorAll('.pw_btn');

pwBtns.forEach(function (pwBtn) {
    pwBtn.addEventListener('click', function () {
        const passwordInput = this.previousElementSibling;
        if (passwordInput.type === 'password') {
            passwordInput.type = 'text';
            pwBtn.textContent = '숨김';
        } else {
            passwordInput.type = 'password';
            pwBtn.textContent = '보기';
        }
    });
});
