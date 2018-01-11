//package landscape;
import com.illposed.osc.OSCPortOut;
import com.illposed.osc.OSCMessage;
//import com.illposed.osc.utility.OSCJavaToByteArrayConverter;
//import java.lang.Object;
import java.net.*;

public class Landscape {
    TCPServer Input;

    public Landscape(){
        Input = new TCPServer(5007);
    }

    public void input() {
            System.out.println("get some input from somewhere");
    }

    public void output(){
            System.out.println("out put the processed input to some other computer");
    }

    public static void main(String args[]) throws Exception {
        System.out.println("Main Function: Landscape");
        Landscape Land = new Landscape();
        String coordinates;
        int port = 6007;
        String ip_string ="192.168.0.31";
        InetAddress ip;
        ip = InetAddress.getByName(ip_string);
        UDPServer OutServer = new UDPServer(ip, port);
        while (true) {
            coordinates = Land.Input.readMessage();
            System.out.println(coordinates);
            String [] coord_part = coordinates.split("\\s+");
            coordinates = coord_part[0];
            OutServer.sendOSC(coordinates);
        }
   }
}
