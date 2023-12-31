// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/120875
// [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
// 주어진 네 개의 점을 두 개씩 이었을 때, 
// 두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution 함수를 완성해보세요.
// 성공.

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        for(int i = 1; i < 4; i++) {
            int x1xI = dots[i][0] - dots[0][0];
            int y1yI = dots[i][1] - dots[0][1];
            
            // 남은 두 개의 점을 구하기 위한 식
            int[] restDots = new int[2]; 
            for(int r = 1, index = 0; r < 4; r++) {
                if(r != i) {
                    restDots[index++] = r;
                }
            }
            int xr = dots[restDots[1]][0] - dots[restDots[0]][0];
            int yr = dots[restDots[1]][1] - dots[restDots[0]][1];
            
            // 기울기 구해서 평행 확인하기
            if((double) y1yI / x1xI == (double) yr / xr) {
                answer = 1;
            }
        }
        return answer;
    }
}