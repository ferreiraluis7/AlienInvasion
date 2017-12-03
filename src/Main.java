import kuusisto.tinysound.TinySound;

import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) {
        TinySound.init();
        Game g = new Game();
        g.init();
        try {
            g.start();
        } catch (InterruptedException e) {
        }
    }
}

