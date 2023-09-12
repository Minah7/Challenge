// 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 
// 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

// 성공

class Solution {
    public int[] solution(long n) {
        String num = Long.toString(n);
        int[] answer = new int[num.length()];
        for(int i = num.length()-1, idx = 0; i >= 0; i--) {
            answer[idx++] = Character.getNumericValue(num.charAt(i));
        }
        return answer;
    }
}