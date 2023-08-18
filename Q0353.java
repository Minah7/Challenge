// 정수 리스트 num_list가 주어집니다. 
// 가장 첫 번째 원소를 1번 원소라고 할 때, 홀수 번째 원소들의 합과 짝수 번째 원소들의 합 중 큰 값을 return 하도록 solution 함수를 완성해주세요. 
// 두 값이 같을 경우 그 값을 return합니다.

// 성공

class Solution {
    public int solution(int[] numList) {
        int odd = 0;
        int even = 0;
        for(int i = 0; i < numList.length; i++) {
            if(i%2 == 0) {
                odd+= numList[i];
            } else {
                even += numList[i];
            }
        }
        int answer = odd;
        if(odd>even) answer = odd;
        if(odd<even) answer = even;
        return answer;
    }
}