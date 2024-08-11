package com.scm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Contact 
{
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String picture;
    @Column(length = 10000 )
    private String description;
    private boolean favorite=false;
    
    private String websiteLink;
    private String linkedInLink;
    //private List<> socialLinks = new ArrayList<>();

    @ManyToOne
    private User user;
}
