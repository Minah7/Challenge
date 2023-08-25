// 문자열 my_string이 매개변수로 주어집니다. 
// my_string은 소문자, 대문자, 자연수로만 구성되어있습니다. 
// my_string안의 자연수들의 합을 return하도록 solution 함수를 완성해주세요.

// 실패

class Solution {
    public int solution(String myString) {
        myString = myString.toLowerCase();
        String[] num = myString.split("[a-z]");
        int answer = 0;
        if(num.length != 0) {
            for(int i = 0; i < num.length; i++) {
                answer += Integer.parseInt(num[i]);
            }
        }
        return answer;
    }
}