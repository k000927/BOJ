import java.io.*;
import java.util.*;

/*
1. 문자열 길이 S와 부분문자열 길이 p를 입력받는다.

2. DNA 문자열을 입력받는다.

3. 각 요소의 최소 개수를 입력받아 minLimit 배열에 저장한다.

4. startIndex, endIndex를 설정한 후 curDNA 배열을 업데이트한다.
    4.1. curDNA 배열에는 A, C, G, T가 현재 얼마나 포함되어있는지 순서대로 저장된다.
    4.2. endIndex가 s-1이 될 때까지 1씩 증가시키며 문자열을 탐색한다.
        4.2.1. 이 때, 해당 문자가 기준 이상 포함된다면 정답여부를 판정하는 정수 isSecure을 1 올려준다.
    4.3. endIndex와 startIndex를 1씩 증가시키고 curDna 배열을 업데이트한다.
        4.3.1. isSecure == 4라면 정답 변수를 1 증가시켜준다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // DNA 문자열 길이
        int s = Integer.parseInt(st.nextToken());
        // 부분문자열 길이
        int p = Integer.parseInt(st.nextToken());
        // 현재 비밀번호가 secure한지 판단하는 변수. 4일 때 secure
        int isSecure = 0;
        int ans = 0;
        // 각 DNA 요소들의 최솟값
        int[] minLimit = {0, 0, 0, 0};
        // 현재 DNA 요소들의 상태
        int[] curDna = {0, 0, 0, 0};

        // DNA 문자열
        String dna = br.readLine();

        st = new StringTokenizer(br.readLine());
        for (int index = 0; index < 4; index++) {
            minLimit[index] = Integer.parseInt(st.nextToken());
        }

        // 슬라이딩 윈도우의 시작 인덱스
        int startIndex = 0;

        // 슬라이딩 윈도우의 마지막 인덱스
        int endIndex = 0;

        // 슬라이딩 윈도우 초기 설정
        while (endIndex < p) {
            int dnaIndex = getDnaIndex(dna.charAt(endIndex++));
            curDna[dnaIndex]++;
        }
        endIndex--;

        // 첫 문자열이 secure한지 판단
        for (int dnaIndex = 0; dnaIndex < 4; dnaIndex++) {
            if (curDna[dnaIndex] >= minLimit[dnaIndex])
                isSecure++;
        }

        if (isSecure == 4)
            ans++;

        // 슬라이딩 윈도우
        // startIndex 위치의 요소를 제거하고, 이 때 최솟값보다 적어진다면 secure--
        // endIndex+1 위치의 요소를 추가하고, 이 때 최솟값과 일차히면 secure++
        while (endIndex < s - 1) {
            int startDnaIndex = getDnaIndex(dna.charAt(startIndex++));
            curDna[startDnaIndex]--;
            if (curDna[startDnaIndex] == minLimit[startDnaIndex] - 1) isSecure--;

            int endDnaIndex = getDnaIndex(dna.charAt(++endIndex));
            curDna[endDnaIndex]++;
            if (curDna[endDnaIndex] == minLimit[endDnaIndex]) isSecure++;

            // secure하다면 정답 변수 ++
            if (isSecure == 4) ans++;
        }

        System.out.println(ans);

    }

    static int getDnaIndex(char dnaChar) {
        if (dnaChar == 'A')
            return 0;
        else if (dnaChar == 'C')
            return 1;
        else if (dnaChar == 'G')
            return 2;
        else
            return 3;
    }
}