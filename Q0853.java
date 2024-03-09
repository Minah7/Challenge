// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/92335

// 정수 n과 k가 매개변수로 주어집니다. 
// n을 k진수로 바꿨을 때, 변환된 수 안에서 찾을 수 있는 위 조건에 맞는 소수의 개수를 return 하도록 solution 함수를 완성해 주세요

// 성공

import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String num = Integer.toString(n);
        if(n != 10) {
            num = Integer.toString(n, k);
        }
        
        for(String str : num.split("0")) {
            if(str.equals("")) {
                continue;
            } else {
                if(checkPrime(str)) {
                    answer++;
                } 
            }
        }

        return answer;
    }
    
    public static boolean checkPrime(String str) {
        long num = Long.parseLong(str);
        if(num > 1) {
            boolean flag = true;
            for(int i = 2; i <= Math.sqrt(num); i++) {
                if(num % i == 0) {
                    flag = false;
                    break;
                }
            }
            return flag;
        } else {
            return false;
        }
    }
}