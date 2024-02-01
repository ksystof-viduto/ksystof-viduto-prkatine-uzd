package utils;

import java.util.Random;

public class DataGenerator {
    public static String getRandomUsername() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return "user" + randomInt;
    }

    public static String getRandomPassword() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        return "pass" + randomInt;
    }
}
