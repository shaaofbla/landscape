//package landscape;

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

    public static void main(String args[]){
        Landscape Land = new Landscape();
        String coordinates;
        while (true) {
            coordinates = Land.Input.readMessage();
            System.out.println(coordinates);
        }
   }
}
