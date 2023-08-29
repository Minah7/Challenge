// 2차원 좌표 평면에 변이 축과 평행한 직사각형이 있습니다. 
// 직사각형 네 꼭짓점의 좌표 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]가 담겨있는 배열 dots가 매개변수로 주어질 때, 직사각형의 넓이를 return 하도록 solution 함수를 완성해보세요.

// 성공

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int width = 0;
        int height = 0;
        for(int row = 1; row < dots.length; row++) {
            //직사각형의 가로 찾기
            if(dots[0][0] == dots[row][0]) {
                //어느 좌표가 더 큰지 비교하고 큰 좌표에서 작은 좌표 빼기
                if(dots[0][1] < dots[row][1]) {
                    width = dots[row][1] - dots[0][1];
                } else if(dots[0][1] > dots[row][1]) {
                    width = dots[0][1] - dots[row][1];
                }
            }
            //직사각형의 세로 찾기
            if(dots[0][1] == dots[row][1]) {
                //어느 좌표가 더 큰지 비교하고 큰 좌표에서 작은 좌표 빼기
                if(dots[0][0] < dots[row][0]) {
                    height = dots[row][0] - dots[0][0];
                } else if(dots[0][0] > dots[row][0]) {
                    height = dots[0][0] - dots[row][0];
                }
            }
        }
        answer = height*width;
        return answer;
    }
}