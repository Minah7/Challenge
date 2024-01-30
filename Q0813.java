// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/92341

// 주차 요금을 나타내는 정수 배열 fees, 
// 자동차의 입/출차 내역을 나타내는 문자열 배열 records가 매개변수로 주어집니다. 
// 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return

// 성공

import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, String> in = new HashMap<>(); // 입차 정보 입력
        // 번호가 작은 자동차부터 넣어야 하기 때문에 TreeMap 사용.
        Map<String, Integer> count = new TreeMap<>(); // 누적 정보 입력
        
        for(int i = 0; i < records.length; i++) {
            String[] info = records[i].split(" ");
            
            if(records[i].contains("IN")) {
                in.put(info[1], info[0]);
            } else if(records[i].contains("OUT")) {
                String[] entryTime = in.get(info[1]).split(":");
                String[] exitTime = info[0].split(":");
                
                int entryT = (Integer.parseInt(entryTime[0]) * 60) + Integer.parseInt(entryTime[1]);
                int exitT = (Integer.parseInt(exitTime[0]) * 60) + Integer.parseInt(exitTime[1]);
                
                int total = exitT - entryT; //주차한 시간 계산
                
                count.put(info[1], (count.getOrDefault(info[1], 0) + total));
                
                in.remove(info[1]);
                // if(count.containsKey(info[1])) {
                //     count.put(info[1], (count.get(info[1]) + total));
                // } else {
                //     count.put(info[1], total);
                // }
            }
        } // 입,출차 정보 입력
        
        for(Entry<String, String> entrySet : in.entrySet()) {
            String carNum = entrySet.getKey();
            String[] entryTime = entrySet.getValue().split(":");
            int entryT = (Integer.parseInt(entryTime[0]) * 60) + Integer.parseInt(entryTime[1]);
            int end = (23*60) + 59;
            int total = end - entryT;
            
            count.put(carNum, (count.getOrDefault(carNum, 0) + total));
        } // 출차 안한 차 누적 시간 구하기
        
        int[] answer = new int[count.size()];
        int idx = 0;
        for(String countKey : count.keySet()) {
            int time = count.get(countKey);
            if(time <= fees[0]) {
                answer[idx++] = fees[1];
            } else if(time > fees[0]) {
                answer[idx++] = fees[1] + ((int)Math.ceil((time - fees[0]) / (double)fees[2]) * fees[3]);
            }
        } // 요금 계산
    
        return answer;
    }
}