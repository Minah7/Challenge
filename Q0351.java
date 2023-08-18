// 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. 
// str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
// 예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

// 성공


class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int min = Integer.valueOf(nums[0]);
        int max = Integer.valueOf(nums[0]);
        for(int i = 0; i < nums.length; i++) {
            if(Integer.valueOf(nums[i]) < min) {
                min = Integer.valueOf(nums[i]);
            }
            if(Integer.valueOf(nums[i]) > max) {
                max = Integer.valueOf(nums[i]);
            }
        }
        String answer = "";
        answer += String.valueOf(min);
        answer += " ";
        answer += String.valueOf(max);
        return answer;
    }
}