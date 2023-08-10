주어진 숫자만큼 # 을 출력해보세요.

성공

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		for(int i = 0; i < N; i++) {
			System.out.printf("#");
		}
		System.out.println();
	}
}
