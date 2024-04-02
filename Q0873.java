// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12927

// Demi가 1시간 동안 작업량 1만큼을 처리할 수 있다고 할 때, 
// 퇴근까지 남은 N 시간과 각 일에 대한 작업량 works에 대해 야근 피로도를 최소화한 값을 리턴하는 함수 solution을 완성해주세요.

// 성공

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int w = works.length;
        reverseSort(works);
        boolean flag = false;
        while(n > 0) {
            for(int i = 0; i < w; i++) {
                if(i == 0 && works[i] == 0) {
                    flag = true;
                    break;
                } else if(i < w - 1 && works[i] > works[i + 1]) {
                    works[i]--;
                    break;
                } else if(i == w - 1 && works[i] > 0) {
                    works[i]--;
                    break;
                }
            }
            if(flag) {
                break;
            }
            n--;
        }
        
        for(int i = 0; i < w; i++) {
            answer += works[i]*works[i];
        }
        return answer;
    }
    
    public static void reverseSort(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
}