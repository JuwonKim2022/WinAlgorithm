package ch09;

import java.util.*;

/*
 * <친구인가>
 * 반 N명, 모든 학생은 1~N까지 번호 부여, 현수에게는 각각 두 명의 학생은 친구 관계가 번호로 표현된 숫자쌍이 주어짐
 * 서로 연결점이 생기면 친구관계, 친구이면 yes, 아니면 no 판별 프로그램 만들기
 */
public class Main06 {
	static int[] unf;
	public static int Find(int v) {
		if(v==unf[v]) return v;
		else return unf[v]=Find(unf[v]);
	}
	
	public static void Union(int a, int b) {
		int fa = Find(a);
		int fb = Find(b);
		if(fa != fb) unf[fa] = fb;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		unf = new int[n+1];
		for(int i=1; i<=n; i++) unf[i]=i;
		for(int i=1; i<=m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			Union(a, b);
		}
		int a = sc.nextInt();
		int b = sc.nextInt();
		int fa = Find(a);
		int fb = Find(b);
		if(fa == fb) System.out.println("YES");
		else System.out.println("NO");
	}

}
