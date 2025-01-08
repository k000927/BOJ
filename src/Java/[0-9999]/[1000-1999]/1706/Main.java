import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = row.charAt(j);
            }
        }

        String min = String.valueOf((char)('z'+1));	// 존재할 수 있는 최대 문자열보다 항상 사전순으로 더 큰 문자열이다.
        for (int i = 0; i < r; i++) {	// 가로로 체크한다.
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= c; j++) {
                if (j==c || arr[i][j] == '#') {	// 가로로 끝에 도착하거나, #을 만날 경우 체크한다.
                    String tmp = sb.toString();
                    if (tmp.length() >= 2 && min.compareTo(tmp) > 0)
                        min = tmp;
                    sb = new StringBuilder();
                } else {
                    sb.append(arr[i][j]);
                }
            }
        }

        for (int j = 0; j < c; j++) {	// 세로로 체크한다.
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= r; i++) {
                if (i==r || arr[i][j] == '#') { // 세로로 끝에 도착하거나, #을 만날 경우 체크한다.
                    String tmp = sb.toString();
                    if (tmp.length() >= 2 && min.compareTo(tmp) > 0)
                        min = tmp;
                    sb = new StringBuilder();
                } else {
                    sb.append(arr[i][j]);
                }
            }
        }
        System.out.println(min);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}