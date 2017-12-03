import kuusisto.tinysound.TinySound;

public class Main {

    public static void main(String[] args) {
        TinySound.init();
        Game g=new Game();
        g.init();
        try{
           g.start();
        } catch (InterruptedException e) {
           System.out.println("Error");
        }
    }
}

