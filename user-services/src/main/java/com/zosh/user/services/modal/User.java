package com.zosh.user.services.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User   {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "name can't be null")
    private String name;
    @NotNull(message = "password can't be null")
    private String password;
    @NotNull(message = "email can't be null")
    @Email
    private String email;
    @NotNull(message = "phone can't be null")
    private  String phone;
    private String address;
    private String role;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

//    public String getName(){
//        return name;
//    }
//    public void setName(String name){
//        this.name=name;
//    }
//    public String getPassword(){
//        return password;
//    }
//    public void setPassword(String password){
//        this.password=password;
//    }
//    public String getEmail(){
//        return email;
//    }
//    public void setEmail(String email){
//        this.email=email;
//    }
//    public String getPhone(){
//        return phone;
//    }
//    public void setPhone(String phone){
//        this.phone=phone;
//    }
//    public String getAddress(){
//        return address;
//    }
//    public void setAddress(String address){
//        this.address=address;
//    }
//    public String getRole(){
//        return role;
//    }
//    public void setRole(String role){
//        this.role=role;
//    }
//    public LocalDateTime getCreatedAt(){
//        return createdAt;
//    }
//    public void setCreatedAt(LocalDateTime createdAt){
//        this.createdAt=createdAt;
//    }
//    public LocalDateTime getUpdatedAt(){
//        return updatedAt;
//    }
//    public void setUpdatedAt(LocalDateTime updatedAt){
//        this.updatedAt=updatedAt;
//    }
//    public User(){}
//    public User(String name, String password, String email, String phone, String address, String role, LocalDateTime createdAt, LocalDateTime updatedAt) {
//        this.name = name;
//        this.password = password;
//        this.email = email;
//        this.phone = phone;
//        this.address = address;
//        this.role =  role;
//        this.createdAt = createdAt;
//    }

}
