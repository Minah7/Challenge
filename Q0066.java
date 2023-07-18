// 문자열 my_string과 target이 매개변수로 주어질 때, target이 문자열 my_string의 부분 문자열이라면 1을, 
// 아니라면 0을 return 하는 solution 함수를 작성해 주세요.

class Solution {
    public int solution(String my_string, String target) {
        int answer = 0;
        if (my_string.contains(target)) answer = 1;
        return answer;
    }
}

//성공