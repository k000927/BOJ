import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, Integer> leftSide;
    static HashMap<String, Integer> rightSide;

    static class Atom implements Comparable<Atom> {
        String name;
        int num;
        String state;

        Atom(String name, int num, String state) {
            this.name = name;
            this.num = num;
            this.state = state;
        }

        @Override
        public int compareTo(Atom o) {
            return name.compareTo(o.name);
        }

        public String toString() {
            if(num > 1) return String.format("You have %s %d atoms of %s.", state, num, name);
            else return String.format("You have %s %d atom of %s.", state, num, name);
        }
    }
    static boolean input() throws IOException {
        String temp = br.readLine();
        if (temp.equals("#")) return false;

        leftSide = new HashMap<>();
        rightSide = new HashMap<>();

        String[] split = temp.split("=");
        String[] leftEq = split[0].strip().split("\\+");
        String[] rightEq = split[1].strip().split("\\+");

        for (String s : leftEq) {
            HashMap<String, Integer> parsedAtom = parseInput(s.strip());

            for (String atom : parsedAtom.keySet()) {
                if (leftSide.containsKey(atom)) leftSide.put(atom, leftSide.get(atom) + parsedAtom.get(atom));
                else leftSide.put(atom, parsedAtom.get(atom));
            }
        }

        for (String s : rightEq) {
            HashMap<String, Integer> parsedAtom = parseInput(s.strip());

            for (String atom : parsedAtom.keySet()) {
                if (rightSide.containsKey(atom)) rightSide.put(atom, rightSide.get(atom) + parsedAtom.get(atom));
                else rightSide.put(atom, parsedAtom.get(atom));
            }
        }

        return true;
    }

    private static HashMap<String, Integer> parseInput(String mole) {
        HashMap<String, Integer> atomSet = new HashMap<>();
        StringBuilder curAtom = new StringBuilder();
        StringBuilder atomCount = new StringBuilder();
        StringBuilder globalCount = new StringBuilder();
        for (int i = 0; i < mole.length(); i++) {
            if ('0' <= mole.charAt(i) && mole.charAt(i) <= '9') {
                if (curAtom.isEmpty()) globalCount.append(mole.charAt(i));
                else atomCount.append(mole.charAt(i));
            } else {
                if ('A' <= mole.charAt(i) && mole.charAt(i) <= 'Z') {
                    if (!curAtom.isEmpty()) {
                        int count = !atomCount.isEmpty() ? Integer.parseInt(atomCount.toString()) : 1;
                        int gCount = !globalCount.isEmpty() ? Integer.parseInt(globalCount.toString()) : 1;
                        String atom = curAtom.toString();
                        if (atomSet.containsKey(atom)) atomSet.put(atom, atomSet.get(atom) + count * gCount);
                        else atomSet.put(atom, count * gCount);

                        curAtom = new StringBuilder();
                        atomCount = new StringBuilder();
                    }
                }
                curAtom.append(mole.charAt(i));
            }
        }

        int count = !atomCount.isEmpty() ? Integer.parseInt(atomCount.toString()) : 1;
        int gCount = !globalCount.isEmpty() ? Integer.parseInt(globalCount.toString()) : 1;
        String atom = curAtom.toString();
        if (atomSet.containsKey(atom)) atomSet.put(atom, atomSet.get(atom) + count * gCount);
        else atomSet.put(atom, count * gCount);

        return atomSet;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; input(); i++) {
            PriorityQueue<Atom> detail = new PriorityQueue<>();
            boolean flag = true;

            for (String atom : leftSide.keySet()) {
                if (rightSide.containsKey(atom) && Objects.equals(leftSide.get(atom), rightSide.get(atom))) continue;
                else {
                    flag = false;
                    int numOfDestroy = leftSide.get(atom) - rightSide.getOrDefault(atom, 0);
                    if (numOfDestroy < 0) continue;
                    else detail.add(new Atom(atom, numOfDestroy, "destroyed"));
                }
            }

            for (String atom : rightSide.keySet()) {
                if (leftSide.containsKey(atom) && Objects.equals(leftSide.get(atom), rightSide.get(atom))) continue;
                else {
                    flag = false;
                    int numOfCreate = rightSide.get(atom) - leftSide.getOrDefault(atom, 0);
                    if (numOfCreate < 0) continue;
                    else detail.add(new Atom(atom, numOfCreate, "created"));
                }
            }

            if (flag) bw.write(String.format("Equation %d is balanced.\n", i));
            else {
                bw.write(String.format("Equation %d is unbalanced.\n", i));
                while(!detail.isEmpty()) {
                    bw.write(detail.poll().toString() + "\n");
                }
                bw.write("\n");
            }
        }

        bw.flush();
    }
}