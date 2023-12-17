
package com.site.User;

import lombok.Data;

@Data
public class User {
    private String name, email, senha, nick;
    private int ID;
    public User(){}
    
    /*public User(String name, String email, String senha, String nick, int ID) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.senha = senha;
        this.nick = nick;
    }*/
}
