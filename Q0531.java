// 정수가 담긴 리스트 num_list가 주어집니다. 
// num_list의 홀수만 순서대로 이어 붙인 수와 짝수만 순서대로 이어 붙인 수의 합을 return하도록 solution 함수를 완성해주세요.

// 성공

class Solution {
    public int solution(int[] numList) {
        String even = "";
        String odd = "";
        for(int i = 0; i < numList.length; i++) {
            if(numList[i]%2 == 0) {
                even += String.valueOf(numList[i]);
            } else {
                odd += String.valueOf(numList[i]);
            }
        }
        int answer = Integer.valueOf(even)+Integer.valueOf(odd);
        
        return answer;
    }
}