// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QPsXKA2UDFAUq
// 입력으로 N 개의 점수가 주어졌을 때, 중간값을 출력하라.
// 성공

package APS;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		int max = -1; //최대값을 구하기 위한 변수
		for(int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
			max = Math.max(max, num[i]);
		}//여기까지 입력값
		
		//카운팅 정렬
		int[] count = new int[max+1];
		for(int i = 0; i < n; i++) {
			count[num[i]]++;
		}
		//count 배열 누적합
		for(int i = 1; i < count.length; i++) {
			count[i] += count[i-1];
		}
		int[] sort = new int[n];
		for(int i = n-1; i >= 0; i--) {
			sort[--count[num[i]]] = num[i];
		}
		System.out.println(sort[n/2]);
	}
}