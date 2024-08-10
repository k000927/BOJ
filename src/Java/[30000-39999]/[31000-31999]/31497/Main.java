import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] people = new String[n];
        for (int i = 0; i < n; i++) {
            people[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            String question = "? " + people[i];

            System.out.println(question);
            System.out.flush();

            String answer = br.readLine();
            if (answer.equals("1")) {
                System.out.println("! " + people[i]);
                System.out.flush();
                System.exit(0);
            }

            System.out.println(question);
            System.out.flush();

            answer = br.readLine();
            if (answer.equals("1")) {
                System.out.println("! " + people[i]);
                System.out.flush();
                System.exit(0);
            }
        }
    }
}
