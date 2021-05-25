package com.example.resttemplate.model;

import lombok.Data;

@Data
public class Question extends AuditModel{

    private Long id;
    private String title;
    private String description;
}
