public class Counter {
    private int count = 0;

    // Synchronized metod för att öka räknaren
    public synchronized void increment() {
        count++; // Ökar räknaren med 1
        System.out.println(Thread.currentThread().getName() + " ökade räknaren till: " + count);
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        // Skapar trådar
        Thread thread1 = new Thread(new CounterIncrementTask(counter), "Tråd 1");
        Thread thread2 = new Thread(new CounterIncrementTask(counter), "Tråd 2");

        // Startar trådarna
        thread1.start();
        thread2.start();

        // Vänta på att båda trådarna ska avsluta
        //Metoden thread1.join(); i Java används för att pausa den tråd som anropar metoden tills den tråd som join()-metoden
        // har anropats på har slutfört sin exekvering.
        // Det innebär att huvudtråden (eller vilken tråd som helst som kallar på join()) kommer att vänta
        // tills thread1 har avslutat sitt arbete innan den fortsätter med sin egen exekvering.
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Slutligt värde på räknaren: " + counter.count);
    }
}

class CounterIncrementTask implements Runnable {
    private Counter counter;

    public CounterIncrementTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment();
            try {
                Thread.sleep(100); // Lägg till lite fördröjning för att simulera verkliga scenarier
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
