// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42839

// 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

// 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 
// 종이 조각으로 만들 수 있는 소수가 몇 개인지 return

// 성공

import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers, "", visited, 0);
        
        for(Integer num : set) {
            // System.out.println(num);
            if(isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void dfs(String numbers, String n, boolean[] visited, int depth) {
        if(depth > numbers.length()) {
            return;
        }
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(n + numbers.charAt(i)));
                dfs(numbers, n + numbers.charAt(i), visited, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    public static boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }
        for(int i = 2; i <= (int)Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}