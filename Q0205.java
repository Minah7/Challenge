// 머쓱이는 행운의 숫자 7을 가장 좋아합니다. 
// 정수 배열 array가 매개변수로 주어질 때, 7이 총 몇 개 있는지 return 하도록 solution 함수를 완성해보세요.

// 성공

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        String arr = "";
        for(int i = 0; i < array.length; i++) {
            arr += String.valueOf(array[i]);
        }
        for(int j = 0; j < arr.length(); j++) {
            if(arr.charAt(j) == '7') {
                answer++;
            }
        }
        return answer;
    }
}