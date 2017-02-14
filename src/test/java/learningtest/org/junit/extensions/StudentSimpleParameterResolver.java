package learningtest.org.junit.extensions;

import java.util.List;
import java.util.stream.Stream;

import learningtest.org.junit.supportingcode.SampleStudents;
import learningtest.org.junit.supportingcode.affiliates.models.Student;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

/**
 * {@link ParameterResolver} for {@link Student}.
 *
 * @author Johnny Lim
 */
public class StudentSimpleParameterResolver implements ParameterResolver {

	@Override
	public boolean supports(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		Class<?> parameterClass = parameterContext.getParameter().getType();
		if (parameterClass == Student.class || parameterClass == List.class || parameterClass == Stream.class) {
			return true;
		}
		return false;
	}

	@Override
	public Object resolve(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		Student student = SampleStudents.getMaxedStudent();
		Class<?> parameterClass = parameterContext.getParameter().getType();
		if (parameterClass == Student.class) {
			return student;
		}
		if (parameterClass == List.class) {
			return student.getCourses();
		}
		if (parameterClass == Stream.class) {
			return student.getCourses().stream();
		}
		return null;
	}

}
