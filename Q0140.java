// 문자열 myString과 pat이 주어집니다. 
// myString에서 pat이 등장하는 횟수를 return 하는 solution 함수를 완성해 주세요.

// 성공

class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int patL = pat.length();
        for(int i = 0; i < myString.length()-patL+1; i++) {
            if (myString.substring(i, i+patL).equals(pat)) answer++;
        }
        return answer;
    }
}