import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double r = Double.parseDouble(br.readLine());
        System.out.printf("%.6f\n%.6f\n", r * r * Math.PI, r * r * 2);
    }
}