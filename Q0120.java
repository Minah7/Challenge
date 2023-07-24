// 문자열 my_string과 정수 배열 indices가 주어질 때, 
// my_string에서 indices의 원소에 해당하는 인덱스의 글자를 지우고 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.

// 실패.

class Solution {
    public String solution(String myString, int[] indices) {
        Arrays.sort(indices);
        String answer = "";
        
        for(int i = 0; i < myString.length(); i++) {
            for(int n = 0; n < indices.length; n++) {
                if(i == indices[n]) {
                    continue;
                }
            }
            answer += myString.charAt(i);
        }

        return answer;
    }
}

import java.util.*;

class Solution {
    public String solution(String myString, int[] indices) {
        Arrays.sort(indices);
        String answer = myString;
        
        for(int i = 0; i < myString.length(); i++) {
            for(int n = 0; n < indices.length; n++) {
                if(i == indices[n]) {
                    answer.replace(
                        ""+answer.charAt(i), "");
                } 
            }
        }
        return answer;
    }
}

class Solution {
    public String solution(String myString, int[] indices) {
        Arrays.sort(indices);
        String answer = myString;
        
        for(int i = 0; i < myString.length(); i++) {
            for(int n = indices.length-1; n >= 0; n--) {
                if(i == indices[n]) {
                    answer = answer.replace(""+answer.charAt(i), "");
                } 
            }
        }
        return answer;
    }
}

class Solution {
    public String solution(String myString, int[] indices) {
        Arrays.sort(indices);
        String answer;
        
        for(int i = 0; i < myString.length(); i++) {
            for(int n = indices.length-1; n >= 0; n--) {
                if(i == indices[n]) {
                    myString = myString.replace(""+myString.charAt(i), "");
                } 
            }
        }
        answer = myString;
        return answer;
    }
}

class Solution {
    public String solution(String myString, int[] indices) {
        Arrays.sort(indices);
        String answer;
        
        for(int i = myString.length()-1; i >= 0; i--) {
            for(int n = indices.length-1; n >= 0; n--) {
                if(i == indices[n]) {
                    myString = myString.replace(""+myString.charAt(i), "");
                } 
            }
        }
        answer = myString;
        return answer;
    }
}

import java.util.*;

class Solution {
    public String solution(String myString, int[] indices) {
        Arrays.sort(indices);
        String answer = myString;

        
        for(int i = 0; i <indices.length; i++) {
            answer = answer.substring(0, indices[i]) + answer.substring(indices[i]+1, answer.length());
        }
        
        return answer;
    }
}

// 성공

import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        Arrays.sort(indices);
        
        for(int i = 0; i < indices.length; i ++) my_string = my_string.substring(0, indices[i] - i) + my_string.substring(indices[i] - i + 1);
        
        return my_string;
    }
}