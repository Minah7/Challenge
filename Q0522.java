어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 
예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. 
"z"는 1만큼 밀면 "a"가 됩니다. 
문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

성공

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] sarr = s.toCharArray();
        
        for(int i = 0; i < sarr.length; i++) {
            if(sarr[i] != 32) {
                if(65 <= sarr[i] && sarr[i] <= 90) {
                    sarr[i] += n;
                    if(sarr[i] > 90) {
                        sarr[i] -= 26;
                    }
                    answer += sarr[i];
                } else {
                    sarr[i] += n;
                    if(sarr[i] > 122) {
                        sarr[i] -= 26;
                    }
                    answer += sarr[i];
                }
            } else {
                answer += " ";
            }
        }
        return answer;
    }
}