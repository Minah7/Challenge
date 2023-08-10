// 1부터 주어진 숫자만큼 모두 더한 값을 출력하시오.

// 성공

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		
		for(int i = 1; i <= N; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}