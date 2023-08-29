// 선분 3개가 평행하게 놓여 있습니다. 
// 세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 형태로 들어있는 2차원 배열 lines가 매개변수로 주어질 때, 
// 두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.

// lines가 [[0, 2], [-3, -1], [-2, 1]]일 때 그림으로 나타내면 다음과 같습니다.
// 선분이 두 개 이상 겹친 곳은 [-2, -1], [0, 1]로 길이 2만큼 겹쳐있습니다.

// 실패. 문제 잘못해석

class Solution {
    public int solution(int[][] lines) {
        int minStart = 100;
        int maxEnd = -100;
        int sum = 0; // 막대의 총 길이 값 구할 변수
        for(int row = 0; row < lines.length; row++) {
            //가장 작은 시작 값 구하기
            if(lines[row][0] < minStart) {
                minStart = lines[row][0];
            }
            //가장 큰 끝 값 구하기
            if(lines[row][1] > maxEnd) {
                maxEnd = lines[row][1];
            }
            if(lines[row][0] > lines[row][1]) {
                sum += lines[row][0] - lines[row][1];
            } else if(lines[row][0] < lines[row][1]) {
                sum += lines[row][1] - lines[row][0];
            }
        }
        int length = maxEnd - minStart;
        int answer = sum - length;
        return answer;
    }
}