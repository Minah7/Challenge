// 길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 
// 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.

// 성공

class Solution {
    public String solution(int n) {
        String answer = "";
        //n 개수만큼 반복문 돌려주면서 단어 넣어주기
        for (int i = 0; i < n; i++) {
            //인덱스는 0부터 시작하기 때문에 짝수 인덱스에는 "수" 넣어주기
            if (i%2 == 0) {
                answer += "수";
            //홀수 인덱스에는 "박" 넣어주기
            } else {
                answer += "박";
            }
        }
        return answer;
    }
}