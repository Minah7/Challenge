// 문제링크: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0

// 성공

package APS;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int winGY;
	static int winIY;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			winGY = 0;
			winIY = 0;
			int[] cardsGY = new int[9];
			boolean[] check = new boolean[19];
			for(int i = 0; i < 9; i++) {
				int card = sc.nextInt();
				cardsGY[i] = card;
				check[card] = true;
			}
			
			int[] cardsIY = new int[9];
			for(int i = 0, idx = 1; idx <= 18; idx++) {
				if(!check[idx]) {
					cardsIY[i++] = idx;
				}
			}
			boolean[] visited = new boolean[9];
			dfs(new int[9], cardsGY, cardsIY, visited, 0);
			
			System.out.println("#" + tc + " " + winGY + " " + winIY);
		}
	}
	
	public static void dfs(int[] tmp, int[] cardsGY, int[] cardsIY, boolean[] visited, int depth) {
		if(depth == 9) {
			countScore(tmp, cardsGY);
			return;
		}
		for(int i = 0; i < 9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				tmp[depth] = cardsIY[i];
				dfs(tmp, cardsGY, cardsIY, visited, depth + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void countScore(int[] tmp, int[] cardsGY) {
		int sumGY = 0;
		int sumIY = 0;
		for(int i = 0; i < 9; i++) {
			int sum = tmp[i] + cardsGY[i];
			if(tmp[i] > cardsGY[i]) {
				sumIY += sum;
			} else {
				sumGY += sum;
			}
		}
		if(sumGY > sumIY) {
			winGY += 1;
		}
		if(sumGY < sumIY) {
			winIY += 1;
		}
	} 
}