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
public class User {
    private String userName;
    private String password;
    private String email;
    private String securityQ;
    private String answer;

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecurityQ() {
        return securityQ;
    }

    public void setSecurityQ(String securityQ) {
        this.securityQ = securityQ;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public ArrayList<Message> getMessages (ArrayList<Message> messages){
        int cont=1;
        ArrayList<Message>myMessages = new ArrayList();
        for(Message m : messages){
           if(m.getAddressee() == this){
               if(m.isReaded())
                   System.out.println(cont+" - "+m.getSender().getUserName()+" ASUNTO: "+m.getSubject());
               else
                   System.out.println(cont+" - *** "+m.getSender().getUserName()+" ASUNTO: "+m.getSubject());
            
               cont++;
               myMessages.add(m);
           }
           
        }
        
        return myMessages;
    }
    
    public void openMessage(Message m){
        System.out.println("FROM: "+m.getSender().getUserName()+"       ASUNTO: "+m.getSubject()+"\n\n"+m.getBody()+"\n\n");
        m.setReaded(true);
    }
    
}
