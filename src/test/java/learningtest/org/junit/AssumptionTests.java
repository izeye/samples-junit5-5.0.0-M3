package learningtest.org.junit;

import learningtest.org.junit.supportingcode.affiliates.models.Affiliate;
import learningtest.org.junit.supportingcode.BuildTestCourses;
import learningtest.org.junit.supportingcode.affiliates.models.Staff;
import learningtest.org.junit.supportingcode.affiliates.models.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * Tests for assumptions.
 *
 * @author Johnny Lim
 */
public class AssumptionTests {

	@Test
	@DisplayName("assumeTrue test")
	void assumeTrueTest() {
		System.out.println("testing assumeTrue");
		Student student = new Student();
		assumeTrue(checkIsStudent(student));
		student.addCourse(BuildTestCourses.engl213());
		System.out.println("ENGL course added");
	}

	@Test
	@DisplayName("assumeFalse failing test")
	void assumeFalseTest() {
		System.out.println("testing assumeFalse skipping the test");
		Student student = new Student();
		assumeFalse(checkIsStudent(student));
		student.addCourse(BuildTestCourses.math220());
		System.out.println("MATH course added");
	}

	@Test
	@DisplayName("assumeFalse passing test")
	void assumeFalsePassingTest() {
		System.out.println("testing assumeFalse passing");
		Staff staff = new Staff();
		assumeFalse(checkIsStudent(staff));
		staff.setFirstName("NOSKIP");
		System.out.println("staff first name set to " + staff.getFirstName());
	}

	@Test
	@DisplayName("assumingThat passing test")
	void assumingThatPassingTest() {
		Affiliate person = new Student();
		assumingThat(checkIsStudent(person), () -> {
			System.out.println("The person is a student. Proceeding with assumingThat enclosed code.");
			Student student = (Student) person;
			student.addCourse(BuildTestCourses.music421());
		});
		System.out.println(
				"The remaining code in the method gets executed no matter what the result of the assumingThat check.");
	}

	@Test
	@DisplayName("assumingThat failing test")
	void assumingThatFailingTest() {
		Affiliate person = new Staff();
		assumingThat(checkIsStudent(person), () -> {
			System.out.println("assumingThat is valid.");
		});
		System.out.println(
				"The remaining code in the method gets executed no matter what the result of the assumingThat check.");
	}

	private boolean checkIsStudent(Affiliate affiliate) {
		return affiliate instanceof Student;
	}

}
