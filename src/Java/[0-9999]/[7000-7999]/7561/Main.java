import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 테스트 케이스 수 입력
        int[][] A = new int[3][4];  // 3행 4열짜리 배열
        List<Long> B = new ArrayList<>();  // 결과값을 저장할 리스트

        double detA1, detA2, detA3, detA, detA1B, detA2B, detA3B;

        for (int t = 0; t < N; t++) {
            // 입력받기
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    A[i][j] = sc.nextInt();
                }
            }

            // detA1B, detA2B, detA3B 계산 (크래머 공식의 분자 부분)
            detA1B = A[0][3] * (A[1][1] * A[2][2] - A[1][2] * A[2][1])
                    - A[0][1] * (A[1][3] * A[2][2] - A[1][2] * A[2][3])
                    + A[0][2] * (A[1][3] * A[2][1] - A[1][1] * A[2][3]);

            detA2B = A[0][0] * (A[1][3] * A[2][2] - A[1][2] * A[2][3])
                    - A[0][3] * (A[1][0] * A[2][2] - A[1][2] * A[2][0])
                    + A[0][2] * (A[1][0] * A[2][3] - A[1][3] * A[2][0]);

            detA3B = A[0][0] * (A[1][1] * A[2][3] - A[1][3] * A[2][1])
                    - A[0][1] * (A[1][0] * A[2][3] - A[1][3] * A[2][0])
                    + A[0][3] * (A[1][0] * A[2][1] - A[1][1] * A[2][0]);

            // detA 계산 (크래머 공식의 분모 부분)
            detA1 = A[0][0] * (A[1][1] * A[2][2] - A[1][2] * A[2][1]);
            detA2 = A[0][1] * (A[1][0] * A[2][2] - A[1][2] * A[2][0]);
            detA3 = A[0][2] * (A[1][0] * A[2][1] - A[1][1] * A[2][0]);

            detA = detA1 - detA2 + detA3;  // detA 계산

            // B에 출력할 값들을 저장
            B.add((long) detA1B);
            B.add((long) detA2B);
            B.add((long) detA3B);
            B.add((long) detA);

            // 각 det 값 출력
            for (int i = 0; i < B.size(); i++) {
                System.out.print(B.get(i) + " ");
            }
            System.out.println();

            // 해를 구하고 출력
            if (detA == 0) {
                System.out.println("No unique solution");
            } else {
                System.out.printf("Unique solution: %.3f %.3f %.3f\n",
                        (Math.abs(detA1B / detA) < 0.0005 ? 0.000 : detA1B / detA),
                        (Math.abs(detA2B / detA) < 0.0005 ? 0.000 : detA2B / detA),
                        (Math.abs(detA3B / detA) < 0.0005 ? 0.000 : detA3B / detA));
            }

            if (t != N - 1) {
                System.out.println();  // 마지막 테스트 케이스가 아니면 줄 바꿈
            }

            B.clear();  // B 리스트 초기화
        }

        sc.close();  // 스캐너 닫기
    }
}
