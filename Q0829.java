// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12953

// n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

// 두번째 성공. (풀리지 않아 인터넷 검색함)

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i = 0; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
    private static int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}

// 첫번째 도전 실패.

import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        int gcd = 1;
        
        Arrays.sort(arr);
        List<Integer> div = new ArrayList<>();
        int min = arr[0];
        
        if(min > 1) {
            int i = 2;
            while(i <= min) {
                if(min % i == 0) {
                    div.add(i);
                    min /= i;
                } else {
                    i++;
                }
            }
            
            for(Integer d : div) {
                boolean flag = true;
                for(Integer a : arr) {
                    if(a % d != 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    gcd *= d;
                    for(int a = 0; a < arr.length; a++) {
                        arr[a] /= d;
                    }
                }
            }
        }
        
        for(int a = 0; a < arr.length; a++) {
            answer *= arr[a];
        }
        
        return answer*gcd;
    }
}