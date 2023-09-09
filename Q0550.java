// 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다. 
// 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요. 최빈값이 여러 개면 -1을 return 합니다.

// 성공

import java.util.*;

class Solution {
    public int solution(int[] array) {
        int[] cnt = new int[1001];
        for(int i = 0; i < array.length; i++) {
            cnt[array[i]]++;
        }
        int answer = 0;
        int max = 0;
        for(int i = 0; i < cnt.length; i++) {
            if(cnt[i] > max) {
                max = cnt[i];
                answer = i;
            } else if(cnt[i] == max) {
                answer = -1;
            }
        }
        return answer;
    }
}