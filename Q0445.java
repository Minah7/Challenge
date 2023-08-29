// 어떤 국가에서는 자국 내 방송국에서 스파이가 활동하는 사실을 알아냈다. 
// 스파이는 영상물에 암호 코드를 삽입하여 송출하고 있었다. 
// 스파이의 암호 코드에 다음과 같은 규칙이 있음을 발견했다.
// 1. 암호코드는 8개의 숫자로 이루어져 있다.
// 2. 올바른 암호코드는 (홀수 자리의 합 x 3) + (짝수 자리의 합)이 10의 배수가 되어야 한다.
//     ex) 암호코드가 88012346일 경우,
//     ( ( 8 + 0 + 2 + 4 ) x 3 ) + ( 8 + 1 + 3 + 6) = 60은 10의 배수이므로 올바른 암호코드다.
//     ex) 암호코드가 19960409일 경우,
//     ( ( 1 + 9 + 0 + 0 ) x 3 ) + ( 9 + 6 + 4 + 9) = 58은 10의 배수가 아니므로 잘못된 암호코드다.

// 이 암호코드들을 빠르고 정확하게 인식할 수 있는 스캐너를 개발하려고 한다.
// 스캐너는 암호코드 1개가 포함된 직사각형 배열을 읽는다.
// 직사각형 배열은 1, 0으로만 이루어져 있고, 암호코드 이외의 부분은 전부 0으로 주어진다.
// 암호코드에서 숫자 하나는 7개의 비트로 암호화되어 주어진다. 따라서 암호코드의 가로 길이는 56이다. 
// 암호코드의 각 숫자가 암호화되는 규칙은 다음과 같다.
// 비정상적인 암호코드(가로 길이가 56이 아닌 경우, 아래 규칙대로 해독할 수 없는 경우)는 주어지지 않는다.

// 성공

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    // 암호를 해독할 코드를 얻기 위한 메소드
    public static char[] getCode(char[][] code, int N, int M) {
		char[] selectedCode = new char[56]; // 코드길이(56)만큼 배열 만들기
        // 입력받은 배열 반복문으로 돌리며 찾아내기
		loop: for (int row = 0; row < N; row++) {
			for (int col = M - 1; col >= 0; col--) {
                // 모든 암호 숫자의 끝자리는 1이므로 이를 이용해서 코드 찾기
				if (code[row][col] == '1') {
                    // 1을 찾으면 앞으로 이동하며 56개 숫자 담기
					for (int idx = 0; idx < 56; idx++) {
						selectedCode[56 - idx - 1] = code[row][col - idx];
					}
                    // 찾으면 아예 나가기
					break loop;
				}
			}
		}
		return selectedCode;
	}
    // 해독할 코드를 숫자로 바꾸기 위한 메소드
	public static String getNumber(char[] selectedCode) {
        // 문제에서 주어진 숫자의 인덱스에 맞춰 값 넣어주기.
		String[] codeNum = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
				"0110111", "0001011" };
        // 숫자로 변경된 값을 넣을 변수
		String num = "";
		for (int i = 0; i < 56; i += 7) {
			String n = "";
            // 7개씩 끊어서 값 담기
			for (int j = i; j < i + 7; j++) {
				n += selectedCode[j];
			}
            // n과 동일한 값을 찾고. 찾으면 그 값의 인덱스 넣어주기
			for (int idx = 0; idx < 10; idx++) {
				if (codeNum[idx].equals(n)) {
					num += String.valueOf(idx);
				}
			}
		}
		return num;
	}
    // 올바른 암호코드인지 확인하기 위한 메소드
	public static int getAnswer(String num) {
		int odd = 0; //홀수자리 합
		int even = 0; //짝수자리 합
		int sum = 0; //모든자리 합. 올바른 코드이면 출력할 답을 위한 변수
		for (int i = 0; i < num.length(); i++) {
            //홀수자리 숫자
			if (i % 2 == 0) {
				odd += Character.getNumericValue(num.charAt(i));
            //짝수자리 숫자
			} else {
				even += Character.getNumericValue(num.charAt(i));
			}
            //모든 자리 숫자
			sum += Character.getNumericValue(num.charAt(i));
		}
        //(홀수 자리의 합 x 3) + (짝수 자리의 합)이 10의 배수인지 확인
		if ((odd * 3 + even) % 10 == 0) {
			return sum;
		} else {
			return 0;
		}

	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			char[][] code = new char[N][M];
			for (int row = 0; row < N; row++) {
				code[row] = sc.next().toCharArray();
			}

			char[] selectedCode = getCode(code, N, M);
			String num = getNumber(selectedCode);
			int answer = getAnswer(num);
			System.out.println("#" + testcase + " " + answer);
		}
		sc.close();
	}
}