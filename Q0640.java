// 삼각수 Tn(n ≥ 1)는 [그림]에서와 같이 기하학적으로 일정한 모양의 규칙을 갖는 점들의 모음으로 표현될 수 있다.

// 자연수 n에 대해 n ≥ 1의 삼각수 Tn는 명백한 공식이 있다.
// Tn = 1 + 2 + 3 + ... + n = n(n+1)/2

// 1796년, 가우스는 모든 자연수가 최대 3개의 삼각수의 합으로 표현될 수 있다고 증명하였다. 
// 예를 들어,
// 4 = T1 + T2
// 5 = T1 + T1 + T2
// 6 = T2 + T2 or 6 = T3
// 10 = T1 + T2 + T3 or 10 = T4
// 이 결과는 증명을 기념하기 위해 그의 다이어리에 “Eureka! num = Δ + Δ + Δ” 라고 
// 적은것에서 유레카 이론으로 알려졌다. 
// 꿍은 몇몇 자연수가 정확히 3개의 삼각수의 합으로 표현될 수 있는지 궁금해졌다. 
// 위의 예시에서, 5와 10은 정확히 3개의 삼각수의 합으로 표현될 수 있지만 4와 6은 그렇지 않다.

// 자연수가 주어졌을 때, 
// 그 정수가 정확히 3개의 삼각수의 합으로 표현될 수 있는지 없는지를 판단해주는 프로그램을 만들어라. 
// 단, 3개의 삼각수가 모두 달라야 할 필요는 없다.

//첫 번째 도전 실패. 출력 초과

package Baekjoon;

import java.util.Scanner;

public class 유레카_이론 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dp = new int[1001];
		for(int i = 1; i < 1001; i++) {
			dp[i] = dp[i-1] + i;
			System.out.println(i +" "+dp[i]);
		}
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			int num = sc.nextInt();
			for(int i = 1; i < 1001; i++) {
				if(num == dp[i]) {
					System.out.println(1);
					break;
				} else if(num < dp[i]) {
					System.out.println(0);
					break;
				}
			}
		}
	}
}