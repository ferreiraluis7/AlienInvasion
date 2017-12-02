import gameobjects.GameObjects;
import gameobjects.aliens.ChiefAlien;
import gameobjects.aliens.BasicAlien;
import gameobjects.aliens.WarriorAlien;
import gameobjects.hostages.Hostage1;
import gameobjects.hostages.Hostage2;
import gameobjects.hostages.Hostage3;

public class ObjectFactory {

    public static GameObjects generateObject() {
        int chanceAlienGenerator = Randomizer.generate();

        if(chanceAlienGenerator <= 25) {
            return new BasicAlien();
        }

        if(chanceAlienGenerator <= 55) {
            return new WarriorAlien();
        }

        if(chanceAlienGenerator <= 70) {
            return new ChiefAlien();
        }

        if(chanceAlienGenerator <= 80) {
            return new Hostage1();
        }

        if(chanceAlienGenerator < 90) {
            return new Hostage2();
        }
        return new Hostage3();
    }
}
