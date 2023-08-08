// 문자열 my_string이 매개변수로 주어질 때, 
// my_string 안에 있는 숫자만 골라 오름차순 정렬한 리스트를 return 하도록 solution 함수를 작성해보세요.

// 성공

import java.util.*;

class Solution {
    public int[] solution(String myString) {
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i < myString.length(); i++) {
            if(Character.isDigit(myString.charAt(i))) {
                int n = Character.getNumericValue(myString.charAt(i));
                nums.add(n);
            }
        }
        int[] answer = new int[nums.size()];
        for(int i=0; i<nums.size(); i++) {
            answer[i] = nums.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}