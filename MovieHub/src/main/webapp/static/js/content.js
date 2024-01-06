window.addEventListener('scroll', function () {
    const headerInner = document.querySelector('.header_inner');
    const title = this.document.querySelector('.header_title');

    if (window.scrollY >= 99) {
        headerInner.style.backgroundColor = 'white';
        title.style.borderBottom = '1px solid gray';
    } else {
        headerInner.style.backgroundColor = 'transparent';
        title.style.borderBottom = 'none';
    }

    headerInner.style.transition = 'all 1s ease';
});