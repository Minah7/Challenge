// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/250121

// data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후, 
// sort_by에 해당하는 값을 기준으로 오름차순으로 정렬하여 return 하도록 solution 함수를 완성해 주세요. 
// 단, 조건을 만족하는 데이터는 항상 한 개 이상 존재합니다.

// 성공

import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int valExt, String sortBy) {
        String[] checkExt = {"code", "date", "maximum", "remain"};
        ArrayList<Integer> arr = new ArrayList<>();
        int e = 0;
        int s = 0;
        for(int c = 0; c < 4; c++) {
            if(ext.equals(checkExt[c])) {
                e = c;
            }
            if(sortBy.equals(checkExt[c])) {
                s = c;
            }
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int row = 0; row < data.length; row++) {
            if(data[row][e] < valExt) {
                arr.add(data[row][s]);
                map.put(data[row][s], row);
            }
        }
        
        int[][] answer = new int[arr.size()][4];
        Collections.sort(arr);
        for(int i = 0; i < arr.size(); i++) {
            int row = map.get(arr.get(i));
            for(int col = 0; col < 4; col++) {
                answer[i][col] = data[row][col];
            }
        }
        
        return answer;
    }
}