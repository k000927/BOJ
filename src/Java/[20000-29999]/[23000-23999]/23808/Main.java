import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String empty = " ".repeat(n);
        String gol = "@".repeat(n);


        for (int i = 0; i < n; i++) {
            bw.write(gol);
            bw.write(empty);
            bw.write(empty);
            bw.write(empty);
            bw.write(gol);
            bw.write("\n");
        }

        for (int i = 0; i < n; i++) {
            bw.write(gol);
            bw.write(empty);
            bw.write(empty);
            bw.write(empty);
            bw.write(gol);
            bw.write("\n");
        }

        for (int i = 0; i < n; i++) {
            bw.write(gol);
            bw.write(gol);
            bw.write(gol);
            bw.write(gol);
            bw.write(gol);
            bw.write("\n");
        }

        for (int i = 0; i < n; i++) {
            bw.write(gol);
            bw.write(empty);
            bw.write(empty);
            bw.write(empty);
            bw.write(gol);
            bw.write("\n");
        }

        for (int i = 0; i < n; i++) {
            bw.write(gol);
            bw.write(gol);
            bw.write(gol);
            bw.write(gol);
            bw.write(gol);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
