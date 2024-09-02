import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        String str = br.readLine();

        List<Character> kids = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            boolean temp = false;
            for (int j = 0; j < kids.size(); j++) {
                if(kids.get(j) < str.charAt(i)){
                    temp = true;
                    k -= str.charAt(i) - kids.get(j) - 1;
                    kids.set(j, str.charAt(i));
                    break;
                }
            }
            if(temp) continue;
            kids.add(str.charAt(i));
            k -= str.charAt(i) - 'A';
        }

        if(k < 0) System.out.println("Impossible");
        else System.out.println(kids.size());
    }
}