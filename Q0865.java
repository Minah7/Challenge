// a배 이상 차이나지 않고, b초 이상 차이나지 않아야한다.
// 서버 중 가장 많은 사용량을 가진 서버의 사용가능한 수와 서버 번호를 출력

int a, int b, int[][] servers

int row = servers.length;
int server = servers[0].length;

int[] answer = new int[2];
int[] max = new int[server];
for(int s = 0; s < server; s++) {
    for(r = 0; r < row; r++) {
        int num = servers[r][s];
        int count = 1;
        for(int i = r + 1; i < row; i++) {
            int n = servers[i][s];
            if(num >= n) {
                if(num / n >= a) {
                    continue;
                }
            } else {
                if(n / num >= a) {
                    continue;
                }
            }

            int tmp = Math.abs(num - n);
            if(tmp / 1000 >= b) {
                continue;
            } else {
                count++;
            }
        }
        max[s] = Math.max(max[s], count);
    }
}
for(int i = 0; i < server; i++) {
    if(max[i] > answer[0]) {
        answer[0] = max[i];
        answer[1] = i;
    }
}