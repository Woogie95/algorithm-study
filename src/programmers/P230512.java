package programmers;

import java.util.HashMap;
import java.util.Map;

public class P230512 {
    public static int solution(String[][] clothes) {

        // 1. 옷을 종류별로 구분하기
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // 2. 입지 않는 경우를 추가하여 모든 조합 계산하기
        int answer = 1;

        for (Integer it : map.values()) {
            answer *= it + 1;
        }
        // 3. 아무종류의 옷도 입지 않는 경우 제외하기
        return answer - 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}})); // 5
        System.out.println(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}})); // 3
    }
}
