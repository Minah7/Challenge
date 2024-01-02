// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/133499

// 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 
// 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 
// 연속해서 같은 발음을 하는 것을 어려워합니다.
// 조카가 발음할 수 있는 단어의 개수를 return

// 성공.

class Solution {
    public int solution(String[] babbling) {
        String[] babbles = {"aya", "ye", "woo", "ma"};
        
        int answer = 0;
        
        for(int i = 0; i < babbling.length; i++) {
            int usedB = -1; // 연속 방지용. 마지막에 사용한 발음 번호를 저장할 변수.
            int startindex = 0; // 확인할 발음의 첫번째 인덱스 번호
            
            out: while(true) {
                for(int b = 0; b < 4; b++) {
                    int endIndex = startindex + babbles[b].length();
                    
                    // 연속한 발음을 사용하지 않고, 인덱스 범위를 넘지 않는지 확인
                    if(b != usedB && endIndex <= babbling[i].length()) {
                        if(babbling[i].substring(startindex, endIndex).equals(babbles[b])) {
                            usedB = b;
                            startindex = endIndex;
                            if(endIndex == babbling[i].length()) {
                                answer++;
                                break out;
                            }
                            break;
                            
                        }
                    }
                    // 마지막까지 오면 찾지 못했으므로 실패.
                    if(b == 3) {
                        break out;
                    }
                }
            }
        }
        return answer;
    }
}