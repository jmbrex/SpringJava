
package com.site.User;

public class User {
    private String name, email, senha, nick;
    private int ID;
    public User(){}

    public User(String name, String email, String senha, String nick, int ID) {
        this.name = name;
        this.email = email;
        this.senha = senha;
        this.nick = nick;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    
    
    
    
    
}
