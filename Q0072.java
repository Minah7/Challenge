import java.util.Scanner;

public class Season1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <=3; i++) {
			System.out.print("월 입력>>");
			int a = sc.nextInt();
			if (a >= 3 && a <= 5) {
				System.out.println(a + "월은 봄입니다.");
			} else if (a >= 6 && a <= 8) {
				System.out.println(a + "월은 여름입니다.");
			} else if (a >= 9 && a <= 11) {
				System.out.println(a + "월은 여름입니다.");
			} else {
				System.out.println(a + "월은 겨울입니다.");
			}
		}
	}
}