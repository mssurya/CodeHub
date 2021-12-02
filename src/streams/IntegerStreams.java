package streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntegerStreams {

	public static void main(String[] args) {
		//Integer stream with range 0 -10
		System.out.println("*******RANGE*******");
		IntStream
			.range(1, 10)
			.forEach(System.out::println);

		//Integer stream with skip
		System.out.println("*******SKIP*******");
		IntStream
			.range(1, 10)
			.skip(5)
			.forEach(x ->System.out.println(x));
		
		//Integer Stream with sum
		System.out.println("*******SUM*******");
		System.out.println(IntStream.range(1, 5).sum());
		
		//Stream.of, sorted and findFirst
		System.out.println("*******STREAM OF*******");
		Stream.of("Ava","AAAA","Aneri","Alberto")
			.sorted()
			.findFirst()
			.ifPresent(System.out::println);
		
		
		
	}

}
