// 선분 3개가 평행하게 놓여 있습니다. 
// 세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 형태로 들어있는 2차원 배열 lines가 매개변수로 주어질 때, 
// 두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.

// lines가 [[0, 2], [-3, -1], [-2, 1]]일 때 그림으로 나타내면 다음과 같습니다.

// 선분이 두 개 이상 겹친 곳은 [-2, -1], [0, 1]로 길이 2만큼 겹쳐있습니다.

// 실패

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        for(int i = 0; i < lines.length - 1; i++) {
            for(int j = i+1; j < lines.length; j++) {
                if(lines[i][0] < lines[j][0] && lines[j][0] < lines[i][1]) {
                    int end = Math.min(lines[i][1], lines[j][1]);
                    answer += end - lines[j][0];
                    break;
                } else if(lines[i][0] < lines[j][1] && lines[j][1] < lines[i][1]) {
                    int start = Math.max(lines[i][0], lines[j][0]);
                    answer += lines[j][1]-start;
                }
            }
        }
        return answer;
    }
}