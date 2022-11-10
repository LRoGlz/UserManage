/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.email;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lrosellg
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        int opMain;
        int opSend;
        int opMess;
        String subject;
        String body;
        User to;
        String dataEmail;
        String dataPass;
        String dataUserName;
        String question;
        String answer;
        
        do{
        System.out.println("Bienvenido al gestor de emails\n<<<<Selecciona una opción>>\n1-Iniciar sesión\n2-Registrarte");
        op = Integer.parseInt(sc.nextLine());
        switch(op){
            case 1:
                System.out.println("Introduce Email");
                dataEmail = sc.nextLine();
                System.out.println("Introduce Contraseña");
                dataPass = sc.nextLine();
                Login l = new Login();
                User logged = l.makeLogin(dataEmail, dataPass, BBDD.getUsers());
                    while(l.isSuccess()){
                        System.out.println("<<<<¿Qué quieres hacer?>>>>\n1-Cambiar contraseña\n2-Crear pregunta de seguridad\n3-Enviar un mensaje\n4-Abrir buzón\n5-LogOut");
                        opMain = Integer.parseInt(sc.nextLine());
                        switch(opMain){
                            case 1:
                                System.out.println("Introduce tu antigua contraseña");
                                dataPass = sc.nextLine();
                                if(logged.getPassword().endsWith(dataPass)){
                                    System.out.println("Introduce tu nueva contraseña");
                                    dataPass = sc.nextLine();
                                    logged.setPassword(dataPass);
                                    System.out.println("Contraseña cambiada correctamente");
                                }else
                                    System.out.println("Contraseña incorrecta");
                                break;
                            case 2:
                                System.out.println("Introduce una pregunta de seguridad");
                                question = sc.nextLine();
                                System.out.println("Introduce la respuesta");
                                answer = sc.nextLine();
                                logged.setSecurityQ(question);
                                logged.setAnswer(answer);
                                System.out.println("Pregunta de seguridad establecida");
                                break;
                            case 3:
                                System.out.println("¿A quien quieres enviar un mensaje?");
                                BBDD.readUsers(logged);
                                opSend = Integer.parseInt(sc.nextLine());
                                to = BBDD.getUsers().get(opSend-1);
                                System.out.println("Escribe un asunto");
                                subject = sc.nextLine();
                                System.out.println("Escribe un mensaje");
                                body = sc.nextLine();
                                System.out.println("Mensaje enviado");
                                Message m = new Message(logged, to, subject, body);
                                BBDD.addMessage(m);
                                break;
                            case 4:
                                do{
                                System.out.println("Indica que mensaje quieres leer");
                                System.out.println("0 - salir");
                                logged.getMessages(BBDD.getMessages());
                                opMess = Integer.parseInt(sc.nextLine());
                                if(opMess != 0)
                                logged.openMessage(logged.getMessages(BBDD.getMessages()).get(opMess-1));
                                }while (opMess != 0);
                                break;
                            case 5:
                                l.setSuccess(false);
                        }
                    }
                break;
            
            case 2:
                System.out.println("Introduce un Nombre de Usuario");
                dataUserName = sc.nextLine();
                System.out.println("Introduce Email");
                dataEmail = sc.nextLine();
                System.out.println("Introduce Contraseña");
                dataPass = sc.nextLine();
                Register re = new Register();
                re.setRegister(dataEmail, dataUserName, dataPass, BBDD.getUsers());
        }
        }while(op == 1 || op == 2);
    }
}
