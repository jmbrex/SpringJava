package com.site.SitePessoaal.Controlers;

import com.site.DataBase.DbSQLUser;
import com.site.User.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller

public class CadastroControler {
    
    @RequestMapping("/Cadastro") 
    public String Cadastro(Model modelo){
        return "Cadastro";
    }
    
    
    @PostMapping("/Cadastro")
    public  ResponseEntity create (@RequestBody User User){
        System.out.println(User.getName());
        
        DbSQLUser SQL = new DbSQLUser();
        User U2 =  SQL.sqlUserSelectNickName(User.getNick()); // busncando no banco de dados para verificar se ja existe um usuario com este nome
        
        if(User.getNick().equals(U2.getNick())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("usuario ja existe"); // caso ja existe ele retorna um aviso
        }else{
            SQL.sqlDbUserInsert(User); // caso nao exista ele salva no banco de dados o usuario
            return ResponseEntity.status(HttpStatus.CREATED).body(User); // retornando o usuario criado
        }
    }
    
    @PostMapping("/Login")
    public  ResponseEntity login (@RequestBody User User){
        DbSQLUser SQL = new DbSQLUser();
        User U2 =  SQL.sqlUserSelectNickName(User.getNick()); // buscando no banco de dados para verificar a existencia no usuario
        if(User.getSenha().equals(U2.getSenha())){
            return ResponseEntity.status(HttpStatus.OK).body(U2); // caso a senha esteja correta ele retorna o usuario
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("usuario ou senha incorreos"); // caso o usuario não exista ou a senha esteja incorreta ele retorna um aviso
        }
        
        
    }
    
    
    
}
