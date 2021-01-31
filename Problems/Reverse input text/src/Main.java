import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String str = "Geeks";

        // conversion from String object to StringBuffer
        StringBuffer sbr = new StringBuffer(reader.readLine());
        // To reverse the string
        sbr.reverse();
        System.out.println(sbr);
        reader.close();
    }
}