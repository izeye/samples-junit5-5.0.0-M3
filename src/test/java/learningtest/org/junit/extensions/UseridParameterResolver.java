package learningtest.org.junit.extensions;

import java.lang.reflect.Method;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

/**
 * {@link ParameterResolver} for user ID.
 *
 * @author Johnny Lim
 */
public class UseridParameterResolver implements ParameterResolver {

	@Override
	public boolean supports(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		Method method = extensionContext.getTestMethod().get();
		if (method.isAnnotationPresent(UseridTest.class)) {
			Class<?> parameterClass = parameterContext.getParameter().getType();
			if (parameterClass == String.class || parameterClass == boolean.class) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object resolve(ParameterContext parameterContext, ExtensionContext extensionContext)
			throws ParameterResolutionException {
		Class<?> parameterClass = parameterContext.getParameter().getType();
		if (parameterClass == String.class) {
			return "sgs166";
		}
		if (parameterClass == boolean.class) {
			return true;
		}
		return null;
	}

}
