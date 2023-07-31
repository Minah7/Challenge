정수가 담긴 리스트 num_list가 주어질 때, 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 크면 0을 return하도록 solution 함수를 완성해주세요.

성공

class Solution {
    public int solution(int[] numList) {
        int sum = 0;
        int product = 1;
        for(int i = 0; i < numList.length; i++) {
            sum += numList[i];
            product*= numList[i];
        }
        if(product < sum*sum) {
            return 1;
        } else {
            return 0;
        }
    }
}
