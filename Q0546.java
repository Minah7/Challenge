// 2016년 1월 1일은 금요일입니다. 
// 2016년 a월 b일은 무슨 요일일까요? 
// 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 
// 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT 입니다. 
// 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.

// 성공

class Solution {
    public String solution(int a, int b) {
        //윤년 월별 일수
        int[] daysPerMonth = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        //요일 : 시작요일 (금요일)
        String[] days = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        //누적합
        for(int i = 2; i < daysPerMonth.length; i++) {
            daysPerMonth[i] += daysPerMonth[i-1];
        }
        int whichDay = (daysPerMonth[a-1]+b-1)%7;
        String answer = days[whichDay];
        return answer;
    }
}
