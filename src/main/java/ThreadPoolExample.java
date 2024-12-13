import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Skapa en thread pool med 3 trådar
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // Skicka uppgifter till thread poolen
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.execute(() -> {
                System.out.println("Uppgift " + taskId + " körs av " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000); // Simulerar en uppgift som tar tid
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Uppgift " + taskId + " är klar.");
            });
        }

        // Stäng thread poolen
        executor.shutdown();
    }
}
