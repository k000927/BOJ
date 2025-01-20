import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int ALength = 0;
    static String s = "";
    static String[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ALength = checkALength();
        int BLength = N - ALength;
        result = new String[N];
        if (ALength != -1 && K != 0) {
            for (int i = 0; i < N; i++) {
                result[i] = "B";
            }
            for (int i = 0; i < ALength - 1; i++) {
                result[i] = "A";
            }
            int c = (ALength - 1) * BLength;
            int r = K - c;
            result[(N - 1) - r] = "A";
        } else if (K == 0) {
            for (int i = 0; i < N; i++) {
                result[i] = "B";
            }
        }
        System.out.println(ALength == -1 ? -1 : String.join("", result));
    }

    public static int checkALength() {
        int ALength = 1;
        int BLength = N - 1;
        while (ALength * BLength < K) {
            if (BLength < 0) return -1;
            ALength++;
            BLength--;
        }
        return ALength;
    }
}