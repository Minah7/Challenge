// 문자열 my_string이 매개변수로 주어집니다. my_string은 소문자, 대문자, 자연수로만 구성되어있습니다. my_string안의 자연수들의 합을 return하도록 solution 함수를 완성해주세요.

// 성공

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

class Solution {
    public int solution(String myString) {
        int answer = 0;
        myString = myString.toLowerCase();
        Matcher matcher = Pattern.compile("\\d+").matcher(myString);
        
        List<Integer> numbers = new ArrayList<>();
        while (matcher.find()) {
            numbers.add(Integer.valueOf(matcher.group()));
        }
        for(int i = 0; i< numbers.size(); i++) {
            answer += numbers.get(i);
        }
        return answer;
    }
}