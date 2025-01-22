package verification;

import java.util.Random;

public class code {
    public static String verificationCode() {
        Random random = new Random();

        StringBuilder letters = new StringBuilder();
        // Generate 4 random letters
        for (int i = 0; i < 4; i++) {
            char randomChar = (char) (random.nextBoolean() ? 'A' + random.nextInt(26) : 'a' + random.nextInt(26));
            letters.append(randomChar);
        }
        // Generate 1 random digit
        char randomDigit = (char) ('0' + random.nextInt(10));
        letters.append(randomDigit);
        // Shuffle the letters
        int randomIndex = random.nextInt(4);
        var temp = letters.charAt(randomIndex);
        letters.setCharAt(randomIndex, letters.charAt(4));
        letters.setCharAt(4, temp);

        return letters.toString();
    }
}
