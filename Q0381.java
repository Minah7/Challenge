// 1937년 Collatz란 사람에 의해 제기된 이 추측은, 주어진 수가 1이 될 때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측입니다. 작업은 다음과 같습니다.

// 성공

class Solution {
    public int solution(int num) {
        int answer = 1;
        while(answer <= 500) {
            if(num%2 == 0) {
                num /= 2;
            } else if(num%2 == 1) {
                num = num*3+1;
            }
            if(num == 1) break;
            answer++;
        }
        if(answer > 500) answer = -1;
        return answer;
    }
}