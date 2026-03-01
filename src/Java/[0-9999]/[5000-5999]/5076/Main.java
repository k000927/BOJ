import java.io.*;
import java.util.*;

public class Main {
    static int index;
    static final String NO_OP_TAG = "STANDALONE_TAG_NO_OP";

    static String extractTagName(String line) {
        StringBuilder tagName = new StringBuilder();

        while (true) {
            char c = line.charAt(index++);

            if (c == '>') {
                if (tagName.toString().endsWith("/")) return NO_OP_TAG;
                StringTokenizer st = new StringTokenizer(tagName.toString());
                return st.nextToken();
            } else {
                tagName.append(c);
            }
        }
    }

    static String parse(String line) {
        Stack<String> tagStack = new Stack<>();

        index = 0;
        while (index < line.length()) {
            char c = line.charAt(index++);

            if (c == '<') {
                String tag = extractTagName(line);
                if (tag.equals(NO_OP_TAG)) continue;
                if (tag.startsWith("/")) {
                    if (tagStack.isEmpty())
                        return "illegal";
                    String prevTag = "/" + tagStack.pop();
                    if (!prevTag.equals(tag)) {
                        return "illegal";
                    }
                } else if (!tag.endsWith("/")) {
                    tagStack.push(tag);
                }
            }
        }

        if (tagStack.isEmpty()) return "legal";
        else return "illegal";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while (!(line = br.readLine()).equals("#")) {
            sb.append(parse(line)).append('\n');
        }

        System.out.println(sb);
    }
}