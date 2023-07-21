// 0 이상의 두 정수가 문자열 a, b로 주어질 때, a + b의 값을 문자열로 return 하는 solution 함수를 작성해 주세요.

class Solution {
    public String solution(String a, String b) {
        int ab = Integer.parseInt(a)+Integer.parseInt(b);
        String answer = Integer.toString(ab);
        
        return answer;
    }
}

// 실패. 이 문제는 왜 틀렸는지 이해가 안된다.