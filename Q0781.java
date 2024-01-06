// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/140108

// 문자열 s가 입력되었을 때 다음 규칙을 따라서 이 문자열을 여러 문자열로 분해하려고 합니다.

// 먼저 첫 글자를 읽습니다. 이 글자를 x라고 합시다.

// 이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서, x와 x가 아닌 다른 글자들이 나온 횟수를 각각 셉니다. 
// 처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열을 분리합니다.

// s에서 분리한 문자열을 빼고 남은 부분에 대해서 이 과정을 반복합니다. 
// 남은 부분이 없다면 종료합니다.

// 만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고, 종료합니다.

//성공.

class Solution {
    public int solution(String s) {
        int answer = 0;
        int sLen = s.length();
        
        char x = s.charAt(0); // 글자 x
        int numX = 0; // x의 개수
        int numNotX = 0; // x가 아닌 글자의 개수
        
        for(int i = 0; i < sLen; i++){
            if(s.charAt(i) == x) {
                numX++;
            } else {
                numNotX++;
            }
            
            if(numX == numNotX) {
                answer++;
                numX = 0;
                numNotX = 0;
                if(i != sLen-1) {
                    x = s.charAt(i+1);
                } // 만일 s의 마지막 글자가 아니라면 계속 진행
                continue;
            } // 만약 같아지면 문자열 나눠주기 // x, numX, numNotX 초기화
            
            if(i == sLen-1) {
                answer++;
            } // 더 이상 읽을 글자가 없다면 문자열 분리
        }
        return answer;
    }
}