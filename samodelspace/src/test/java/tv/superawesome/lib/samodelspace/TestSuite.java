package tv.superawesome.lib.samodelspace;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tv.superawesome.lib.samodelspace.referral.TestSAReferral;
import tv.superawesome.lib.samodelspace.saad.TestSAAd_1;
import tv.superawesome.lib.samodelspace.saad.TestSAAd_2;
import tv.superawesome.lib.samodelspace.saad.TestSAAd_3;
import tv.superawesome.lib.samodelspace.saad.TestSAAd_4;
import tv.superawesome.lib.samodelspace.saad.TestSAAd_5;
import tv.superawesome.lib.samodelspace.saad.TestSAAd_6;
import tv.superawesome.lib.samodelspace.saad.TestSAAd_7;
import tv.superawesome.lib.samodelspace.saad.TestSAAd_8;
import tv.superawesome.lib.samodelspace.vastad.TestSAVAST_1;
import tv.superawesome.lib.samodelspace.vastad.TestSAVAST_2;

/**
 * Created by gabriel.coman on 30/04/2018.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestSAReferral.class,
        TestSAAd_1.class,
        TestSAAd_2.class,
        TestSAAd_3.class,
        TestSAAd_4.class,
        TestSAAd_5.class,
        TestSAAd_6.class,
        TestSAAd_7.class,
        TestSAAd_8.class,
        TestSAVAST_1.class,
        TestSAVAST_2.class

})
public class TestSuite {
}
