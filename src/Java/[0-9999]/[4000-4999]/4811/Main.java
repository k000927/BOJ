import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] brace;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        brace = new long[31];
        brace[0] = 1;

        for (int i = 1; i <= 30; i++) {
            for (int j = 0; j < i; j++) {
                brace[i] += brace[j] * brace[i-1-j];
            }
        }

        int temp;
        StringBuilder ans = new StringBuilder();
        while(true){
            temp = Integer.parseInt(br.readLine());
            if(temp == 0)
                break;
            ans.append(brace[temp]).append('\n');
        }

        System.out.print(ans);
    }
}