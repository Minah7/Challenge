// 다음과 같이 두 개의 숫자 N, M이 주어질 때, N의 M 거듭제곱 값을 구하는 프로그램을 재귀호출을 이용하여 구현해 보아라.

// 2 5 = 2 X 2 X 2 X 2 X 2 = 32
// 3 6 = 3 X 3 X 3 X 3 X 3 X 3 = 729

// 성공

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void getPower(int n, int m, int idx, int[] answer) {
		if (idx == m) {
			return;
		} else if (idx < m) {
			answer[0] *= n;
			getPower(n, m, idx + 1, answer);
		}
	}

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for (int testcase = 1; testcase <= 10; testcase++) {
			sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] answer = { 1 };
			getPower(n, m, 0, answer);
			System.out.println("#" + testcase + " " + answer[0]);
		}
	}
}