import java.io.*;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        File sampleFile = new File("sample.txt");
        byte[] content = new byte[] {'J', 'a', 'v', 'a'};

        try {
            OutputStream outputStream = new ByteArrayOutputStream();
            outputStream.write(content);
            outputStream.close();
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }
}