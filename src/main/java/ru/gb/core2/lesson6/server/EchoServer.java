package ru.gb.core2.lesson6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        Socket socket= null;
        try (ServerSocket serverSocket= new ServerSocket(8189)) {
            System.out.println("Server ON. Wait connection ...");
            socket= serverSocket.accept();
            System.out.println("Client has switched on");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out= new DataOutputStream(socket.getOutputStream());
            while (true){
                String  str= in.readUTF();
                if (str.equals("/end")) {
                    break;
                }
                out.writeUTF("Echo:  " + str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
