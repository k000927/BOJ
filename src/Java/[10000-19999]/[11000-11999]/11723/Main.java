import java.io.*;
import java.util.*;

/*
int 형 변수 bitSet을 선언한다. x번째 비트는 x 원소가 존재하는지를 나타낸다.

1. add
    1.1. x번째 원소를 제외하고 전부 0으로 초기화된 정수형 변수와 or 연산을 진행한다.

2. remove
    2.1. x번째 원소를 제외하고 전부 1로 초기회된 정수형 번수와 and 연산을 수행한다.

3. check
    3.1. x번째 원소를 제외하고 전부 0으로 초기화된 정수형 변수와 or 연산을 수행한다.
    3.2. 연산 수행 결과가 bitSet과 일치한다면 0, 그렇지 않다면 1을 반환한다.

4. toggle
    4.1. check연산을 진행하고, 1이 반환되면 remove, 0이 반횐되면 add를 수행한다.

5. all
    5.2. bitSet을 MAX_INT로 초기화한다.

6. empty
    6.2. bitSet을 0으로 초기화한다.

 */
public class Main {
    // 현재 집합을 저장하는 정수형 변수
    static int bitSet = 0;
    // x번째 원소는 0, 나머지 원소는 1
    static int[] oneExceptIndex = {
            0,
            1048574, // x = 1
            1048573, // x = 2
            1048571, // x = 3
            1048567, // x = 4
            1048559, // x = 5
            1048543, // x = 6
            1048511, // x = 7
            1048447, // x = 8
            1048319, // x = 9
            1048063, // x = 10
            1047551, // x = 11
            1046527, // x = 12
            1044479, // x = 13
            1040383, // x = 14
            1032191, // x = 15
            1015807, // x = 16
            983039,  // x = 17
            917503,  // x = 18
            786431,  // x = 19
            524287   // x = 20
    };

    // x번째 원소는 1, 나머지 원소는 0
    static int[] zeroExceptIndex = {
            0,
            1,        // x = 1
            2,        // x = 2
            4,        // x = 3
            8,        // x = 4
            16,       // x = 5
            32,       // x = 6
            64,       // x = 7
            128,      // x = 8
            256,      // x = 9
            512,      // x = 10
            1024,     // x = 11
            2048,     // x = 12
            4096,     // x = 13
            8192,     // x = 14
            16384,    // x = 15
            32768,    // x = 16
            65536,    // x = 17
            131072,   // x = 18
            262144,   // x = 19
            524288    // x = 20
    };

    static int add(int x) {
        return bitSet | zeroExceptIndex[x];
    }

    static int remove(int x) {
        return bitSet & oneExceptIndex[x];
    }

    static int check(int x) {
        // add값과 bitSet이 일치할 때 해당 비트가 존재함
        int add = add(x);
        return bitSet == add ? 1 : 0;
    }

    static void toggle(int x) {
        // 해당 원소가 있으면 remove, 없으면 add
        if (check(x) == 0) {
            bitSet = add(x);
        } else {
            bitSet = remove(x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st;

        int m = Integer.parseInt(br.readLine());
        String op;
        int x;

        for (int input = 0; input < m; input++) {
            st = new StringTokenizer(br.readLine());

            op = st.nextToken();

            if (op.equals("add")) {
                x = Integer.parseInt(st.nextToken());
                bitSet = add(x);
            } else if (op.equals("remove")) {
                x = Integer.parseInt(st.nextToken());
                bitSet = remove(x);
            } else if (op.equals("check")) {
                x = Integer.parseInt(st.nextToken());
                ans.append(check(x)).append("\n");
            } else if (op.equals("toggle")) {
                x = Integer.parseInt(st.nextToken());
                toggle(x);
            } else if (op.equals("all"))
                // 전부 1로 초기화
                bitSet = Integer.MAX_VALUE;
            else
                // 전부 0으로 초기화
                bitSet = 0;
        }

        System.out.println(ans);
    }
}