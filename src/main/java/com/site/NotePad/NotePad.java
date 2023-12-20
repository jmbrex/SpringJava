package com.site.NotePad;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class NotePad {
    private int ID, userID;
    private String name, content;
    private Timestamp  createdAt;
}
