// 정수가 담긴 리스트 num_list가 주어질 때, 
// 리스트의 길이가 11 이상이면 리스트에 있는 모든 원소의 합을 10 이하이면 모든 원소의 곱을 return하도록 solution 함수를 완성해주세요.

// 성공

class Solution {
    public int solution(int[] numList) {
        int sum = 0;
        int product = 1;
        for(int i  = 0; i < numList.length; i++) {
            sum += numList[i];
            product *= numList[i];
        }
        if (numList.length <= 10) {
            return product;
        } else {
            return sum;
        }
    }
}