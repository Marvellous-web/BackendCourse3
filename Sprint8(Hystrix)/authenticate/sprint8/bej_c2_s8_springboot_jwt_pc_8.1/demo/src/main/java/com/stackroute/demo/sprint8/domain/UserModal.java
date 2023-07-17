package com.stackroute.demo.sprint8.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UserModal {

    @Id @GeneratedValue
    private int user_id;
    private String username,password,role,email;
}
