// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/86971

// n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있습니다. 
// 당신은 이 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할하려고 합니다. 
// 이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 합니다.

// 송전탑의 개수 n, 그리고 전선 정보 wires가 매개변수로 주어집니다. 
// 전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때, 
// 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return 하도록 solution 함수를 완성해주세요.

// 성공

import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 0;
        
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        for(int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            boolean[] visited = new boolean[n + 1];
            
            int cnt = dfs(graph, visited, 1);
            
            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return min;
    }
    
    static int dfs(ArrayList<Integer>[] graph, boolean[] visited, int v) {
        visited[v] = true;
        int cnt = 1;
        
        for(int next : graph[v]) {
            if(!visited[next]) {
                cnt += dfs(graph, visited, next);
            }
        }
        
        return cnt;
    }
}