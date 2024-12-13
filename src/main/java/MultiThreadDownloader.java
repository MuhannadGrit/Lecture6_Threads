import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

class WebPageDownloader implements Runnable {
    private String url;

    public WebPageDownloader(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        try {
            System.out.println("Börjar hämta: " + url);
            URL website = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                // Simulerar att skriva ut innehållet (vi kan istället spara det i en fil)
                System.out.println(url + " -> " + inputLine.substring(0, Math.min(50, inputLine.length())) + "...");
            }
            in.close();
            System.out.println("Hämtning klar: " + url);
        } catch (Exception e) {
            System.out.println("Fel vid hämtning från: " + url);
            e.printStackTrace();
        }
    }
}

public class MultiThreadDownloader {
    public static void main(String[] args) {
        // Lista över URL:er att ladda ner
        String[] urls = {
                "https://www.example.com",
                "https://www.wikipedia.org",
                "https://www.github.com"
        };

        // Skapa och starta en tråd för varje URL
        for (String url : urls) {
            Thread thread = new Thread(new WebPageDownloader(url));
            thread.start();
        }
    }
}
