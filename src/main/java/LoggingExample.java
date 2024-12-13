import java.util.logging.Logger;

public class LoggingExample {
    private static final Logger logger = Logger.getLogger(LoggingExample.class.getName());

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        logger.info("Startar programmet...");
        logger.info("Summan är: " + calculateSum(numbers));
    }

    public static int calculateSum(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            logger.fine("Lägger till nummer: " + numbers[i]);
            sum += numbers[i];
        }
        return sum;
    }
}
