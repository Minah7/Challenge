// 문자열 before와 after가 매개변수로 주어질 때, 
// before의 순서를 바꾸어 after를 만들 수 있으면 1을, 
// 만들 수 없으면 0을 return 하도록 solution 함수를 완성해보세요.

// 성공

import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        char[] b = before.toCharArray();
        char[] a = after.toCharArray();
        Arrays.sort(b);
        Arrays.sort(a);
        int answer = 1;
        for(int i = 0; i < b.length; i++) {
            if(b[i] != a[i]) {
                answer = 0;
                break;
            }
        }
        return answer;
    }
}