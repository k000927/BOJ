import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            char[] code = br.readLine().toCharArray();

            int index = 0;
            while (true) {
                try {
                    if (index == code.length) {
                        ans.append("YES").append('\n');
                        break;
                    } else if (code[index] == '1' && code[index + 1] == '0') {
                        index += 2;
                        if (code[index] != '0') {
                            ans.append("NO").append('\n');
                            break;
                        }
                        while (code[index] == '0') {
                            index++;
                        }

                        if (code[index] != '1') {
                            ans.append("NO").append('\n');
                            break;
                        }
                        while (index < code.length && code[index] == '1') {
                            index++;
                        }
                    } else if (code[index] == '0' && code[index + 1] == '1') {
                        index += 2;
                    } else {
                        ans.append("NO").append('\n');
                        break;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    ans.append("NO").append('\n');
                    break;
                }
            }
        }

        System.out.print(ans);
    }
}
