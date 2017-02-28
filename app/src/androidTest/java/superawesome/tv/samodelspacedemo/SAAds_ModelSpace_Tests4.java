package superawesome.tv.samodelspacedemo;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;

import java.util.ArrayList;
import java.util.List;

import tv.superawesome.lib.samodelspace.saad.SAAd;
import tv.superawesome.lib.samodelspace.saad.SACampaignType;
import tv.superawesome.lib.samodelspace.saad.SACreativeFormat;
import tv.superawesome.lib.samodelspace.vastad.SAVASTAdType;
import tv.superawesome.lib.samodelspace.vastad.SAVASTEvent;
import tv.superawesome.lib.samodelspace.vastad.SAVASTMedia;

/**
 * Created by gabriel.coman on 28/02/2017.
 */

public class SAAds_ModelSpace_Tests4 extends ActivityInstrumentationTestCase2<MainActivity> {

    private String given = "{\n" +
            "    \"advertiserId\": 1,\n" +
            "    \"publisherId\": 1,\n" +
            "    \"creative\": {\n" +
            "        \"id\": 127,\n" +
            "        \"name\": \"Interstitial 3-1\",\n" +
            "        \"cpm\": null,\n" +
            "        \"format\": \"tag\",\n" +
            "        \"impressionUrl\": null,\n" +
            "        \"clickCounterUrl\": null, \n"+
            "        \"installUrl\": null,\n" +
            "        \"details\": {\n" +
            "            \"url\": null,\n" +
            "            \"image\": null,\n" +
            "            \"video\": null,\n" +
            "            \"placement_format\": \"mobile_display\",\n" +
            "            \"tag\": \"<!-- Beginning PassBack for Ad unit FK:Site-Skyscraper-Passback ### size: [[120,600]] -->\\\\n\\\\t<script type='text/javascript' src='http://www.googletagservices.com/tag/js/gpt.js'>\\\\n\\\\t\\\\tgoogletag.pubads().definePassback('1002534/FK:Site-Skyscraper-Passback', [[120,600]]).display();\\\\n\\\\t</script>\\\\n<!-- End Passback -->\",\n" +
            "            \"width\": 320,\n" +
            "            \"height\": 480,\n" +
            "            \"transcodedVideos\": null,\n" +
            "            \"duration\": 0\n" +
            "        },\n" +
            "        \"approved\": 1,\n" +
            "        \"live\": true,\n" +
            "        \"osTarget\": null,\n" +
            "        \"bundleId\": null,\n" +
            "        \"impression_url\": null\n" +
            "    },\n" +
            "    \"is_fill\": false,\n" +
            "    \"is_fallback\": false,\n" +
            "    \"is_house\": false,\n" +
            "    \"safe_ad_approved\": true,\n" +
            "    \"moat\": 0.5," +
            "    \"show_padlock\": true,\n" +
            "    \"campaign_type\": 0,\n" +
            "    \"line_item_id\": 141,\n" +
            "    \"campaign_id\": 117,\n" +
            "    \"test\": false,\n" +
            "    \"app\": 105,\n" +
            "    \"device\": \"web\"\n" +
            "}\n";
    private SAAd result;

    public SAAds_ModelSpace_Tests4() {
        super("tv.superawesome.lib", MainActivity.class);

        result = new SAAd(100, 0, given);
    }

    @SmallTest
    public void test_SAAd () {

        int expected_error = 0;
        int expected_advertiserId = 1;
        int expected_publisherId = 1;
        int expected_appId = 105;
        int expected_lineItemId = 141;
        double expected_moat = 0.5;
        int expected_campaignId = 117;
        int expected_placementId = 100;
        SACampaignType expected_campaignType = SACampaignType.CPM;
        String expected_device = "web";
        boolean expected_isTest = false;
        boolean expected_isFallback = false;
        boolean expected_isFill = false;
        boolean expected_isHouse = false;
        boolean expected_isSafeAdApproved = true;
        boolean expected_isPadlockVisible = true;

        assertNotNull(result);
        assertEquals(result.error, expected_error);
        assertEquals(result.advertiserId, expected_advertiserId);
        assertEquals(result.publisherId, expected_publisherId);
        assertEquals(result.appId, expected_appId);
        assertEquals(result.moat, expected_moat, 0.01);
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

    }

    @SmallTest
    public void test_SACreative () {

        int expected_creative_id = 127;
        String expected_creative_name = "Interstitial 3-1";
        int expected_creative_cpm = 0;
        SACreativeFormat expected_creative_format = SACreativeFormat.tag;
        boolean expected_creative_live = true;
        boolean expected_creative_approved = true;
        String expected_creative_payload = null;
        String expected_creative_clickUrl = null;
        String expected_creative_clickCounterUrl = null;
        String expected_creative_installUrl = null;
        String expected_creative_impressionUrl = null;
        String expected_creative_bundle = null;

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

    }

    @SmallTest
    public void test_SAReferral () {

        int expected_referral_configuration = 0;
        int expected_referral_campaignId = 117;
        int expected_referral_lineItemId = 141;
        int expected_referral_creativeId = 127;
        int expected_referral_placementId = 100;

        assertNotNull(result.creative.referral);
        assertEquals(result.creative.referral.configuration, expected_referral_configuration);
        assertEquals(result.creative.referral.campaignId, expected_referral_campaignId);
        assertEquals(result.creative.referral.lineItemId, expected_referral_lineItemId);
        assertEquals(result.creative.referral.creativeId, expected_referral_creativeId);
        assertEquals(result.creative.referral.placementId, expected_referral_placementId);
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_source%3D0"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_campaign%3D117"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_term%3D141"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_content%3D127"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_medium%3D100"));

    }

    @SmallTest
    public void test_SADetails () {

        int expected_details_width = 320;
        int expected_details_height = 480;
        String expected_details_name = null;
        String expected_details_format = "mobile_display";
        int expected_details_bitrate = 0;
        int expected_details_duration = 0;
        int expected_details_value = 0;
        String expected_details_image = null;
        String expected_details_video = null;
        String expected_details_tag = "<!-- Beginning PassBack for Ad unit FK:Site-Skyscraper-Passback ### size: [[120,600]] -->\\n\\t<script type='text/javascript' src='http://www.googletagservices.com/tag/js/gpt.js'>\\n\\t\\tgoogletag.pubads().definePassback('1002534/FK:Site-Skyscraper-Passback', [[120,600]]).display();\\n\\t</script>\\n<!-- End Passback -->";
        String expected_details_zip = null;
        String expected_details_url = null;
        String expected_details_cdn = null;
        String expected_details_vast = null;

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

    }

    @SmallTest
    public void test_SAMedia () {

        String expected_media_html = null;
        String expected_media_path = null;
        String expected_media_url = null;
        String expected_media_type = null;
        boolean expected_media_isDownloaded = false;

        assertNotNull(result.creative.details.media);
        assertEquals(result.creative.details.media.html, expected_media_html);
        assertEquals(result.creative.details.media.path, expected_media_path);
        assertEquals(result.creative.details.media.url, expected_media_url);
        assertEquals(result.creative.details.media.type, expected_media_type);
        assertEquals(result.creative.details.media.isDownloaded, expected_media_isDownloaded);
    }

    @SmallTest
    public void test_SAVASTAd () {

        String expected_vastad_redirect = null;
        String expected_vastad_url = null;
        SAVASTAdType expected_vastad_type = SAVASTAdType.Invalid;
        List<SAVASTMedia> expected_vastad_media = new ArrayList<>();
        List<SAVASTEvent> expected_vastad_events = new ArrayList<>();

        assertNotNull(result.creative.details.media.vastAd);
        assertEquals(result.creative.details.media.vastAd.redirect, expected_vastad_redirect);
        assertEquals(result.creative.details.media.vastAd.url, expected_vastad_url);
        assertEquals(result.creative.details.media.vastAd.type, expected_vastad_type);
        assertNotNull(result.creative.details.media.vastAd.media);
        assertNotNull(result.creative.details.media.vastAd.events);
        assertEquals(result.creative.details.media.vastAd.media.size(), expected_vastad_media.size());
        assertEquals(result.creative.details.media.vastAd.events.size(), expected_vastad_events.size());

    }
}
