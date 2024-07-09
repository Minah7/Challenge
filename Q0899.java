// 문제링크: https://code-challenge.elice.io/courses/95930/lectures/738999/lecturepages/20391342/

// 사람들은 k씨의 특이한 행동 2가지 때문에 그를 '정리 정돈을 좋아하는 k씨'라고 부릅니다. 
// 그 두 가지 행동은 그가 숫자를 정리하는 일을 하면 아무 규칙없이 나열되어 있는 숫자중 범위를 정한 후 무조건 오름차순으로 정리한다는 것, 
// 그리고 오름차순으로 정리된 숫자 중 k번째 숫자를 선택한다는 것입니다
// 첫째 줄에 배열의 크기인 정수 n과 k씨가 일한 횟수인 정수 m을 입력합니다.
// 둘째 줄에는 배열에 포함된 정수를 순서대로 입력합니다. 각 정수는 절댓값이 200을 넘지 않는 정수입니다.
// 다음 줄 부터 m개 줄에 걸쳐 k씨가 고른 범위인 정수 i, j와 정수 k를 입력합니다.

// k씨가 일할 때마다 k씨가 선택한 숫자를 한 줄에 하나씩 출력합니다.

// 성공

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int tc = 1; tc <= m; tc++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] temp = new int[j - i + 1];
            for(int start = i - 1, idx = 0; start < j; start++) {
                temp[idx++] = num[start];
            }

            Arrays.sort(temp);
            System.out.println(temp[k - 1]);
        }
    }
}