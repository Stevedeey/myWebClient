package com.example.resttemplate.model;

import lombok.Data;

import java.util.Date;

@Data
public abstract class AuditModel{
    private Date createdAt;
    private Date updatedAt;
}