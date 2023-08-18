// 머쓱이는 구슬을 친구들에게 나누어주려고 합니다. 
// 구슬은 모두 다르게 생겼습니다. 
// 머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때, 
// balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.

// 실패

class Solution {
    public int solution(int balls, int share) {
        int answer = 0;
        //combination공식을 이용하기 위한 분자 구하기 
        int numerator = 1;
        //분모 구하기
        int denominator = 1;
        //고를개수의 수 만큼 총 구슬의 개수값에서 하나씩 줄여가면서 분자값 구하기
        for(int i = balls; i > share; i--) {
            numerator *= i;
        }
        //1에서 고를 개수의 수 만큼 곱해주기 위한 반복문
        for(int i = balls-share; i > 0; i--) {
            denominator *= i;
        }
        answer = numerator/denominator;
        return answer;
    }
}