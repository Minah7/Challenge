// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/131128

// 두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 
// 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다
// (단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다).
//  X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. 
//  X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.

//성공. StringBuilder를 사용해야 시간 초과가 나지 않는다.

import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        // X 문자열 숫자 개수 구하기
        int[] digitX = new int[10];
        for(int i = 0; i < X.length(); i++) {
            digitX[X.charAt(i)-'0']++;
        }
        
        // Y 문자열 숫자 개수 구하기
        int[] digitY = new int[10];
        for(int i = 0; i < Y.length(); i++) {
            digitY[Y.charAt(i)-'0']++;
        }
        
        // 공통 숫자 개수 만큼 넣어주기
        for(int d = 9; d >= 0; d--) {
            int min = Math.min(digitX[d], digitY[d]);
            for(int i = 0; i < min; i++) {
                answer.append(d);
            }
        }

        // 빈 문자열인지 확인
        if(answer.length() == 0) {
            return "-1";
        } else if(answer.toString().charAt(0) == '0') {
            return "0";
        }
        return answer.toString();
    }
}

//실패한 코드.
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        // X 문자열 숫자 개수 구하기
        int[] digitX = new int[10];
        for(int i = 0; i < X.length(); i++) {
            digitX[X.charAt(i)-'0']++;
        }
        
        // Y 문자열 숫자 개수 구하기
        int[] digitY = new int[10];
        for(int i = 0; i < Y.length(); i++) {
            digitY[Y.charAt(i)-'0']++;
        }
        
        // 공통 숫자 개수 만큼 넣어주기
        for(int d = 9; d >= 0; d--) {
            int min = Math.min(digitX[d], digitY[d]);
            if(min != 0) {
                if(d == 0 && answer.isEmpty()) {
                    answer += "0";
                } else {
                    for(int i = 0; i < min; i++) {
                        answer += Integer.toString(d);
                    }
                }
            }
        }
        
        // 빈 문자열인지 확인
        if(answer.length() == 0) {
            answer = "-1";
        }
        return answer;
    }
}