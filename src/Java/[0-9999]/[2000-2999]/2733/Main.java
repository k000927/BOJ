import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T;
    static int[] byteArray;
    static int pointer;
    static String inst;
    static int index;
    static HashMap<Integer, Integer> bracket;

    static void incPointer() {
        if (pointer == 32767) pointer = 0;
        else pointer++;
    }

    static void decPointer() {
        if (pointer == 0) pointer = 32767;
        else pointer--;
    }

    static void addValue() {
        if (byteArray[pointer] == 255) byteArray[pointer] = 0;
        else byteArray[pointer]++;
    }

    static void subValue() {
        if (byteArray[pointer] == 0) byteArray[pointer] = 255;
        else byteArray[pointer]--;
    }

    static void print() throws IOException {
        bw.write((char) byteArray[pointer]);
    }

    static void frontBracket() {
        if (byteArray[pointer] == 0) index = bracket.get(index);
    }

    static void backBracket() {
        if (byteArray[pointer] != 0) index = bracket.get(index);
    }

    static boolean compile() {
        bracket = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < inst.length(); i++) {
            char c = inst.charAt(i);
            if (c == '[') stack.push(i);
            else if (c == ']') {
                if (stack.isEmpty()) return false;
                int frontBracket = stack.pop();
                bracket.put(frontBracket, i);
                bracket.put(i, frontBracket);
            }
        }
        return stack.isEmpty();
    }

    static void comment() {
        while (inst.charAt(index) != 'N') index++;
    }

    static void brainFuck() throws IOException {
        byteArray = new int[32768];
        pointer = 0;

        StringBuilder instBuilder = new StringBuilder();
        String temp = "";
        while (!(temp = br.readLine()).equals("end")) {
            instBuilder.append(temp).append("N");
        }

        inst = instBuilder.toString();
        if (!compile()) {
            bw.write("COMPILE ERROR");
            return;
        }

        for (index = 0; index < inst.length(); index++) {
            char c = inst.charAt(index);
            switch (c) {
                case '>' -> incPointer();
                case '<' -> decPointer();
                case '+' -> addValue();
                case '-' -> subValue();
                case '.' -> print();
                case '[' -> frontBracket();
                case ']' -> backBracket();
                case '%' -> comment();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            bw.write("PROGRAM #" + i + ":\n");
            brainFuck();
            bw.write('\n');
        }
        bw.flush();
    }
}