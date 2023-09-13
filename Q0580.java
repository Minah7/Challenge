// 두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다
// (단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다). 
// X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. 
// X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.

// 예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다. 
// 다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다
// (X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)
// 두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.

// 실패

//두번째 실패. 테스트케이스 19개 중 5개 실패.(이유: 시간초과)
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        //X와 Y의 0-9개수
        int[] x = new int[10];
        for(int i = 0; i < X.length(); i++) {
            x[X.charAt(i)-'0']++;
        }
        int[] y = new int[10];
        for(int i = 0; i < Y.length(); i++) {
            y[Y.charAt(i)-'0']++;
        }
        //짝궁 수 구하기
        int numFriend = 0;
        int[] numF = new int[10];
        for(int i = 0; i < x.length; i++) {
            if(x[i] > 0 && y[i] > 0) {
                numFriend += Math.min(x[i],y[i]);
                numF[i] = Math.min(x[i],y[i]);
            }
        }
        //답 구하기
        if(numFriend == 0) {
            answer = "-1";
        } else if(numFriend > 0 && numFriend == numF[0]) {
            answer = "0";
        } else {
            for(int n = numF.length-1; n >= 0; n--) {
                if(numF[n]>0) {
                    for(int j = 0; j < numF[n]; j++) {
                        answer += String.valueOf(n);
                    }
                }
            } 
        }
        return answer;
    }
}

//첫번째 실패(코드실행에서 실패)
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        //X와 Y의 0-9개수
        int[] x = new int[10];
        for(int i = 0; i < X.length(); i++) {
            x[X.charAt(i)-'0']++;
        }
        int[] y = new int[10];
        for(int i = 0; i < Y.length(); i++) {
            y[Y.charAt(i)-'0']++;
        }
        //짝궁 수 구하기
        int numFriend = 0;
        int[] numF = new int[10];
        for(int i = 0; i < x.length; i++) {
            if(x[i] > 0 && y[i] > 0) {
                numFriend += Math.min(x[i],y[i]);
                numF[i] = Math.min(x[i],y[i]);
            }
        }
        if(numFriend == 0) {
            answer = "-1";
        } else {
            Arrays.sort(numF);
            for(int n = numF.length-1; n >= 0; n--) {
                if(numF[n]>0) {
                    for(int j = 0; j < numF[n]; j++) {
                        answer += String.valueOf(numF[j]);
                    }
                }
            }
            
        }
        return answer;
    }
}