import java.io.*;

public class Main {
    static char[][] match;

    public static boolean isSquare(int x, int y, int dist) {
        for (int i = x; i < x + dist * 3; i++) {
            if (match[i][y] == '.') return false;
            if (match[i][y + dist * 3] == '.') return false;
        }

        for (int j = y; j < y + dist * 3; j++) {
            if (match[x][j] == '.') return false;
            if (match[x + dist * 3][j] == '.') return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        match = new char[10][10];
        int A = 0, B = 0;

        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                match[i][j] = line.charAt(j);
                if (match[i][j] == '-' || match[i][j] == '|') A++;
            }
        }

        A = 24 - A / 2;

        if (isSquare(0,0, 1)) B++;
        if (isSquare(0,3, 1)) B++;
        if (isSquare(0,6, 1)) B++;
        if (isSquare(3,0, 1)) B++;
        if (isSquare(3,3, 1)) B++;
        if (isSquare(3,6, 1)) B++;
        if (isSquare(6,0, 1)) B++;
        if (isSquare(6,3, 1)) B++;
        if (isSquare(6,6, 1)) B++;


        if (isSquare(0,0, 2)) B++;
        if (isSquare(0,3, 2)) B++;
        if (isSquare(3,0, 2)) B++;
        if (isSquare(3,3, 2)) B++;


        if (isSquare(0,0, 3)) B++;

        System.out.println(A + " " + B);
    }
}