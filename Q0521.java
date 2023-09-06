// 1부터 6까지 숫자가 적힌 주사위가 네 개 있습니다. 네 주사위를 굴렸을 때 나온 숫자에 따라 다음과 같은 점수를 얻습니다.

// 네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점을 얻습니다.
// 세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.
// 주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.
// 어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서 나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.
// 네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중 가장 작은 숫자 만큼의 점수를 얻습니다.
// 네 주사위를 굴렸을 때 나온 숫자가 정수 매개변수 a, b, c, d로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.

// 성공

import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] num = {a, b, c, d};
        int[] cnt = new int[7];
        for(int i = 0; i < num.length; i++) {
            cnt[num[i]]++;
        }
        List<Integer> cntList = new ArrayList<>();
        for(int i = 0; i < cnt.length; i++) {
        	cntList.add(cnt[i]);
        }
        if(cntList.contains(4)) {
            answer = 1111*a;
        } else if(cntList.contains(3)) {
            int p = 0;
            int q = 0;
            for(int i = 0; i < cnt.length; i++) {
                if(cnt[i] == 3) p = i;
                if(cnt[i] == 1) q = i;
            }
            answer = (10*p + q)*(10*p + q);
        } else if(cntList.contains(2) && !cntList.contains(1)) {
            int[] pq = new int[2];
            for(int i = 0, idx= 0; i < cnt.length; i++) {
                if(cnt[i] == 2) pq[idx++] = i;
            }
            int sumPQ = pq[0]+pq[1];
            int abs = Math.abs(pq[0]-pq[1]);
            answer = sumPQ * abs;
        } else if(cntList.contains(2) && cntList.contains(1)) {
            int[] qr = new int[2];
            for(int i = 0, idx = 0; i < cnt.length; i++) {
                if(cnt[i] == 1) qr[idx++] = i;
            }
            answer = qr[0] * qr[1];
        } else if (!cntList.contains(4) && !cntList.contains(3) && !cntList.contains(2)) {
            int min = 6;
            for(int i = 0; i < cnt.length; i++) {
                if(cnt[i] == 1 && i < min) {
                    min = i;
                }
            }
            answer = min;
        }
        return answer;
    }
}