package learningtest.org.junit;

import learningtest.org.junit.extensions.Small;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Tests for {@link Tag}.
 *
 * @author Johnny Lim
 */
public class TaggingTests {

	@Test
	@Tag("small")
	@DisplayName("Test that assertEquals() is true when applicable")
	void testAssertEquals() {
		assertEquals(2, 2);
	}

	@Test
	@Small
	void testAssertNotEquals() {
		assertNotEquals(2, 3);
	}

}
