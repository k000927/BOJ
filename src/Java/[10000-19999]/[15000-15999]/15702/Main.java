import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[] score = new int[n];
        stringTokenizer =  new  StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int max_score = 0;
        int ans = 100001;
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int student = Integer.parseInt(stringTokenizer.nextToken());
            int temp_score = 0;
            for (int j = 0; j < n; j++) {
                String right = stringTokenizer.nextToken();
                if(right.equals("O")) temp_score += score[j];
            }

            if(max_score < temp_score) {
                max_score = temp_score;
                ans = student;
            }
            else if(max_score == temp_score) {
                ans = Math.min(student, ans);
            }
        }

        System.out.println(ans + " " + max_score);

    }
}
