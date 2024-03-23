// 복기 1
// 각 식물의 물을 주지 않아도 되는 날짜가 담긴 int[] plants
// 날짜마다 물을 주는 식물의 번호가 담긴 int[] watered
// 식물의 기분이 한번 상하면 더이상 물을 줘도 살지 못함.

int[] plants, int[] watered

int plant = plants.length;
int days = watered.length;
int[] answer = new int[days];

boolean[] mood = new boolean[plant];
boolean[][] check = new boolean[days][plant];
for(int p = 0; p < plant; p++) {
    mood[p] = true;
    for(int day = 0; day < plants[p] - 1; day++) {
        if(day < days) {
            check[day][p] = true;
        } else {
            break;
        }
    }
}

for(int day = 0; day < days; day++) {
    int p = watered[day] - 1;
    if(mood[p]) {
        for(int d = 0; d < plants[p]; d++) {
            if(day + d < days) {
                check[day + d][p] = true;
            }
        }
    }

    int count = 0;
    for(int i = 0; i < plant; i++) {
        if(check[day][i]) {
            count++;
        }
    }

    answer[day] = count;
}