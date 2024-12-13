class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
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

public class ThreadExample {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Tråd 1");
        MyThread thread2 = new MyThread("Tråd 2");

        thread1.start(); // Startar tråd 1
        thread2.start(); // Startar tråd 2
    }
}
