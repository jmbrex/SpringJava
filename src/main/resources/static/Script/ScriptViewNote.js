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


function Notes(data){
    for (var i = 0; i < data.length ; i++) {
        console.log(data[i]["name"]);
        
    }
}