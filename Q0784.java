// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12921
// 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

//성공.

class Solution {
    public int solution(int n) {
        int answer = 1; // n은 2이상. 2는 무조건 계산되니 미리 넣어놓기
        
        for(int num = 3; num <= n; num++) {
            // 소수 확인
            boolean check = true;
            for(int i = 2; i <= (int)Math.sqrt(num); i++) {
                if(num % i == 0) {
                    check = false;
                    break;
                }
            }
            if(check) {
                answer++;
            }
        }
        return answer;
    }
}