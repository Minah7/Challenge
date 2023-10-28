// 1부터 N까지의 숫자에서 홀수는 더하고 짝수는 뺐을 때 최종 누적된 값을 구해보자.

// 성공

package SWEA;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int tc = 1; tc <= testcase; tc++) {
			int n = sc.nextInt();
			int answer = 0;
			for(int i = 1; i <= n; i++) {
				if(i%2 == 1) {
					answer += i;
				} else {
					answer -= i;
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
