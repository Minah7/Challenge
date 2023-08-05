// 정수 num과 k가 매개변수로 주어질 때, num을 이루는 숫자 중에 k가 있으면 num의 그 숫자가 있는 자리 수를 return하고 없으면 -1을 return 하도록 solution 함수를 완성해보세요.

// 성공

class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        String n = String.valueOf(num);
        for(int i = 0; i < n.length(); i++) {
            int j = Character.digit(n.charAt(i),10);
            if (j == k) {
                answer = i+1;
                break;
            }
        }
        return answer;
    }
}

// 참고한 사이트 :10번째 줄 코드
// https://stackoverflow.com/questions/3389264/how-to-get-the-separate-digits-of-an-int-number