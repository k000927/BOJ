import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            map.put(subject, score);
        }

        // 여기서 map의 key-value를 지우기 시작합니다.
        // M값을 하나씩 줄이지만 사실 M -= K; 를 해도 무방합니다.
        // ans 값은 정답을 위한 기준이 되는 값이 될 것입니다.
        int ans = 0;
        for (int i = 0; i < K; i++) {
            String colSubject = br.readLine();
            ans += map.get(colSubject);
            map.remove(colSubject);
            M--;
        }

        int ansOfMax = ans;
        int ansOfMin = ans;

        // 여기서 정렬과 리스트를 만들어 줍니다.
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);

        // 이후에 j는 N - K - 1을 해줍니다. 이유는
        // 이렇게 해야 뒤에서부터 탐색을 하기 때문입니다. (max를 구할 목적)
        int j = N - K - 1;

        // 그리고 여기서 값을 점점 더해주었습니다.
        for (int i = 0; i < M; i++, j--) {
            ansOfMax += list.get(j);
            ansOfMin += list.get(i);
        }

        // 짜잔~
        sb.append(ansOfMin).append(" ").append(ansOfMax);
        System.out.println(sb);
    }
}