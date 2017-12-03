import gameobjects.GameObjects;
import gameobjects.aliens.ChiefAlien;
import gameobjects.aliens.BasicAlien;
import gameobjects.aliens.WarriorAlien;
import gameobjects.hostages.Hostage1;
import gameobjects.hostages.Hostage2;
import gameobjects.hostages.Hostage3;

public class ObjectFactory {

    static GameObjects generateObject() {
        int chanceObjectGenerator = Randomizer.generate(0,101);

        if(chanceObjectGenerator <= 30) {
            return new BasicAlien();
        }

        if(chanceObjectGenerator <= 60) {
            return new WarriorAlien();
        }

        if(chanceObjectGenerator <= 85) {
            return new ChiefAlien();
        }

        if(chanceObjectGenerator <= 90) {
            return new Hostage1();
        }

        if(chanceObjectGenerator <= 95) {
            return new Hostage2();
        }
        return new Hostage3();
    }
}
