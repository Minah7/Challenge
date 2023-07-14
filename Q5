// 영어 알파벳으로 이루어진 문자열 str이 주어집니다. 
// 각 알파벳을 대문자는 소문자로 소문자는 대문자로 변환해서 출력하는 코드를 작성해 보세요.

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for (int i = 0; i < a.length; i++) {
            if (Character.isUpperCase(a[i])) {
                System.out.print(a[i].toLowerCase());
            } else {
                System.out.print(a[i].toUpperCase());
            }
            
        }
    }
}

//실패. 나중에 다시 풀어보기

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String answer = "";
        
        for(int i = 0; i < a.length(); i++) {
            char b = a.charAt(i);
            if(Character.isUpperCase(b)) {
                answer = answer + Character.toLowerCase(b);
            } else {
                answer = answer + Character.toUpperCase(b);
            }
        }
        System.out.println(answer);
    }
}

//성공!! 너무 어렵당
