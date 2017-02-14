package learningtest.org.junit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import learningtest.org.junit.extensions.StudentSimpleParameterResolver;
import learningtest.org.junit.supportingcode.CourseUtils;
import learningtest.org.junit.supportingcode.affiliates.models.Course;
import learningtest.org.junit.supportingcode.affiliates.models.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Parameterized tests for loops.
 *
 * @author Johnny Lim
 */
@ExtendWith(StudentSimpleParameterResolver.class)
public class LoopingTestsParameterized {

	@Test
	@DisplayName("Student parameterized for loop")
	void courseAddLoopTest(Student student) {
		List<Course> courses = student.getCourses();
		courseAddLoopTest(courses);
	}

	@Test
	@DisplayName("Course parameterized for loop")
	void courseAddLoopTest(List<Course> courses) {
		for (Course course : courses) {
			assertTrue(
					CourseUtils.findPrerequisite(course) == null,
					"Course requires prerequisite.");
		}
	}

	@TestFactory
	@DisplayName("Testing using a TestFactory")
	Stream<DynamicTest> courseAddTestFactoryTest(Stream<Course> courseStream) {
		return courseStream.map(
				c -> DynamicTest.dynamicTest(
						"Parameterized Course: " + c.getName(),
						() -> assertTrue(
								CourseUtils.findPrerequisite(c) == null,
								"Prerequisite requires for this course.")));
	}

	@Test
	@DisplayName("Parameterized Testing using assertAll")
	void courseAddAssertAllTest(Stream<Course> courseStream) {
		assertAll(
				courseStream
						.map(c -> (Executable) () -> assertNull(CourseUtils.findPrerequisite(c)))
						.collect(Collectors.toList()).toArray(new Executable[0]));
	}

}
