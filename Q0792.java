// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/178870

// 다음 조건을 만족하는 부분 수열을 찾으려고 합니다.

// 기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열이어야 합니다.
// 부분 수열의 합은 k입니다.
// 합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾습니다.
// 길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.
// 위 조건을 만족하는 부분 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 return

// 실패

// 1번째 실패 57점?
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        for(int i = 0; i < sequence.length; i++) {
            int count = sequence[i];
            if(count == k) {
                answer[0] = i;
                answer[1] = i;
                break;
            }
            for(int j = i+1; j < sequence.length; j++) {
                count += sequence[j];
                if(count == k) {
                    if(answer[1] == 0) {
                        answer[0] = i;
                        answer[1] = j;
                    } else {
                        int length = answer[1] - answer[0] + 1;
                        if(length > (j - i + 1)) {
                            answer[0] = i;
                            answer[1] = j;
                        }
                    }
                }
                if(count > k) {
                    break;
                }
            }
        }
        return answer;
    }
}

// 2번째 실패 
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        for(int i = 0; i < sequence.length; i++) {           
            check(sequence, answer, k, i);
        } // 1개부터 확인.
        return answer;
    }
    public void check(int[] sequence, int[] answer, int k, int i) {
        for(int j = 0; j < sequence.length - i; j++) {
            int count = sequence[j];
            boolean flag = true;
            for(int c = j+1; c <= j+i; c++) {
                count += sequence[c];
                if(count > k) {
                    flag = false;
                    break;
                }
            }
            if(flag && count == k) {
                answer[0] = j;
                answer[1] = j+i;
                return;
            }
        }
    }
}