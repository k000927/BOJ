import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cakeIsMissing = br.readLine();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<String> suspects = new PriorityQueue<>();
        boolean dongho = false;
        for (int i = 0; i < n; i++) {
            String suspect = br.readLine();
            // 1. 동호가 사건 당시에 존재했을 경우
            if (suspect.equals("dongho")) {
                dongho = true;
            }
            suspects.add(suspect);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String alibi = br.readLine();
            suspects.remove(alibi);
        }

        if (dongho) System.out.println("dongho");
            // 2. 용의자가 한 명일 경우
        else if (suspects.size() == 1) System.out.println(suspects.poll());
            // 3. bumin이 용의자 중에 있을 경우
        else if (suspects.contains("bumin")) System.out.println("bumin");
            // 4. cake가 용의자 중에 있을 경우
        else if (suspects.contains("cake")) System.out.println("cake");
            // 5. lawyer가 용의자 중에 있을 경우
        else if (suspects.contains("lawyer")) System.out.println("lawyer");
        else if (suspects.isEmpty()) System.out.println("swi");
            // 6. 사전 순 출력
        else System.out.println(suspects.poll());
    }
}
