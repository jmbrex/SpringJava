/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        LocalDateTime currentDate = LocalDateTime.now(); // pegando data e hora atual
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // tipo de formatação
        notePad.setCreatedAt(Timestamp.valueOf(currentDate.format(formatter))); // salvando a data e hora formatada no objeto notePad
        sqlNote.sqlDbNoteInsert(notePad); // Inserindo no banco de dados
        
        return ResponseEntity.status(HttpStatus.CREATED).body("Anotações salvas"); // retornando pro cliente que os dados foram salvos
    }
}
