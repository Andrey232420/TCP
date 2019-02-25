/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

/**
 *
 * @author GT
 */
public class Server {

    final int port = 6667;

    public Server() {

        try {
          //  Frame.jTextArea1.append("I`m server. My IP: " + Inet4Address.getLocalHost().getHostAddress());
            ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
            
            System.out.println("Жду клиента");
            //Frame.jTextArea1.append("Жду клиента");

            Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
            System.out.println("Клиент подключился");

            //Frame.jTextArea1.append("Клиент подключился");

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту. 
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;
         // while (true) {
                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
       
                System.out.println(socket.getInetAddress().getHostName() );
                System.out.println(socket.getInetAddress().getHostAddress() );


                Frame.jTextArea1.append(Inet4Address.getLocalHost().getHostName() + " принял сообщение от " 
                        + socket.getInetAddress().getCanonicalHostName() + ": '" + line+ "'\n");
                System.out.println("Пришло: "+line);
                out.writeUTF(line); // отсылаем клиенту обратно ту самую строку текста.
                out.flush(); // заставляем поток закончить передачу данных.
         // }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

}
