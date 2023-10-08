// 자연수 N과 M이 주어졌을 때, 
// 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

// 성공

package Baekjoon;

import java.util.Scanner;

public class N과M_15649 {
	public static void dfs(int[] sequence, boolean[] check, int n, int m, int depth) {
		if(depth == m) {
			for(int i : sequence) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < n; i++) {
			if(!check[i]) {
				check[i] = true;
				sequence[depth] = i+1;
				dfs(sequence, check, n, m, depth+1);
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] sequence = new int[m];
		boolean[] check = new boolean[n];
		dfs(sequence, check, n, m, 0);
	}
}
