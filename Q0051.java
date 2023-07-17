// 정수 n과 문자열 control이 주어집니다. 
// control은 "w", "a", "s", "d"의 4개의 문자로 이루어져 있으며, 
//control의 앞에서부터 순서대로 문자에 따라 n의 값을 바꿉니다.

class Solution {
    public int solution(int n, String control) {
        for(int i = 0; i < control.length(); i++) {
            switch(control.charAt(i)) {
            case 'w':
                n += 1;
                break;
            case 's':
                n -= 1;
                break;
            case 'd':
                n += 10;
                break;
            case 'a':
                n -= 10;
                break;
            }
        }
    return n;
    }
}

//성공