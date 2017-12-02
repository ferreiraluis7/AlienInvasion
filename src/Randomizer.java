public class Randomizer {

    public static int generate(int minNum, int maxNum) {
        return (int) (Math.random() * ((maxNum - minNum) + minNum));
    }
}
