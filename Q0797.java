// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42583

// 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다. 
// 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 
// 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다. 
// 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.

// 성공

import java.util.*;

class Solution {
    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        int answer = 0;
        int cnt = 0;
        
        Queue<Integer> que = new LinkedList<>();
        
        for(int i = 0; i < truckWeights.length; i++) {
            int truck = truckWeights[i];
            
            while(true) {
                if(que.isEmpty()) {
                    que.add(truck);
                    cnt += truck;
                    answer++;
                    break;
                } else if(que.size() == bridgeLength) {
                    cnt -= que.poll();
                } else {
                    if(cnt + truck <= weight) {
                        que.add(truck);
                        cnt += truck;
                        answer++;
                        break;
                    } else {
                        que.add(0);
                        answer++;
                    }
                }
            }
        }
        
        return answer + bridgeLength;
    }
}