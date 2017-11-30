import gameobjects.GameObjects;
import gameobjects.aliens.ChiefAlien;
import gameobjects.aliens.BasicAlien;
import gameobjects.aliens.WarriorAlien;

public class AlienFactory {

    public GameObjects generateAlien() {
        int chanceAlienHostage = Randomizer.generate();

        if(chanceAlienHostage < 40) {
            return new BasicAlien();
        }

        if(chanceAlienHostage >80) {
            return new WarriorAlien();
        }

        return new ChiefAlien();
    }
}
