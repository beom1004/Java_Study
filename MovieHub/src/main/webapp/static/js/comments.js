let reviewComment = document.querySelector('#review_comment');
reviewComment.addEventListener('click', function() {
    let replyLists = document.querySelector('.replyLists');
    replyLists.classList.toggle('hide');
});
	
const replyLists = document.querySelectorAll('.replyList');
const replyButtons = document.querySelectorAll('.viewReply');

replyButtons.forEach((button, index) => {
    button.addEventListener('click', function() {
        let replyList = replyLists[index];
        let reReplyContainer = replyList.querySelector('.re_reply_container');
        reReplyContainer.classList.toggle('re_reply_hide');
    });
});

// dropdown
let isMenuOpen = false;

function toggleDropdown() {
    let dropdown = document.getElementById('myDropdown');
    dropdown.classList.toggle('show-dropdown');

    let dropdownIcon = document.getElementsByClassName('expand-icon')[0];
    dropdownIcon.textContent = isMenuOpen ? 'expand_more' : 'keyboard_arrow_up';
    isMenuOpen = !isMenuOpen;
}
window.onclick = function (event) {
    if (!event.target.matches('.dropdown-btn')) {
        let dropdowns = document.getElementsByClassName('dropdown_content');
        let dropdownIcon = document.getElementsByClassName('expand-icon')[0];

        for (let i = 0; i < dropdowns.length; i++) {
            let openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show-dropdown')) {
                openDropdown.classList.remove('show-dropdown');
                dropdownIcon.textContent = 'expand_more';
                isMenuOpen = false;
            }
        }
    }
};





