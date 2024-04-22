// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/17687

// 숫자를 0부터 시작해서 차례대로 말한다. 첫 번째 사람은 0, 두 번째 사람은 1, … 열 번째 사람은 9를 말한다.
// 10 이상의 숫자부터는 한 자리씩 끊어서 말한다. 즉 열한 번째 사람은 10의 첫 자리인 1, 열두 번째 사람은 둘째 자리인 0을 말한다.
// 이렇게 게임을 진행할 경우,
// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, …
// 순으로 숫자를 말하면 된다.

// 한편 코딩 동아리 일원들은 컴퓨터를 다루는 사람답게 이진수로 이 게임을 진행하기도 하는데, 이 경우에는
// 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, …
// 순으로 숫자를 말하면 된다.

// 성공

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        if(p == m) {
            p = 0;
        }
        int aLen = 0;
        int num = 0;
        int turn = 1;
        while(true) {
            if(aLen == t) {
                break;
            }
            String check = Integer.toString(num, n);
            for(int i = 0; i < check.length(); i++) {
                if(aLen == t) {
                    break;
                }
                if(turn % m == p) {
                    answer += check.charAt(i);
                    aLen++;
                }
                turn++;
            }
            num++;
        }

        return answer.toUpperCase();
    }
}