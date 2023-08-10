// 1부터 주어진 횟수까지 2를 곱한 값(들)을 출력하시오.

// 성공

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int num = 1;
		System.out.print(num);
		for(int i = 0; i < N; i++) {
			num *= 2;
			System.out.print(" "+num);
		}
		System.out.println();
	}
}