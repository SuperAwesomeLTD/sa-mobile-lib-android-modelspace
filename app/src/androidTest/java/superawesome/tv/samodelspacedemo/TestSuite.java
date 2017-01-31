package superawesome.tv.samodelspacedemo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SAAds_Valid_ModelSpace_Tests.class,
        SAAds_Invalid_ModelSpace_Tests.class,
        SARefferal_ModelSpace_Tests.class,
        SAVAST_ModelSpace_Tests.class
})
public class TestSuite {
}
