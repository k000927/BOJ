import java.io.*;

public class Main {
    static boolean isBracketOpened = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        String input = br.readLine();

        for (char c : input.toCharArray()) {
            if(c == '<') {
                ans.append(temp.reverse());
                temp = new StringBuilder("<");
                isBracketOpened = true;
            }
            else if (c == '>') {
                temp.append('>');
                ans.append(temp);
                temp = new StringBuilder();
                isBracketOpened = false;
            }
            else if(c == ' ') {
                if(!isBracketOpened) {
                    ans.append(temp.reverse()).append(' ');
                    temp = new StringBuilder();
                }
                else {
                    temp.append(' ');
                }
            } else {
                temp.append(c);
            }
        }

        ans.append(temp.reverse());

        System.out.println(ans);
    }
}