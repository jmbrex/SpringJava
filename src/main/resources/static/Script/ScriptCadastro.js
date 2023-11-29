console.log("Cadastro");

const form = document.getElementById('FormCadastro');
const name = document.getElementById('InputName');
const nick = document.getElementById('InputNick');
const email = document.getElementById('InputEmail');
const senha = document.getElementById('InputSenha');
const senhaConfirm = document.getElementById('InputSenhaConfirm');

form.addEventListener('submit', function(event) {
    event.preventDefault()
    console.log("tetste")
    if(senha.value === senhaConfirm.value){
        let postData = {
            
            name: name.value,
            nick: nick.value,
            email: email.value,
            senha: senha.value,
        
        };
        
        fetch('/Cadastro',{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(postData),
        })
        .then(response => response.json())
        .then(data => {
            console.log('POST Response:', data);
        })
        .catch(error => console.error('Error:', error));
        console.log("fez o post");
    }else{
        window.alert('Senhas divergentes')
    }
    
})




