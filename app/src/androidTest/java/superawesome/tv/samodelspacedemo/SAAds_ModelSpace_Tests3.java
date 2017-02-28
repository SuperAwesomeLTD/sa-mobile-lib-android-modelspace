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

public class SAAds_ModelSpace_Tests3 extends ActivityInstrumentationTestCase2<MainActivity> {

    private String given = "{\n" +
            "    \"advertiserId\": 1,\n" +
            "    \"publisherId\": 1,\n" +
            "    \"creative\": {\n" +
            "        \"id\": 114,\n" +
            "        \"name\": \"Banner 1\",\n" +
            "        \"cpm\": null,\n" +
            "        \"format\": \"image_with_link\",\n" +
            "        \"impressionUrl\": \"http://superawesome.tv\",\n" +
            "        \"installUrl\": null,\n" +
            "        \"clickCounterUrl\": \"http://zoso.ro\",\n"+
            "        \"clickUrl\": \"http://superawesome.tv\",\n" +
            "        \"details\": {\n" +
            "            \"url\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/cvWABPEIS7vUEtlv5U17MwaTNhRARYjB.png\",\n" +
            "            \"image\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/cvWABPEIS7vUEtlv5U17MwaTNhRARYjB.png\",\n" +
            "            \"video\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/cvWABPEIS7vUEtlv5U17MwaTNhRARYjB.png\",\n" +
            "            \"placement_format\": \"mobile_display\",\n" +
            "            \"tag\": null,\n" +
            "            \"width\": 320,\n" +
            "            \"height\": 50,\n" +
            "            \"transcodedVideos\": null,\n" +
            "            \"duration\": 0\n" +
            "        },\n" +
            "        \"approved\": 1,\n" +
            "        \"live\": true,\n" +
            "        \"osTarget\": null,\n" +
            "        \"bundleId\": null,\n" +
            "        \"impression_url\": \"http://superawesome.tv\",\n" +
            "        \"click_url\": \"http://superawesome.tv\"\n" +
            "    },\n" +
            "    \"is_fill\": false,\n" +
            "    \"is_fallback\": false,\n" +
            "    \"is_house\": false,\n" +
            "    \"safe_ad_approved\": true,\n" +
            "    \"show_padlock\": true,\n" +
            "    \"moat\": 0.2," +
            "    \"campaign_type\": 0,\n" +
            "    \"line_item_id\": 138,\n" +
            "    \"campaign_id\": 117,\n" +
            "    \"test\": false,\n" +
            "    \"app\": 105,\n" +
            "    \"device\": \"web\"\n" +
            "}\n";
    private SAAd result;

    public SAAds_ModelSpace_Tests3() {
        super("tv.superawesome.lib", MainActivity.class);

        result = new SAAd(100, 0, given);
    }

    @SmallTest
    public void test_SAAd () {

        int expected_error = 0;
        int expected_advertiserId = 1;
        int expected_publisherId = 1;
        int expected_appId = 105;
        double expected_moat = 0.2;
        int expected_lineItemId = 138;
        int expected_campaignId = 117;
        int expected_placementId = 100;
        SACampaignType expected_campaignType = SACampaignType.CPM;
        String expected_device = "web";
        boolean expected_isTest = false;
        boolean expected_isFallback = false;
        boolean expected_isFill = false;
        boolean expected_isHouse = false;
        boolean expected_isSafeAdApproved = true;
        boolean expected_isPadlockVisible= true;

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

        int expected_creative_id = 114;
        String expected_creative_name = "Banner 1";
        int expected_creative_cpm = 0;
        SACreativeFormat expected_creative_format = SACreativeFormat.image;
        boolean expected_creative_live = true;
        boolean expected_creative_approved = true;
        String expected_creative_payload = null;
        String expected_creative_clickUrl = "http://superawesome.tv";
        String expected_creative_clickCounterUrl = "http://zoso.ro";
        String expected_creative_installUrl = null;
        String expected_creative_impressionUrl = "http://superawesome.tv";
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
        int expected_referral_lineItemId = 138;
        int expected_referral_creativeId = 114;
        int expected_referral_placementId = 100;

        assertNotNull(result.creative.referral);
        assertEquals(result.creative.referral.configuration, expected_referral_configuration);
        assertEquals(result.creative.referral.campaignId, expected_referral_campaignId);
        assertEquals(result.creative.referral.lineItemId, expected_referral_lineItemId);
        assertEquals(result.creative.referral.creativeId, expected_referral_creativeId);
        assertEquals(result.creative.referral.placementId, expected_referral_placementId);
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_source%3D0"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_campaign%3D117"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_term%3D138"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_content%3D114"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_medium%3D100"));

    }

    @SmallTest
    public void test_SADetails () {

        int expected_details_width = 320;
        int expected_details_height = 50;
        String expected_details_name = null;
        String expected_details_format = "mobile_display";
        int expected_details_bitrate = 0;
        int expected_details_duration = 0;
        int expected_details_value = 0;
        String expected_details_image = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/cvWABPEIS7vUEtlv5U17MwaTNhRARYjB.png";
        String expected_details_video = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/cvWABPEIS7vUEtlv5U17MwaTNhRARYjB.png";
        String expected_details_tag = null;
        String expected_details_zip = null;
        String expected_details_url = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/cvWABPEIS7vUEtlv5U17MwaTNhRARYjB.png";
        String expected_details_cdn = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/";
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
