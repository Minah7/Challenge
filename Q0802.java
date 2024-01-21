// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/178870

// 비내림차순으로 정렬된 수열이 주어질 때, 다음 조건을 만족하는 부분 수열을 찾으려고 합니다.

// 기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열이어야 합니다.
// 부분 수열의 합은 k입니다.
// 합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾습니다.
// 길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.

//두번째 성공
class Solution {
    public int[] solution(int[] sequence, int k) {
        int s = sequence.length;
        int start = 0, end = 0, 
        int len = Integer.MAX_VALUE;
        int sum = 0;
        for(int left = 0, right = 0; left < s; left++) {
            while(right < s && sum < k) {
                sum += sequence[right++];
            }
            
            if(sum == k) {
                if(right - left < len) {
                    start = left;
                    end = right;
                    len = right - left;
                }
                if(right - left == 1) {
                    break;
                }
            }
            sum -= sequence[left];
        }
            
        int[] answer = {start, end-1};
        return answer;
    }
}

// 첫 시도 실패.
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int sLen = sequence.length;
        int length = 0, start = 0, end = 0; // 길이, 시작 인덱스, 마지막 인덱스 
        out: for(int i = 0; i < sLen; i++) {
            int sum = 0;
            for(int j = i; j < sLen; j++) {
                sum += sequence[j];
                if(sum == k) {
                    if(length != 0 && (j - i + 1) < length) {
                        length = j - i + 1;
                        start = i;
                        end = j;
                        if(length == 1) {
                            break out;
                        }
                    } else if(length == 0) {
                        length = j - i + 1;
                        start = i;
                        end = j;
                        if(length == 1) {
                            break out;
                        }
                    } else {
                        break;
                    }
                } else if(sum > k) {
                    break;
                } else if(j == sLen - 1) {
                    break out;
                }
            }
        }
        answer[0] = start;
        answer[1] = end;
        
        return answer;
    }
}