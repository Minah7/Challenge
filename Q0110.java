// 문자열 myString과 pat이 주어집니다. 
// myString에서 pat이 등장하는 횟수를 return 하는 solution 함수를 완성해 주세요.

class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        for(int i = myString.length()-1; i>=0; i--) {
            String subS = myString.substring(0, i+1);
            if(subS.endsWith(pat)) {
                answer++;
            }
        }
        return answer;
    }
}

//성공