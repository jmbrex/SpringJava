package com.site.SitePessoaal.Controlers;

import com.site.DataBase.DbSQLNotePad;
import com.site.NotePad.NotePad;
import com.site.User.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/NoteView")
public class NoteViewControler {
    @RequestMapping
    public String Note(){return"NoteView";}
    
    @GetMapping("/{id}")
    public ResponseEntity GetNotes( @PathVariable int id ){
        System.out.println(id);
        DbSQLNotePad sqlNote = new DbSQLNotePad();
        User user = new User();
        user.setID(id);
        List<NotePad> NotePadList = sqlNote.sqlDbNoteSelect(user);
        if(NotePadList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista Vazia");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(NotePadList);
        }
        
    }
    
    
}
