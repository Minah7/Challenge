// 문자열 myString과 pat가 주어집니다. 
// myString의 부분 문자열중 pat로 끝나는 가장 긴 부분 문자열을 찾아서 return 하는 solution 함수를 완성해 주세요.

// 성공

class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        for(int i = myString.length(); i >= pat.length(); i--) {
            if(myString.substring(i-pat.length(),i).equals(pat)) {
                answer = myString.substring(0,i);
                break;
            }
        }
        return answer;
    }
}