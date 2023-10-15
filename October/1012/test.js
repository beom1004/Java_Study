'use strict';
let text = '';
const fruits = ['apple', 'orange', 'cherry'];
fruits.forEach((item, index) => console.log(`${item} : ${index}`));

let sum = 0;
const numbers = [65, 44, 12, 4];
numbers.forEach((item) => (sum += item));
console.log(sum);

const numbers2 = [65, 44, 12, 4];
numbers2.forEach((item, index, arr) => (arr[index] = item * 10));
console.log(numbers2);

let numbers3 = [273, 25, 75, 52, 103, 32, 57, 24, 76];
let newArr = numbers3
    .filter((value) => value % 2 !== 0)
    .filter((value) => value <= 100)
    .filter((value) => value % 5 === 0);

console.log(newArr);

const array = ['사과', '배', '귤', '바나나'];
array.forEach((value, index) => console.log(index + ' : ' + value));

let pi = 3.14;
console.log(`파이 값은 ${pi}입니다.`);

//  IIFE (Immediately Invoked Function Expression)
// 블록을 사용한 스코프 생성
{
    let pi = 3.141592;
    console.log(`파이 값은 ${pi}입니다.`);
}
console.log(`파이 값은 ${pi}입니다.`);

// 함수 블록을 사용한 스코프 생성
function sample() {
    let pi = 3.141592;
    console.log(`파이 값은 ${pi}입니다`);
}

sample();
console.log(`파이 값은 ${pi}입니다.`);
