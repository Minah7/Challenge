// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/150370

// 고객의 약관 동의를 얻어서 수집된 1~n번으로 분류되는 개인정보 n개가 있습니다. 
// 약관 종류는 여러 가지 있으며 각 약관마다 개인정보 보관 유효기간이 정해져 있습니다. 
// 당신은 각 개인정보가 어떤 약관으로 수집됐는지 알고 있습니다. 
// 수집된 개인정보는 유효기간 전까지만 보관 가능하며, 유효기간이 지났다면 반드시 파기해야 합니다.

// 당신은 오늘 날짜로 파기해야 할 개인정보 번호들을 구하려 합니다.
// 모든 달은 28일까지 있다고 가정합니다.

// 성공

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
       List<Integer> answer = new ArrayList<>();
		
		int countTodayDays = 0;
		String[] t = today.split("\\.");
		countTodayDays += (Integer.parseInt(t[0]) * 12 * 28); // 년도 일수
		countTodayDays += (Integer.parseInt(t[1]) * 28); // 월 일수
		countTodayDays += Integer.parseInt(t[2]);
		
		Map<String, Integer> term = new HashMap<>();
		for(int i = 0; i < terms.length; i++) {
			String[] info = terms[i].split(" ");
			term.put(info[0], Integer.parseInt(info[1]));
		}
		
		for(int i = 0; i < privacies.length; i++) {
			String[] info = privacies[i].split(" ");
			
			int compareDays = 0;
			String[] date = info[0].split("\\.");
			compareDays += (Integer.parseInt(date[0]) * 12 * 28);
			compareDays += (Integer.parseInt(date[1]) * 28);
			compareDays += Integer.parseInt(date[2]);
			
			int termMonths = term.get(info[1]);
			compareDays += (termMonths * 28);
			
			if(countTodayDays >= compareDays) {
				answer.add(i+1);
			}
		}
		return answer.stream().mapToInt(i -> i).toArray();
    }
}