// 0 이상의 두 정수가 문자열 a, b로 주어질 때, a + b의 값을 문자열로 return 하는 solution 함수를 작성해 주세요.

// 성공

import java.util.*;
import java.math.*;

class Solution {
    public String solution(String a, String b) {
        BigInteger A = new BigInteger(a);
        BigInteger B = new BigInteger(b);
        BigInteger AB = A.add(B);
        String answer = AB.toString();
        
        return answer;
    }
}