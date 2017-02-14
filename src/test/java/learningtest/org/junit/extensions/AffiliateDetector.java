package learningtest.org.junit.extensions;

import java.lang.reflect.Method;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;

/**
 * {@link TestExecutionCondition} to detect {@link learningtest.org.junit.supportingcode.affiliates.models.Affiliate}.
 *
 * @author Johnny Lim
 */
public class AffiliateDetector implements TestExecutionCondition {

	@Override
	public ConditionEvaluationResult evaluate(TestExtensionContext context) {
		Method method = context.getTestMethod().get();
		if (method.getName().toLowerCase().contains("affiliate")) {
			return ConditionEvaluationResult.enabled("is an affiliate");
		}
		return ConditionEvaluationResult.disabled("is not an affiliate");
	}

}
