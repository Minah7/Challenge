// 직사각형 형태의 그림 파일이 있고, 이 그림 파일은 1 × 1 크기의 정사각형 크기의 픽셀로 이루어져 있습니다. 
// 이 그림 파일을 나타낸 문자열 배열 picture과 정수 k가 매개변수로 주어질 때, 
// 이 그림 파일을 가로 세로로 k배 늘린 그림 파일을 나타내도록 문자열 배열을 return 하는 solution 함수를 작성해 주세요.

// 성공

class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length*k];
        for(int i = 0, idx = 0; i < picture.length; i++) {
            for(int repeatStr = 0; repeatStr < k; repeatStr++) {
                String a = "";
                for(int ch = 0; ch < picture[i].length(); ch++) {
                    for(int repeatChar = 0; repeatChar < k; repeatChar++) {
                        a += String.valueOf(picture[i].charAt(ch));
                    }
                }
                answer[idx++] = a;
            }
        }
        return answer;
    }
}