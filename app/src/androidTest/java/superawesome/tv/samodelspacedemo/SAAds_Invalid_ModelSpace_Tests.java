package superawesome.tv.samodelspacedemo;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import java.util.ArrayList;
import java.util.List;

import tv.superawesome.lib.samodelspace.SAAd;
import tv.superawesome.lib.samodelspace.SACampaignType;
import tv.superawesome.lib.samodelspace.SACreativeFormat;
import tv.superawesome.lib.samodelspace.SATracking;

public class SAAds_Invalid_ModelSpace_Tests extends ApplicationTestCase<Application> {
    public SAAds_Invalid_ModelSpace_Tests() {
        super(Application.class);
    }

    @SmallTest
    public void testModelDefault () {

        // when
        int expected_error = 0;
        int expected_advertiserId = 0;
        int expected_publisherId = 0;
        int expected_appId = 0;
        int expected_lineItemId = 0;
        int expected_campaignId = 0;
        int expected_placementId = 0;
        double expected_moat = 0.2;
        SACampaignType expected_campaignType = SACampaignType.CPM;
        boolean expected_isTest = false;
        boolean expected_isFallback = false;
        boolean expected_isFill = false;
        boolean expected_isHouse = false;
        boolean expected_isSafeAdApproved = false;
        boolean expected_isPadlockVisible = false;
        String expected_device = null;

        int expected_creative_id = 0;
        String expected_creative_name = null;
        int expected_creative_cpm = 0;
        SACreativeFormat expected_creative_format = SACreativeFormat.invalid;
        boolean expected_creative_live = true;
        boolean expected_creative_approved = true;
        String expected_creative_payload = null;
        String expected_creative_clickUrl = null;
        String expected_creative_clickCounterUrl = null;
        String expected_creative_installUrl = null;
        String expected_creative_impressionUrl = null;
        String expected_creative_bundle = null;
        List<SATracking> expected_creative_events = new ArrayList<>();

        int expected_referral_configuration = -1;
        int expected_referral_campaignId = -1;
        int expected_referral_lineItemId = -1;
        int expected_referral_creativeId = -1;
        int expected_referral_placementId = -1;

        int expected_details_width = 0;
        int expected_details_height = 0;
        String expected_details_name = null;
        String expected_details_format = null;
        int expected_details_bitrate = 0;
        int expected_details_duration = 0;
        int expected_details_value = 0;
        String expected_details_image = null;
        String expected_details_video = null;
        String expected_details_tag = null;
        String expected_details_zip = null;
        String expected_details_url = null;
        String expected_details_cdn = null;
        String expected_details_vast = null;

        String expected_media_html = null;
        String expected_media_path = null;
        String expected_media_url = null;
        String expected_media_type = null;
        boolean expected_media_isDownloaded = false;

        // then
        SAAd result = new SAAd();

        // assert
        assertNotNull(result);
        assertEquals(result.error, expected_error);
        assertEquals(result.advertiserId, expected_advertiserId);
        assertEquals(result.publisherId, expected_publisherId);
        assertEquals(result.moat, expected_moat, 0.01);
        assertEquals(result.appId, expected_appId);
        assertEquals(result.lineItemId, expected_lineItemId);
        assertEquals(result.campaignId, expected_campaignId);
        assertEquals(result.placementId, expected_placementId);
        assertEquals(result.campaignType, expected_campaignType);
        assertEquals(result.device, expected_device);
        assertEquals(result.isTest, expected_isTest);
        assertEquals(result.isFallback, expected_isFallback);
        assertEquals(result.isFill, expected_isFill);
        assertEquals(result.isHouse, expected_isHouse);
        assertEquals(result.isSafeAdApproved, expected_isSafeAdApproved);
        assertEquals(result.isPadlockVisible, expected_isPadlockVisible);

        assertNotNull(result.creative);
        assertEquals(result.creative.id, expected_creative_id);
        assertEquals(result.creative.name, expected_creative_name);
        assertEquals(result.creative.cpm, expected_creative_cpm);
        assertEquals(result.creative.format, expected_creative_format);
        assertEquals(result.creative.live, expected_creative_live);
        assertEquals(result.creative.approved, expected_creative_approved);
        assertEquals(result.creative.payload, expected_creative_payload);
        assertEquals(result.creative.clickUrl, expected_creative_clickUrl);
        assertEquals(result.creative.clickCounterUrl, expected_creative_clickCounterUrl);
        assertEquals(result.creative.installUrl, expected_creative_installUrl);
        assertEquals(result.creative.impressionUrl, expected_creative_impressionUrl);
        assertEquals(result.creative.bundle, expected_creative_bundle);
        assertEquals(result.creative.events, expected_creative_events);

        assertNotNull(result.creative.referral);
        assertEquals(result.creative.referral.configuration, expected_referral_configuration);
        assertEquals(result.creative.referral.campaignId, expected_referral_campaignId);
        assertEquals(result.creative.referral.lineItemId, expected_referral_lineItemId);
        assertEquals(result.creative.referral.creativeId, expected_referral_creativeId);
        assertEquals(result.creative.referral.placementId, expected_referral_placementId);
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_content%3D-1"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_medium%3D-1"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_term%3D-1"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_campaign%3D-1"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_source%3D-1"));

        assertNotNull(result.creative.details);
        assertEquals(result.creative.details.width, expected_details_width);
        assertEquals(result.creative.details.height, expected_details_height);
        assertEquals(result.creative.details.name, expected_details_name);
        assertEquals(result.creative.details.format, expected_details_format);
        assertEquals(result.creative.details.bitrate, expected_details_bitrate);
        assertEquals(result.creative.details.duration, expected_details_duration);
        assertEquals(result.creative.details.value, expected_details_value);
        assertEquals(result.creative.details.image, expected_details_image);
        assertEquals(result.creative.details.video, expected_details_video);
        assertEquals(result.creative.details.tag, expected_details_tag);
        assertEquals(result.creative.details.zip, expected_details_zip);
        assertEquals(result.creative.details.url, expected_details_url);
        assertEquals(result.creative.details.cdn, expected_details_cdn);
        assertEquals(result.creative.details.vast, expected_details_vast);

        assertNotNull(result.creative.details.media);
        assertEquals(result.creative.details.media.html, expected_media_html);
        assertEquals(result.creative.details.media.path, expected_media_path);
        assertEquals(result.creative.details.media.url, expected_media_url);
        assertEquals(result.creative.details.media.type, expected_media_type);
        assertEquals(result.creative.details.media.isDownloaded, expected_media_isDownloaded);

    }
}
