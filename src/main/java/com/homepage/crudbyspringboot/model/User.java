package com.homepage.crudbyspringboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "firstname")
   private String firstName;

   @Column(name = "lastname")
   private String lastName;

   @Column(name = "email")
   private String email;
}
