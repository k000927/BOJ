import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> PitchToNumber = new HashMap<>();
        HashMap<String, String> PitchToSong = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                sb.append(st.nextToken());
            }
            String pitch = sb.toString();

            if (PitchToNumber.containsKey(pitch)) {
                PitchToNumber.replace(pitch, PitchToNumber.get(pitch) + 1);
            } else PitchToNumber.put(pitch, 1);

            PitchToSong.put(pitch, s);
        }

        for (int i = 0; i < m; i++) {
            String pitch = br.readLine().replace(" ", "");
            if(PitchToNumber.containsKey(pitch)){
                if(PitchToNumber.get(pitch) > 1) System.out.println("?");
                else System.out.println(PitchToSong.get(pitch));
            }else System.out.println("!");
        }
    }
}
