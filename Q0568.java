// 정수 배열 array와 정수 n이 매개변수로 주어질 때, 
// array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.

// 18개 테스트 케이스 중 2개 실패

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int[] compare = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            compare[i] = Math.abs(array[i]-n);
        }
        int min = 100;
        int minIdx = 0;
        for(int i = 0; i < compare.length; i++) {
            if(min > compare[i]) {
                min = compare[i];
                minIdx = i;
            }
        }
        answer = array[minIdx];
        return answer;
    }
}