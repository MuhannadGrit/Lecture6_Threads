class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " kör: " + i);
            try {
                Thread.sleep(1000); // Pausar tråden i 1 sekund
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " är klar!");
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task("Tråd 1"));
        Thread thread2 = new Thread(new Task("Tråd 2"));

        thread1.start(); // Startar tråd 1
        thread2.start(); // Startar tråd 2
    }
}
