const FormLogin = document.getElementById('formLogin');
const Nick = document.getElementById('InputNick');
const Senha = document.getElementById('InputSenha');

FormLogin.addEventListener('submit', function(event){
    event.preventDefault();
    let postData = {
            nick: Nick.value,
            senha: Senha.value
        };
    fetch('/Login',{
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(postData),
        })
        .then(response => {
        if (response.ok) {
                return response.json(); // Tenta analisar como JSON se a resposta estiver OK
            } else {
                return response.text(); // Se a resposta não estiver OK, pega como texto
            }
        })
        .then(data => {
            if(data instanceof Object){
                console.log(data);
                sessionStorage.setItem('LoggedID', data.id);
                window.location.href = 'Menu';
            }else{
                window.alert(data);
            }
        })
        .catch(error => console.error('Error:', error));
})


