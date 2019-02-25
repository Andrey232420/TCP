/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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

    public Client() {

        String address = Frame.jTextField2.getText(); // IP-адрес компьютера, где исполняется серверная программа. 

        try {
            InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес.
//            System.out.println("Any of you heard of a socket with IP address " + address + " and port " + serverPort + "?");
            socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера.
//            System.out.println("Yes! I just got hold of the program.");

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиентом. 
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            in = new DataInputStream(sin);
            out = new DataOutputStream(sout);

        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void send() {

        try {
            line = Frame.jTextField3.getText();

            out.writeUTF(line); // отсылаем введенную строку текста серверу.
            out.flush(); // заставляем поток закончить передачу данных.
            line = in.readUTF(); // ждем пока сервер отошлет строку текста.
            Frame.jTextArea1.append("Принято от сервера: " + line+"\n");
//            System.out.println("The server was very polite. It sent me this : " + line);
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
    
    
}
