함수 solution은 정수 n을 매개변수로 입력받습니다. 
n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 
예를들어 n이 118372면 873211을 리턴하면 됩니다.

성공

import java.util.*;

class Solution {
    public long solution(long n) {
        String num = Long.toString(n);
        int[] numArr = new int[num.length()];
        for(int i = 0; i < num.length(); i++) {
            numArr[i] = Character.getNumericValue(num.charAt(i));
        }
        Arrays.sort(numArr);
        num = "";
        for(int i = numArr.length-1; i >= 0; i--) {
            num += String.valueOf(numArr[i]);
        }
        long answer = Long.parseLong(num);
        return answer;
    }
}