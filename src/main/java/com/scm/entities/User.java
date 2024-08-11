package com.scm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "user")
@Table(name = "users")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    @Id  // Primary key
    @Column(name = "user_id")  // Optional, if you want to explicitly set column name
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Column(length = 10000)
    @Lob
    private String about;

    @Column(length = 10000)
    @Lob
    private String profilePicture;

    private String phoneNumber; 

    // Information
    private boolean enabled = false;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;

    // Providers enum should be defined in your codebase
    private Providers provider = Providers.SELF;
    
    private String providerUserId;

    // One-to-many relationship with Contact
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();
}
