// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12939

// 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. 
// str에 나타나는 숫자 중 최소값과 최대값을 찾아 
// 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.

// 성공

class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            int n = Integer.parseInt(nums[i]);
            if(n < min) {
                min = n;
            }
            if(n > max) {
                max = n;
            }
        }
        
        String answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}