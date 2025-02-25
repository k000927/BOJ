import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. N을 입력받는다.
 * 
 * 2. isPrime 메서드를 작성한다. 파라미터로 소수를 판별할 정수 number를 넘기며, 소수일 경우 true를 반환한다.
 * 		2.1. 2 <= divisor <= sqrt(number) 까지 반복하며, number % divisor == 0이면 false를 반환한다.
 * 		2.2. true를 리턴한다.
 * 
 * 3. makeAmazingPrime 메서드는 아래와 같이 동작한다. 파라미터로는 자릿수를 나타내는 depth와 현재 숫자 number를 받는다.
 * 		3.1. isPrime(number) == false라면 리턴한다.
 * 		3.2. depth == N 이라면 정답을 출력한 후 리턴한다.
 * 		3.3. makeAmazingPrime(depth+1, number * 10 + x)를 호출한다. x는 홀수인 한자릿수 자연수이다.
 * 
 * 4. makeAmazingPrime(1, x)를 호출한다. x는 각각 한 자릿수 소수이다.
 */
public class Main {
	// 출력할 신기한 소수의 자리수
	static int N;
	// 출력할 정답 버퍼
	static StringBuilder ans = new StringBuilder();

	// 파라미터로 주어진 수가 소수인지를 판별하는 메서드
	static boolean isPrime(int number) {
		// 3 이상의 홀수로 나누어떨어진다면 소수
		// 입력값이 두자릿수 이상의 홀수임이 보장됨
		for (int divisor = 3; divisor <= Math.sqrt(number); divisor += 2) {
			if (number % divisor == 0)
				return false;
		}
		return true;
	}

	// 놀라운 소수를 만드는 메서드
	static void makeAmazingPrime(int depth, int number) {
		// 현재 숫자가 소수가 아니라면 리턴
		if (!isPrime(number))
			return;

		// N자리수라면 정답 버퍼에 추가 후 리턴
		if (depth == N) {
			ans.append(number).append("\n");
			return;
		}

		// 뒤에 홀수를 붙여 재귀 호출
		makeAmazingPrime(depth + 1, number * 10 + 1);
		makeAmazingPrime(depth + 1, number * 10 + 3);
		makeAmazingPrime(depth + 1, number * 10 + 5);
		makeAmazingPrime(depth + 1, number * 10 + 7);
		makeAmazingPrime(depth + 1, number * 10 + 9);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// 한자리 소수부터 시작
		makeAmazingPrime(1, 2);
		makeAmazingPrime(1, 3);
		makeAmazingPrime(1, 5);
		makeAmazingPrime(1, 7);

		System.out.println(ans);
	}
}
