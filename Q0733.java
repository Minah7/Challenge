// 준호는 요즘 디펜스 게임에 푹 빠져 있습니다. 
// 디펜스 게임은 준호가 보유한 병사 n명으로 연속되는 적의 공격을 순서대로 막는 게임입니다. 
// 디펜스 게임은 다음과 같은 규칙으로 진행됩니다.

// 준호는 처음에 병사 n명을 가지고 있습니다.
// 매 라운드마다 enemy[i]마리의 적이 등장합니다.
// 남은 병사 중 enemy[i]명 만큼 소모하여 enemy[i]마리의 적을 막을 수 있습니다.
// 예를 들어 남은 병사가 7명이고, 적의 수가 2마리인 경우, 현재 라운드를 막으면 7 - 2 = 5명의 병사가 남습니다.
// 남은 병사의 수보다 현재 라운드의 적의 수가 더 많으면 게임이 종료됩니다.
// 게임에는 무적권이라는 스킬이 있으며, 무적권을 사용하면 병사의 소모없이 한 라운드의 공격을 막을 수 있습니다.
// 무적권은 최대 k번 사용할 수 있습니다.
// 준호는 무적권을 적절한 시기에 사용하여 최대한 많은 라운드를 진행하고 싶습니다.

// 준호가 처음 가지고 있는 병사의 수 n, 사용 가능한 무적권의 횟수 k, 
// 매 라운드마다 공격해오는 적의 수가 순서대로 담긴 정수 배열 enemy가 매개변수로 주어집니다. 
// 준호가 몇 라운드까지 막을 수 있는지 return 하도록 solution 함수를 완성해주세요.

// 실패. 21.9점

import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int[] shield = new int[k];
        for(int e = 0; e < k; e++) {
            shield[e]=enemy[e];
            answer++;
        }
        Arrays.sort(shield);
        //무적권을 사용해서 해치웠던 적의 수 보다 지금 보는 라운드의 적이 더 많으면 n에서 무적권에서 사용했던 값을 빼기
        for(int e = k; e < enemy.length; e++) {
            for(int i = k-1; i >= 0; i--) {
                if(shield[i] != 0 && enemy[e] > shield[i] && n-shield[i] >= 0) {
                    answer++;
                    n -= shield[i];
                    enemy[e] = 0;
                    shield[i] = 0;
                }
            }
            if(enemy[e] != 0) {
                break;
            }
        }
        return answer;
    }
}