function isLearYear(year){
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
}
let table="";
let year, month, today, firstDay, lastDay, curDay;

function initialize(){
    let now = new Date();
    year = now.getFullYear();
    month = now.getMonth();
    today = now.getDate();
    curDay = 1;

    renderCalendar();
}
function goPrev(){
    if(month==0){
        year--;
        month = 11;
    }else{
        month--;
    }
    renderCalendar();
}
function goNext(){
    if(month==11){
        year++;
        month = 0;
    }else{
        month++;
    }
    renderCalendar();
}

const dayOfWeek = ["일", "월", "화", "수", "목", "금" ,"토"];

const COL = 7;

function renderCalendar(){
    table = "";

    let content = `${year}년 ${month+1}월`;
    document.getElementById("content").innerHTML = content;

    firstDay = new Date(year, month, 1);
    curDay=1;

    if(month == 1){
        if(isLearYear(year)){
            lastDay = new Date(year, month, 29);
        }else{
            lastDay = new Date(year, month, 28);
        }
    }else if(month == 3 || month == 5 || month == 8 || month == 10){
        lastDay = new Date(year, month, 30);
    }else{
        lastDay = new Date(year, month, 31);
    }
    table += `<table border='1'>`;
    table += `<tr>`; 
    for(let i=0; i<7; i++){
        table += `<th>${dayOfWeek[i]}</th>`;
    }
    table += `</tr>`;
    
    let totalDays = lastDay.getDate();
    let firstWeekDays = 7 - firstDay.getDay();
    let remainingDays = totalDays - firstWeekDays;
    let row = Math.ceil(remainingDays / 7) + 1;

    for(let i=0; i<row; i++){
        table += `<tr>`;
        for(let j=0; j<COL; j++){
            if(i==0 && j<firstDay.getDay()){
                table += `<td></td>`;
            }else if(curDay<=totalDays){
                table += `<td>${curDay++}</td>`;
            }else{
                table += `<td></td>`;
            }
        }
        table += `</tr>`;
    }
    table += `</table>`;
    document.getElementById("calendar").innerHTML = table;
}
initialize();
renderCalendar();