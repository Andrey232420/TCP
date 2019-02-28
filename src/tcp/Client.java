/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author GT
 */
public class Client {

    final int serverPort = 6667; // здесь обязательно нужно указать порт к которому привязывается сервер.
    private DataInputStream in;
    private DataOutputStream out;
    private String line = null;
    private Socket socket;
    private InputStream sin;
    private OutputStream sout;

//    public Client() {
//
//        System.out.println("I`am client");
//        String address = Frame.jTextField2.getText(); // IP-адрес компьютера, где исполняется серверная программа. 
//
//        try {
//            InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.
////            System.out.println("Any of you heard of a socket with IP address " + address + " and port " + serverPort + "?");
//            socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.
////            System.out.println("Yes! I just got hold of the program.");
//
//            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом. 
//            InputStream sin = socket.getInputStream();
//            OutputStream sout = socket.getOutputStream();
//
//            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
//            in = new DataInputStream(sin);
//            out = new DataOutputStream(sout);
//
//            // Создаем поток для чтения с клавиатуры.
////            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
////            while (true) {
////                line = keyboard.readLine(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.
//////                System.out.println("Sending this line to the server...");
////                out.writeUTF(line); // отсылаем введенную строку текста серверу.
////                out.flush(); // заставляем поток закончить передачу данных.
////                line = in.readUTF(); // ждем пока сервер отошлет строку текста.
////                Frame.jTextArea1.append("Принято от сервера: " + line + "\n");
////
////                System.out.println("The server was very polite. It sent me this : " + line);
//////                System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
//////                System.out.println();
////            }
//
////                Frame.jButton2.addActionListener(new ActionListener() {
////                    public void actionPerformed(ActionEvent e) {
////                        System.out.println("work");
////                        line = Frame.jTextField3.getText();                    }
////                });
//            //line = keyboard.readLine(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.
////                System.out.println("Sending this line to the server...");
////                line = Frame.jTextField3.getText();
////
////                out.writeUTF(line); // отсылаем введенную строку текста серверу.
////                out.flush(); // заставляем поток закончить передачу данных.
////                line = in.readUTF(); // ждем пока сервер отошлет строку текста.
////                System.out.println("The server was very polite. It sent me this : " + line);
////                System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
////                System.out.println();
//        } catch (Exception x) {
//            x.printStackTrace();
//        }
//    }
    public void start() {
        System.out.println("I`am client");
        String address = Frame.jTextField2.getText(); // IP-адрес компьютера, где исполняется серверная программа. 

        try {
            InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.
//            System.out.println("Any of you heard of a socket with IP address " + address + " and port " + serverPort + "?");
            socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.
//            System.out.println("Yes! I just got hold of the program.");

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом. 
            sin = socket.getInputStream();
            sout = socket.getOutputStream();

//            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
//            in = new DataInputStream(sin);
//            out = new DataOutputStream(sout);

            Frame.jLabel4.setText("Клиент запущен");
        } catch (Exception x) {
            x.printStackTrace();
        }

    }

    public void send() {

        try {
            out = new DataOutputStream(sout);
            in = new DataInputStream(sin);

            line = Frame.jTextField3.getText();

            out.writeUTF(line); // отсылаем введенную строку текста серверу.
            out.flush(); // заставляем поток закончить передачу данных.
            line = in.readUTF(); // ждем пока сервер отошлет строку текста.
            Frame.jTextArea1.append("Сообщение от " + Inet4Address.getLocalHost().getHostName() + ": " + line + "\n");
            System.out.println("Сервер вернул : " + line);
        } catch (Exception x) {
            x.printStackTrace();
        } finally {
            socket = null;
            in = null;
            out = null;
            line = null;
        }
    }

}
