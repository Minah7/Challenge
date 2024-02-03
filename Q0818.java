// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/131704

// 예를 들어, 영재가 5개의 상자를 실어야 하며, 택배 기사님이 알려준 순서가 기존의 컨테이너 벨트에 
// 네 번째, 세 번째, 첫 번째, 두 번째, 다섯 번째 놓인 택배상자 순서인 경우, 
// 영재는 우선 첫 번째, 두 번째, 세 번째 상자를 보조 컨테이너 벨트에 보관합니다. 
// 그 후 네 번째 상자를 트럭에 싣고 보조 컨테이너 벨트에서 세 번째 상자 빼서 트럭에싣습니다. 
// 다음으로 첫 번째 상자를 실어야 하지만 보조 컨테이너 벨트에서는 두 번째 상자를, 
// 기존의 컨테이너 벨트에는 다섯 번째 상자를 꺼낼 수 있기 때문에 더이상의 상자는 실을 수 없습니다. 
// 따라서 트럭에는 2개의 상자만 실리게 됩니다.

// 택배 기사님이 원하는 상자 순서를 나타내는 정수 배열 order가 주어졌을 때, 
// 영재가 몇 개의 상자를 실을 수 있는지 return

// 성공

import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int oLen = order.length;
        Stack<Integer> conveyorBelt = new Stack<>();
        int box = 1;
        for(int i = 0; i < oLen; i++) {
            if(box < order[i]) {
                while(box < order[i]) {
                    conveyorBelt.push(box++);
                }
                if(box == order[i]) {
                	answer++;
                	box++;
                }
            } else if(box == order[i]) {
            	answer++;
            	box++;
            } else {
            	if(conveyorBelt.peek() == order[i]) {
            		conveyorBelt.pop();
            		answer++;
            	} else {
            		break;
            	}
            }
        }
        return answer;
    }
}