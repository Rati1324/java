package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public Client(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            System.out.println("Connected");
            input = new DataInputStream(System.in);
            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Client c = new Client("127.0.0.1", 8888);
    }
}