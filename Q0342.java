// 이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
// 별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.

// 성공

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        //행의 개수인 b만큼 돌기
        for(int row = 0; row < b; row++) {
            //열의 개수 a 만큼 돌기
            for(int col = 0; col < a; col++) {
                System.out.print('*');
            }
            //행 1줄이 끝난 뒤 줄 바꿔주기
            System.out.println();
        }
    }
}