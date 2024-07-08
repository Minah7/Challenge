// 문제링크: https://code-challenge.elice.io/courses/95930/lectures/738999/lecturepages/20391340/

// 내일 풀 수학 문제의 개수는 오늘 푼 문제 개수의 수와 숫자의 구성이 같으면서, 오늘 푼 문제 개수의 수보다 큰 수 중 가장 작은 수입니다.
// 오늘 푼 문제의 개수를 줬을 때 다음날 풀 문제의 개수를 출력하는 프로그램을 작성하세요.

// 성공

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int[] n = new int[10];
        for(int i = 0; i < num.length(); i++) {
            n[Character.getNumericValue(num.charAt(i))]++;
        }
        
        String answer = "";

        int change = 0;
        out: for(int check = num.length() - 2; check >= 0; check--) {
            int digit = Character.getNumericValue(num.charAt(check));
            for(int i = check + 1; i < num.length(); i++) {
                if(Character.getNumericValue(num.charAt(i)) > digit) {
                    change = check;
                    break out;
                }
            }
        }

        for(int i = 0; i < num.length(); i++) {
            int digit = Character.getNumericValue(num.charAt(i));
            if(i < change) {
                answer += String.valueOf(digit);
                n[digit]--;
            }
            if(i == change) {
                for(int d = digit + 1; d < 10; d++) {
                    if(n[d] > 0) {
                        answer += String.valueOf(d);
                        n[d]--;
                        break;
                    }
                }
            }
            if(i > change) {
                for(int d = 0; d < 10; d++) {
                    while(n[d] > 0) {
                        answer += String.valueOf(d);
                        n[d]--;
                    }
                }
                break;
            }
        }

        System.out.println(answer);
    }
}