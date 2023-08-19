// 두 정수 q, r과 문자열 code가 주어질 때, code의 각 인덱스를 q로 나누었을 때 나머지가 r인 위치의 문자를 앞에서부터 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.

// 성공

class Solution {
    public String solution(int q, int r, String code) {
        String answer = "";
        //code의 문자를 q의 개수만큼 나누므로 q만큼 더해주면서 반복
        for(int i = 0; i < code.length(); i+=q) {
            //나눈 곳에서 r번째의 문자를 더하므로 문자열 길이 넘어가는지 확인하고 그렇지 않으면 더해주기
            if(i+r < code.length()) {
                answer += code.charAt(i+r);
            }
        }
        return answer;
    }
}