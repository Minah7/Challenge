// 어떤 자연수 N이 있을 때, 
// 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 
// 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 
// 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 
// 따라서 245는 256의 생성자가 된다. 
// 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 
// 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.

// 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.

// 첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
// 첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.

//두 번째 시도 성공. // DP 사용. 

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        // DP를 담을 배열 생성. 가장 큰 N은 1,000,000이기 때문에 +1 
		int[] digitGenerator = new int[1000001];
		for(int i = 1; i <= 1000000; i++) {
            // 자기 자신인 n값 넣어주기
			digitGenerator[i] += i;
            // 각 자리수를 더하기 위해 문자열로 만들어 분해해주기
			String numI = Integer.toString(i);
			for(int c = 0; c < numI.length(); c++) {
				digitGenerator[i] += numI.charAt(c) - '0';
			}
		}
		int find = sc.nextInt();
		for(int i = 1 ; i <= 1000000; i++) {
            // 가장 작은 생성자를 구해야 하기 때문에 
			// 낮은 인덱스 값부터 탐색하며 찾으면 바로 출력하고 끝내기.
			if(digitGenerator[i] == find) {
				System.out.println(i);
				break;
			}
			// 만일 가장 큰 값을 탐색했는데도 생성자를 찾지 못하면 0출력
      if(i == 1000000) {
				System.out.println(0);
			}
		}
	}
}

// 첫 시도 실패
// 이유 : 문제를 제대로 읽지 않았음. 
// 생성자가 없는 경우에는 0을 출력해야 하는데 이 부분을 놓침.
 
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] digitGenerator = new int[1000001];
		for(int i = 1; i <= 1000000; i++) {
			digitGenerator[i] += i;
			String numI = Integer.toString(i);
			for(int c = 0; c < numI.length(); c++) {
				digitGenerator[i] += numI.charAt(c) - '0';
			}
		}
		int find = sc.nextInt();
		for(int i = 1 ; i <= 1000000; i++) {
			if(digitGenerator[i] == find) {
				System.out.println(i);
				break;
			}
		}
	}
}