package learningtest.org.junit;

import java.lang.reflect.Method;

import learningtest.org.junit.extensions.AffiliateDetector;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Tests for {@link ExtendWith} and {@link Disabled}.
 *
 * @author Johnny Lim
 */
@ExtendWith(AffiliateDetector.class)
public class ExtensionDisabledTests {

	@Test
	void checkStudentAffiliate(TestInfo testInfo) {
		assumeTrue(studentDetector(testInfo));
		System.out.println("checkStudentAffiliate passes");
	}

	@Test
	void checkStudent(TestInfo testInfo) {
		assumeTrue(studentDetector((testInfo)));
		System.out.println("checkStudent disabled by AffiliateDetector extension class");
	}

	@Test
	void checkAffiliate(TestInfo testInfo) {
		assumeTrue(studentDetector(testInfo));
		System.out.println("checkAffiliate fails at assumption");
	}

	@Test
	@Disabled
	void checkStaffAffiliate(TestInfo testInfo) {
		assumeTrue(studentDetector(testInfo));
		System.out.println("checkStaffAffiliate is disabled with annotation");
	}

	private boolean studentDetector(TestInfo testInfo) {
		Method method = testInfo.getTestMethod().get();
		return method.getName().toLowerCase().contains("student");
	}

}
