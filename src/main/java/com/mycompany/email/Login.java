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
public class Login {
    private boolean success;
    
    public String enterEmail(String e){
        return e;
    }
    
    public String enterPass(String p){
        return p;
    }
    
    //iniciar sesión
    public User makeLogin(String email, String pass, ArrayList<User> au){
        for(User u: au){
            if(email.equals(u.getEmail()) && pass.equals(u.getPassword())){
                System.out.println("Has iniciado sesión como "+u.getUserName());
                success = true;
                return u;
            }
        }
        System.out.println("El nombre de usuario o la contraseña son erroneos");
        return null;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
}
