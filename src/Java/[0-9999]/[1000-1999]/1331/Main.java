import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static ArrayList<String> getNext(String curPos) {
        ArrayList<String> nextPos = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            char first = (char) (curPos.charAt(0) + dx[i]);
            char second = (char) (curPos.charAt(1) + dy[i]);

            if (first < 'A' || first > 'F' || second < '1' || second > '6') continue;
            nextPos.add(String.valueOf(first) + String.valueOf(second));
        }
        return nextPos;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Boolean> visited = new HashMap<>();
        String curPos = br.readLine();

        String startPos = curPos;
        String lastPos = null;

        visited.put(curPos, true);
        for (int i = 1; i < 36; i++) {
            ArrayList<String> next = getNext(curPos);

            String nextPos = br.readLine();
            if (!next.contains(nextPos) || visited.containsKey(nextPos)) {
                System.out.println("Invalid");
                System.exit(0);
            }
            visited.put(nextPos, true);
            curPos = nextPos;
            lastPos = nextPos;
        }

        if (!getNext(lastPos).contains(startPos)) {
            System.out.println("Invalid");

        } else System.out.println("Valid");
    }
}