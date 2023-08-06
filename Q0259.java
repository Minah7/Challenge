// 어떤 문자열에 대해서 접두사는 특정 인덱스까지의 문자열을 의미합니다. 예를 들어, "banana"의 모든 접두사는 "b", "ba", "ban", "bana", "banan", "banana"입니다.
// 문자열 my_string과 is_prefix가 주어질 때, is_prefix가 my_string의 접두사라면 1을, 아니면 0을 return 하는 solution 함수를 작성해 주세요.

// 성공

class Solution {
    public int solution(String myString, String isPrefix) {
        int answer = 0;
        if(myString.startsWith(isPrefix)) {
            answer = 1;
        } 
        return answer;
    }
}