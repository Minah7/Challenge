// 정수 배열 array와 정수 n이 매개변수로 주어질 때, 
// array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.

// 성공

import java.util.*;

class Solution {
    
    public int solution(int[] array, int n) {
        Arrays.sort(array);
        int answer = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == n) {
                answer = array[i];
                break;
            } else if(array[i] > n) {
                if(i != 0) {
                    int beforeI = n-array[i-1];
                    int I = array[i]-n;
                    if(beforeI > I) {
                        answer = array[i];
                        break;
                    } else {
                        answer = array[i-1];
                        break;
                    }
                }
            }
        }
        if(answer == 0) {
            answer = array[array.length-1];
        }
        return answer;
    }
}