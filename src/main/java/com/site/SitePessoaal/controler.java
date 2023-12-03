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
    public  ResponseEntity create (@RequestBody User User){
        System.out.println("chegou");
        System.out.println(User.getName());
        
        DbSQL SQL = new DbSQL();
        User U2 =  SQL.sqlUserSelectNickName(User.getNick());
        
        if(User.getNick().equals(U2.getNick())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(U2);
        }else{
            return ResponseEntity.status(HttpStatus.CREATED).body(User);
        }
        
        
        
    }
    
    
    
    
}
