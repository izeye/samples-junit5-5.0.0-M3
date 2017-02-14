package learningtest.org.junit;

import learningtest.org.junit.extensions.UseridParameterResolver;
import learningtest.org.junit.extensions.UseridTest;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for user ID case.
 *
 * @author Johnny Lim
 */
@ExtendWith(UseridParameterResolver.class)
public class UseridCaseTests {

	// FIXME: Doesn't work. JUnit 5 bug?
	@UseridTest
	public void testUseridsAreLowercase(String userid, boolean success) {
		String expected = userid.toLowerCase();
		assertEquals(expected.equals(userid), success);
	}

}
