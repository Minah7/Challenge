Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

//Third fail : 74 / 93 testcases passed (better than yesterday)
class Solution {
    public boolean isValid(String s) {
        boolean answer = false;
        String[] p = {"()", "{}", "[]"};
        while (s.length() > 1) {
            for (int i = 0; i < p.length; i++) {
                if (s.contains(p[i])) {
                    s = s.replace(p[i], "");
                }
            }
            break;
        }
        if (s.isEmpty()) {
            answer = true;
        }
        return answer;
    }
}

//Second fail
class Solution {
    public boolean isValid(String s) {
        boolean answer = true;
        String[] p = {"()", "{}", "[]"};
        while (s.length() != 0) {
            for (int i = 0; i < p.length; i++) {
                if (s.contains(p[i])) {
                    answer = true;
                    s = s.replace(p[i], "");
                } else {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}

//First fail
class Solution {
    public boolean isValid(String s) {
        boolean answer = true;
        String[] p = {"()", "{}", "[]"};
        while (s.isEmpty()) {
            for (String i : p) {
                if(s.contains(p[i])) {
                    s = s.replace("p[i]", "");
                } else {
                    answer = false;
                }
            }
        }
        return answer;
    }
}