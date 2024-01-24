function userDeleteConfirm(userId){
	alert("유저 삭제를 진행합니다. 정말로 삭제하시겠습니까?");
	const userConfirmation = confirm("유저를 삭제하시겠습니까?");
	
	if (userConfirmation) {
        window.location.href = `/userDelete.do?id=${userId}`;
    } else {
        alert("삭제가 취소되었습니다.");
    }
}

function showTab(tabName) {
    let tabs = document.querySelectorAll('.tab_content');
    tabs.forEach(function (tab) {
        tab.style.display = 'none';
    });

    let selectedTab = document.querySelector('.' + tabName);
    if (selectedTab) {
        selectedTab.style.display = 'block';
    }
}

function submitForm(tabName) {
    showTab(tabName);
}