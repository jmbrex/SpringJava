
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
            } else {
                window.alert(data);
            }
        })
        .catch(error => console.error('Error:', error));