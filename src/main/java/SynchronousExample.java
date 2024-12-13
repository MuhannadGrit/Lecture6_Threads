//Sequential Execution: Tasks are executed one after the other.
// Each task must complete before the next one begins. This is a straightforward,
// linear approach where each task blocks the next one until it is completed.
public class SynchronousExample {
    public static void main(String[] args) {
        System.out.println("Startar synkrona uppgifter...");

        // Uppgift 1
        performTask("Uppgift 1", 2000);

        // Uppgift 2
        performTask("Uppgift 2", 3000);

        // Uppgift 3
        performTask("Uppgift 3", 1000);

        System.out.println("Alla uppgifter är klara!");
    }

    private static void performTask(String taskName, int duration) {
        try {
            System.out.println(taskName + " påbörjad...");
            Thread.sleep(duration); // Simulerar en lång uppgift
            System.out.println(taskName + " avslutad!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
