package stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx1 {
	public static void main(String[] args) {
		System.out.println("[ List 예제 ]");
		System.out.println("하나의 입력값을 가지는 Consumer 인터페이스를 람다 인터페이스로 사용한다.");
		List<String> list1 = new ArrayList<String>();
	    list1.add("A");
	    list1.add("B");
	    list1.forEach((x)->System.out.println("List item ="+x));
	      
	    System.out.println("[ Map 예제 ] ");
	    System.out.println("두개의 입력값(키,값)을 가지는 BiConsumer 인터페이스를 람다 인터페이스로 사용한다.");
	    Map<String,String> map1 = new HashMap<String,String>();
	    map1.put("key1","val1");
	    map1.put("key2","val2");
	    map1.forEach((x,y)->System.out.println("Map item x="+x+" y="+y));
	      
	    System.out.println("[ Set 예제 ] ");
	    System.out.println("하나의 입력값을 가지는 Consumer인터페이스를 람다 인터페이스로 사용한다.");
	    Set<String> set1 = new HashSet<String>();
	    set1.add("set1");
	    set1.add("set2");
	    set1.forEach(x->System.out.println("Set item x="+x));
	    
	    System.out.println("컬렉션스타일과 스트림 스타일의 비교");
/*
 * 		-  A.전통적 배열요소 처리
			for (Trade trade : trades) {
			    if((trade.getQuantity() > MILLION) && 
			    if (trade.getIssuer().equals(IBM)) &&
			    if (trade.getStatus().equals(NEW))) {
			        largeTrades.add(trade);
			    }
			}
			
		-  B.Stream식 처리
			Stream<Trade> filteredTrades =  
			  trades.stream()
			    .filter(t -> t.getIssuer().equals("GOOG"))
			    .filter(t-> t.getQuantity()>100000)
			    .filter(t -> t.getStatus().equals("PEND"));
 * 
 */
	    System.out.println("[ 각 스트림 함수들의 기능 ]");
	    System.out.println("- Stream.of({param})");
	    System.out.println("배열을 스트림객체로 변경해준다.");
	    Integer[] ids = {1,2,3,4};
	    Stream<Integer> intStream = Stream.of(ids);
	    System.out.println("intStream의 값: " + intStream);
	    
	    System.out.println("- map()");
	    System.out.println("하나의 파라미터 값을 인자로 받아서 다른 임의의 형태로 리턴한다.");
	    Integer[] ids1 = {1,2,3,4};
	    Stream.of(ids1).map(x->x*10.0);
	    
	    System.out.println("- reduce()");
	    System.out.println("두개의 파라미터 값을 받아 연산후 다른 형태로 리턴한다. 여기서 앞의 값은 초기값이자 수식의 결과로 나온 리턴값을 의미한다.");
	    Integer[] ids2 = {1,2,3,4};
	    int ret = Stream.of(ids2).reduce(0, 
	      (a,b)->{
	        System.out.println("lambda a="+a+" b="+b);
	        return a+b;
	      });
	    System.out.println("result = "+ret);
	    
	    System.out.println("- collect()");
	   
	    /*
	     * 스트림객체는 기본적으로 연속적인 성격을 갖는데, 
	     * 이것은 filter, map,reduce등의 연산이후에도 여전이 최종 값이라고는 볼수 없다는 뜻이다. 
	     * filter,map,reduce는 지정된 하나의 데이터셋뿐 아니라, 계속적으로 이어지는 값들의 
	     * 연속적인 흐름 즉 stream이라고 할수 있다. 
	     * 이렇게 stream의 filter,map,reduce후의 최종적인 값을 얻으려면 
	     * collect라는 함수를 호출한다. 이러한 최종값을 얻는 형태를 terminal이라고 하는데, 
	     * collect가 불리기전의 map,filter,reduce등은 실제로 실행되지 않고, 
	     * collect혹은 foreach등의 terminal operation전까지는 수행이 지연된다. 
	     */
	    List<Double> list = 
	    		Stream.of(ids).map(x->x*10.0).collect(Collectors.toList()); 

	    ArrayList<Double> arrayList = 
	    		Stream.of(ids).map(x->x*10.0).collect(Collectors.toCollection(ArrayList::new)); 
	    
	    /*- parallel()
	     * 스트림객체는 parallel()메소드를 통해 병렬처리를 지원하는 parallel객체로 변형될수 있고, 
	     * 한번 변형이 된 병렬 스트림 객체는 멀티코어 환경에서 동작하게 된다.
	     */
	    List<Double> list2 = 
	    		Stream.of(ids).parallel().map(x->x*10.0).collect(Collectors.toList()); 
	} 
}
