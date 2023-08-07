// 가로 N 세로 100 크기의 방에 상자들이 쌓여있다. 
// 방이 오른쪽으로 90도 회전하여 상자들이 중력의 영향을 받아 낙하한다고 할 때, 가장 큰 낙차를 구하여라
// 성공

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		int N = sc.nextInt();
			int[] box = new int[N];
			for(int i = 0; i < N; i++) {
				box[i] = sc.nextInt();
			}
			int answer = 0;
			int[] fall = new int[N];
			for(int i = N-1; i >= 0; i--) {
				if(box[i] != 0) {
					int cnt = 0;
					for(int j = i; j < N-1; j++) {
						if(box[j]>box[j+1]) {
							int e = box[j+1];
							box[j+1] = box[j];
							box[j] = e;
							cnt++;
						}
					}
					fall[i] = cnt;
				} else {
					fall[i] = 0;
				}
			}
			for(int k = 0; k < N; k++) {
				if(fall[k] > answer) {
					answer = fall[k];
				}
			}
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}