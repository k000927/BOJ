import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder start = new StringBuilder(br.readLine());
        StringBuilder end = new StringBuilder(br.readLine());

        while (start.length() != end.length()) {
            if (end.charAt(end.length() - 1) == 'A') {
                end = new StringBuilder(end.substring(0, end.length() - 1));
            } else {
                end = new StringBuilder(end.substring(0, end.length() - 1));
                end.reverse();
            }
        }

        if (end.toString().contentEquals(start)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}