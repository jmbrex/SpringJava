package com.site.NotePad;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class NotePad {
    private int ID, userID;
    private String name, content;
    private Date  createdAt;
}
