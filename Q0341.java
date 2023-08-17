// 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 
// 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.

// 성공


class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        //s문자열의 길이가 4 또는 6인지 확인
        if(s.length() == 4 || s.length() == 6) {
            //반복문을 돌려 s가 숫자로만 구성돼있는지 확인하기
            for(int i = 0; i < s.length(); i++) {
                //문자열의 해당 인덱스 문자가 숫자인지 확인.
                if(!Character.isDigit(s.charAt(i))) {
                    //만약 문자가 아니라면 false로 변경하고 반복문 나가기
                    answer =false;
                    break;
                }
            }
        //만약 문자열의 길이가 4 또는 6이 아니면 false 출력
        } else answer = false;
        return answer;
    }
}