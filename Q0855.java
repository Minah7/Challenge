// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/67256

// 맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.

// 1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
// 2. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
// 3. 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
// 4. 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
// 4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.

// 순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 
// 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.

// 성공

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int l = 10;
        int r = 12;
        
        for(int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            if(n == 1 || n == 4 || n == 7) {
                answer += "L";
                l = n;
            } else if(n == 3 || n == 6 || n == 9) {
                answer += "R";
                r = n;
            } else {
                if(n == 0) {
                    n = 11;
                }
                
                int disL = (Math.abs(n - l) / 3) + (Math.abs(n - l) % 3);
                int disR = (Math.abs(n - r) / 3) + (Math.abs(n - r) % 3);
                
                if(disL == disR) {
                    if(hand.equals("left")) {
                        answer += "L";
                        l = n;
                    } else {
                        answer += "R";
                        r = n;
                    }
                    continue;
                }
                
                int min = Math.min(disL, disR);
                if(min == disL) {
                    answer += "L";
                    l = n;
                } else {
                    answer += "R";
                    r = n;
                }
            }
        }
        return answer;
    }
}