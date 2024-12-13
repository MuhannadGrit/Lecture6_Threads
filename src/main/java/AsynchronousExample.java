//Parallel Execution: In the AsynchronousExample,
// you are using threads to handle each task,
// allowing them to execute simultaneously.
// This means that tasks can start and complete independently of one another,
// potentially overlapping in time.
public class AsynchronousExample {
    public static void main(String[] args) {
        System.out.println("Startar asynkrona uppgifter...");

        // Skapar trådar för varje uppgift
        Thread task1 = new Thread(() -> performTask("Uppgift 1", 2000));
        Thread task2 = new Thread(() -> performTask("Uppgift 2", 3000));
        Thread task3 = new Thread(() -> performTask("Uppgift 3", 1000));

        // Startar trådarna
        task1.start();
        task2.start();
        task3.start();

        System.out.println("Alla uppgifter är startade!");
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
