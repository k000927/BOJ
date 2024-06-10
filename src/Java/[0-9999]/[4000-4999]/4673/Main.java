import javax.swing.text.StyledEditorKit;
import java.io.*;
import java.util.*;

public class Main {

    static int getNext(int num) {
        int next = num;
        String temp = String.valueOf(num);

        for (int i = 0; i < temp.length(); i++) {
            next += (int) temp.charAt(i) - 48;
        }
        if (next > 10000) return 0;
        return next;
    }

    public static void main(String[] args) throws IOException {
        Boolean[] num = new Boolean[10001];
        Arrays.fill(num, false);

        for (int i = 1; i < 10001; i++) {
            if (num[i]) continue;

            int next = getNext(i);
            while (!num[next]) {
                if (i == next) break;
                num[next] = true;
                next = getNext(next);
            }
        }

        for (int i = 1; i < 10001; i++) {
            if (!num[i]) System.out.println(i);
        }
    }
}