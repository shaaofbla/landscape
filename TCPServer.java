//package landscape;

import java.io.*;
import java.net.*;

class TCPServer{
    public int port;
    public Socket TCPSocket;

    public TCPServer(int port){
        port = port;
        try {
                TCPSocket = setupSocket(this.port);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    private Socket setupSocket(int _port) throws Exception{
        ServerSocket _ServerSocket = new ServerSocket(_port);
        Socket connectionSocket = _ServerSocket.accept();
        return(connectionSocket);
    }

    public String readMessage(){
        String message;
        try (BufferedReader messageFromClient =new BufferedReader(new InputStreamReader(TCPSocket.getInputStream()))){
                message = messageFromClient.readLine();
        } catch (IOException e){
            System.out.println(e);
            message = null;
        }
        return(message);
    }
}
/*
public static void main(String [] args){
        String clientSentence;
        TCPServer server = TCPServer(5007);
        //String capitalizedSentence;
        //ServerSocket welcomeSocket = new ServerSocket(5007);
        //Socket connectionSocket = welcomeSocket.accept();
        while (true) {
            clientSentence = server.readMessage();
            System.out.println("Received: " + clientSentence);
    }
    */
