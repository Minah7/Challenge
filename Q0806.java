// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42587

// 이 문제에서는 운영체제가 다음 규칙에 따라 프로세스를 관리할 경우 
// 특정 프로세스가 몇 번째로 실행되는지 알아내면 됩니다.

// 1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
// 2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
// 3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
// 3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.

//성공.

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
		int n = priorities.length;
		Queue<Integer> que = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			que.add(i);
		}
		
		boolean[] check = new boolean[n];
		int turn = 0;
		while(true) {
			int i = que.poll();
			boolean flag = false;
			for(int p = 0; p < n; p++) {
				if(!check[p] && i != p && priorities[p] > priorities[i]) {
					flag = true;
					break;
				}
			}
			if(flag) {
				que.add(i);
			} else {
                check[i] = true;
				turn++;
				if(i == location) {
					answer = turn;
                    break;
				}
			}
		}
		return answer;
    }
}