// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 
// 정점 번호는 1번부터 N번까지이다.

// 성공

package APS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class DFS_BFS {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //정점의 개수
		int m = sc.nextInt(); //간선의 개수
		int v = sc.nextInt(); //탐색을 시작할 정점의 번호
		
		//dfs
		List<Integer>[] adjList = new ArrayList[n+1];
		
		for(int i = 0; i < n+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			adjList[x].add(y);
			adjList[y].add(x);
		}
		
		for(int i = 0; i < n+1; i++) adjList[i].sort(Comparator.naturalOrder());
		
		dfs(adjList, new boolean[n+1], v);
		
		System.out.println();
		
		//bfs
		boolean[] visited = new boolean[n+1];
		
		Queue<Integer> queue = new LinkedList<>();
			queue.add(v);
			
			visited[v] = true;
			
			while(!queue.isEmpty()) {
				int b = queue.poll();
				System.out.print(b+" ");
				
				for(int i : adjList[b]) {
					if(visited[i] == false) {
						queue.add(i);
						visited[i] = true;
					}
				}
			}
		
		sc.close();
	}
	
	public static void dfs(List<Integer>[] adjList, boolean[] visited, int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int i : adjList[v]) {
			if(visited[i] == false) {
				dfs(adjList, visited, i);;
			}
		}
	}
}
