//Dependencias
const toDayJs = dayjs();

//Eelementos HTML
const TitleDay = document.getElementById('Day');


//Scipt
TitleDay.innerText = toDayJs.format("DD/MM/YYYY")