package GenericUtility;

import org.testng.annotations.Test;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomNumber {

    @Test
    public void testRandomNumber() {
        Random rand = new Random();
        int diff=rand.nextInt(1000);
        System.out.println(diff);
    }
}
