// 양의 정수 n이 매개변수로 주어집니다. 
// n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터 시계방향 나선형으로 배치한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.

// 성공

class Solution {
    public int[][] solution(int n) {
        // n*n개수의 배열 생성
        int[][] answer = new int[n][n];
        // 기입할 숫자 설정
        int num = 1;
        int row = 0;
        int col = -1;
        // 방향설정 : 우 하 좌 상
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        //이동할 방향 값. 오른쪽으로 시작
        int dir = 0;
        //세트개수만큼 반복문 돌리기
        for(int set = 0; set < n; set++) {
            //첫번째 반복문 = 세트개수만큼
            for(int first = set; first < n; first++) {
                //방향값
                dir = dir%4;
                //행 값
                row = row+dr[dir];
                //열 값
                col = col+dc[dir];
                //숫자 기입하고 1씩 더해주기
                answer[row][col] = num++;
            }
            //만약 숫자가 n제곱이면 멈추기
            if(num == n*n) break;
            //방향값 더해주기
            dir++;
            //두번째 반복문 = 첫번째 반복문 -1개
            for(int second = set+1; second < n; second++) {
                dir = dir%4;
                row = row+dr[dir];
                col = col+dc[dir];
                answer[row][col] = num++;
            }
            dir++;
        }
        return answer;
    }
}