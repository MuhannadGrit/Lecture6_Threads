import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // Kör en uppgift efter 3 sekunder
        scheduler.schedule(() -> {
            System.out.println("Uppgift körs efter en fördröjning: " + Thread.currentThread().getName());
        }, 3, TimeUnit.SECONDS);

        // Kör en uppgift varje 2 sekunder
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Uppgift körs periodiskt: " + Thread.currentThread().getName());
        }, 1, 2, TimeUnit.SECONDS);

        // Schemalägger avslutning efter 10 sekunder
        scheduler.schedule(() -> {
            scheduler.shutdown();
            System.out.println("Schemalagd pool avslutad.");
        }, 10, TimeUnit.SECONDS);
    }
}
