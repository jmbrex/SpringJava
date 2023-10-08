
package com.site.User;

public class User {
    private String Nome, Email, Senha;

    public User(){}
    public User(String Nome, String Email, String Senha) {
        this.Nome = Nome;
        this.Email = Email;
        this.Senha = Senha;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
    
    
    
}
