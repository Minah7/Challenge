// 문제링크: https://www.acmicpc.net/problem/7568

//성공

package Silver;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		int[][] weightHeight = new int[n][3];
		for(int p = 0; p < n; p++) {
			weightHeight[p][0] = sc.nextInt();
			weightHeight[p][1] = sc.nextInt();
			weightHeight[p][2] = 1;
		}
		
		for(int p = 0; p < n; p++) {
			for(int np = 0; np < n; np++) {
				if(p == np) continue;
				
				if(weightHeight[p][0] < weightHeight[np][0] && weightHeight[p][1] < weightHeight[np][1]) {
					weightHeight[p][2]++;
				}
			}
			sb.append(weightHeight[p][2]).append(' ');
		}
		
		System.out.println(sb);
	}
}