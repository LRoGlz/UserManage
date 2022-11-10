/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.email;

import java.util.ArrayList;

/**
 *
 * @author lrosellg
 */
public class Register {
    
    
    //Registrar usuario en la BBDD
    public void setRegister(String email, String userName, String password, ArrayList<User> au){
        User u = new User(userName, password, email);
        au.add(u);
        System.out.println("Usario "+u.getUserName()+" añadido creado correctamente");
    }
}
