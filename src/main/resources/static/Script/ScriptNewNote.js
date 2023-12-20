const NoteName = document.getElementById("NoteName");
const NoteContent = document.getElementById("NoteContent");
const form = document.getElementById("NewNote");



form.addEventListener('submit', () => {
    
    let postData = {
        name: NoteName.value,
        content: NoteContent.value,
        userID: sessionStorage.getItem('LoggedID')
    }
    
    fetch('/NoteCreate/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(postData)
    })
            .then(response => {
                if (response.ok) {
                    return response.text();
                } else {
                    return response.text()
                }
            })
            .then(data => {
                if (data instanceof Object) {
                    console.log(data);
                    window.location.href = 'Menu';
                } else {
                    window.alert(data);
                }
            })
            .catch(error => console.error('Error:', error));
})



