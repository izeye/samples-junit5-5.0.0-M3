package learningtest.org.junit.supportingcode.affiliates.models;

import lombok.Data;

/**
 * Course.
 *
 * @author Johnny Lim
 */
@Data
public class Course {

	private String id;
	private String name;
	private String description;
	private int creditHours;
	private String prerequisiteCourse;

	public Course(String id, String name, String description, int creditHours) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.creditHours = creditHours;
	}

}
