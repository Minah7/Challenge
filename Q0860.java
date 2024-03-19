// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12913

// 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고, 모든 칸에는 점수가 쓰여 있습니다.
// 1행부터 땅을 밟으며 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다.
// 단, 땅따먹기 게임에는 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.

// 마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 return하는 solution 함수를 완성해 주세요.

// 성공
class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int[] sum = new int[4];
        for(int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }
        
        for(int i = 0; i < 4; i++) {
            answer = Math.max(answer, land[land.length - 1][i]);
        }

        return answer;
    }
}

// 첫번째 시도 실패. 시간 초과.
class Solution {
    static int answer;
    int solution(int[][] land) {
        answer = 0;
        boolean[][] visited = new boolean[land.length][4];
        dfs(land, 0, 0, -1);

        return answer;
    }
    
    public static void dfs(int[][] land, int depth, int sum, int idx) {
        if(depth == land.length) {
            answer = Math.max(answer, sum);
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            if(i != idx) {
                dfs(land, depth + 1, sum + land[depth][i], i);
            }
        }
    }
}