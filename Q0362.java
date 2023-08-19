// 머쓱이는 행운의 숫자 7을 가장 좋아합니다. 
// 정수 배열 array가 매개변수로 주어질 때, 7이 총 몇 개 있는지 return 하도록 solution 함수를 완성해보세요.

// 성공

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        //array배열 돌아가며 확인
        for(int i = 0; i < array.length; i++) {
            //array[i]값을 문자열로 만들어주기
            String n = String.valueOf(array[i]);
            //문자열을 돌아가며 7인지 확인하기
            for(int j = 0; j < n.length(); j++) {
                if(n.charAt(j) == '7') answer++;
            }
        }
        return answer;
    }
}