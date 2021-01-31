import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            if (number == 1) {continue;}
            executor.submit(()-> new PrintIfPrimeTask(number).run());
        }
        executor.shutdown();
        executor.awaitTermination(5,TimeUnit.SECONDS);
        System.exit(0);
    }
}

class PrintIfPrimeTask implements Runnable {
    private final int number;

    public PrintIfPrimeTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        BigInteger bigInteger = BigInteger.valueOf(number);
        boolean probablePrime = bigInteger.isProbablePrime((int) Math.log(number));
        if (probablePrime) {
            System.out.println(number);
        }
    }
}