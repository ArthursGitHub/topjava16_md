import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NumberTest {
  public static void main(String[] args) {
    int squareOfMaxOdd = findSquareOfMaxOdd(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    System.out.println(squareOfMaxOdd);
  }

  public static int findSquareOfMaxOdd(List<Integer> numbers) {
    return numbers.stream()
            .filter(NumberTest::isOdd)    //Predicate is functional interface and
            .filter(NumberTest::isGreaterThan3)  // we are using lambdas to initialize it
            .filter(NumberTest::isLessThan11)  // rather than anonymous inner classes
            .max(Comparator.naturalOrder())
            .map(i -> i * i)
            .get();
  }

  public static boolean isOdd(int i) {
    return i % 2 != 0;
  }

  public static boolean isGreaterThan3(int i) {
    return i > 3;
  }

  public static boolean isLessThan11(int i) {
    return i < 11;
  }
}
