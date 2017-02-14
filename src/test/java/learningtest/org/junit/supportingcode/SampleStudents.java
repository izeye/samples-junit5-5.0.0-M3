package learningtest.org.junit.supportingcode;

import learningtest.org.junit.supportingcode.affiliates.models.Student;

/**
 * Sample students.
 *
 * @author Johnny Lim
 */
public class SampleStudents {

	public static Student getFullTimeStudent() {
		Student student = new Student();
		student.setFirstName("Bob");
		student.setLastName("Builder");
		student.setMiddleName("The");
		student.setMajor("MechEng");
		student.addCourse(BuildTestCourses.emech210());
		student.addCourse(BuildTestCourses.emech211());
		student.addCourse(BuildTestCourses.emech212());
		student.addCourse(BuildTestCourses.math220());
		student.addCourse(BuildTestCourses.stat401());
		return student;
	}

	public static Student getPartTimeStudent() {
		Student student = new Student();
		student.setFirstName("Harry");
		student.setLastName("Duncan");
		student.setMiddleName("James");
		student.setMajor("Business");
		student.addCourse(BuildTestCourses.emech210());
		student.addCourse(BuildTestCourses.emech211());
		return student;
	}

	public static Student getNewFreshman() {
		Student student = new Student();
		student.setLastName("Blutarsky");
		student.setFirstName("John");
		student.setMajor("Party Studies");
		return student;
	}

	public static Student getMaxedStudent() {
		Student student = new Student();
		student.setLastName("Cooper");
		student.setFirstName("Sheldon");
		student.setMajor("Theoretical Physics");
		student.addCourse(BuildTestCourses.engl213());
		student.addCourse(BuildTestCourses.math220());
		student.addCourse(BuildTestCourses.stat401());
		student.addCourse(BuildTestCourses.chem408());
		student.addCourse(BuildTestCourses.insc480());
		student.addCourse(BuildTestCourses.emech210());
		student.addCourse(BuildTestCourses.span200());
		student.addCourse(BuildTestCourses.music421());
		return student;
	}

}
