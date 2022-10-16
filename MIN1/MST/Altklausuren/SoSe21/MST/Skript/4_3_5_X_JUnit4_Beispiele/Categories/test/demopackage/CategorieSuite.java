package demopackage;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Categories.class)
@SuiteClasses({CalculatorTest.class})
@IncludeCategory(MySpecialTests.class)
public class CategorieSuite {

}
