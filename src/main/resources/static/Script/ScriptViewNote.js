const section = document.getElementById("section");

fetch(`/NoteView/${parseInt(sessionStorage.getItem('LoggedID'))}`, {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json',
    },
})
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                return response.text()
            }
        })
        .then(data => {
            if (data instanceof Object) {
                console.log(data);
                Notes(data);
            } else {
                window.alert(data);
            }
        })
        .catch(error => console.error('Error:', error));


//Função que recebe o parametro data que é um arquivo json e transforma o conteudo em elementos HTML ná tela usando manipulação do DOM
function Notes(data){
    for (var i = 0; i < data.length ; i++) {
        let div = document.createElement("div");
        div.className = "NoteStructure";
        
        let NoteName = document.createElement("h2");
        NoteName.innerHTML = data[i]["name"];
        NoteName.className = "NoteTitle"
        
        let NoteContent = document.createElement("p");
        NoteContent.innerHTML = data[i]["content"];
        NoteContent.className = "NoteContent"
        
        div.appendChild(NoteName);
        div.appendChild(NoteContent);
        section.appendChild(div);
    }
}