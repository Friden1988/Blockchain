import java.util.Locale;
import java.util.Scanner;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
        String sr = scanner.nextLine();
        if (sr.equals(sr.toUpperCase(Locale.ROOT))) {
            System.out.println("FINISHED");
            break;
        } else {
            System.out.println(sr.toUpperCase(Locale.ROOT));
        }
        }
    }
}