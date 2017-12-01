import gameobjects.GameObjects;
import gameobjects.aliens.ChiefAlien;
import gameobjects.aliens.BasicAlien;
import gameobjects.aliens.WarriorAlien;

public class AlienFactory {

    public static GameObjects generateAlien() {
        int chanceAlienGenerator = Randomizer.generate();

        if(chanceAlienGenerator < 40) {
            return new BasicAlien();
        }

        if(chanceAlienGenerator >80) {
            return new WarriorAlien();
        }

        return new ChiefAlien();
    }
}
