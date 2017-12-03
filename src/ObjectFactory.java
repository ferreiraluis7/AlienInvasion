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

        if(chanceObjectGenerator <= 40) {
            return new BasicAlien();
        }

        if(chanceObjectGenerator <= 65) {
            return new WarriorAlien();
        }

        if(chanceObjectGenerator <= 90) {
            return new ChiefAlien();
        }

        if(chanceObjectGenerator <= 93) {
            return new Hostage1();
        }

        if(chanceObjectGenerator <= 96) {
            return new Hostage2();
        }
        return new Hostage3();
    }
}
