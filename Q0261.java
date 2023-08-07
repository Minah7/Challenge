// 10개의 수를 입력 받아, 그 중에서 가장 큰 수를 출력하는 프로그램을 작성하라.
// 성공

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int max = 0;
			int[] num = new int[10];
			for(int i = 0; i < 10; i++) {
				int c = sc.nextInt();
				num[i] = c;
			}
			for(int j = 0; j < 10; j++) {
				if(max < num[j]) {
					max = num[j];
				}
			}
			System.out.printf("#%d %d\n", test_case, max);
		}
	}

}