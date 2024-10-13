import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static Character[][] screen;
    static ArrayList<Window> windows;
    static Character[][] ans;

    static class Window implements Comparable<Window> {
        String name;
        int h;
        int w;

        Window(String name, int h, int w) {
            this.name = name;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Window o) {
            return name.compareTo(o.name);
        }

        public String[] getWindow() {
            int left = (w - name.length() - 2) / 2;
            int right = w - name.length() - 2 - left;
            String[] window = new String[h + 2];

            StringBuilder builder = new StringBuilder();
            builder.append("+").append("-".repeat(left)).append("|").append(name).append("|").append("-".repeat(right)).append("+");
            window[0] = builder.toString();

            for (int i = 1; i <= h; i++) {
                builder = new StringBuilder();
                builder.append("|").append(".".repeat(w)).append("|");
                window[i] = builder.toString();
            }

            builder = new StringBuilder();
            builder.append("+").append("-".repeat(w)).append("+");
            window[h + 1] = builder.toString();

            return window;
        }
    }

    static void getWindow(int x, int y) {
        StringBuilder name = new StringBuilder();
        int w = 1;
        int h = 1;

        try {
            while (true) {
                if (screen[x][y + w] == '-') {
                    w++;
                } else if (screen[x][y + w] == '+') {
                    break;
                } else {
                    if (screen[x][y + w] == '-') {
                        w++;
                        break;
                    } else {
                        name.append(screen[x][y + w]);
                        w++;
                    }
                }
            }

            while (true) {
                if (screen[x + h][y + w] == '+') {
                    break;
                } else {
                    h++;
                }
            }

            String windowName = name.toString();
            windowName = windowName.substring(1, windowName.length() - 1);
            windows.add(new Window(windowName, h - 1, w - 1));
        } catch (Exception e) {
            return;
        }

    }

    static void print(Window window, int level) {
        String[] w = window.getWindow();

        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < w[0].length(); j++) {
                ans[level + i][level + j] = w[i].charAt(j);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        windows = new ArrayList<>();
        screen = new Character[n][m];
        ans = new Character[n][m];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                screen[i][j] = temp.charAt(j);
                ans[i][j] = '.';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (screen[i][j] == '+' && i + 1 < n && j + 1 < m && screen[i + 1][j] == '|' && screen[i][j + 1] == '-')
                    getWindow(i, j);
            }
        }

        int level = 0;
        Collections.sort(windows);
        while (!windows.isEmpty()) {
            Window window = windows.remove(0);
            print(window, level++);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
}