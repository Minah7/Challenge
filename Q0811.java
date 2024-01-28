// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/42888

// 채팅방에 들어오고 나가거나, 닉네임을 변경한 기록이 담긴 문자열 배열 record가 매개변수로 주어질 때, 
// 모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return

//두 번째도 성공. 시간이 훨씬 줄어들었다.

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Queue<Integer> messages = new LinkedList<>(); // 출력 순서를 담을 큐
        HashMap<String, String> id = new HashMap<>(); // 아이디와 닉네임 담을 용도
        for(int i = 0; i < record.length; i++) {
            if(record[i].contains("Enter") || record[i].contains("Change")) {
                String[] r = record[i].split(" ");
                id.put(r[1], r[2]);
                if(r[0].equals("Enter")) {
                    messages.add(i);
                }
            } else if(record[i].contains("Leave")) {
                messages.add(i);
            }
        }
        
        int ms = messages.size();
        String[] answer = new String[ms];
        for(int m = 0; m < ms; m++) {
            String[] info = record[messages.poll()].split(" ");
            
            if(info[0].equals("Enter")) {
                answer[m] = id.get(info[1]) + "님이 들어왔습니다.";
            } else {
                answer[m] = id.get(info[1]) + "님이 나갔습니다.";
            }
        }       
        return answer;
    }
}

//첫 번째 성공.

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Queue<String> messages = new LinkedList<>(); // 출력 순서를 담을 큐
        HashMap<String, String> id = new HashMap<>(); // 아이디와 닉네임 담을 용도
        for(int i = 0; i < record.length; i++) {
            if(record[i].contains("Enter") || record[i].contains("Change")) {
                String[] r = record[i].split(" ");
                id.put(r[1], r[2]);
                if(r[0].equals("Enter")) {
                    String m = r[0] + " " + r[1];
                    messages.add(m);
                }
            } else if(record[i].contains("Leave")) {
                messages.add(record[i]);
            }
        }

        String[] answer = new String[messages.size()];
        int n = messages.size();
        for(int m = 0; m < n; m++) {
            String s = messages.poll();
            String[] info = s.split(" ");
            if(info[0].equals("Enter")) {
                answer[m] = id.get(info[1]) + "님이 들어왔습니다.";
            } else {
                answer[m] = id.get(info[1]) + "님이 나갔습니다.";
            }
        }       
        return answer;
    }
}