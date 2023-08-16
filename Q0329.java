// 1-1. 입력된 수가 짝수라면 2로 나눕니다. 
// 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다. 
// 2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다. 

// 성공

class Solution {
    public int solution(int num) {
        int answer = -1;
        int i = 0;
        while(i < 500) {
            if(num == 1) {
                answer = i;
                break;
            }
            if(num%2 == 0) {
                num = num/2;
            } else if(num%2 == 1) {
                num = num*3+1;
            }
            i++;
        }
        return answer;
    }
}