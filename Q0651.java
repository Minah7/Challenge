// 자연수 N과 M이 주어졌을 때, 
// 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

// 1부터 N까지 자연수 중에서 M개를 고른 수열
// 같은 수를 여러 번 골라도 된다.

// 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 
// 중복되는 수열을 여러 번 출력하면 안되며, 
// 각 수열은 공백으로 구분해서 출력해야 한다.

// 수열은 사전 순으로 증가하는 순서로 출력해야 한다.

// 성공

package Baekjoon;

import java.util.Scanner;

public class N과M3 {
	public static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int[] sequence, boolean[] check, int n, int m, int depth) {
		if(depth == m) {
			for(int i : sequence) {
				sb.append(i + " ");
			}
			sb.append('\n');
			return;
		}
		for(int i = 0; i < n; i++) {
			check[i] = true;
			sequence[depth] = i+1;
			dfs(sequence, check, n, m, depth+1);
			check[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] sequence = new int[m];
		boolean[] check = new boolean[n];
		dfs(sequence, check, n, m, 0);
		System.out.println(sb);
	}
}