// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42862

// 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 
// 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
// 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

// 실패. 53.3점

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int lenL = lost.length;
        int lenR = reserve.length;
        int[] uniform = new int[n+1];
        for(int student = 1, idL = 0, idR = 0; student <= n; student++) {
            if(idL < lenL && lost[idL] == student) {
                uniform[student] = 0;
                idL++;
            } else if(idR < lenR && reserve[idR] == student) {
                uniform[student] = 2;
                idR++;
            } else {
                uniform[student] = 1;
            }
        }
        
        for(int student = 1; student <= n; student++) {
            if(uniform[student] == 0) {
                if(1 < student && (uniform[student - 1] == 2)) {
                    uniform[student] = 1;
                    uniform[student - 1] -= 1;
                } else if(student < n && (uniform[student + 1] == 2)) {
                    uniform[student] = 1;
                    uniform[student + 1] -= 1; 
                }
            }
        }
        
        for(int student = 1; student <= n; student++) {
            if(uniform[student] > 0) {
                answer++;
            }
        }
        return answer;
    }
}