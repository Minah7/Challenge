// 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 
// 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.

// 예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 
// 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 
// 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 
// 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.

// 어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 
// 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 
// 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.

// 성공

package Baekjoon;

import java.util.Scanner;

public class 바이러스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int node = sc.nextInt();
		int[][] adjArr = new int[node+1][node+1]; 
		int edge = sc.nextInt();
		for(int e = 0; e < edge; e++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjArr[a][b] = adjArr[b][a] = 1;
		}
		
		boolean[] check = new boolean[node+1];
		int[] cnt = new int[1];
		
		dfs(adjArr, check, node, cnt, 1);
		
		int answer = cnt[0]-1;
		
		System.out.println(answer);
	}
	
	public static void dfs(int[][] adjArr, boolean[] check, int node, int[] cnt, int start) {
		check[start] = true;
		cnt[0]++;
		
		for(int n = 0; n <= node; n++) {
			if(adjArr[start][n] == 1 && !check[n]) {
				dfs(adjArr, check, node, cnt, n);
			}
		}
	}
}
