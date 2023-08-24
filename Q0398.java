// 문자열 my_str과 n이 매개변수로 주어질 때, my_str을 길이 n씩 잘라서 저장한 배열을 return하도록 solution 함수를 완성해주세요.

// 실패

class Solution {
    public String[] solution(String myStr, int n) {
        int cnt = 0;
        if(myStr.length()%n != 0) {
            cnt = myStr.length()/n+1;
        } else cnt = myStr.length()/n;
        String[] answer = new String[cnt];
        for(int i = 0, j = 0; j < cnt; i+=n) {
            if(j == cnt - 1) {
                answer[j] = myStr.substring(i);
            }
            answer[j++] = myStr.substring(i, i+n);
        }
        return answer;
    }
}