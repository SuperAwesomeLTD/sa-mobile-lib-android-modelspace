package superawesome.tv.samodelspacedemo;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import tv.superawesome.lib.samodelspace.saad.SAReferral;

public class SARefferal_ModelSpace_Tests extends ApplicationTestCase<Application> {
    public SARefferal_ModelSpace_Tests() {
        super(Application.class);
    }

    @SmallTest
    public void testSARefferalData1 () {

        String json = "{\n" +
                "\t\"utm_source\": 1,\n" +
                "\t\"utm_campaign\": 33,\n" +
                "\t\"utm_term\": 22,\n" +
                "\t\"utm_content\": 2041,\n" +
                "\t\"utm_medium\": 28000\n" +
                "}";

        SAReferral referralData = new SAReferral(json);
        assertNotNull(referralData);

        int expected_configuration = 1;
        int expected_campaignId = 33;
        int expected_lineItemId = 22;
        int expected_creativeId = 2041;
        int expected_placementId = 28000;

        assertEquals(expected_configuration, referralData.configuration);
        assertEquals(expected_campaignId, referralData.campaignId);
        assertEquals(expected_lineItemId, referralData.lineItemId);
        assertEquals(expected_creativeId, referralData.creativeId);
        assertEquals(expected_placementId, referralData.placementId);
        assertTrue(referralData.writeToReferralQuery().contains("utm_source%3D" + expected_configuration));
        assertTrue(referralData.writeToReferralQuery().contains("utm_campaign%3D" + expected_campaignId));
        assertTrue(referralData.writeToReferralQuery().contains("utm_term%3D" + expected_lineItemId));
        assertTrue(referralData.writeToReferralQuery().contains("utm_content%3D" + expected_creativeId));
        assertTrue(referralData.writeToReferralQuery().contains("utm_medium%3D" + expected_placementId));

        assertTrue(referralData.isValid());

    }

    @SmallTest
    public void testSARefferalData2 () {

        String json = "{\n" +
                "\t\"utm_source\": 1,\n" +
                "\t\"utm_campaign\": 33,\n" +
                "\t\"utm_medium\": 28000\n" +
                "}";

        SAReferral referralData = new SAReferral(json);
        assertNotNull(referralData);

        int expected_configuration = 1;
        int expected_campaignId = 33;
        int expected_lineItemId = -1;
        int expected_creativeId = -1;
        int expected_placementId = 28000;

        assertEquals(expected_configuration, referralData.configuration);
        assertEquals(expected_campaignId, referralData.campaignId);
        assertEquals(expected_lineItemId, referralData.lineItemId);
        assertEquals(expected_creativeId, referralData.creativeId);
        assertEquals(expected_placementId, referralData.placementId);
        assertTrue(referralData.writeToReferralQuery().contains("utm_source%3D" + expected_configuration));
        assertTrue(referralData.writeToReferralQuery().contains("utm_campaign%3D" + expected_campaignId));
        assertTrue(referralData.writeToReferralQuery().contains("utm_term%3D" + expected_lineItemId));
        assertTrue(referralData.writeToReferralQuery().contains("utm_content%3D" + expected_creativeId));
        assertTrue(referralData.writeToReferralQuery().contains("utm_medium%3D" + expected_placementId));

        assertFalse(referralData.isValid());
    }

    @SmallTest
    public void testSARefferalData3 () {

        // source JSON
        String json = null;

        SAReferral referralData = new SAReferral(json);
        assertNotNull(referralData);

        int expected_configuration = -1;
        int expected_campaignId = -1;
        int expected_lineItemId = -1;
        int expected_creativeId = -1;
        int expected_placementId = -1;

        assertEquals(expected_configuration, referralData.configuration);
        assertEquals(expected_campaignId, referralData.campaignId);
        assertEquals(expected_lineItemId, referralData.lineItemId);
        assertEquals(expected_creativeId, referralData.creativeId);
        assertEquals(expected_placementId, referralData.placementId);
        assertTrue(referralData.writeToReferralQuery().contains("utm_source%3D" + expected_configuration));
        assertTrue(referralData.writeToReferralQuery().contains("utm_campaign%3D" + expected_campaignId));
        assertTrue(referralData.writeToReferralQuery().contains("utm_term%3D" + expected_lineItemId));
        assertTrue(referralData.writeToReferralQuery().contains("utm_content%3D" + expected_creativeId));
        assertTrue(referralData.writeToReferralQuery().contains("utm_medium%3D" + expected_placementId));

        assertFalse(referralData.isValid());

    }
}
