// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/43162

// 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 
// 네트워크의 개수를 return

// 성공

import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(computers, visited, i);
            }
        }
        
        return answer;
    }
    
    public void bfs(int[][] computers, boolean[] visited, int c) {
        Queue<Integer> que = new LinkedList<>();
        
        que.add(c);
        visited[c] = true;
        
        while(!que.isEmpty()) {
            int computer = que.poll();
            
            for(int i = 0; i < computers.length; i++) {
                if(computers[computer][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    que.add(i);
                }
            }
        }
        answer++;
    }
}