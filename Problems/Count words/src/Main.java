import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sd = reader.readLine().split(" +");
        if (sd.length == 0) {
            System.out.println("0");
        } else {
            if (sd[0].equals("")) {
                System.out.println(sd.length - 1);
            } else {
                System.out.println(sd.length);
            }
        }
        reader.close();
    }
}