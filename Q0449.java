// 연속된 세 개의 정수를 더해 12가 되는 경우는 3, 4, 5입니다. 
// 두 정수 num과 total이 주어집니다. 
// 연속된 수 num개를 더한 값이 total이 될 때, 정수 배열을 오름차순으로 담아 return하도록 solution함수를 완성해보세요.

// 성공

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        for(int n = -100; n < 200; n++) {
            int sum = 0;
            for(int i = n; i <n+num; i++) {
                sum += i;
            }
            if(sum == total) {
                for(int i = n, idx = 0; i < n+num; i++) {
                    answer[idx++] = i;
                }
            }
        }
        return answer;
    }
}