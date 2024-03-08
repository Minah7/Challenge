// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12985

// 게임 참가자 수 N, 참가자 번호 A, 경쟁자 번호 B가 함수 solution의 매개변수로 주어질 때, 
// 처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 return 하는 solution 함수를 완성해 주세요. 
// 단, A번 참가자와 B번 참가자는 서로 붙게 되기 전까지 항상 이긴다고 가정합니다.

// 성공

import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int round = n/2;
        Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            que.add(i);
        }
        
        while(true) {
            boolean flag = false;
            for(int i = 0; i < round; i++) {
                int p1 = que.poll();
                int p2 = que.poll();
                if((p1 == a || p1 == b) && (p2 == a || p2 == b)) {
                    flag = true;
                    break;
                } else if(p1 == a || p1 == b) {
                    que.add(p1);
                } else if(p2 == a || p2 == b) {
                    que.add(p2);
                } else {
                    que.add(p1);
                }
            }
            round /= 2;
            answer++;
            
            if(flag) {
                break;
            }
        }
        
        return answer;
    }
}