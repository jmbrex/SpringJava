
package com.site.User;

import lombok.Data;

@Data
public class User {
    private int ID;
    private String name, email, senha, nick;
    
    //public User(){}
    
    /*public User(String name, String email, String senha, String nick, int ID) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.senha = senha;
        this.nick = nick;
    }*/
}
