// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/161990

// 머쓱이의 컴퓨터 바탕화면의 상태를 나타내는 문자열 배열 wallpaper가 
// 매개변수로 주어질 때 바탕화면의 파일들을 한 번에 삭제하기 위해 
// 최소한의 이동거리를 갖는 드래그의 시작점과 끝점을 담은 정수 배열을 return
// 드래그의 시작점이 (lux, luy), 끝점이 (rdx, rdy)라면 정수 배열 [lux, luy, rdx, rdy]를 return

// 성공

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {-1, -1, -1, -1};
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        boolean[][] file = new boolean[row][col];
        
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                if(wallpaper[r].charAt(c) == '#') {
                    if(answer[0] == -1) {
                        answer[0] = r;
                        answer[2] = r + 1;
                        answer[1] = c;
                        answer[3] = c + 1;
                    } else {
                        if(c <= answer[1]) {
                            answer[1] = c;
                        } else if(c+1 > answer[3]) {
                            answer[3] = c + 1;
                        }
                        answer[2] = r+1;
                    }
                }
            }
        }
        
        return answer;
    }
}