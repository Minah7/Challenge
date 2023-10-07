// 지나다니는 길을 'O', 장애물을 'X'로 나타낸 직사각형 격자 모양의 공원에서 로봇 강아지가 산책을 하려합니다. 
// 산책은 로봇 강아지에 미리 입력된 명령에 따라 진행하며, 명령은 다음과 같은 형식으로 주어집니다.

// ["방향 거리", "방향 거리" … ]
// 예를 들어 "E 5"는 로봇 강아지가 현재 위치에서 동쪽으로 5칸 이동했다는 의미입니다. 
// 로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.

// 주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
// 주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
// 위 두 가지중 어느 하나라도 해당된다면, 로봇 강아지는 해당 명령을 무시하고 다음 명령을 수행합니다.
// 공원의 가로 길이가 W, 세로 길이가 H라고 할 때, 
// 공원의 좌측 상단의 좌표는 (0, 0), 우측 하단의 좌표는 (H - 1, W - 1) 입니다.

// 공원을 나타내는 문자열 배열 park, 
// 로봇 강아지가 수행할 명령이 담긴 문자열 배열 routes가 매개변수로 주어질 때, 
// 로봇 강아지가 모든 명령을 수행 후 놓인 위치를 [세로 방향 좌표, 가로 방향 좌표] 순으로 배열에 담아 return 하도록 solution 함수를 완성해주세요.

// 성공!!!

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] start = new int[2]; //시작위치 넣을 배열 => 답

        // E, S, W, N : 우, 하, 좌, 상
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int parkR = park.length; // park 세로길이
        int parkC = park[0].length(); // park 가로길이
        int[][] parkCopy = new int[parkR][parkC];
        for(int row = 0; row < parkR; row++) {
            for(int col = 0; col < parkC; col++) {
                if(park[row].charAt(col) == 'S') {
                    parkCopy[row][col] = 2; //시작위치
                    start[0] = row;
                    start[1] = col;
                } else if(park[row].charAt(col) == 'O') {
                    parkCopy[row][col] = 0; //이동 가능
                } else {
                    parkCopy[row][col] = 1; //장애물
                }
            }
        } // park배열 값 int로 담아서 parkCopy에 넣어주기.
        
        String[][] routesCopy = new String[routes.length][2];
        for(int i = 0; i < routes.length; i++) {
            routesCopy[i] = routes[i].split(" ");
        } // routes배열 '이동할 방향'과 '이동할 칸의 수'로 나눠주기
        
        // 명령 수행
        for(int i = 0; i < routes.length; i++) {
            int n = Integer.parseInt(routesCopy[i][1]);
            int cnt = 0;
            int[] tmp = {start[0], start[1]};
            switch(routesCopy[i][0]) {
                case "E" :
                    // 이동할 수만큼 반복
                    while(cnt < n) {
                        int nc = tmp[1]+dir[0][1];
                        if (nc < parkC && parkCopy[start[0]][nc] != 1) {
                            tmp[1] = nc;
                            cnt++;
                        } else {
                            break;
                        }
                    }
                    // 명령의 수만큼 수행했다면 시작 위치 바꿔주기 
                    if(cnt == n) {
                        start[1] = tmp[1];
                    }
                    break;
                case "S" :
                    while(cnt < n) {
                        int nr = tmp[0]+dir[1][0];
                        if (nr < parkR && parkCopy[nr][start[1]] != 1) {
                            tmp[0] = nr;
                            cnt++;
                        } else {
                            break;
                        }
                    }
                    if(cnt == n) {
                        start[0] = tmp[0];
                    }
                    break;
                case "W" :
                    while(cnt < n) {
                        int nc = tmp[1]+dir[2][1];
                        if (0 <= nc && parkCopy[start[0]][nc] != 1) {
                            tmp[1] = nc;
                            cnt++;
                        } else {
                            break;
                        }
                    }
                    if(cnt == n) {
                        start[1] = tmp[1];
                    }
                    break;
                case "N" :
                    while(cnt < n) {
                        int nr = tmp[0]+dir[3][0];
                        if (0 <= nr && parkCopy[nr][start[1]] != 1) {
                            tmp[0] = nr;
                            cnt++;
                        } else {
                            break;
                        }
                    }
                    if(cnt == n) {
                        start[0] = tmp[0];
                    }
                    break;
            }
        }
        return start;
	}
}