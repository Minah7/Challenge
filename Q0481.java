// 자연수 n이 매개변수로 주어집니다. 
// n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

// 성공

class Solution {
    public int solution(int n) {
        int answer = 0;
        //3진법 변환
        String trit = Integer.toString(n, 3);
        //스트링으로 만들기
        String reverseTrit = "";
        for(int i = trit.length()-1; i >= 0; i--) {
            reverseTrit += trit.charAt(i);
        }
        answer = Integer.parseInt(reverseTrit, 3);
        return answer;
    }
}