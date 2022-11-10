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
public class BBDD {
    private static ArrayList<User> users = new ArrayList();
    private static ArrayList<Message> messages = new ArrayList();
    
    public static void addUser(User u){
        users.add(u);
    }
    
    public static void addMessage(Message m){
        messages.add(m);
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        BBDD.users = users;
    }

    public static ArrayList<Message> getMessages() {
        return messages;
    }

    public static void setMessages(ArrayList<Message> messages) {
        BBDD.messages = messages;
    }

    
    public static void readUsers(User us) {
        int cont=1;
        for(User u : users){
           
            System.out.println(cont+" "+u.getUserName());
            cont++;
            
        }
        
    }
    
    
}
