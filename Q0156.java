정수가 담긴 리스트 num_list가 주어질 때, 
num_list의 원소 중 짝수와 홀수의 개수를 담은 배열을 return 하도록 solution 함수를 완성해보세요.

성공

class Solution {
    public int[] solution(int[] numList) {
        int[] answer = new int[2];
        for(int i = 0; i < numList.length; i++) {
            if (numList[i]%2 == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
        }
        return answer;
    }
}