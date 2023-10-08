package com.site.SitePessoaal;

import com.site.DataBase.DbSQL;
import com.site.User.User;
import java.lang.annotation.Target;
import javax.security.auth.message.callback.PrivateKeyCallback;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
//@RequestMapping("/Cadastro")
public class controler {
   @RequestMapping("/Cadastro")
    public String SayHello2(Model modelo){
        
        
        return "Cadastro";
                
    }
    
    @RequestMapping(value = "teste", method = RequestMethod.POST)
    public String bd(Model modelo, String InputName, String InputEmail, String InputSenha, String InputSenhaConfirm){
    
        System.out.println(InputEmail);
        User u1 = new User(InputName, InputEmail, InputSenha);
        DbSQL SQL = new DbSQL();
        SQL.sqlDbUserInsert(u1);
        return "Cadastro";
        
    }
    
    
    
    
    
}
