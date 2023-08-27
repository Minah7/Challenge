한 쪽 벽면에 다음과 같이 노란색 상자들이 쌓여 있다.
높은 곳의 상자를 낮은 곳에 옮기는 방식으로 최고점과 최저점의 간격을 줄이는 작업을 평탄화라고 한다.
평탄화를 모두 수행하고 나면, 가장 높은 곳과 가장 낮은 곳의 차이가 최대 1 이내가 된다.
평탄화 작업을 위해서 상자를 옮기는 작업 횟수에 제한이 걸려있을 때, 제한된 횟수만큼 옮기는 작업을 한 후 최고점과 최저점의 차이를 반환하는 프로그램을 작성하시오.

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        for(int testcase = 1; testcase <= T; testcase++) {
            int dump = sc.nextInt();
            int[] box = new int[100];
            for(int i = 0; i < 100; i++) {
                box[i] = sc.nextInt();
            }
            int[] height = new int[101];
            for(int i = 0; i < 100; i++) {
                height[box[i]]++;
            }
            for(int i = 1; i < 101; i++) {
                height[i] += height[i-1];
            }
            int[] order = new int[100];
            for(int i = 99; i >= 0; i--) {
                order[--height[box[i]]] = box[i];
            }
            for(int i = 0; i < dump; i++) {
                for(int j = order.length-1; j >= 0; j--) {
                    if(order[j] > order[j-1]) {
                        order[j] -= 1;
                        break;
                    }
                }
                for(int j = 0; j < order.length; j++) {
                    if(order[j] < order[j+1]) {
                        order[j]++;
                        break;
                    }
                }
            }
            int answer = order[99] - order[0];
            System.out.println("#"+testcase+" "+answer);
        }
	}
}