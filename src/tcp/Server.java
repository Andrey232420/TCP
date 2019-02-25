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

    final int port = 6666;

    public Server() {

        try {
            System.out.println("I`m server. My IP: " + Inet4Address.getLocalHost().getHostAddress());
            ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
            System.out.println("Waiting for a client...");

            Frame.jTextArea1.append("Жду клиента");

         //   Socket socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
            System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту. 
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;
            while (true) {
                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
                Frame.jTextArea1.append(Inet4Address.getLocalHost().getHostName() + "Принял сообщение:" + line);

                out.writeUTF(line); // отсылаем клиенту обратно ту самую строку текста.
                out.flush(); // заставляем поток закончить передачу данных.
                System.out.println("Waiting for the next line...");
                System.out.println();

            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

}
