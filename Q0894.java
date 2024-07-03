// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QPsXKA2UDFAUq

// 중간값은 통계 집단의 수치를 크기 순으로 배열 했을 때 전체의 중앙에 위치하는 수치를 뜻한다.
// 입력으로 N 개의 점수가 주어졌을 때, 중간값을 출력하라.

// 성공

import java.util.Arrays;
import java.util.Scanner;

public class 중간값_찾기 {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		for(int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		
		Arrays.sort(num);
		System.out.println(num[n/2]);
	}
}