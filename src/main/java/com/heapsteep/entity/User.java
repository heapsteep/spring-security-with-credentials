package com.heapsteep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SEC_USER")
public class User {
    @Id
    private int id;
    private String userName;
    private String password;

    /** Values like ADMIN, USER — mapped to Spring authorities ROLE_ADMIN, ROLE_USER. */
    @Column(name = "user_role")
    private String userRole;
}