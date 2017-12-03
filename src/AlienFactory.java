import gameobjects.GameObjects;
import gameobjects.aliens.ChiefAlien;
import gameobjects.aliens.BasicAlien;
import gameobjects.aliens.WarriorAlien;
import gameobjects.hostages.Sergio;
import gameobjects.hostages.Audrey;
import gameobjects.hostages.Faustino;

public class AlienFactory {

    static GameObjects generateAlien() {
        int chanceObjectGenerator = Randomizer.generate(0,101);

        if(chanceObjectGenerator <= 50) {
            return new BasicAlien();
        }

        if(chanceObjectGenerator <= 85) {
            return new WarriorAlien();
        }

        return new ChiefAlien();
    }
}
