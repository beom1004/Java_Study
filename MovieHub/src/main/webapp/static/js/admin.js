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
