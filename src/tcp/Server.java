/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import java.net.*;

/**
 *
 * @author GT
 */
public class Server {

    final int PORT = 6666;

    public Server() {

        try {

            System.out.println("My IP: " + Inet4Address.getLocalHost().getHostAddress());
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

}
