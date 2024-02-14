package com.site.SitePessoaal.Controlers;

import com.site.DataBase.DbSQLNotePad;
import com.site.NotePad.NotePad;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/NoteUpdate")
public class NoteUpdateControler {
    
    @RequestMapping()public String Note(){return"NoteUpdate";}
    
    @PutMapping("Update")
    ResponseEntity UpdateNotet(@RequestBody NotePad notePad, NotePad NewNote){
    
        return null;
    
    }
}
