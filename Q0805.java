// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/250137

// 붕대 감기 기술의 시전 시간, 1초당 회복량, 추가 회복량을 담은 1차원 정수 배열 bandage와 
// 최대 체력을 의미하는 정수 health, 
// 몬스터의 공격 시간과 피해량을 담은 2차원 정수 배열 attacks가 매개변수로 주어집니다. 
// 모든 공격이 끝난 직후 남은 체력을 return 하도록 solution 함수를 완성해 주세요. 
// 만약 몬스터의 공격을 받고 캐릭터의 체력이 0 이하가 되어 죽는다면 -1을 return 해주세요.

//성공.

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int time = attacks[attacks.length - 1][0];
        int cnt = 0, hp = health;
        for(int t = 1, a = 0; t <= time; t++) {
            if(attacks[a][0] == t) {
                cnt = -1;
                hp -= attacks[a][1];
                if(hp <= 0) {
                    hp = -1;
                    break;
                }
                a++;
            } else if(hp < health) {
                hp += bandage[1];
                if(cnt == (bandage[0] - 1)) {
                    hp += bandage[2];
                    cnt = -1;
                }
                if(hp > health) {
                    hp = health;
                }
            }
            cnt++;
        }
        answer = hp;
        return answer;
    }
}