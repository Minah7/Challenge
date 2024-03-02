// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu

// 실패

package APS;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static int min;
	static boolean check = false;
	static int d;
	static int w;
	static int k;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			d = sc.nextInt();
			w = sc.nextInt();
			k = sc.nextInt();
			
			boolean[][] film = new boolean[d][w];
			for(int r = 0; r < d; r++) {
				for(int c = 0; c < w; c++) {
					if(sc.nextInt() == 1) {
						film[r][c] = true;
					}
				}
			}
			
			for(int i = 0; i <= d; i++) {
				Set<Integer> set = new HashSet<>();
				boolean[] visited = new boolean[d];
				min = i;
				dfs(film, visited, set, 0);
				if(check) {
					break;
				}
			}
			System.out.println("#" + tc + " " + min);
		}
	}
	
	public static void dfs(boolean[][] film, boolean[] visited, Set<Integer> set, int depth) {
		if(depth == min) {
			setAB(film, set, new boolean[set.size()], 0);
			return;
		}
		for(int i = 0; i < d; i++) {
			if(!visited[i]) {
				visited[i] = true;
				set.add(i);
				dfs(film, visited, set, depth + 1);
				visited[i] = false;
				set.remove(i);
			}
		}
	}
	
	public static void setAB(boolean[][] film, Set<Integer> set, boolean[] ab, int depth) {
		if(depth == set.size()) {
			checkPass(film, set, ab);
			return;
		}
		ab[depth] = true;
		setAB(film, set, ab, depth + 1);
		ab[depth] = false;
		setAB(film, set, ab, depth + 1);
	}
	
	public static void checkPass(boolean[][] film, Set<Integer> set, boolean[] ab) {
		boolean[][] copy = new boolean[d][w];
		for(int row = 0; row < d; row++) {
			copy[row] = film[row].clone();
		}
		
		int idx = 0;
		for(Integer s : set) {
			for(int j = 0; j < w; j++) {
				copy[s][j] = ab[idx];
			}
			idx++;
		}
		
		out : for(int c = 0; c < w; c++) {
			int a = 0;
			int b = 0;
			for(int r = 0; r < d; r++) {
				if(copy[r][c]) {
					a++;
					b = 0;
				} else {
					b++;
					a = 0;
				}
				if(r == (d - 1) && a < k && b < k) {
					break out;
				}
			}
			if(c == (w - 1)) {
				check = true;
				return;
			}
		}
	}
}