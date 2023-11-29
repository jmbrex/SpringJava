package com.site.SitePessoaal;

import com.site.DataBase.DbSQL;
import com.site.User.User;
import java.lang.annotation.Target;
import javax.security.auth.message.callback.PrivateKeyCallback;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
//@RequestMapping("/Cadastro")
public class controler {
    
    @RequestMapping("/Cadastro")
    public String Cadastro(Model modelo){
        return "Cadastro";
    }
    
    @PostMapping("/Cadastro")
    public  ResponseEntity<User> create (@RequestBody User User){
        System.out.println("chegou");
        System.out.println(User.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(User);
    }
    
    /*
    @RequestMapping(value = "teste", method = RequestMethod.POST)
    public String Cadastro(Model modelo, String InputName,String InputNick, String InputEmail, String InputSenha, String InputSenhaConfirm){
    
        System.out.println(InputEmail);
        User u1 = new User(0,InputName,InputNick, InputEmail, InputSenha);
        System.out.println(u1.getNickName());
        DbSQL SQL = new DbSQL();
        SQL.sqlDbUserInsert(u1);
        return "Cadastro";
        
    }
    
    @RequestMapping(value = "formLogin", method = RequestMethod.POST)
    public String Login(Model modelo, String InputUser,String InputNick, String InputSenha){
        DbSQL SQL = new DbSQL();
        User p1 = SQL.sqlUserSelectNickName(InputNick);
        System.out.println(p1.getSenha());
        if (p1.getSenha().equals(InputSenha)){
            System.out.println("Login OK");
            return "Menu";
        }else{
            return "Cadastro";
        }
       
   }*/
    
    
    
}
