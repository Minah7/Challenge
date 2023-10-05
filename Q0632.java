// 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, 
// solution을 만들어 보세요.

// 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
// (1은 소수가 아닙니다.)

// 제한 조건
// n은 2이상 1000000이하의 자연수입니다.

// 실패. 시간초과

import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> prime = new ArrayList<>();
		int answer = 0;
		if(n == 2)
			return 1;
		prime.add(2);
		for(int num = 3; num <= n; num++) {
			int cnt = 0;
			for(int d = 2; d <= num; d++) {
				if(d < num && num%d == 0) {
					break;
				} else if(num == d && num%d == 0){
					cnt++;
				}
			}
			if(cnt == 1) {
				prime.add(num);
			}
		}
		return prime.size();
    }
}