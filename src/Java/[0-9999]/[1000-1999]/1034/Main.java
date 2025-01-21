import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int k;
    static int ans = 0;
    static HashMap<String, Integer> rampMap = new HashMap<>();

    static void clickToOn(String ramp) {
        StringBuilder sb = new StringBuilder();
        int click = 0;
        for(int i = 0; i< m; i++){
            if(ramp.charAt(i) == '0') click++;
            sb.append(ramp.charAt(i) == '0' ? '1' : '0');
        }

        if(click <= k && (k-click) % 2 == 0){
            if(!rampMap.containsKey(sb.toString())){
                rampMap.put(sb.toString(), 1);
            }
            else{
                rampMap.put(sb.toString(), rampMap.get(sb.toString()) + 1);
            }

            ans = Math.max(ans, rampMap.get(sb.toString()));
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<String> rampList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            rampList.add(br.readLine());
        }

        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String ramp = rampList.get(i);
            clickToOn(ramp);
        }
        
        System.out.println(ans);
    }
}
