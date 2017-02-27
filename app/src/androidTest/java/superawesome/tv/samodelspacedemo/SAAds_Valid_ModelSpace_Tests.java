package superawesome.tv.samodelspacedemo;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import java.util.ArrayList;
import java.util.List;

import tv.superawesome.lib.samodelspace.saad.SAAd;
import tv.superawesome.lib.samodelspace.saad.SACampaignType;
import tv.superawesome.lib.samodelspace.saad.SACreativeFormat;
import tv.superawesome.lib.samodelspace.vastad.SAVASTAdType;
import tv.superawesome.lib.samodelspace.vastad.SAVASTEvent;
import tv.superawesome.lib.samodelspace.vastad.SAVASTMedia;

public class SAAds_Valid_ModelSpace_Tests extends ApplicationTestCase<Application> {
    public SAAds_Valid_ModelSpace_Tests() {
        super(Application.class);
    }

    @SmallTest
    public void testValidModelSpace1 () {
        String given = "{\n" +
                "    \"creative\": {\n" +
                "        \"id\": 4906,\n" +
                "        \"format\": \"video\",\n" +
                "        \"details\": {\n" +
                "            \"url\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/Jnit8s0LdkbOKbx6q6qn4A4jqMid2T4I.mp4\",\n" +
                "            \"image\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/Jnit8s0LdkbOKbx6q6qn4A4jqMid2T4I.mp4\",\n" +
                "            \"video\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/Jnit8s0LdkbOKbx6q6qn4A4jqMid2T4I.mp4\",\n" +
                "            \"placement_format\": \"video\",\n" +
                "            \"tag\": null,\n" +
                "            \"width\": 600,\n" +
                "            \"height\": 480,\n" +
                "            \"transcodedVideos\": null,\n" +
                "            \"duration\": 32,\n" +
                "            \"vast\": \"https://ads.staging.superawesome.tv/v2/video/vast/480/931/4906/?sdkVersion=unknown&rnd=434251983&device=web\"\n" +
                "        },\n" +
                "        \"click_url\": \"https://superawesome.tv\"\n" +
                "    },\n" +
                "    \"advertiserId\": 1,\n" +
                "    \"publisherId\": 1,\n" +
                "    \"is_fill\": false,\n" +
                "    \"is_fallback\": false,\n" +
                "    \"campaign_type\": 0,\n" +
                "    \"is_house\": false,\n" +
                "    \"moat\": 0.2," +
                "    \"safe_ad_approved\": true,\n" +
                "    \"show_padlock\": true,\n" +
                "    \"line_item_id\": 931,\n" +
                "    \"test\": false,\n" +
                "    \"app\": 1484,\n" +
                "    \"device\": \"web\"\n" +
                "}\n";

        // when
        int expected_error = 0;
        int expected_advertiserId = 1;
        int expected_publisherId = 1;
        int expected_appId = 1484;
        int expected_lineItemId = 931;
        int expected_campaignId = 0;
        int expected_placementId = 100;
        double expected_moat = 0.2;
        SACampaignType expected_campaignType = SACampaignType.CPM;
        boolean expected_isTest = false;
        boolean expected_isFallback = false;
        boolean expected_isFill = false;
        boolean expected_isHouse = false;
        boolean expected_isSafeAdApproved = true;
        boolean expected_isPadlockVisible = true;
        String expected_device = "web";

        int expected_creative_id = 4906;
        String expected_creative_name = null;
        int expected_creative_cpm = 0;
        SACreativeFormat expected_creative_format = SACreativeFormat.video;
        boolean expected_creative_live = true;
        boolean expected_creative_approved = true;
        String expected_creative_payload = null;
        String expected_creative_clickUrl = "https://superawesome.tv";
        String expected_creative_clickCounterUrl = null;
        String expected_creative_installUrl = null;
        String expected_creative_impressionUrl = null;
        String expected_creative_bundle = null;

        int expected_referral_configuration = 0;
        int expected_referral_campaignId = 0;
        int expected_referral_lineItemId = 931;
        int expected_referral_creativeId = 4906;
        int expected_referral_placementId = 100;

        int expected_details_width = 600;
        int expected_details_height = 480;
        String expected_details_name = null;
        String expected_details_format = "video";
        int expected_details_bitrate = 0;
        int expected_details_duration = 32;
        int expected_details_value = 0;
        String expected_details_image = "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/Jnit8s0LdkbOKbx6q6qn4A4jqMid2T4I.mp4";
        String expected_details_video = "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/Jnit8s0LdkbOKbx6q6qn4A4jqMid2T4I.mp4";
        String expected_details_tag = null;
        String expected_details_zip = null;
        String expected_details_url = "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/Jnit8s0LdkbOKbx6q6qn4A4jqMid2T4I.mp4";
        String expected_details_cdn = "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/";
        String expected_details_vast = "https://ads.staging.superawesome.tv/v2/video/vast/480/931/4906/?sdkVersion=unknown&rnd=434251983&device=web";

        String expected_media_html = null;
        String expected_media_path = null;
        String expected_media_url = null;
        String expected_media_type = null;
        boolean expected_media_isDownloaded = false;

        String expected_vastad_redirect = null;
        String expected_vastad_url = null;
        SAVASTAdType expected_vastad_type = SAVASTAdType.Invalid;
        List<SAVASTMedia> expected_vastad_media = new ArrayList<>();
        List<SAVASTEvent> expected_vastad_events = new ArrayList<>();

        // then
        SAAd result = new SAAd(100, 0, given);

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

        assertNotNull(result.creative.referral);
        assertEquals(result.creative.referral.configuration, expected_referral_configuration);
        assertEquals(result.creative.referral.campaignId, expected_referral_campaignId);
        assertEquals(result.creative.referral.lineItemId, expected_referral_lineItemId);
        assertEquals(result.creative.referral.creativeId, expected_referral_creativeId);
        assertEquals(result.creative.referral.placementId, expected_referral_placementId);
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_source%3D0"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_campaign%3D0"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_term%3D931"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_content%3D4906"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_medium%3D100"));

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

        assertNotNull(result.creative.details.media.vastAd);
        assertEquals(result.creative.details.media.vastAd.redirect, expected_vastad_redirect);
        assertEquals(result.creative.details.media.vastAd.url, expected_vastad_url);
        assertEquals(result.creative.details.media.vastAd.type, expected_vastad_type);
        assertNotNull(result.creative.details.media.vastAd.media);
        assertNotNull(result.creative.details.media.vastAd.events);
        assertEquals(result.creative.details.media.vastAd.media.size(), expected_vastad_media.size());
        assertEquals(result.creative.details.media.vastAd.events.size(), expected_vastad_events.size());
    }

    @SmallTest
    public void testValidModelSpace2 () {
        // given
        String given = "{\n" +
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

        // when
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

        int expected_referral_configuration = 0;
        int expected_referral_campaignId = 117;
        int expected_referral_lineItemId = 138;
        int expected_referral_creativeId = 114;
        int expected_referral_placementId = 100;

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

        String expected_media_html = null;
        String expected_media_path = null;
        String expected_media_url = null;
        String expected_media_type = null;
        boolean expected_media_isDownloaded = false;

        String expected_vastad_redirect = null;
        String expected_vastad_url = null;
        SAVASTAdType expected_vastad_type = SAVASTAdType.Invalid;
        List<SAVASTMedia> expected_vastad_media = new ArrayList<>();
        List<SAVASTEvent> expected_vastad_events = new ArrayList<>();
        
        // then
        SAAd result = new SAAd(100, 0, given);

        // assert
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

        assertNotNull(result.creative.details.media.vastAd);
        assertEquals(result.creative.details.media.vastAd.redirect, expected_vastad_redirect);
        assertEquals(result.creative.details.media.vastAd.url, expected_vastad_url);
        assertEquals(result.creative.details.media.vastAd.type, expected_vastad_type);
        assertNotNull(result.creative.details.media.vastAd.media);
        assertNotNull(result.creative.details.media.vastAd.events);
        assertEquals(result.creative.details.media.vastAd.media.size(), expected_vastad_media.size());
        assertEquals(result.creative.details.media.vastAd.events.size(), expected_vastad_events.size());
    }

    @SmallTest
    public void testValidModelSpace3 () {
        String given = "{\n" +
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

        // when
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

        int expected_referral_configuration = 0;
        int expected_referral_campaignId = 117;
        int expected_referral_lineItemId = 141;
        int expected_referral_creativeId = 127;
        int expected_referral_placementId = 100;

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

        String expected_media_html = null;
        String expected_media_path = null;
        String expected_media_url = null;
        String expected_media_type = null;
        boolean expected_media_isDownloaded = false;

        String expected_vastad_redirect = null;
        String expected_vastad_url = null;
        SAVASTAdType expected_vastad_type = SAVASTAdType.Invalid;
        List<SAVASTMedia> expected_vastad_media = new ArrayList<>();
        List<SAVASTEvent> expected_vastad_events = new ArrayList<>();

        // then
        SAAd result = new SAAd(100, 0, given);

        // assert
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

        assertNotNull(result.creative.details.media.vastAd);
        assertEquals(result.creative.details.media.vastAd.redirect, expected_vastad_redirect);
        assertEquals(result.creative.details.media.vastAd.url, expected_vastad_url);
        assertEquals(result.creative.details.media.vastAd.type, expected_vastad_type);
        assertNotNull(result.creative.details.media.vastAd.media);
        assertNotNull(result.creative.details.media.vastAd.events);
        assertEquals(result.creative.details.media.vastAd.media.size(), expected_vastad_media.size());
        assertEquals(result.creative.details.media.vastAd.events.size(), expected_vastad_events.size());
    }

    @SmallTest
    public void testValidModelSpace4 () {
        String given = "{\n" +
                "    \"advertiserId\": 1,\n" +
                "    \"publisherId\": 1,\n" +
                "    \"creative\": {\n" +
                "        \"id\": 116,\n" +
                "        \"name\": \"Interstitial 2\",\n" +
                "        \"cpm\": null,\n" +
                "        \"format\": \"rich_media\",\n" +
                "        \"impressionUrl\": \"http://superawesome.tv\",\n" +
                "        \"clickCounterUrl\": \"http://zoso.ro\", \n" +
                "        \"installUrl\": null,\n" +
                "        \"clickUrl\": \"http://superawesome.tv\",\n" +
                "        \"details\": {\n" +
                "            \"url\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/rich-media/tNmFLJ7kGQWBbyORkIqTJ4oqykaGPU9w/rich-media/index.html\",\n" +
                "            \"image\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/rich-media/tNmFLJ7kGQWBbyORkIqTJ4oqykaGPU9w/rich-media/index.html\",\n" +
                "            \"video\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/rich-media/tNmFLJ7kGQWBbyORkIqTJ4oqykaGPU9w/rich-media/index.html\",\n" +
                "            \"placement_format\": \"mobile_display\",\n" +
                "            \"tag\": null,\n" +
                "            \"width\": 320,\n" +
                "            \"height\": 480,\n" +
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
                "    \"moat\": 0.75," +
                "    \"campaign_type\": 0,\n" +
                "    \"line_item_id\": 140,\n" +
                "    \"campaign_id\": 117,\n" +
                "    \"test\": false,\n" +
                "    \"app\": 105,\n" +
                "    \"device\": \"web\"\n" +
                "}\n";

        // when
        int expected_error = 0;
        int expected_advertiserId = 1;
        int expected_publisherId = 1;
        int expected_appId= 105;
        int expected_lineItemId = 140;
        int expected_campaignId = 117;
        double expected_moat = 0.75;
        int expected_placementId = 100;
        SACampaignType expected_campaignType = SACampaignType.CPM;
        String expected_device = "web";
        boolean expected_isTest = false;
        boolean expected_isFallback = false;
        boolean expected_isFill = false;
        boolean expected_isHouse = false;
        boolean expected_isSafeAdApproved = true;
        boolean expected_isPadlockVisible = true;

        int expected_creative_id = 116;
        String expected_creative_name = "Interstitial 2";
        int expected_creative_cpm = 0;
        SACreativeFormat expected_creative_format = SACreativeFormat.rich;
        boolean expected_creative_live = true;
        boolean expected_creative_approved = true;
        String expected_creative_payload = null;
        String expected_creative_clickUrl = "http://superawesome.tv";
        String expected_creative_clickCounterUrl = "http://zoso.ro";
        String expected_creative_installUrl = null;
        String expected_creative_impressionUrl = "http://superawesome.tv";
        String expected_creative_bundle = null;

        int expected_referral_configuration = 0;
        int expected_referral_campaignId = 117;
        int expected_referral_lineItemId = 140;
        int expected_referral_creativeId = 116;
        int expected_referral_placementId = 100;

        int expected_details_width = 320;
        int expected_details_height = 480;
        String expected_details_name = null;
        String expected_details_format = "mobile_display";
        int expected_details_bitrate = 0;
        int expected_details_duration = 0;
        int expected_details_value = 0;
        String expected_details_image = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/rich-media/tNmFLJ7kGQWBbyORkIqTJ4oqykaGPU9w/rich-media/index.html";
        String expected_details_video = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/rich-media/tNmFLJ7kGQWBbyORkIqTJ4oqykaGPU9w/rich-media/index.html";
        String expected_details_tag = null;
        String expected_details_zip = null;
        String expected_details_url = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/rich-media/tNmFLJ7kGQWBbyORkIqTJ4oqykaGPU9w/rich-media/index.html";
        String expected_details_cdn = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/rich-media/tNmFLJ7kGQWBbyORkIqTJ4oqykaGPU9w/rich-media/";
        String expected_details_vast = null;

        String expected_media_html = null;
        String expected_media_path = null;
        String expected_media_url = null;
        String expected_media_type = null;
        boolean expected_media_isDownloaded = false;

        String expected_vastad_redirect = null;
        String expected_vastad_url = null;
        SAVASTAdType expected_vastad_type = SAVASTAdType.Invalid;
        List<SAVASTMedia> expected_vastad_media = new ArrayList<>();
        List<SAVASTEvent> expected_vastad_events = new ArrayList<>();
        
        // then
        SAAd result = new SAAd(100, 0, given);

        // assert
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

        assertNotNull(result.creative.referral);
        assertEquals(result.creative.referral.configuration, expected_referral_configuration);
        assertEquals(result.creative.referral.campaignId, expected_referral_campaignId);
        assertEquals(result.creative.referral.lineItemId, expected_referral_lineItemId);
        assertEquals(result.creative.referral.creativeId, expected_referral_creativeId);
        assertEquals(result.creative.referral.placementId, expected_referral_placementId);
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_source%3D0"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_campaign%3D117"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_term%3D140"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_content%3D116"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_medium%3D100"));

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

        assertNotNull(result.creative.details.media.vastAd);
        assertEquals(result.creative.details.media.vastAd.redirect, expected_vastad_redirect);
        assertEquals(result.creative.details.media.vastAd.url, expected_vastad_url);
        assertEquals(result.creative.details.media.vastAd.type, expected_vastad_type);
        assertNotNull(result.creative.details.media.vastAd.media);
        assertNotNull(result.creative.details.media.vastAd.events);
        assertEquals(result.creative.details.media.vastAd.media.size(), expected_vastad_media.size());
        assertEquals(result.creative.details.media.vastAd.events.size(), expected_vastad_events.size());
    }

    @SmallTest
    public void testValidModelSpace5 () {
        // given
        String given = "{\n" +
                "    \"advertiserId\": 1,\n" +
                "    \"publisherId\": 1,\n" +
                "    \"creative\": {\n" +
                "        \"id\": 1051,\n" +
                "        \"name\": \"CPI Gab iOS Banner\",\n" +
                "        \"cpm\": null,\n" +
                "        \"format\": \"image_with_link\",\n" +
                "        \"impressionUrl\": null,\n" +
                "        \"installUrl\": null,\n" +
                "        \"clickCounterUrl\": \"http://zoso.ro\", \n" +
                "        \"clickUrl\": \"http://theguardian.com\",\n" +
                "        \"details\": {\n" +
                "            \"url\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/iwPc7H9hU94gNhw8bx7SBgoQy0rUy3o5.jpg\",\n" +
                "            \"image\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/iwPc7H9hU94gNhw8bx7SBgoQy0rUy3o5.jpg\",\n" +
                "            \"video\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/iwPc7H9hU94gNhw8bx7SBgoQy0rUy3o5.jpg\",\n" +
                "            \"placement_format\": \"mobile_display\",\n" +
                "            \"tag\": null,\n" +
                "            \"width\": 320,\n" +
                "            \"height\": 50,\n" +
                "            \"transcodedVideos\": null,\n" +
                "            \"duration\": 0\n" +
                "        },\n" +
                "        \"approved\": 1,\n" +
                "        \"live\": true,\n" +
                "        \"osTarget\": 1,\n" +
                "        \"bundleId\": \"tv.superawesome.KWSDemo\",\n" +
                "        \"impression_url\": null,\n" +
                "        \"click_url\": \"http://theguardian.com\"\n" +
                "    },\n" +
                "    \"is_fill\": false,\n" +
                "    \"is_fallback\": false,\n" +
                "    \"is_house\": false,\n" +
                "    \"safe_ad_approved\": true,\n" +
                "    \"moat\": 1," +
                "    \"show_padlock\": true,\n" +
                "    \"campaign_type\": 1,\n" +
                "    \"line_item_id\": 673,\n" +
                "    \"campaign_id\": 556,\n" +
                "    \"test\": false,\n" +
                "    \"app\": 541,\n" +
                "    \"device\": \"phone\"\n" +
                "}\n";

        // when
        int expected_error = 0;
        int expected_advertiserId = 1;
        int expected_publisherId = 1;
        int expected_appId = 541;
        int expected_lineItemId = 673;
        int expected_campaignId = 556;
        int expected_placementId = 100;
        double expected_moat = 1;
        SACampaignType expected_campaignType = SACampaignType.CPI;
        String expected_device = "phone";
        boolean expected_isTest = false;
        boolean expected_isFallback = false;
        boolean expected_isFill = false;
        boolean expected_isHouse = false;
        boolean expected_isSafeAdApproved = true;
        boolean expected_isPadlockVisible = true;

        int expected_creative_id = 1051;
        String expected_creative_name = "CPI Gab iOS Banner";
        int expected_creative_cpm = 0;
        SACreativeFormat expected_creative_format = SACreativeFormat.image;
        boolean expected_creative_live = true;
        boolean expected_creative_approved = true;
        String expected_creative_payload = null;
        String expected_creative_clickUrl = "http://theguardian.com";
        String expected_creative_clickCounterUrl = "http://zoso.ro";
        String expected_creative_installUrl = null;
        String expected_creative_impressionUrl = null;
        String expected_creative_bundle = "tv.superawesome.KWSDemo";

        int expected_referral_configuration = 0;
        int expected_referral_campaignId = 556;
        int expected_referral_lineItemId = 673;
        int expected_referral_creativeId = 1051;
        int expected_referral_placementId = 100;

        int expected_details_width = 320;
        int expected_details_height = 50;
        String expected_details_name = null;
        String expected_details_format = "mobile_display";
        int expected_details_bitrate = 0;
        int expected_details_duration = 0;
        int expected_details_value = 0;
        String expected_details_image = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/iwPc7H9hU94gNhw8bx7SBgoQy0rUy3o5.jpg";
        String expected_details_video = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/iwPc7H9hU94gNhw8bx7SBgoQy0rUy3o5.jpg";
        String expected_details_tag = null;
        String expected_details_zip = null;
        String expected_details_url = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/iwPc7H9hU94gNhw8bx7SBgoQy0rUy3o5.jpg";
        String expected_details_cdn = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/";
        String expected_details_vast = null;

        String expected_media_html = null;
        String expected_media_path = null;
        String expected_media_url = null;
        String expected_media_type = null;
        boolean expected_media_isDownloaded = false;

        String expected_vastad_redirect = null;
        String expected_vastad_url = null;
        SAVASTAdType expected_vastad_type = SAVASTAdType.Invalid;
        List<SAVASTMedia> expected_vastad_media = new ArrayList<>();
        List<SAVASTEvent> expected_vastad_events = new ArrayList<>();

        // then
        SAAd result = new SAAd(100, 0, given);

        // assert
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

        assertNotNull(result.creative.referral);
        assertEquals(result.creative.referral.configuration, expected_referral_configuration);
        assertEquals(result.creative.referral.campaignId, expected_referral_campaignId);
        assertEquals(result.creative.referral.lineItemId, expected_referral_lineItemId);
        assertEquals(result.creative.referral.creativeId, expected_referral_creativeId);
        assertEquals(result.creative.referral.placementId, expected_referral_placementId);
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_source%3D0"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_campaign%3D556"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_term%3D673"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_content%3D1051"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_medium%3D100"));

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

        assertNotNull(result.creative.details.media.vastAd);
        assertEquals(result.creative.details.media.vastAd.redirect, expected_vastad_redirect);
        assertEquals(result.creative.details.media.vastAd.url, expected_vastad_url);
        assertEquals(result.creative.details.media.vastAd.type, expected_vastad_type);
        assertNotNull(result.creative.details.media.vastAd.media);
        assertNotNull(result.creative.details.media.vastAd.events);
        assertEquals(result.creative.details.media.vastAd.media.size(), expected_vastad_media.size());
        assertEquals(result.creative.details.media.vastAd.events.size(), expected_vastad_events.size());
    }

    @SmallTest
    public void testValidModelSpace6 () {
        // given
        String given = "{\n" +
                "    \"is_house\": false,\n" +
                "    \"show_padlock\": true,\n" +
                "    \"vastType\": 0,\n" +
                "    \"creative\": {\n" +
                "        \"id\": 4907,\n" +
                "        \"creativeFormat\": 1,\n" +
                "        \"bundleId\": null,\n" +
                "        \"approved\": false,\n" +
                "        \"installUrl\": null,\n" +
                "        \"click_url\": \"https://superawesome.tv\",\n" +
                "        \"details\": {\n" +
                "            \"vast\": \"https://ads.staging.superawesome.tv/v2/video/vast/481/932/4907/?sdkVersion=ios_5.2.3&rnd=621706701&dauid=8798453893251470766&device=phone\",\n" +
                "            \"width\": 600,\n" +
                "            \"placement_format\": \"video\",\n" +
                "            \"url\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4\",\n" +
                "            \"bitrate\": 0,\n" +
                "            \"value\": 0,\n" +
                "            \"image\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4\",\n" +
                "            \"tag\": null,\n" +
                "            \"cdn\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/\",\n" +
                "            \"height\": 480,\n" +
                "            \"zip\": null,\n" +
                "            \"duration\": 32,\n" +
                "\t\t\t\t\t\t\"name\": null,\n" +
                "            \"video\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4\",\n" +
                "            \"media\": {\n" +
                "                \"isDownloaded\": true,\n" +
                "                \"path\": \"samov_19410.mp4\",\n" +
                "                \"url\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4\",\n" +
                "                \"html\": null,\n" +
                "                \"type\": \"video/mp4\",\n" +
                "\t\t\t\t\t\t\t\t\"vastAd\": {\n" +
                "\t\t\t\t\t\t\t\t\t\"redirect\": null,\n" +
                "\t\t\t\t\t\t\t\t\t\"type\": 1,\n" +
                "\t\t\t\t\t\t\t\t\t\"url\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4\",\n" +
                "\t\t\t\t\t\t\t\t\t\"media\": [\n" +
                "\t\t\t\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"type\": \"video/mp4\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"url\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"bitrate\": 720,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"width\": 600,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"height\": 480\n" +
                "\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t],\n" +
                "\t\t\t\t\t\t\t\t\t\"events\": [\n" +
                "\t\t\t\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"event\": \"creativeView\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"URL\": \"https://ads.staging.superawesome.tv/v2/4907/creativeView\"\n" +
                "\t\t\t\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"event\": \"start\",\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\"URL\": \"https://ads.staging.superawesome.tv/v2/4907/start\"\n" +
                "\t\t\t\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t\t\t\t\t]\n" +
                "\t\t\t\t\t\t\t\t}\n" +
                "            }\n" +
                "        },\n" +
                "        \"payload\": null,\n" +
                "        \"live\": false,\n" +
                "        \"format\": \"video\",\n" +
                "        \"impression_url\": null,\n" +
                "        \"name\": null,\n" +
                "        \"cpm\": 0\n" +
                "    },\n" +
                "    \"advertiserId\": 1,\n" +
                "    \"publisherId\": 1,\n" +
                "    \"is_fallback\": false,\n" +
                "    \"error\": 0,\n" +
                "    \"vastRedirect\": null,\n" +
                "    \"app\": 1484,\n" +
                "    \"isVAST\": false,\n" +
                "    \"placementId\": 481,\n" +
                "    \"safe_ad_approved\": true,\n" +
                "    \"campaign_id\": 0,\n" +
                "    \"test\": false,\n" +
                "    \"is_fill\": false,\n" +
                "    \"line_item_id\": 932\n" +
                "}";

        // when
        int expected_error = 0;
        int expected_advertiserId = 1;
        int expected_publisherId = 1;
        int expected_appId = 1484;
        int expected_lineItemId = 932;
        int expected_campaignId = 0;
        int expected_placementId = 481;
        double expected_moat = 0.2;
        SACampaignType expected_campaignType = SACampaignType.CPM;
        String expected_device = null;
        boolean expected_isTest = false;
        boolean expected_isFallback = false;
        boolean expected_isFill = false;
        boolean expected_isHouse = false;
        boolean expected_isSafeAdApproved = true;
        boolean expected_isPadlockVisible = true;

        int expected_creative_id = 4907;
        String expected_creative_name = null;
        int expected_creative_cpm = 0;
        SACreativeFormat expected_creative_format = SACreativeFormat.video;
        boolean expected_creative_live = false;
        boolean expected_creative_approved = false;
        String expected_creative_payload = null;
        String expected_creative_clickUrl =  "https://superawesome.tv";
        String expected_creative_installUrl = null;
        String expected_creative_impressionUrl = null;
        String expected_creative_bundle = null;

        int expected_referral_configuration = 1;
        int expected_referral_campaignId = 0;
        int expected_referral_lineItemId = 932;
        int expected_referral_creativeId = 4907;
        int expected_referral_placementId = 481;

        int expected_details_width = 600;
        int expected_details_height = 480;
        String expected_details_name = null;
        String expected_details_format =  "video";
        int expected_details_bitrate = 0;
        int expected_details_duration = 32;
        int expected_details_value = 0;
        String expected_details_image =  "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4";
        String expected_details_video =  "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4";
        String expected_details_tag = null;
        String expected_details_zip = null;
        String expected_details_url =  "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4";
        String expected_details_cdn =  "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/";
        String expected_details_vast =  "https://ads.staging.superawesome.tv/v2/video/vast/481/932/4907/?sdkVersion=ios_5.2.3&rnd=621706701&dauid=8798453893251470766&device=phone";

        String expected_media_html = null;
        String expected_media_path =  "samov_19410.mp4";
        String expected_media_url =  "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4";
        String expected_media_type =  "video/mp4";
        boolean expected_media_isDownloaded = true;

        String expected_vastad_redirect = null;
        String expected_vastad_url = "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4";
        SAVASTAdType expected_vastad_type = SAVASTAdType.InLine;
        List<SAVASTMedia> expected_vastad_media = new ArrayList<>();
        SAVASTMedia media = new SAVASTMedia();
        media.type = "video/mp4";
        media.url = "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4";
        media.bitrate = 720;
        media.width = 600;
        media.height = 480;
        expected_vastad_media.add(media);
        List<SAVASTEvent> expected_vastad_events = new ArrayList<>();
        SAVASTEvent event1 = new SAVASTEvent();
        event1.event = "creativeView";
        event1.URL = "https://ads.staging.superawesome.tv/v2/4907/creativeView";
        SAVASTEvent event2 = new SAVASTEvent();
        event2.event = "start";
        event2.URL = "https://ads.staging.superawesome.tv/v2/4907/start";
        expected_vastad_events.add(event1);
        expected_vastad_events.add(event2);

        // then
        SAAd result = new SAAd(481, 1, given);

        // assert
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

        assertNotNull(result.creative);
        assertEquals(result.creative.id, expected_creative_id);
        assertEquals(result.creative.name, expected_creative_name);
        assertEquals(result.creative.cpm, expected_creative_cpm);
        assertEquals(result.creative.format, expected_creative_format);
        assertEquals(result.creative.live, expected_creative_live);
        assertEquals(result.creative.approved, expected_creative_approved);
        assertEquals(result.creative.payload, expected_creative_payload);
        assertEquals(result.creative.clickUrl, expected_creative_clickUrl);
        assertEquals(result.creative.installUrl, expected_creative_installUrl);
        assertEquals(result.creative.impressionUrl, expected_creative_impressionUrl);
        assertEquals(result.creative.bundle, expected_creative_bundle);

        assertNotNull(result.creative.referral);
        assertEquals(result.creative.referral.configuration, expected_referral_configuration);
        assertEquals(result.creative.referral.campaignId, expected_referral_campaignId);
        assertEquals(result.creative.referral.lineItemId, expected_referral_lineItemId);
        assertEquals(result.creative.referral.creativeId, expected_referral_creativeId);
        assertEquals(result.creative.referral.placementId, expected_referral_placementId);
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_source%3D1"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_campaign%3D0"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_term%3D932"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_content%3D4907"));
        assertTrue(result.creative.referral.writeToReferralQuery().contains("utm_medium%3D481"));

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

        assertNotNull(result.creative.details.media.vastAd);
        assertEquals(result.creative.details.media.vastAd.redirect, expected_vastad_redirect);
        assertEquals(result.creative.details.media.vastAd.url, expected_vastad_url);
        assertEquals(result.creative.details.media.vastAd.type, expected_vastad_type);
        assertNotNull(result.creative.details.media.vastAd.media);
        assertNotNull(result.creative.details.media.vastAd.events);
        assertEquals(result.creative.details.media.vastAd.media.size(), expected_vastad_media.size());
        assertEquals(result.creative.details.media.vastAd.events.size(), expected_vastad_events.size());

        SAVASTMedia resMedia = result.creative.details.media.vastAd.media.get(0);
        assertNotNull(resMedia);
        assertEquals(media.url, resMedia.url);
        assertEquals(media.type, resMedia.type);
        assertEquals(media.bitrate, resMedia.bitrate);
        assertEquals(media.width, resMedia.width);
        assertEquals(media.height, resMedia.height);

        SAVASTEvent resEvent1 = result.creative.details.media.vastAd.events.get(0);
        assertEquals(event1.event, resEvent1.event);
        assertEquals(event1.URL, resEvent1.URL);
        SAVASTEvent resEvent2 = result.creative.details.media.vastAd.events.get(1);
        assertEquals(event2.event, resEvent2.event);
        assertEquals(event2.URL, resEvent2.URL);
    }
}