package com.notesapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Notes {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

     @Lob
     String content;

     String ownerUsername;

    }



