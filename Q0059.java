//이 문제에서 두 정수 배열의 대소관계를 다음과 같이 정의합니다.
//두 배열의 길이가 다르다면, 배열의 길이가 긴 쪽이 더 큽니다.
//배열의 길이가 같다면 각 배열에 있는 모든 원소의 합을 비교하여 다르다면 더 큰 쪽이 크고, 같다면 같습니다

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        int SumArr1 = 0;
        for (int i = 0; i<arr1.length; i++) {
            SumArr1 += arr1[i];
        }
        
        int SumArr2 = 0;
        for (int i = 0; i<arr2.length; i++) {
            SumArr2 += arr2[i];
        }
        
        if (arr1.length < arr2.length) {
            answer = -1;
        } else if (arr1.length > arr2.length) {
            answer = 1;
        } else if (arr1.length == arr2.length) {
            if (SumArr1 < SumArr2) {
                answer = -1;
            } else if (SumArr1 > SumArr2) {
                answer = 1;
            } else {
                answer = 0;
            }
        }
        return answer;
    }
}

//성공