// 문자열 리스트 str_list와 제외하려는 문자열 ex가 주어질 때, str_list에서 ex를 포함한 문자열을 제외하고 만든 꼬리 문자열을 return하도록 solution 함수를 완성해주세요.

class Solution {
    public String solution(String[] strList, String ex) {
        String answer = "";
        for (int i = 0; i < strList.length; i++) {
            if (!strList[i].contains(ex)) {
                answer += strList[i];
            }
        }
        return answer;
    }
}

//성공