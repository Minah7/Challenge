// 정점이 N개, 간선이 M개 있는 그래프가 주어진다. 
// 정점에는 1번에서 N번까지의 번호가 붙어 있다.
// 이 때, i번 정점과 j번 정점 사이에, j번 정점과 k번 정점 사이에, k번 정점과 i번 정점 사이에
// 모두 간선이 있는 ( i, j, k ) (단, i < j < k )를 삼각형이라고 하자.
// 삼각형의 개수를 구하는 프로그램을 작성하라.

// 첫번째 시도 성공. 하지만 비효율적이다.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int testcase = 1; testcase <= t; testcase++) {
			int answer = 0;
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[][] adjArr = new int[n+1][n+1];
			
			for(int i = 0; i < m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				adjArr[x][y] = adjArr[y][x] = 1;
			}
			
			for(int i = 1; i < n+1-2; i++) {
				for(int j = i+1; j < n+1-1; j++) {
					for(int k = j+1; k < n+1; k++) {
						if(adjArr[i][j] == 1 && adjArr[j][k] == 1 && adjArr[k][i] == 1)
							answer++;
					}
				}
			}
			System.out.println("#"+testcase+" "+answer);
		}
	}
}