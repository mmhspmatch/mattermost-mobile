package demopackage;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectClasses({MyFirstJUnitJupiterTests.class, SecondClassUnderTest.class})
class TestSuiteExample {
}
