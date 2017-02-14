package learningtest.org.junit;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for {@link DynamicTest}.
 *
 * @author Johnny Lim
 */
public class DynamicTests {

	@TestFactory
	Stream<DynamicTest> testOneThroughTen() {
		return Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
				.map(i -> DynamicTest.dynamicTest("Input: " + i, () -> assertTrue(i != 4)));
	}

}
