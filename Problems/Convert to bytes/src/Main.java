import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        byte[] a = inputStream.readAllBytes();
        for (Byte b:a) {
            System.out.print(b);
        }

    }
}