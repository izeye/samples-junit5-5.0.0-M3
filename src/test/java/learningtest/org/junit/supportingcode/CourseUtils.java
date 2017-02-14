package learningtest.org.junit.supportingcode;

import learningtest.org.junit.supportingcode.affiliates.models.Course;
import learningtest.org.junit.supportingcode.affiliates.models.Student;

/**
 * Utilities for courses.
 *
 * @author Johnny Lim
 */
public class CourseUtils {

	public static final int MAX_ALLOWED = 25;

	public static void registerForCourse(Student student, Course course) {
		int studentCourseLoad = calculateStudentLoad(student);
		int courseCredit = course.getCreditHours();
		if (studentCourseLoad + courseCredit > MAX_ALLOWED) {
			throw new RuntimeException(
					"Can't register for course. Student would exceed allowed credits.");
		}
		student.addCourse(course);
	}

	public static int calculateStudentLoad(Student student) {
		return student.getCourses().stream()
				.mapToInt(course -> course.getCreditHours()).sum();
	}

	public static String findPrerequisite(Course course) {
		String prerequisiteCourse = course.getPrerequisiteCourse();
		System.out.println(course.getId() + " prerequisite is " + prerequisiteCourse);
		return prerequisiteCourse;
	}

}
