import java.util.ArrayList;
public class App {
	public static void main(String[] args) {
		int m = 729, n = 369;
		System.out.println(Euclid1(m, n));	
		System.out.println(Euclid2(m, n));	
		System.out.println(Euclid3(m, n));	
		System.out.println(Euclid4(m, n));	
	}
	
	public static int Euclid1(int m, int n) {
		if(n == 0) {
			return m;
		}else {
			return Euclid1(n, m % n);
		}		
	}
	
	public static int Euclid2(int m, int n) {
		while(n != 0) {
			int r = m % n;
			m = n;
			n = r;
		}
		return m;
	}
	
	public static int Euclid3(int m, int n) {
		// 1. int t = Math.min(m, n);
		// 2. int t;
		// if(m > n) t = n;
		// else t = m;
		int t = m > n? n: m;
		while(true) {
			if(m % t == 0 && n % t == 0) {
				return t;
			}
			t--;
		}
	}
	
	public static int Euclid4(int m, int n) {
		ArrayList <Integer> list1 = factorize(m);
		ArrayList <Integer> list2 = factorize(n);
		int i = 0, j = 0, gcd = 1;
		while(i < list1.size() && j < list2.size()) {
			if(list1.get(i) == list2.get(j)) {
				gcd *= list1.get(i);
				i++; j++;
			}else if(list1.get(i) > list2.get(j)) {
				j++;
			}else{
				i++;
			}
		}
		return gcd;
	}
	
	public static ArrayList <Integer> factorize(int n) {
		ArrayList <Integer> list = new ArrayList <>();
		if(n < 1)	return null;
		for(int i = 2; i < Math.sqrt(n); i++) {
			while(n % i == 0 && isPrime(i)) {
				list.add(i);
				n /= i;
			}
		}
		if(n > 1) list.add(n);	
		return list;
	}
	
	public static boolean isPrime(int n) {
		if(n <= 1) {
			return false;
		}
		for(int i = 2; i < Math.sqrt(n); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}	
}
