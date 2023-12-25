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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/NoteView")
public class NoteViewControler {
    @RequestMapping
    public String Note(){return"NoteView";}
    
    @GetMapping("/")
    public ResponseEntity GetNotes(@RequestBody User user){
        System.out.println(user.getID());
        DbSQLNotePad sqlNote = new DbSQLNotePad();
        
        List<NotePad> NotePadList = sqlNote.sqlDbNoteSelect(user);
        
        return ResponseEntity.status(HttpStatus.OK).body(NotePadList);
    }
    
    
}
