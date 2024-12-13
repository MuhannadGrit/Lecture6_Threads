class CountUpTask implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Räknar upp: " + i);
            try {
                Thread.sleep(1000); // Pausar i 1 sekund
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Räkna upp-task klar!");
    }
}

class CountDownTask extends Thread {
    @Override
    public void run() {
        for (int i = 5; i >= 1; i--) {
            System.out.println("Räknar ner: " + i);
            try {
                Thread.sleep(1000); // Pausar i 1 sekund
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Räkna ner-task klar!");
    }
}

public class DifferentTasksExample {
    public static void main(String[] args) {
        // Skapa trådar med olika uppgifter
        Thread countUpThread = new Thread(new CountUpTask());
        Thread countDownThread = new CountDownTask();

        // Starta trådarna
        countUpThread.start();
        countDownThread.start();
    }
}
