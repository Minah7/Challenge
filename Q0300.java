import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        for(int T = 1; T <= 10; T++) {
            int N = sc.nextInt();
            int[] building = new int[N];
            for(int i = 0; i < N; i++) {
                building[i] = sc.nextInt();
            }

            int total = 0;
            for(int i = 2; i < N-2; i++) {
                int buildingH = 0;
                if(building[i-2] >= building[i] || building[i-1] >= building[i] || building[i+1] >= building[i] || building[i+2] >= building[i]) {
                    continue;
                }
                for(int j = i-2; j <= i+2; j++) {
                    if(j != i && buildingH < building[j]) {
                        buildingH = building[j];
                    }
                }
                total += building[i]-buildingH;
            }
            System.out.println("#"+T+" "+total);
        }
    }
}