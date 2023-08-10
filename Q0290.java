// 입력으로 1개의 정수 N 이 주어진다.
// 정수 N 의 약수를 오름차순으로 출력하는 프로그램을 작성하라.

// 성공

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		for(int i = 1; i <= N; i++) {
			if(N%i == 0) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}
}