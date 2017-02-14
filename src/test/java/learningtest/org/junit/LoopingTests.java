package learningtest.org.junit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import learningtest.org.junit.supportingcode.BuildTestCourses;
import learningtest.org.junit.supportingcode.CourseUtils;
import learningtest.org.junit.supportingcode.SampleStudents;
import learningtest.org.junit.supportingcode.affiliates.models.Course;
import learningtest.org.junit.supportingcode.affiliates.models.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for loops.
 *
 * @author Johnny Lim
 */
public class LoopingTests {

	private Student student = SampleStudents.getMaxedStudent();

	@Test
	@DisplayName("Testing using a for loop")
	void courseAddLoopTest() {
		List<Course> courses = this.student.getCourses();
		System.out.println("Start looping prerequisite test.");
		for (Course course : courses) {
			assertTrue(CourseUtils.findPrerequisite(course) == null, "Course requires prerequisite.");
		}
		System.out.println("End looping prerequisite test.");
	}

	@TestFactory
	@DisplayName("Testing using a TestFactory")
	Stream<DynamicTest> courseAddTestFactoryTest() {
		System.out.println("Start TestFactory prerequisite test.");
		Stream<DynamicTest> factoryTests = this.student.getCourses().stream()
				.map(c -> DynamicTest.dynamicTest(
						"Course: " + c.getName(),
						() -> assertTrue(
								CourseUtils.findPrerequisite(c) == null,
								"Course requires prerequisite."))
		);
		System.out.println("Start TestFactory prerequisite test.");
		return factoryTests;
	}

	@Test
	@DisplayName("AssertAll Verbose Form")
	void courseAssertAllVerbose() {
		System.out.println("Start assertAll verbose prerequisite test.");
		assertAll(
				"course",
				() ->assertNull(CourseUtils.findPrerequisite(BuildTestCourses.engl213())),
				() ->assertNull(CourseUtils.findPrerequisite(BuildTestCourses.math220())),
				() ->assertNull(CourseUtils.findPrerequisite(BuildTestCourses.stat401())),
				() ->assertNull(CourseUtils.findPrerequisite(BuildTestCourses.chem408())),
				() ->assertNull(CourseUtils.findPrerequisite(BuildTestCourses.insc480())),
				() ->assertNull(CourseUtils.findPrerequisite(BuildTestCourses.emech210())),
				() ->assertNull(CourseUtils.findPrerequisite(BuildTestCourses.span200())),
				() ->assertNull(CourseUtils.findPrerequisite(BuildTestCourses.music421()))
		);
		System.out.println("End assertAll verbose prerequisite test.");
	}

	@Test
	@DisplayName("Testing using assertAll")
	void courseAddAssertAllTest() {
		System.out.println("Start assertAll prerequisite test.");
		assertAll(
				this.student.getCourses().stream().map(c -> new Executable() {
					@Override
					public void execute() throws Throwable {
						assertNull(CourseUtils.findPrerequisite(c));
					}
				}).collect(Collectors.toList()).toArray(new Executable[0])
		);
		System.out.println("End assertAll prerequisite test.");
	}

}
