// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/92334

// 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
// 신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
// 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
// k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
// 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.

// 성공

import java.util.*;

class Solution {
    public int[] solution(String[] idList, String[] report, int k) {
        int[] answer = new int[idList.length];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < idList.length; i++) {
            map.put(idList[i], i);
        }
        
        ArrayList<Integer>[] count = new ArrayList[idList.length];
        for(int i = 0; i < idList.length; i++) {
            count[i] = new ArrayList();
        }
        
        for(int i = 0; i < report.length; i++) {
            String[] st = report[i].split(" ");
            int p1 = map.get(st[0]);
            int p2 = map.get(st[1]);
            if(!count[p2].contains(p1)) {
                count[p2].add(p1);
            }
        }
        
        for(int i = 0; i < idList.length; i++) {
            if(count[i].size() >= k) {
                for(int j = 0; j < count[i].size(); j++) {
                    answer[count[i].get(j)]++;
                }
            }
        }
        
        return answer;
    }
}