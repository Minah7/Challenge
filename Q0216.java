i팩토리얼 (i!)은 1부터 i까지 정수의 곱을 의미합니다. 
예를들어 5! = 5 * 4 * 3 * 2 * 1 = 120 입니다. 
정수 n이 주어질 때 다음 조건을 만족하는 가장 큰 정수 i를 return 하도록 solution 함수를 완성해주세요.

실패..

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] factNums = new int[n+1];
        for(int i = 0; i < 10; i++) {
            int x = 1;
            for(int j=i+1; j > 0; j--) {
                x *= j;
                factNums[i] = x;
            }
            if(x == n) {
                answer = i;
                break;
            }
            if(x > n) {
                if(x-n > n-factNums[i-1]) {
                    answer = i;
                    break;
                } else {
                    answer = i-1;
                    break;
                }
            }
        }
        return answer;
    }
}