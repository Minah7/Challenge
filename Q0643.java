// 자연수 N과 M이 주어졌을 때, 
// 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
// 고른 수열은 오름차순이어야 한다.

//성공
package Baekjoon;

import java.util.Scanner;

public class N과M2 {
	public static void permutation(int[] answer, boolean[] visited, int n, int m, int depth) {
		if(depth == m) {
			for(int i = 1; i < m; i++) {
				if(answer[i-1] > answer[i]) {
					return;
				}
			}
			for(int i = 0; i < m; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				answer[depth] = i+1;
				permutation(answer, visited, n, m, depth+1);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] answer = new int[m];
		boolean[] visited = new boolean[n];
		
		permutation(answer, visited, n, m, 0);
	}
}
