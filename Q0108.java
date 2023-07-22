// 모든 자연수 x에 대해서 현재 값이 x이면 x가 짝수일 때는 2로 나누고, 
// x가 홀수일 때는 3 * x + 1로 바꾸는 계산을 계속해서 반복하면 언젠가는 반드시 x가 1이 되는지 묻는 문제를 콜라츠 문제라고 부릅니다.

// 그리고 위 과정에서 거쳐간 모든 수를 기록한 수열을 콜라츠 수열이라고 부릅니다.

// 계산 결과 1,000 보다 작거나 같은 수에 대해서는 전부 언젠가 1에 도달한다는 것이 알려져 있습니다.
// 임의의 1,000 보다 작거나 같은 양의 정수 n이 주어질 때 초기값이 n인 콜라츠 수열을 return 하는 solution 함수를 완성해 주세요.

import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> r = new ArrayList<>();
        r.add(n);
        
        while (n != 1) {
            if (n%2 == 0) {
                n = n/2;
            } else {
                n = 3*n+1;
            }
            r.add(n);
        }
        
        int[] answer = new int[r.size()];
        for (int i = 0; i < r.size(); i++) {
            answer[i] = r.get(i);
        }
        return answer;
    }
}

//성공. 마지막에 리스트를 배열로 변경해줘야 함. 