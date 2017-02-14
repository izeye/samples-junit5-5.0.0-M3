package learningtest.org.junit;

import learningtest.org.junit.supportingcode.SampleStudents;
import learningtest.org.junit.supportingcode.affiliates.models.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for assertions.
 *
 * @author Johnny Lim
 */
@DisplayName("Simple Assertion Tests")
public class AssertionTests {

	@Test
	@DisplayName("assertEquals test")
	void checkStudentLastName() {
		assertEquals(
				"Builder",
				SampleStudents.getFullTimeStudent().getLastName(), "not Bob");
	}

	@Test
	@DisplayName("assertTrue test")
	void checkStudentFirstName() {
		assertTrue("Bob".equals(SampleStudents.getFullTimeStudent().getFirstName()));
	}

	@Test
	@DisplayName("assertTrue test with λ")
	void checkForCourses() {
		Student student = SampleStudents.getNewFreshman();
		assertTrue(
				student.getCourses().size() == 0,
				() -> "new student has " + student.getCourses().size() + " courses.");
	}

	@Test
	@DisplayName("grouped test")
	void groupedAssertion() {
		Student student = SampleStudents.getNewFreshman();
		assertAll(
				"student",
				() -> assertEquals(0, student.getCourses().size()),
				() -> assertEquals("John", student.getFirstName()),
				() -> assertEquals("Blutarsky", student.getLastName()));
	}

}
