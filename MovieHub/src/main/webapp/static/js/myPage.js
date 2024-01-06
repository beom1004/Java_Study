function isLeapYear(year) {
    return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
}
const dayOfWeek = ['일', '월', '화', '수', '목', '금', '토'];
const fullNameOfWeek = [
    'SUNDAY',
    'MONDAY',
    'TUESDAY',
    'WEDNESDAY',
    'THURSDAY',
    'FRIDAY',
    'SATURDAY',
];

let year, month, today, firstDay, lastDay, currentDay;
let table = '';
let curDay = '';
let curDayOfWeek = '';

function initialize() {
    const now = new Date();
    year = now.getFullYear();
    month = now.getMonth();
    today = now.getDate();
    currentDay = 1;

    renderCalendar();
}

function prevMonth() {
    if (month == 0) {
        year--;
        month = 11;
    } else {
        month--;
    }
    renderCalendar();
    updateMonthList();
}
function nextMonth() {
    if (month == 11) {
        year++;
        month = 0;
    } else {
        month++;
    }
    renderCalendar();
    updateMonthList();
}
function goToday() {
    const now = new Date();
    year = now.getFullYear();
    month = now.getMonth();
    today = now.getDate();

    renderCalendar();
    updateMonthList();
}
document.querySelector('.today').addEventListener('click', function () {
    goToday();
});
function updateMonthList() {
    const monthList = document.getElementById('monthList');
    const months = monthList.getElementsByTagName('li');

    for (let i = 0; i < months.length; i++) {
        months[i].style.fontWeight = 'normal';
        if (i == month) {
            months[month].style.color = 'rgb(46, 205, 111)';
            months[month].style.fontWeight = 'bold';
        } else {
            months[i].style.color = 'black';
        }
    }
}
function renderCalendar() {
    const now = new Date();
    firstDay = new Date(year, month, 1);
    currentDay = 1;

    if (month == 1) {
        if (isLeapYear(year)) {
            lastDay = new Date(year, month, 29);
        } else {
            lastDay = new Date(year, month, 28);
        }
    } else if (month == 3 || month == 5 || month == 8 || month == 10) {
        lastDay = new Date(year, month, 30);
    } else {
        lastDay = new Date(year, month, 31);
    }

    let curYear = year + '.';
    let curMonth = month + 1;
    document.querySelector('.curYear').innerHTML = curYear;
    document.querySelector('.curMonth').innerHTML = curMonth;

    const monthList = document.getElementById('monthList');
    const months = monthList.getElementsByTagName('li');

    for (let i = 0; i < months.length; i++) {
        months[i].style.fontWeight = 'normal';
    }
    months[month].style.color = 'rgb(46, 205, 111)';
    months[month].style.fontWeight = 'bold';

    table = `<table>`;
    table += `<tr>`;
    for (let i = 0; i < 7; i++) {
        table += `<th>${dayOfWeek[i]}</th>`;
    }
    table += `</tr>`;

    const firstWeekDays = 7 - firstDay.getDay();
    const totalDays = lastDay.getDate();
    const remainingDays = totalDays - firstWeekDays;
    const ROW = Math.ceil(remainingDays / 7) + 1;

    // 영화 포스터 url
    const url_path = 'https://image.tmdb.org/t/p/original';
    const poster_path = '/qVdrpBY920kKikUmPm89wig60Kd.jpg';
    const imgSrc = `${url_path}${poster_path}`;

    for (let i = 0; i < ROW; i++) {
        table += `<tr>`;
        for (let j = 0; j < 7; j++) {
            if (i == 0 && j < firstDay.getDay()) {
                table += `<td></td>`;
            } else if (currentDay <= totalDays) {
                let cellStyle = '';
                if (j == 0) {
                    cellStyle = 'color: red;';
                } else if (j == 6) {
                    cellStyle = 'color: blue;';
                }

                // 영화 리뷰를 등록한 날짜에 맞춰서 td에 poster url 추가
                if (currentDay == today && month == now.getMonth() && year == now.getFullYear()) {
                    table += `<td>
                        <div class="reviewedMovie">
                            <div class="curDay" style="${cellStyle}">${currentDay++}</div>
                            <div class="poster">
                                <img src="${imgSrc}" alt="movie">
                            </div>
                        </div>
                    </td>`;
                } else {
                    table += `<td style="${cellStyle}">${currentDay++}</td>`;
                }
            } else {
                table += `<td></td>`;
            }
        }
        table += `</tr>`;
    }
    table += `</table>`;
    document.getElementById('calendar').innerHTML = table;
}
initialize();
renderCalendar();
