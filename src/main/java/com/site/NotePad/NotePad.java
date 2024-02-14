package com.site.NotePad;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

// objeto da ttabela de anotações
// usado para salvar no banco de dadoss
@Data
public class NotePad {
    private int ID, userID;
    private String name, content;
    private Timestamp  createdAt;
}
