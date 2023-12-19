//Dependencias
const toDayJs = dayjs();

//Eelementos HTML
const TitleDay = document.getElementById('Day');
const BTNlogout = document.getElementById("voltar");
const BTNCreateNote = document.getElementById("CreateNote");
const BTNYuorNote = document.getElementById("YourNotes");



//Scipt
TitleDay.innerText = toDayJs.format("DD/MM/YYYY")

BTNlogout.addEventListener('click', function (event){
    event.preventDefault();
    window.location.href = '../index.html'
})

BTNYuorNote.addEventListener('click', function (event){
    event.preventDefault();
    window.location.href = 'NoteView'
})

BTNCreateNote.addEventListener('click', function (event){
    event.preventDefault();
    window.location.href = 'NoteCreate'
})