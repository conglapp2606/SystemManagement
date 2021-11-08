package test;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server {
    public static void main(String[] args) {
        new Server();
    }

    public Server(){
        try {
            ServerSocket serverSocket = new ServerSocket();
            SocketAddress http = new InetSocketAddress(50000);
            serverSocket.bind(http);
            System.out.println("Server running...");
            Socket socket = serverSocket.accept();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true){
                String strNum = reader.readLine();

                int s = 0;
                for(int i = 0; i < strNum.length(); i++){
                    String c = strNum.charAt(i) + "";
                    int num = Integer.parseInt(c);
                    s += num;
                }

                writer.write("Number: " + s);
                writer.newLine();
                writer.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
