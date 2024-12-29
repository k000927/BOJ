import java.io.*;
import java.util.*;

public class Main {
    static HashMap<String, String> dict = new HashMap<>();
    static HashSet<String> ambiguous = new HashSet<>();

    static boolean isAbbreviation(String word) {
        if (word.length() <= 2) return false;
        word = word.toLowerCase();
        if (!Character.isAlphabetic(word.charAt(0)) || !Character.isAlphabetic(word.charAt(word.length() - 1)))
            return false;
        for (int i = 1; i < word.length() - 1; i++) {
            if (!Character.isDigit(word.charAt(i))) return false;
        }
        return true;
    }

    static void printToken(String token) {
        if (!dict.containsKey(token.toLowerCase())) System.out.print(token);
        else if(ambiguous.contains(token.toLowerCase())) System.out.print(token);
        else {
            char prefix = token.charAt(0);
            char suffix = token.charAt(token.length() - 1);

            if ('A' <= prefix && prefix <= 'Z' && 'A' <= suffix && suffix <= 'Z')
                System.out.print(dict.get(token.toLowerCase()).toUpperCase());
            else if ('a' <= prefix && prefix <= 'z' && 'a' <= suffix && suffix <= 'z')
                System.out.print(dict.get(token.toLowerCase()));
            else {
                String original = dict.get(token.toLowerCase());
                System.out.print(original.toUpperCase().charAt(0));
                System.out.print(original.substring(1));
            }
        }
    }

    static void addAbbreviation(String word) {
        word = word.toLowerCase();

        String abbreviation = String.valueOf(word.charAt(0)) + (word.length() - 2) + word.charAt(word.length() - 1);
        if (dict.containsKey(abbreviation) && !word.equals(dict.get(abbreviation))) {
            ambiguous.add(abbreviation);
        } else dict.put(abbreviation, word);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        while ((line = br.readLine()) != null) {
            StringBuilder token = new StringBuilder();

            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                if (Character.isLetterOrDigit(ch)) {
                    token.append(ch);
                } else {
                    addAns(token);
                    System.out.print(ch);
                }
            }

            addAns(token);
            System.out.print("\n");
        }
    }

    private static void addAns(StringBuilder token) throws IOException {
        if (!token.isEmpty()) {
            String tokenStr = token.toString();

            if (isAbbreviation(tokenStr)) {
                printToken(tokenStr);
            } else {
                addAbbreviation(tokenStr);
                System.out.print(tokenStr);
            }

            token.setLength(0);
        }
    }
}
