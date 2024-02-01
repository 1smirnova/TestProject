package libs;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomLettersGenerator {

    public static String generateRandomLetters(int length) {
        // Generate a random string containing only letters
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static void main(String[] args) {
        // Example usage
        int length = 10;
        String randomLetters = generateRandomLetters(length);
        System.out.println("Random Letters: " + randomLetters);
    }
}
