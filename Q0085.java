// 문자열 myString이 주어집니다. myString을 문자 "x"를 기준으로 나눴을 때 
// 나눠진 문자열 각각의 길이를 순서대로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.

class Solution {
    public int[] solution(String myString) {
        String[] ArrayStr = myString.split("x",-1);
        int[] answer = new int[ArrayStr.length];
        for (int i = 0; i < ArrayStr.length; i++) {
            answer[i] = ArrayStr[i].length();
        }
        return answer;
    }
}

//성공.

// String[] ArrayStr = myString.split("x",-1);
// 여기서 ("x",-1) 부분에서 -1을 추가한 이유는 끝에 x가 있을 때 0이 출력돼서이다.
// 아직도 이 부분이 조금 헷갈리긴 한다. 