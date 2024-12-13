class CustomerThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Kund: Jag vill ha en läsk.");
            Thread.sleep(1000); // Simulerar beställningstid
            System.out.println("Kund: Beställning gjord.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PreparationThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Tillredning: Förbereder läsken...");
            Thread.sleep(2000); // Simulerar tillredningstid
            System.out.println("Tillredning: Läsken är klar!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DeliveryThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Leverans: Läsken levereras till kunden...");
            Thread.sleep(1500); // Simulerar leveranstid
            System.out.println("Leverans: Läsken är levererad!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class exercise {
    public static void main(String[] args) {
        System.out.println("Startar läskmaskinen...");

        // Skapa trådar
        CustomerThread customerThread = new CustomerThread();
        PreparationThread preparationThread = new PreparationThread();
        DeliveryThread deliveryThread = new DeliveryThread();

        // Kör trådar
        customerThread.start();
        try {
            customerThread.join(); // Vänta tills kunden är klar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        preparationThread.start();
        try {
            preparationThread.join(); // Vänta tills tillredningen är klar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        deliveryThread.start();
        try {
            deliveryThread.join(); // Vänta tills leveransen är klar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Processen är avslutad. Tack för att du använder läskmaskinen!");
    }
}
