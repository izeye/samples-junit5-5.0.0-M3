package learningtest.org.junit;

import learningtest.org.junit.supportingcode.BuildTestCourses;
import learningtest.org.junit.supportingcode.CourseUtils;
import learningtest.org.junit.supportingcode.SampleStudents;
import learningtest.org.junit.supportingcode.affiliates.models.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for {@link Exception}.
 */
public class ExceptionTests {

	@Test
	@DisplayName("register-course-assertion-test")
	void addCourseTest() {
		Student student = SampleStudents.getNewFreshman();
		try {
			registerCoursesOverMax(student);
		}
		catch (RuntimeException ex) {
			String exceptionClassName = ex.getClass().getName();
			System.out.println(exceptionClassName);
			assertTrue(exceptionClassName.equals("java.lang.RuntimeException"));
		}

		assertTrue(
				CourseUtils.calculateStudentLoad(student) <= CourseUtils.MAX_ALLOWED,
				"Student has more than allowed credit hours.");
	}

	private void registerCoursesOverMax(Student student) {
		CourseUtils.registerForCourse(student, BuildTestCourses.engl213());
		CourseUtils.registerForCourse(student, BuildTestCourses.math220());
		CourseUtils.registerForCourse(student, BuildTestCourses.stat401());
		CourseUtils.registerForCourse(student, BuildTestCourses.chem408());
		CourseUtils.registerForCourse(student, BuildTestCourses.insc480());
		CourseUtils.registerForCourse(student, BuildTestCourses.emech210());
		CourseUtils.registerForCourse(student, BuildTestCourses.span200());
		CourseUtils.registerForCourse(student, BuildTestCourses.music421());
	}

	@Test
	@DisplayName("assertThrows-test")
	void registerCourseTest1() {
		Student student = SampleStudents.getNewFreshman();
		assertThrows(Exception.class, () -> {
			registerCoursesOverMax(student);
		});
	}

}
