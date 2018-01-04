//package landscape;

public class Landscape {
    TCPServer Input = null;

    public Landscape(){
        Input = TCPServer(5007);
    }

    public void input() {

            System.out.println("get some input from somewhere");
        }
    public void output(){
            System.out.println("out put the processed input to some other computer");
        }
    public static void main(String args[]){
       input();
   }
}
