package learningtest.org.junit.supportingcode.affiliates.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Student.
 *
 * @author Johnny Lim
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Student extends Affiliate {

	private String major;
	private List<Course> courses = new ArrayList<>();

	public void addCourse(Course course) {
		this.courses.add(course);
	}

}
