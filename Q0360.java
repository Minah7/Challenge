1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
(1은 소수가 아닙니다.)

실패(시간 초과)

class Solution {
    public int solution(int n) {
        int answer = 0;
        //2이상부터 소수일 수 있어서 2부터 시작
        for(int num = 2; num <= n; num++) {
            //각 숫자의 약수의 개수를 구하기 위한 변수
            int factor = 0;
            //1은 당연히 나누어지므로 2부터 시작
            for(int i = 2; i <= num; i++) {
                if(num%i == 0) factor++;
                //만일 1개 이상이면 소수가 아니므로 나가기
                if(factor > 1) break;
            }
            //만일 약수가 1개라면 소수이기 때문에 답에 +1 해주기
            if(factor == 1) answer++;
        }
        return answer;
    }
}