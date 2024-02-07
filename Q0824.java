// 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12927

// 야근 피로도는 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값입니다. 
// Demi는 N시간 동안 야근 피로도를 최소화하도록 일할 겁니다.
// Demi가 1시간 동안 작업량 1만큼을 처리할 수 있다고 할 때, 
// 퇴근까지 남은 N 시간과 각 일에 대한 작업량 works에 대해 
// 야근 피로도를 최소화한 값을 리턴하는 함수 solution을 완성해주세요.

// 실패. 풀지 못했음.

class Solution {
    public long solution(int n, int[] works) {
        int len = works.length;
		
		long answer = 0;
		Arrays.sort(works);
//		System.out.println(Arrays.toString(works));
		
		long sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < len; i++) {
			map.put(works[i], (map.getOrDefault(works[i], 0) + 1));
			sum += works[i];
		}
		
		if(sum <= n) {
//			return 0;
		} 
		
		List<Integer> keySet = new ArrayList<>(map.keySet());
		
		Collections.reverse(keySet);
		
		int cnt = 0;
		while(cnt < n) {
			int biggest = works[len - 1];
			for(int i = len - 2; i >= 0; i--) {
				if(works[i] < biggest) {
					int value = map.get(biggest);
					
				}
			}
		}
        return answer;
    }
}