// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/172927

// 마인은 다이아몬드 곡괭이, 철 곡괭이, 돌 곡괭이를 각각 0개에서 5개까지 가지고 있으며, 
// 곡괭이로 광물을 캘 때는 피로도가 소모됩니다.
// 마인은 다음과 같은 규칙을 지키면서 최소한의 피로도로 광물을 캐려고 합니다.

// 사용할 수 있는 곡괭이중 아무거나 하나를 선택해 광물을 캡니다.
// 한 번 사용하기 시작한 곡괭이는 사용할 수 없을 때까지 사용합니다.
// 광물은 주어진 순서대로만 캘 수 있습니다.
// 광산에 있는 모든 광물을 캐거나, 더 사용할 곡괭이가 없을 때까지 광물을 캡니다.

// 두번째 실패. 97.1
import java.util.Comparator;
import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int box = Math.min(((int)Math.ceil(minerals.length / 5.0)), (picks[0] + picks[1] + picks[2]));
        int[][] countM = new int[box][3];
        
        int b = 0;
        for(int i = 0; i < minerals.length; i++) {
            if(b == box) {
                break;
            }
            if(minerals[i].equals("diamond")) {
                countM[b][0] += 1;
                countM[b][1] += 5;
                countM[b][2] += 25;
            } else if(minerals[i].equals("iron")) {
                countM[b][0] += 1;
                countM[b][1] += 1;
                countM[b][2] += 5;
            } else if(minerals[i].equals("stone")) {
                countM[b][0] += 1;
                countM[b][1] += 1;
                countM[b][2] += 1;
            }
            if(i%5 == 4) {
                b++;
            }
        }
        
        Arrays.sort(countM, (o1, o2) -> (o2[2] - o1[2]));
        boolean[] check = new boolean[box];
        
        for(int i = 0; i < box; i++) {
            if(picks[0] != 0) {
                answer += countM[i][0];
                check[i] = true;
                picks[0]--;
            } else if(picks[1] != 0) {
                Arrays.sort(countM, (o1, o2) -> (o2[1] - o1[1]));
                for(int j = 0; j < box; j++) {
                    if(!check[j]) {
                        answer += countM[i][1];
                        check[j] = true;
                        picks[1]--;
                        break;
                    }
                }
            } else if(picks[2] != 0) {
                Arrays.sort(countM, (o1, o2) -> (o2[0] - o1[0]));
                for(int j = 0; j < box; j++) {
                    if(!check[j]) {
                        answer += countM[i][2];
                        check[j] = true;
                        picks[2]--;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}

// 첫번째 실패. 48.6
import java.util.Comparator;
import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int box = Math.min(((int)Math.ceil(minerals.length / 5.0)), (picks[0] + picks[1] + picks[2]));
        int[][] countM = new int[box][3];
        
        int b = 0;
        for(int i = 0; i < minerals.length; i++) {
            if(b == box) {
                break;
            }
            if(minerals[i].equals("diamond")) {
                countM[b][0] += 1;
                countM[b][1] += 5;
                countM[b][2] += 25;
            } else if(minerals[i].equals("iron")) {
                countM[b][0] += 1;
                countM[b][1] += 1;
                countM[b][2] += 5;
            } else if(minerals[i].equals("stone")) {
                countM[b][0] += 1;
                countM[b][1] += 1;
                countM[b][2] += 1;
            }
            if(i%5 == 4) {
                b++;
            }
        }
        
        Arrays.sort(countM, (o1, o2) -> (o2[2] - o1[2]));
        boolean[] check = new boolean[box];
        
        for(int i = 0; i < box; i++) {
            if(picks[0] != 0) {
                answer += countM[i][0];
                check[i] = true;
                picks[0]--;
            } else if(picks[1] != 0) {
                Arrays.sort(countM, (o1, o2) -> (o2[1] - o1[1]));
                for(int j = 0; j < box; j++) {
                    if(!check[j]) {
                        answer += countM[i][1];
                        check[j] = true;
                    }
                }
                picks[1]--;
            } else if(picks[2] != 0) {
                Arrays.sort(countM, (o1, o2) -> (o2[0] - o1[0]));
                for(int j = 0; j < box; j++) {
                    if(!check[j]) {
                        answer += countM[i][2];
                        check[j] = true;
                    }
                }
                picks[2]--;
            }  
        }
        
        return answer;
    }
}