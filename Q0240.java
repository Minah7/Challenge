// Given a string s consisting of lowercase English letters, return the first letter to appear twice.
// Note:
// A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
// s will contain at least one letter that appears twice.

// Accepted

import java.util.ArrayList;

class Solution {
    public char repeatedCharacter(String s) {
        char answer = '\0';
        ArrayList<Character> alphabets = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(alphabets.contains(s.charAt(i))) {
                answer = s.charAt(i);
                break;
            } else {
                 alphabets.add(s.charAt(i));
            }
        }
        return answer;
    }
}