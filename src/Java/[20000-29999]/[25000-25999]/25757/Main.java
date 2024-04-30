import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String G = st.nextToken();
        int player = 0;
        if(G.equals("Y")) player = 1;
        else if(G.equals("F")) player = 2;
        else player = 3;

        HashSet<String> friend = new HashSet<>();


        for (int i = 0; i < N; i++) {
            String f = br.readLine();
            if(friend.contains(f)) continue;
            friend.add(f);
        }
        System.out.println((int) Math.floor(friend.size()/player));
    }
}