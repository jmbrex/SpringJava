/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.site.SitePessoaal.Controlers;

import com.site.DataBase.DbSQLNotePad;
import com.site.NotePad.NotePad;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author João Marcelo
 */
@Controller
@RequestMapping("/NoteCreate")
public class NoteCreateControler {
    
    @RequestMapping
    public String Note(){return"NoteCreate";}
    
    @PostMapping("/")
    public ResponseEntity saveNotes(@RequestBody NotePad notePad){
        DbSQLNotePad sqlNote = new DbSQLNotePad();
        sqlNote.sqlDbNoteInsert(notePad);
        
        return ResponseEntity.status(HttpStatus.CREATED).body("Anotações salvas");
    }
}
