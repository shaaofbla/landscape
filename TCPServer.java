//package landscape;

import java.io.*;
import java.net.*;

public class TCPServer{
    public int port;
    public Socket TCPSocket;
    public BufferedReader Reader;

    public TCPServer(int port){
        port = port;
        try {
            TCPSocket = setupSocket(port);
            Reader = setupReader();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    private Socket setupSocket(int _port) throws Exception{
        ServerSocket _ServerSocket = new ServerSocket(_port);
        System.out.println("Connecting to Port: " + _port);
        System.out.println("Waiting for the client to connect.");
        Socket connectionSocket = _ServerSocket.accept();
        System.out.println("Client successfully connected.");
        return(connectionSocket);
    }

    private BufferedReader setupReader() throws Exception{
        BufferedReader Reader = new BufferedReader(new InputStreamReader(TCPSocket.getInputStream()));
        return(Reader);
    }

    public String readMessage(){
        String message;
        try {
            message = this.Reader.readLine();
        } catch (IOException e){
            System.out.println(e);
            message = "reader error occured.";
        }
        return(message);
    }
}

class TestTCPServer{
    public static void main(String args[]){
        System.out.println("Main Function: TestTCPServer");
        int port = 5007;
        TCPServer testServer = new TCPServer(port);
        String message=null;
        for (int i=0; i<10; i++){
            message = testServer.readMessage();
            System.out.println("Recived coordinates: " + message);
        }
        System.out.println("Test complete");
    }
}
