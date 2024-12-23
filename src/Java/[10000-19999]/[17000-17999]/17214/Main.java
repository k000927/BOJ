import java.io.*;
import java.util.*;

public class Main {
    static String exp;
    static ArrayList<String> ans;

    static void integral(int coefficient, int degree) {
        coefficient /= (degree + 1);
        degree += 1;

        StringBuilder ret = new StringBuilder();
        if (coefficient == 1) ret.append("x".repeat(degree));
        else if (coefficient != 0) ret.append(coefficient).append("x".repeat(degree));

        if (ret.isEmpty()) return;
        ans.add(ret.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        exp = br.readLine();
        ans = new ArrayList<>();

        StringBuilder coefficient = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == 'x') {
                integral(Integer.parseInt(coefficient.toString()), 1);
                coefficient = new StringBuilder();
            } else if (exp.charAt(i) == '+' || exp.charAt(i) == '-') {
                ans.add(String.valueOf(exp.charAt(i)));
            } else {
                coefficient.append(exp.charAt(i));
            }
        }

        if (!coefficient.isEmpty()) integral(Integer.parseInt(coefficient.toString()), 0);

        for (String an : ans) {
            System.out.print(an);
        }

        if (!ans.isEmpty()) System.out.print("+");
        System.out.println("W");
    }
}