// 머쓱이는 구슬을 친구들에게 나누어주려고 합니다. 
// 구슬은 모두 다르게 생겼습니다. 
// 머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때, 
// balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.

// 성공

class Solution {
    public long solution(int balls, int share) {
        long answer = 0;
        //분모 구하기
        long denominator = 1;
        int minDenom = Math.min(balls-share, share);
        for(int i = minDenom; i > 0; i--) {
            denominator *= i;
        }
        //분자 구하기 
        long numerator = 1;
        for(int i = balls; i > balls-minDenom; i--) {
            //약분하면서 곱하기
            if(denominator%i == 0) {
                denominator /= i;
            } else {
                numerator *= i;
            }
        }
       
        answer = numerator/denominator;
        return answer;
    }
}