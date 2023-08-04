// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.

// Wrong Answer : 4 / 93 testcases passed

class Solution {
    public boolean isValid(String s) {
        boolean answer = true;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                if(s.charAt(i+1) ==  ')') {
                    continue;
                } else {
                    answer = false;
                    break;
                }
            }
            if(s.charAt(i) == '[') {
                if(s.charAt(i+1) == ']') {
                    continue;
                } else {
                    answer = false;
                    break;
                }
            }
            if(s.charAt(i) == '{') {
                if(s.charAt(i+1) == '}') {
                    continue;
                } else {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}