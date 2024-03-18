// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/17679

// 블라인드 공채를 통과한 신입 사원 라이언은 신규 게임 개발 업무를 맡게 되었다. 이번에 출시할 게임 제목은 "프렌즈4블록".
// 같은 모양의 카카오프렌즈 블록이 2×2 형태로 4개가 붙어있을 경우 사라지면서 점수를 얻는 게임이다.

// 만약 판이 위와 같이 주어질 경우, 라이언이 2×2로 배치된 7개 블록과 콘이 2×2로 배치된 4개 블록이 지워진다. 
// 같은 블록은 여러 2×2에 포함될 수 있으며, 지워지는 조건에 만족하는 2×2 모양이 여러 개 있다면 한꺼번에 지워진다.

// 성공

class Solution {
    static int[][] dir = {{0, 1}, {1, 1}, {1, 0}};
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        int[][] arr = new int[m][n];
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                arr[r][c] = board[r].charAt(c) - 'A' + 1;
            }
        }
        
        int round = 0;
        while(true) {
            round++;
            boolean flag = false;
            int count = 0;
            boolean[][] delete = new boolean[m][n];
            for(int r = 0; r < m - 1; r++) {
                for(int c = 0; c < n - 1; c++) {
                    if(arr[r][c] != 0) {
                        int num = arr[r][c];
                        boolean check = true;
                        for(int d = 0; d < 3; d++) {
                            if(arr[r + dir[d][0]][c + dir[d][1]] != num) {
                                check = false;
                                break;
                            }
                        }
                        if(check) {
                            if(!delete[r][c]) {
                                delete[r][c] = true;
                                count++;
                            }
                            for(int d = 0; d < 3; d++) {
                                if(!delete[r + dir[d][0]][c + dir[d][1]]) {
                                    delete[r + dir[d][0]][c + dir[d][1]] = true;
                                    count++;
                                }
                            }
                        }
                    }
                }
            } // 지울 수 있는 블록 찾고 개수 구하기
            
            if(count == 0) {
                break;
            } // 만일 지우는 블록이 없다면 멈추기
            
            answer += count;
            
            for(int r = 0; r < m; r++) {
                for(int c = 0; c < n; c++) {
                    if(delete[r][c]) {
                        arr[r][c] = 0;
                    }
                }
            } // 블록 지우기
            
            for(int c = 0; c < n; c++) {
                int idx = m - 1;
                for(int r = m - 1; r >= 0; r--) {
                    int num = arr[r][c];
                    if(num != 0) {
                        arr[r][c] = 0;
                        arr[idx--][c] = num;
                    }
                }
            } // 블록 떨어뜨리기
        }
        
        return answer;
    }
}