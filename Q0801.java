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