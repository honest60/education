package spring.cham.test.lamda;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Lamda {
	
	public static void main(String[] args) {
		Func add = (int a, int b) -> a + b;
		Func sub = (int a, int b) -> a - b;
		Func add2 = (int a, int b) -> { return a + b; };
		
		int result = add.calc(1,2) + add2.calc(3, 4); // 10
		System.out.println("result의 값은 " + result);
		
		Arrays.asList(1,2,3).stream(); // (1)
		Arrays.asList(1,2,3).parallelStream(); // (2)
		
		System.out.println("[ forEach ]");
		Arrays.asList(1,2,3).stream()
		.forEach(System.out::println); // forEach 1,2,3
		
		System.out.println("[ map ]");
		Arrays.asList(1,2,3).stream()
		.map(i -> i*i)
		.forEach(System.out::println); // map 1,4,9
		
		System.out.println("[ limit ]");
		Arrays.asList(1,2,3).stream()
		.limit(1)
		.forEach(System.out::println); // limit 1
		
		System.out.println("[ skip ]");
		Arrays.asList(1,2,3).stream()
		.skip(1)
		.forEach(System.out::println); // skip 2,3
		
		System.out.println("[ filter ]");
		Arrays.asList(1,2,3).stream()
		.filter(i-> 2>=i)
		.forEach(System.out::println); // filter 1,2
		
		System.out.println("[ flatMap ]");
		Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4,5),Arrays.asList(6,7,8,9)).stream()
		.flatMap(i -> i.stream())
		.forEach(System.out::println); // flatMap 1,2,3,4,5,6,7,8,9
		
		System.out.println("[ reduce ]");
		int reduce = 
		Arrays.asList(1,2,3).stream()
		.reduce((a,b)-> a-b)
		.get(); // reduce -4
		System.out.println("reduce의 값은 " + reduce);
		
		System.out.println("[ collection ]");
		System.out.println("아래의 코드들은 각각의 메소드로 "
				+ "콜렉션 객체를 만들어서 반환합니다.");
		Arrays.asList(1,2,3).stream()
				.collect(Collectors.toList());
		Arrays.asList(1,2,3).stream()
				.iterator();
	}
}
