import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        System.out.println("Truststore test");

        if (args.length == 0) {
            System.out.println("parameters: [url] <truststore-file> <password>");
            return;
        }

        URL url;
        try {
            url = new URL(args[0]);
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
            return;
        }
        System.out.println("Look-up " + url);

        if (args.length >= 2) {
            System.setProperty("javax.net.ssl.trustStore", args[1]);

            if (args.length >= 3) {
                System.setProperty("javax.net.ssl.trustStorePassword", args[2]);
                System.out.println("Using provided trust store password (" + args[2].length() + " chars)");
            } else {
                System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
                System.out.println("Using standard password (changeit)");
            }
            System.setProperty("javax.net.ssl.trustStoreType", "JKS");

            System.out.println("Using truststore file " + args[1]);
        } else {
            System.out.println("Using system's truststore");
        }

        BufferedReader br;
        int numberOfLines = 0;
        try (InputStream is = url.openStream()) {
            br = new BufferedReader(new InputStreamReader(is));

            while ((br.readLine()) != null) {
                numberOfLines++;
            }
            System.out.println("Recived " + numberOfLines + " lines of data");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("Truststore finished");
    }
}
