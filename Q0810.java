// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/154539

// 정수로 이루어진 배열 numbers가 있습니다. 
// 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
// 정수 배열 numbers가 매개변수로 주어질 때, 
// 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요. 
// 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.

//세번째 시도 성공
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            while(true) {
                if(stack.isEmpty()) {
                    stack.add(numbers[i]);
                    answer[i] = -1;
                    break;
                } else if(numbers[i] >= stack.peek()) {
                    stack.pop();
                } else if(numbers[i] < stack.peek()) {
                    answer[i] = stack.peek();
                    stack.add(numbers[i]);
                    break;
                }
            }
        }
        return answer;
    }
}

//두번째 시도 실패.
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(numbers[i]);
        }
        
        Collections.sort(list);
        
        int i = 0;
        while(i < n - 1) {
            int num = numbers[i];
            if(num < list.get(list.size()-1)) {
                for(int j = i+1; j < n; j++) {
                    if(num < numbers[j]) {
                        answer[i] = numbers[j];
                        break;
                    }
                }
            } else {
                answer[i] = -1;
            }
            list.remove(Integer.valueOf(num));
            i++;
        }
        answer[n-1] = -1;
        
        return answer;
    }
}

//첫번째 시도 실패. 82.6% 마지막 4문제 시간 초과.
class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        for(int i = 0; i < n - 1; i++) {
            for(int j = i+1; j < n; j++) {
                if(numbers[i] < numbers[j]) {
                    answer[i] = numbers[j];
                    break;
                }
                if(j == n - 1) {
                    answer[i] = -1;
                }
            }
        }
        answer[n-1] = -1; 
        return answer;
    }
}
