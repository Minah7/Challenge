// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12924

// 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다.
// 자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.

// 성공

class Solution {
    public int solution (int n) {
        int answer = 0;
        int start = 1;
        while (start <= n) {
            int sum = start;
            for(int i = start + 1; i <= n; i++) {
                if(sum == n) {
                    System.out.println(start);
                    answer++;
                    break;
                } 
                sum += i;
                if(sum > n) {
                    break;
                }
            }
            start++;
        }
        answer++;
        return answer;
    }
}