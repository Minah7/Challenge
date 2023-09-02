// 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 
// 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 
// 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

// 성공

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        if(n > m) {
            for(int gcd = m; gcd >= 1; gcd--) {
                if(n%gcd == 0 && m%gcd == 0) {
                    answer[0] = gcd;
                    break;
                }
            }
            for(int lcm = n; lcm < 1000000; lcm++) {
                if(lcm%n == 0 && lcm%m == 0) {
                    answer[1] = lcm;
                    break;
                }
            }
        } else if(n < m) {
            for(int gcd = n; gcd >= 1; gcd--) {
                if(n%gcd == 0 && m%gcd == 0) {
                    answer[0] = gcd;
                    break;
                }
            }
            for(int lcm = m; lcm <= 1000000; lcm++) {
                if(lcm%n == 0 && lcm%m == 0) {
                    answer[1] = lcm;
                    break;
                }
            }
        } else {
            answer[0] = n;
            answer[1] = n;
        }
        return answer;
    }
}