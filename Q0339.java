// 두 정수 left와 right가 매개변수로 주어집니다. 
// left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 
// 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.

// 성공

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        //left값부터 right값까지 반복문 돌리기
        for(int i = left; i <= right; i++) {
            //약수 개수를 세기 위한 변수 count
                int count = 0;
            //i값 약수의 개수 구하기
            for(int j = 1; j <= i; j++) {
                //i를 j로 나눴을 때 나머지가 0이면 약수
                if(i%j == 0) {
                    //약수 찾을 때마다 count개수 1개씩 더해주기
                    count++;
                }
            }
            //약수의 개수가 짝수인지 홀수인지 확인하기
            //짝수면 i값 더해주기
            if(count%2 == 0) {
                answer += i;
            //홀수면 i값 빼주기
            } else {
                answer -= i;
            }
        }
        return answer;
    }
}