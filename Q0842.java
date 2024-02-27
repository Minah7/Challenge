// 문제링크: https://swexpertacademy.com/main/solvingProblem/solvingProblem.do

// 다음 주어진 조건에 따라 n개의 수를 처리하면 8자리의 암호를 생성할 수 있다.

// - 8개의 숫자를 입력 받는다.
// - 첫 번째 숫자를 1 감소한 뒤, 맨 뒤로 보낸다. 
// 다음 첫 번째 수는 2 감소한 뒤 맨 뒤로, 그 다음 첫 번째 수는 3을 감소하고 맨 뒤로, 
// 그 다음 수는 4, 그 다음 수는 5를 감소한다.
// 이와 같은 작업을 한 사이클이라 한다.
// - 숫자가 감소할 때 0보다 작아지는 경우 0으로 유지되며, 프로그램은 종료된다. 
// 이 때의 8자리의 숫자 값이 암호가 된다.

// 성공

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			sc.nextInt();
            Queue<Integer> que = new LinkedList<>();
            for(int i = 0; i < 8; i++) {
                que.add(sc.nextInt());
            }
            int subtract = 1;
            while(true) {
                int num = que.poll();
                num -= subtract;
                if(num > 0) {
                	que.add(num);
                } else {
					que.add(0);
                    break;
                }
                subtract++;
                if(subtract == 6) {
                    subtract = 1;
                }
            }
            String nums = "";
            for(int i = 0; i < 7; i++) {
                nums += (String.valueOf(que.poll()) + " ");
            }
            nums += String.valueOf(que.poll());
            System.out.println("#" + test_case + " " + nums);
		}
	}
}