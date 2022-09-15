package step04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import model.domain.Person;

public class StreamTest {

	public static void main(String[] args) {
		

		// Optional
				// empty(): 빈 Optional 객체 생성
				Optional<String> optional1 = Optional.empty();
				System.out.println(optional1);
				
				// of(value): null이 아닌 데이터 생성
				Optional<String> optional2 = Optional.of("java");
				System.out.println(optional2);
				System.out.println(optional2.get());
				
				// of(null): null 데이터를 파라미터로 전달하면 NPE 발생
//				Optional<String> optional3 = Optional.of(null); // NPE 발생
//				System.out.println(optional3);
				
				// ofNullable(): 값이 null일 수도 혹은 아닐수도 있는 경우
				Optional<String> optional4 = Optional.ofNullable("java");
				System.out.println(optional4);
				
				// null이라면 Optional 빈 객체 생성
				Optional<String> optional5 = Optional.ofNullable(null);
				System.out.println(optional5);
				
				System.out.println("-------------");
				
				// ifPresent()
				optional4.ifPresent(v -> System.out.println(v));
				optional5.ifPresent(v -> System.out.println(v));
				
				System.out.println("-------------");
				
				// orElse: 파라미터로 값을 받음
				// orElseGet: 파라미터로 함수형 인터페이스를 받음
				System.out.println(optional4.orElse("orElse 실행"));
				System.out.println(optional5.orElse("orElse 실행"));
				
				System.out.println("-------------");
				
				// orElseThrow: 파라미터로 Exception 타입
				System.out.println(optional4.orElseThrow(IllegalArgumentException::new));
//				System.out.println(optional5.orElseThrow(IllegalArgumentException::new));
				
				
				// Stream
				// step01: 스트림 생성
				ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
				System.out.println(list1);
				
				Stream<Integer> stream1 = list1.stream();
				stream1.forEach(num -> System.out.println(num));
				
				// 배열 스트림
				int[] intArray = {1, 2, 3};
				
				IntStream intStream = Arrays.stream(intArray);
				System.out.println(intStream);
				
				System.out.println("---------------");
				// step02: 중개 연산
				// Filter: 스트림 내 요소 중 조건에 맞는 것을 찾는 기능
				List<String> fruitList = Arrays.asList("apple", "banana", "melon");
				Stream<String> stream2 = fruitList.stream().filter(v -> v.contains("o"));
				stream2.forEach(v -> System.out.println(v));
				
				// Map: 스트림 내 요소들이 특정 로직 수행 후, 새로운 스트림을 반환
				List<Integer> integerList = Arrays.asList(2, 1, 3);
				Stream<Integer> stream3 = integerList.parallelStream().map(v -> v + 10);
				stream3.forEach(v -> System.out.println(v));
				
				// sorted: 정렬: 기본 정렬은 오름차순
				List<Integer> sortedList1 = integerList.stream().sorted().collect(Collectors.toList());
				System.out.println(sortedList1);
				// 내림차순
				List<Integer> sortedList2 = integerList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
				System.out.println(sortedList2);
				
				// step03: 최종 연산
				// count, min, max, sum
				// collect: toList / toMap / toSet
				List<Integer> integerList2 = Arrays.asList(2, 1, 3, 4, 5, 4, 1, 4, 5, 1, 4, 1, 3, 2);
				Set<Integer> resultSet = integerList2.parallelStream().collect(Collectors.toSet());
				System.out.println(resultSet);
				
				System.out.println(integerList2.size());
				System.out.println(integerList2.stream().count());
				
				// 실습
				System.out.println("===== 실습 =====");
				 //reduce : 누적된 값을 계산합니다.
				Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
				Optional<Integer> sum = numbers.reduce((x, y) -> x + y);
				sum.ifPresent(s -> System.out.println("sum: " + s));
				
				Stream<Integer> numbers2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
				Optional<Integer> sum2 = numbers2.reduce(Integer::sum);
				sum2.ifPresent(s -> System.out.println("sum2: " + s));
				
				// 초기값 존재 
				Stream<Integer> numbers3 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
				Integer sum3 = numbers3.reduce(10, (total, n) -> total + n);
				System.out.println("sum3: " + sum3);
				System.out.println("-초기값");
				
				// 병렬처리 : (1 + 2) + (3 + 4) + ... + (9 + 10)
				Stream<Integer> numbers4 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
				Integer sum4 = numbers4.parallel().reduce(0, (total, n) -> total + n);
				System.out.println("sum4: " + sum4);
				
				// (1 - 2) - (3 - 4) - ... - (9 - 10)
				Stream<Integer> numbers5 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
				Integer sum5 = numbers5.parallel().reduce(0, (total, n) -> total - n);
				System.out.println("sum5: " + sum5);
				
				
				// 순서가 있는 병렬처리
				Stream<Integer> numbers6 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
				Integer sum6 = numbers6.reduce(0,
				        (total, n) -> total - n,
				        (total1, total2) -> total1 + total2);
				System.out.println("sum6: " + sum6);
				
				
				// forEach
				Arrays.asList(1, 2, 3).stream().forEach(System.out::println);
				
				// map
				System.out.println();
				Arrays.asList(1, 2, 3).stream().map(i -> i*i).forEach(System.out::println);
			
				// skip
				System.out.println();
				Arrays.asList(1, 2, 3).stream().skip(2).forEach(System.out::println);
				
				// limit
				System.out.println();
				Arrays.asList(1, 2, 3).stream().limit(3).forEach(System.out::println);
				
				// filter : 1~10까지의 자연수중 홀수만 출력하기!!!
				System.out.println();
				Arrays.asList(1, 2, 3).stream().filter(i -> (i % 2) != 0).forEach(System.out::println);
			
				// sorted
				System.out.println();
				Arrays.asList(3, 1, 2).stream().sorted().forEach(System.out::println);
				Arrays.asList("A", "B", "AB", "O").stream().sorted().forEach(System.out::println);
				
				System.out.println();
				Arrays.asList(3, 1, 2).stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
			
				// distinct
				System.out.println();
				Arrays.asList(3, 1, 2, 3, 2, 4, 5).stream().distinct().forEach(System.out::println);
			
				//count, sum // min, max, average
				int[] numList = IntStream.range(0, 100).toArray();
				System.out.println(numList);
				System.out.println(numList.length);
				
				long sum22;
				sum22 = IntStream.of(1, 2, 3, 4, 5).sum();
				System.out.println(sum22);
				
				OptionalInt min;
				min = IntStream.of(1, 2, 3, 4, 5).min();
				System.out.println(min.getAsInt());
				
				// reduce
				System.out.println();
				System.out.println(Arrays.asList(1, 2, 7).stream().reduce((v1, v2) -> v1 + v2).get());
				System.out.println(Arrays.asList(1, 2, 7).stream().reduce((v1, v2) -> v1 - v2).get());
				System.out.println(Arrays.asList(1, 2, 7).stream().reduce((v1, v2) -> v1 * v2).get());
				
				
				 
				List<Person> personList = new ArrayList<Person>();
				// 문제! I이고 J인 사람들만 출력하시오!  
				Person hyeji = new Person("혜지", "entp");
				Person kyoungWook = new Person("경욱", "infp");
				Person jaeSeon = new Person("재선", "intj");
				Person minUk = new Person("민욱", "istp");
				Person bora = new Person("보라", "estp");
				Person dongHun = new Person("동훈", "infp");
				Person kwonMo = new Person("권모", "entj");
				Person kwangSeok = new Person("광석", "intp");
				Person dongHa = new Person("동하", "esfj");
				Person minHyang = new Person("민향", "isfp");
				Person jungHyun = new Person("정현", "istp");
				Person juHyun = new Person("주현", "istp");

				personList.add(hyeji);
				personList.add(kyoungWook);
				personList.add(jaeSeon);
				personList.add(minUk);
				personList.add(bora);
				personList.add(dongHun);
				personList.add(kwonMo);
				personList.add(kwangSeok);
				personList.add(dongHa);
				personList.add(minHyang);
				personList.add(jungHyun);
				personList.add(juHyun);
				

				// 순서대로 출력
				System.out.println("순서대로 출력");
				
				Stream<Person> stream99 = personList.stream();
				
				//Person :: getName 는 Person 객체가 가지고 있는 getName 매소드를 참조 해 하나씩 꺼내겠다 라는 뜻임
				stream99.sorted(Comparator.comparing(Person :: getName)).forEach(pe -> System.out.println("이름: " +  pe.getName() + " mbti:" + pe.getMbti()));
				
				
				
				// i, j 인사람 출력
				Stream<Person> stream100 = personList.stream().filter(v -> v.getMbti().contains("i") && v.getMbti().contains("j"));
				System.out.println("======================================");
				System.out.println("i, j 인 사람 출력");
				stream100.forEach(x -> System.out.println("이름: " +  x.getName() + " \nmbti: " + x.getMbti()));
				
		
		
	}

}
