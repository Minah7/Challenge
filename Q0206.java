// 문자열 my_string과 정수 num1, num2가 매개변수로 주어질 때, my_string에서 인덱스 num1과 인덱스 num2에 해당하는 문자를 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.
// 실패

class Solution {
    public String solution(String myString, int num1, int num2) {
        String answer = "";
        char a = myString.charAt(num1);
        char b = myString.charAt(num2);
        myString.setcharAt(num1, b);
        myString.setcharAt(num2, a);
        return myString;
    }
}