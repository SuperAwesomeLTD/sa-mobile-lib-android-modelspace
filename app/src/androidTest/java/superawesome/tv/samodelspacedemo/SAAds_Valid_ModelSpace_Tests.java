package superawesome.tv.samodelspacedemo;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tv.superawesome.lib.sajsonparser.SAJsonParser;
import tv.superawesome.lib.samodelspace.SAAd;
import tv.superawesome.lib.samodelspace.SACampaignType;
import tv.superawesome.lib.samodelspace.SACreativeFormat;
import tv.superawesome.lib.samodelspace.SATracking;
import tv.superawesome.lib.samodelspace.SAVASTAdType;

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
        int expected_app = 1484;
        int expected_lineItemId = 931;
        int expected_campaignId = 0;
        int expected_placementId = 0;
        double expected_moat = 0.2;
        SACampaignType expected_campaignType = SACampaignType.CPM;
        boolean expected_test = false;
        boolean expected_isFallback = false;
        boolean expected_isFill = false;
        boolean expected_isHouse = false;
        boolean expected_safeAdApproved = true;
        boolean expected_showPadlock = true;
        String expected_device = "web";

        int expected_creative_id = 4906;
        String expected_creative_name = null;
        int expected_creative_cpm = 0;
        SACreativeFormat expected_creative_format = SACreativeFormat.video;
        boolean expected_creative_live = true;
        boolean expected_creative_approved = true;
        String expected_creative_customPayload = null;
        String expected_creative_clickUrl = "https://superawesome.tv";
        String expected_creative_clickCounterUrl = null;
        String expected_creative_installUrl = null;
        String expected_creative_impressionUrl = null;
        String expected_creative_bundleId = null;
        List<SATracking> expected_creative_events = new ArrayList<>();

        int expected_referral_configuration = -1;
        int expected_referral_campaignId = -1;
        int expected_referral_lineItemId = -1;
        int expected_referral_creativeId = -1;
        int expected_referral_placementId = -1;

        int expected_details_width = 600;
        int expected_details_height = 480;
        String expected_details_name = null;
        String expected_details_placementFormat = "video";
        int expected_details_bitrate = 0;
        int expected_details_duration = 32;
        int expected_details_value = 0;
        String expected_details_image = "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/Jnit8s0LdkbOKbx6q6qn4A4jqMid2T4I.mp4";
        String expected_details_video = "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/Jnit8s0LdkbOKbx6q6qn4A4jqMid2T4I.mp4";
        String expected_details_tag = null;
        String expected_details_zipFile = null;
        String expected_details_url = "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/Jnit8s0LdkbOKbx6q6qn4A4jqMid2T4I.mp4";
        String expected_details_cdnUrl = "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/";
        String expected_details_vast = "https://ads.staging.superawesome.tv/v2/video/vast/480/931/4906/?sdkVersion=unknown&rnd=434251983&device=web";

        String expected_media_html = null;
        String expected_media_playableDiskUrl = null;
        String expected_media_playableMediaUrl = null;
        String expected_media_type = null;
        boolean expected_media_isOnDisk = false;

        // then
        SAAd result = new SAAd(given);

        // assert
        assertNotNull(result);
        assertEquals(result.error, expected_error);
        assertEquals(result.advertiserId, expected_advertiserId);
        assertEquals(result.publisherId, expected_publisherId);
        assertEquals(result.moat, expected_moat, 0.01);
        assertEquals(result.app, expected_app);
        assertEquals(result.lineItemId, expected_lineItemId);
        assertEquals(result.campaignId, expected_campaignId);
        assertEquals(result.placementId, expected_placementId);
        assertEquals(result.campaignType, expected_campaignType);
        assertEquals(result.device, expected_device);
        assertEquals(result.test, expected_test);
        assertEquals(result.isFallback, expected_isFallback);
        assertEquals(result.isFill, expected_isFill);
        assertEquals(result.isHouse, expected_isHouse);
        assertEquals(result.safeAdApproved, expected_safeAdApproved);
        assertEquals(result.showPadlock, expected_showPadlock);

        assertNotNull(result.creative);
        assertEquals(result.creative.id, expected_creative_id);
        assertEquals(result.creative.name, expected_creative_name);
        assertEquals(result.creative.cpm, expected_creative_cpm);
        assertEquals(result.creative.format, expected_creative_format);
        assertEquals(result.creative.live, expected_creative_live);
        assertEquals(result.creative.approved, expected_creative_approved);
        assertEquals(result.creative.customPayload, expected_creative_customPayload);
        assertEquals(result.creative.clickUrl, expected_creative_clickUrl);
        assertEquals(result.creative.clickCounterUrl, expected_creative_clickCounterUrl);
        assertEquals(result.creative.installUrl, expected_creative_installUrl);
        assertEquals(result.creative.impressionUrl, expected_creative_impressionUrl);
        assertEquals(result.creative.bundleId, expected_creative_bundleId);
        assertEquals(result.creative.events, expected_creative_events);

        assertNotNull(result.creative.referralData);
        assertEquals(result.creative.referralData.configuration, expected_referral_configuration);
        assertEquals(result.creative.referralData.campaignId, expected_referral_campaignId);
        assertEquals(result.creative.referralData.lineItemId, expected_referral_lineItemId);
        assertEquals(result.creative.referralData.creativeId, expected_referral_creativeId);
        assertEquals(result.creative.referralData.placementId, expected_referral_placementId);
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_content%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_medium%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_term%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_campaign%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_source%3D-1"));

        assertNotNull(result.creative.details);
        assertEquals(result.creative.details.width, expected_details_width);
        assertEquals(result.creative.details.height, expected_details_height);
        assertEquals(result.creative.details.name, expected_details_name);
        assertEquals(result.creative.details.placementFormat, expected_details_placementFormat);
        assertEquals(result.creative.details.bitrate, expected_details_bitrate);
        assertEquals(result.creative.details.duration, expected_details_duration);
        assertEquals(result.creative.details.value, expected_details_value);
        assertEquals(result.creative.details.image, expected_details_image);
        assertEquals(result.creative.details.video, expected_details_video);
        assertEquals(result.creative.details.tag, expected_details_tag);
        assertEquals(result.creative.details.zipFile, expected_details_zipFile);
        assertEquals(result.creative.details.url, expected_details_url);
        assertEquals(result.creative.details.cdnUrl, expected_details_cdnUrl);
        assertEquals(result.creative.details.vast, expected_details_vast);

        assertNotNull(result.creative.details.media);
        assertEquals(result.creative.details.media.html, expected_media_html);
        assertEquals(result.creative.details.media.playableDiskUrl, expected_media_playableDiskUrl);
        assertEquals(result.creative.details.media.playableMediaUrl, expected_media_playableMediaUrl);
        assertEquals(result.creative.details.media.type, expected_media_type);
        assertEquals(result.creative.details.media.isOnDisk, expected_media_isOnDisk);
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
        int expected_app = 105;
        double expected_moat = 0.2;
        int expected_lineItemId = 138;
        int expected_campaignId = 117;
        int expected_placementId = 0;
        SACampaignType expected_campaignType = SACampaignType.CPM;
        String expected_device = "web";
        boolean expected_test = false;
        boolean expected_isFallback = false;
        boolean expected_isFill = false;
        boolean expected_isHouse = false;
        boolean expected_safeAdApproved = true;
        boolean expected_showPadlock = true;

        int expected_creative_id = 114;
        String expected_creative_name = "Banner 1";
        int expected_creative_cpm = 0;
        SACreativeFormat expected_creative_format = SACreativeFormat.image;
        boolean expected_creative_live = true;
        boolean expected_creative_approved = true;
        String expected_creative_customPayload = null;
        String expected_creative_clickUrl = "http://superawesome.tv";
        String expected_creative_clickCounterUrl = "http://zoso.ro";
        String expected_creative_installUrl = null;
        String expected_creative_impressionUrl = "http://superawesome.tv";
        String expected_creative_bundleId = null;
        List<SATracking> expected_creative_events = new ArrayList<>();

        int expected_referral_configuration = -1;
        int expected_referral_campaignId = -1;
        int expected_referral_lineItemId = -1;
        int expected_referral_creativeId = -1;
        int expected_referral_placementId = -1;

        int expected_details_width = 320;
        int expected_details_height = 50;
        String expected_details_name = null;
        String expected_details_placementFormat = "mobile_display";
        int expected_details_bitrate = 0;
        int expected_details_duration = 0;
        int expected_details_value = 0;
        String expected_details_image = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/cvWABPEIS7vUEtlv5U17MwaTNhRARYjB.png";
        String expected_details_video = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/cvWABPEIS7vUEtlv5U17MwaTNhRARYjB.png";
        String expected_details_tag = null;
        String expected_details_zipFile = null;
        String expected_details_url = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/cvWABPEIS7vUEtlv5U17MwaTNhRARYjB.png";
        String expected_details_cdnUrl = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/";
        String expected_details_vast = null;

        String expected_media_html = null;
        String expected_media_playableDiskUrl = null;
        String expected_media_playableMediaUrl = null;
        String expected_media_type = null;
        boolean expected_media_isOnDisk = false;
        
        // then
        SAAd result = new SAAd(given);

        // assert
        assertNotNull(result);
        assertEquals(result.error, expected_error);
        assertEquals(result.advertiserId, expected_advertiserId);
        assertEquals(result.publisherId, expected_publisherId);
        assertEquals(result.app, expected_app);
        assertEquals(result.moat, expected_moat, 0.01);
        assertEquals(result.lineItemId, expected_lineItemId);
        assertEquals(result.campaignId, expected_campaignId);
        assertEquals(result.placementId, expected_placementId);
        assertEquals(result.campaignType, expected_campaignType);
        assertEquals(result.device, expected_device);
        assertEquals(result.test, expected_test);
        assertEquals(result.isFallback, expected_isFallback);
        assertEquals(result.isFill, expected_isFill);
        assertEquals(result.isHouse, expected_isHouse);
        assertEquals(result.safeAdApproved, expected_safeAdApproved);
        assertEquals(result.showPadlock, expected_showPadlock);

        assertNotNull(result.creative);
        assertEquals(result.creative.id, expected_creative_id);
        assertEquals(result.creative.name, expected_creative_name);
        assertEquals(result.creative.cpm, expected_creative_cpm);
        assertEquals(result.creative.format, expected_creative_format);
        assertEquals(result.creative.live, expected_creative_live);
        assertEquals(result.creative.approved, expected_creative_approved);
        assertEquals(result.creative.customPayload, expected_creative_customPayload);
        assertEquals(result.creative.clickUrl, expected_creative_clickUrl);
        assertEquals(result.creative.clickCounterUrl, expected_creative_clickCounterUrl);
        assertEquals(result.creative.installUrl, expected_creative_installUrl);
        assertEquals(result.creative.impressionUrl, expected_creative_impressionUrl);
        assertEquals(result.creative.bundleId, expected_creative_bundleId);
        assertEquals(result.creative.events, expected_creative_events);

        assertNotNull(result.creative.referralData);
        assertEquals(result.creative.referralData.configuration, expected_referral_configuration);
        assertEquals(result.creative.referralData.campaignId, expected_referral_campaignId);
        assertEquals(result.creative.referralData.lineItemId, expected_referral_lineItemId);
        assertEquals(result.creative.referralData.creativeId, expected_referral_creativeId);
        assertEquals(result.creative.referralData.placementId, expected_referral_placementId);
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_content%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_medium%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_term%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_campaign%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_source%3D-1"));

        assertNotNull(result.creative.details);
        assertEquals(result.creative.details.width, expected_details_width);
        assertEquals(result.creative.details.height, expected_details_height);
        assertEquals(result.creative.details.name, expected_details_name);
        assertEquals(result.creative.details.placementFormat, expected_details_placementFormat);
        assertEquals(result.creative.details.bitrate, expected_details_bitrate);
        assertEquals(result.creative.details.duration, expected_details_duration);
        assertEquals(result.creative.details.value, expected_details_value);
        assertEquals(result.creative.details.image, expected_details_image);
        assertEquals(result.creative.details.video, expected_details_video);
        assertEquals(result.creative.details.tag, expected_details_tag);
        assertEquals(result.creative.details.zipFile, expected_details_zipFile);
        assertEquals(result.creative.details.url, expected_details_url);
        assertEquals(result.creative.details.cdnUrl, expected_details_cdnUrl);
        assertEquals(result.creative.details.vast, expected_details_vast);

        assertNotNull(result.creative.details.media);
        assertEquals(result.creative.details.media.html, expected_media_html);
        assertEquals(result.creative.details.media.playableDiskUrl, expected_media_playableDiskUrl);
        assertEquals(result.creative.details.media.playableMediaUrl, expected_media_playableMediaUrl);
        assertEquals(result.creative.details.media.type, expected_media_type);
        assertEquals(result.creative.details.media.isOnDisk, expected_media_isOnDisk);
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
        int expected_app = 105;
        int expected_lineItemId = 141;
        double expected_moat = 0.5;
        int expected_campaignId = 117;
        int expected_placementId = 0;
        SACampaignType expected_campaignType = SACampaignType.CPM;
        String expected_device = "web";
        boolean expected_test = false;
        boolean expected_isFallback = false;
        boolean expected_isFill = false;
        boolean expected_isHouse = false;
        boolean expected_safeAdApproved = true;
        boolean expected_showPadlock = true;

        int expected_creative_id = 127;
        String expected_creative_name = "Interstitial 3-1";
        int expected_creative_cpm = 0;
        SACreativeFormat expected_creative_format = SACreativeFormat.tag;
        boolean expected_creative_live = true;
        boolean expected_creative_approved = true;
        String expected_creative_customPayload = null;
        String expected_creative_clickUrl = null;
        String expected_creative_clickCounterUrl = null;
        String expected_creative_installUrl = null;
        String expected_creative_impressionUrl = null;
        String expected_creative_bundleId = null;
        List<SATracking> expected_creative_events = new ArrayList<>();

        int expected_referral_configuration = -1;
        int expected_referral_campaignId = -1;
        int expected_referral_lineItemId = -1;
        int expected_referral_creativeId = -1;
        int expected_referral_placementId = -1;

        int expected_details_width = 320;
        int expected_details_height = 480;
        String expected_details_name = null;
        String expected_details_placementFormat = "mobile_display";
        int expected_details_bitrate = 0;
        int expected_details_duration = 0;
        int expected_details_value = 0;
        String expected_details_image = null;
        String expected_details_video = null;
        String expected_details_tag = "<!-- Beginning PassBack for Ad unit FK:Site-Skyscraper-Passback ### size: [[120,600]] -->\\n\\t<script type='text/javascript' src='http://www.googletagservices.com/tag/js/gpt.js'>\\n\\t\\tgoogletag.pubads().definePassback('1002534/FK:Site-Skyscraper-Passback', [[120,600]]).display();\\n\\t</script>\\n<!-- End Passback -->";
        String expected_details_zipFile = null;
        String expected_details_url = null;
        String expected_details_cdnUrl = null;
        String expected_details_vast = null;

        String expected_media_html = null;
        String expected_media_playableDiskUrl = null;
        String expected_media_playableMediaUrl = null;
        String expected_media_type = null;
        boolean expected_media_isOnDisk = false;

        // then
        SAAd result = new SAAd(given);

        // assert
        assertNotNull(result);
        assertEquals(result.error, expected_error);
        assertEquals(result.advertiserId, expected_advertiserId);
        assertEquals(result.publisherId, expected_publisherId);
        assertEquals(result.app, expected_app);
        assertEquals(result.moat, expected_moat, 0.01);
        assertEquals(result.lineItemId, expected_lineItemId);
        assertEquals(result.campaignId, expected_campaignId);
        assertEquals(result.placementId, expected_placementId);
        assertEquals(result.campaignType, expected_campaignType);
        assertEquals(result.device, expected_device);
        assertEquals(result.test, expected_test);
        assertEquals(result.isFallback, expected_isFallback);
        assertEquals(result.isFill, expected_isFill);
        assertEquals(result.isHouse, expected_isHouse);
        assertEquals(result.safeAdApproved, expected_safeAdApproved);
        assertEquals(result.showPadlock, expected_showPadlock);

        assertNotNull(result.creative);
        assertEquals(result.creative.id, expected_creative_id);
        assertEquals(result.creative.name, expected_creative_name);
        assertEquals(result.creative.cpm, expected_creative_cpm);
        assertEquals(result.creative.format, expected_creative_format);
        assertEquals(result.creative.live, expected_creative_live);
        assertEquals(result.creative.approved, expected_creative_approved);
        assertEquals(result.creative.customPayload, expected_creative_customPayload);
        assertEquals(result.creative.clickUrl, expected_creative_clickUrl);
        assertEquals(result.creative.clickCounterUrl, expected_creative_clickCounterUrl);
        assertEquals(result.creative.installUrl, expected_creative_installUrl);
        assertEquals(result.creative.impressionUrl, expected_creative_impressionUrl);
        assertEquals(result.creative.bundleId, expected_creative_bundleId);
        assertEquals(result.creative.events, expected_creative_events);

        assertNotNull(result.creative.referralData);
        assertEquals(result.creative.referralData.configuration, expected_referral_configuration);
        assertEquals(result.creative.referralData.campaignId, expected_referral_campaignId);
        assertEquals(result.creative.referralData.lineItemId, expected_referral_lineItemId);
        assertEquals(result.creative.referralData.creativeId, expected_referral_creativeId);
        assertEquals(result.creative.referralData.placementId, expected_referral_placementId);
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_content%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_medium%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_term%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_campaign%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_source%3D-1"));

        assertNotNull(result.creative.details);
        assertEquals(result.creative.details.width, expected_details_width);
        assertEquals(result.creative.details.height, expected_details_height);
        assertEquals(result.creative.details.name, expected_details_name);
        assertEquals(result.creative.details.placementFormat, expected_details_placementFormat);
        assertEquals(result.creative.details.bitrate, expected_details_bitrate);
        assertEquals(result.creative.details.duration, expected_details_duration);
        assertEquals(result.creative.details.value, expected_details_value);
        assertEquals(result.creative.details.image, expected_details_image);
        assertEquals(result.creative.details.video, expected_details_video);
        assertEquals(result.creative.details.tag, expected_details_tag);
        assertEquals(result.creative.details.zipFile, expected_details_zipFile);
        assertEquals(result.creative.details.url, expected_details_url);
        assertEquals(result.creative.details.cdnUrl, expected_details_cdnUrl);
        assertEquals(result.creative.details.vast, expected_details_vast);

        assertNotNull(result.creative.details.media);
        assertEquals(result.creative.details.media.html, expected_media_html);
        assertEquals(result.creative.details.media.playableDiskUrl, expected_media_playableDiskUrl);
        assertEquals(result.creative.details.media.playableMediaUrl, expected_media_playableMediaUrl);
        assertEquals(result.creative.details.media.type, expected_media_type);
        assertEquals(result.creative.details.media.isOnDisk, expected_media_isOnDisk);
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
        int expected_app = 105;
        int expected_lineItemId = 140;
        int expected_campaignId = 117;
        double expected_moat = 0.75;
        int expected_placementId = 0;
        SACampaignType expected_campaignType = SACampaignType.CPM;
        String expected_device = "web";
        boolean expected_test = false;
        boolean expected_isFallback = false;
        boolean expected_isFill = false;
        boolean expected_isHouse = false;
        boolean expected_safeAdApproved = true;
        boolean expected_showPadlock = true;

        int expected_creative_id = 116;
        String expected_creative_name = "Interstitial 2";
        int expected_creative_cpm = 0;
        SACreativeFormat expected_creative_format = SACreativeFormat.rich;
        boolean expected_creative_live = true;
        boolean expected_creative_approved = true;
        String expected_creative_customPayload = null;
        String expected_creative_clickUrl = "http://superawesome.tv";
        String expected_creative_clickCounterUrl = "http://zoso.ro";
        String expected_creative_installUrl = null;
        String expected_creative_impressionUrl = "http://superawesome.tv";
        String expected_creative_bundleId = null;
        List<SATracking> expected_creative_events = new ArrayList<>();

        int expected_referral_configuration = -1;
        int expected_referral_campaignId = -1;
        int expected_referral_lineItemId = -1;
        int expected_referral_creativeId = -1;
        int expected_referral_placementId = -1;

        int expected_details_width = 320;
        int expected_details_height = 480;
        String expected_details_name = null;
        String expected_details_placementFormat = "mobile_display";
        int expected_details_bitrate = 0;
        int expected_details_duration = 0;
        int expected_details_value = 0;
        String expected_details_image = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/rich-media/tNmFLJ7kGQWBbyORkIqTJ4oqykaGPU9w/rich-media/index.html";
        String expected_details_video = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/rich-media/tNmFLJ7kGQWBbyORkIqTJ4oqykaGPU9w/rich-media/index.html";
        String expected_details_tag = null;
        String expected_details_zipFile = null;
        String expected_details_url = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/rich-media/tNmFLJ7kGQWBbyORkIqTJ4oqykaGPU9w/rich-media/index.html";
        String expected_details_cdnUrl = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/rich-media/tNmFLJ7kGQWBbyORkIqTJ4oqykaGPU9w/rich-media/";
        String expected_details_vast = null;

        String expected_media_html = null;
        String expected_media_playableDiskUrl = null;
        String expected_media_playableMediaUrl = null;
        String expected_media_type = null;
        boolean expected_media_isOnDisk = false;
        
        // then
        SAAd result = new SAAd(given);

        // assert
        assertNotNull(result);
        assertEquals(result.error, expected_error);
        assertEquals(result.advertiserId, expected_advertiserId);
        assertEquals(result.publisherId, expected_publisherId);
        assertEquals(result.app, expected_app);
        assertEquals(result.moat, expected_moat, 0.01);
        assertEquals(result.lineItemId, expected_lineItemId);
        assertEquals(result.campaignId, expected_campaignId);
        assertEquals(result.placementId, expected_placementId);
        assertEquals(result.campaignType, expected_campaignType);
        assertEquals(result.device, expected_device);
        assertEquals(result.test, expected_test);
        assertEquals(result.isFallback, expected_isFallback);
        assertEquals(result.isFill, expected_isFill);
        assertEquals(result.isHouse, expected_isHouse);
        assertEquals(result.safeAdApproved, expected_safeAdApproved);
        assertEquals(result.showPadlock, expected_showPadlock);

        assertNotNull(result.creative);
        assertEquals(result.creative.id, expected_creative_id);
        assertEquals(result.creative.name, expected_creative_name);
        assertEquals(result.creative.cpm, expected_creative_cpm);
        assertEquals(result.creative.format, expected_creative_format);
        assertEquals(result.creative.live, expected_creative_live);
        assertEquals(result.creative.approved, expected_creative_approved);
        assertEquals(result.creative.customPayload, expected_creative_customPayload);
        assertEquals(result.creative.clickUrl, expected_creative_clickUrl);
        assertEquals(result.creative.clickCounterUrl, expected_creative_clickCounterUrl);
        assertEquals(result.creative.installUrl, expected_creative_installUrl);
        assertEquals(result.creative.impressionUrl, expected_creative_impressionUrl);
        assertEquals(result.creative.bundleId, expected_creative_bundleId);
        assertEquals(result.creative.events, expected_creative_events);

        assertNotNull(result.creative.referralData);
        assertEquals(result.creative.referralData.configuration, expected_referral_configuration);
        assertEquals(result.creative.referralData.campaignId, expected_referral_campaignId);
        assertEquals(result.creative.referralData.lineItemId, expected_referral_lineItemId);
        assertEquals(result.creative.referralData.creativeId, expected_referral_creativeId);
        assertEquals(result.creative.referralData.placementId, expected_referral_placementId);
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_content%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_medium%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_term%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_campaign%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_source%3D-1"));

        assertNotNull(result.creative.details);
        assertEquals(result.creative.details.width, expected_details_width);
        assertEquals(result.creative.details.height, expected_details_height);
        assertEquals(result.creative.details.name, expected_details_name);
        assertEquals(result.creative.details.placementFormat, expected_details_placementFormat);
        assertEquals(result.creative.details.bitrate, expected_details_bitrate);
        assertEquals(result.creative.details.duration, expected_details_duration);
        assertEquals(result.creative.details.value, expected_details_value);
        assertEquals(result.creative.details.image, expected_details_image);
        assertEquals(result.creative.details.video, expected_details_video);
        assertEquals(result.creative.details.tag, expected_details_tag);
        assertEquals(result.creative.details.zipFile, expected_details_zipFile);
        assertEquals(result.creative.details.url, expected_details_url);
        assertEquals(result.creative.details.cdnUrl, expected_details_cdnUrl);
        assertEquals(result.creative.details.vast, expected_details_vast);

        assertNotNull(result.creative.details.media);
        assertEquals(result.creative.details.media.html, expected_media_html);
        assertEquals(result.creative.details.media.playableDiskUrl, expected_media_playableDiskUrl);
        assertEquals(result.creative.details.media.playableMediaUrl, expected_media_playableMediaUrl);
        assertEquals(result.creative.details.media.type, expected_media_type);
        assertEquals(result.creative.details.media.isOnDisk, expected_media_isOnDisk);
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
        int expected_app = 541;
        int expected_lineItemId = 673;
        int expected_campaignId = 556;
        int expected_placementId = 0;
        double expected_moat = 1;
        SACampaignType expected_campaignType = SACampaignType.CPI;
        String expected_device = "phone";
        boolean expected_test = false;
        boolean expected_isFallback = false;
        boolean expected_isFill = false;
        boolean expected_isHouse = false;
        boolean expected_safeAdApproved = true;
        boolean expected_showPadlock = true;

        int expected_creative_id = 1051;
        String expected_creative_name = "CPI Gab iOS Banner";
        int expected_creative_cpm = 0;
        SACreativeFormat expected_creative_format = SACreativeFormat.image;
        boolean expected_creative_live = true;
        boolean expected_creative_approved = true;
        String expected_creative_customPayload = null;
        String expected_creative_clickUrl = "http://theguardian.com";
        String expected_creative_clickCounterUrl = "http://zoso.ro";
        String expected_creative_installUrl = null;
        String expected_creative_impressionUrl = null;
        String expected_creative_bundleId = "tv.superawesome.KWSDemo";
        List<SATracking> expected_creative_events = new ArrayList<>();

        int expected_referral_configuration = -1;
        int expected_referral_campaignId = -1;
        int expected_referral_lineItemId = -1;
        int expected_referral_creativeId = -1;
        int expected_referral_placementId = -1;

        int expected_details_width = 320;
        int expected_details_height = 50;
        String expected_details_name = null;
        String expected_details_placementFormat = "mobile_display";
        int expected_details_bitrate = 0;
        int expected_details_duration = 0;
        int expected_details_value = 0;
        String expected_details_image = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/iwPc7H9hU94gNhw8bx7SBgoQy0rUy3o5.jpg";
        String expected_details_video = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/iwPc7H9hU94gNhw8bx7SBgoQy0rUy3o5.jpg";
        String expected_details_tag = null;
        String expected_details_zipFile = null;
        String expected_details_url = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/iwPc7H9hU94gNhw8bx7SBgoQy0rUy3o5.jpg";
        String expected_details_cdnUrl = "https://s3-eu-west-1.amazonaws.com/sb-ads-uploads/images/";
        String expected_details_vast = null;

        String expected_media_html = null;
        String expected_media_playableDiskUrl = null;
        String expected_media_playableMediaUrl = null;
        String expected_media_type = null;
        boolean expected_media_isOnDisk = false;

        
        // then
        SAAd result = new SAAd(given);

        // assert
        assertNotNull(result);
        assertEquals(result.error, expected_error);
        assertEquals(result.advertiserId, expected_advertiserId);
        assertEquals(result.publisherId, expected_publisherId);
        assertEquals(result.app, expected_app);
        assertEquals(result.moat, expected_moat, 0.01);
        assertEquals(result.lineItemId, expected_lineItemId);
        assertEquals(result.campaignId, expected_campaignId);
        assertEquals(result.placementId, expected_placementId);
        assertEquals(result.campaignType, expected_campaignType);
        assertEquals(result.device, expected_device);
        assertEquals(result.test, expected_test);
        assertEquals(result.isFallback, expected_isFallback);
        assertEquals(result.isFill, expected_isFill);
        assertEquals(result.isHouse, expected_isHouse);
        assertEquals(result.safeAdApproved, expected_safeAdApproved);
        assertEquals(result.showPadlock, expected_showPadlock);

        assertNotNull(result.creative);
        assertEquals(result.creative.id, expected_creative_id);
        assertEquals(result.creative.name, expected_creative_name);
        assertEquals(result.creative.cpm, expected_creative_cpm);
        assertEquals(result.creative.format, expected_creative_format);
        assertEquals(result.creative.live, expected_creative_live);
        assertEquals(result.creative.approved, expected_creative_approved);
        assertEquals(result.creative.customPayload, expected_creative_customPayload);
        assertEquals(result.creative.clickUrl, expected_creative_clickUrl);
        assertEquals(result.creative.clickCounterUrl, expected_creative_clickCounterUrl);
        assertEquals(result.creative.installUrl, expected_creative_installUrl);
        assertEquals(result.creative.impressionUrl, expected_creative_impressionUrl);
        assertEquals(result.creative.bundleId, expected_creative_bundleId);
        assertEquals(result.creative.events, expected_creative_events);

        assertNotNull(result.creative.referralData);
        assertEquals(result.creative.referralData.configuration, expected_referral_configuration);
        assertEquals(result.creative.referralData.campaignId, expected_referral_campaignId);
        assertEquals(result.creative.referralData.lineItemId, expected_referral_lineItemId);
        assertEquals(result.creative.referralData.creativeId, expected_referral_creativeId);
        assertEquals(result.creative.referralData.placementId, expected_referral_placementId);
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_content%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_medium%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_term%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_campaign%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_source%3D-1"));

        assertNotNull(result.creative.details);
        assertEquals(result.creative.details.width, expected_details_width);
        assertEquals(result.creative.details.height, expected_details_height);
        assertEquals(result.creative.details.name, expected_details_name);
        assertEquals(result.creative.details.placementFormat, expected_details_placementFormat);
        assertEquals(result.creative.details.bitrate, expected_details_bitrate);
        assertEquals(result.creative.details.duration, expected_details_duration);
        assertEquals(result.creative.details.value, expected_details_value);
        assertEquals(result.creative.details.image, expected_details_image);
        assertEquals(result.creative.details.video, expected_details_video);
        assertEquals(result.creative.details.tag, expected_details_tag);
        assertEquals(result.creative.details.zipFile, expected_details_zipFile);
        assertEquals(result.creative.details.url, expected_details_url);
        assertEquals(result.creative.details.cdnUrl, expected_details_cdnUrl);
        assertEquals(result.creative.details.vast, expected_details_vast);

        assertNotNull(result.creative.details.media);
        assertEquals(result.creative.details.media.html, expected_media_html);
        assertEquals(result.creative.details.media.playableDiskUrl, expected_media_playableDiskUrl);
        assertEquals(result.creative.details.media.playableMediaUrl, expected_media_playableMediaUrl);
        assertEquals(result.creative.details.media.type, expected_media_type);
        assertEquals(result.creative.details.media.isOnDisk, expected_media_isOnDisk);
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
                "        \"events\": [{\n" +
                "                   \"event\": \"impression\",\n" +
                "                   \"URL\": \"https://ads.staging.superawesome.tv/v2/video/impression?placement=481&creative=4907&line_item=932&sdkVersion=ios_5.2.3&rnd=8832683&dauid=8798453893251470766&device=phone\"\n" +
                "                   },\n" +
                "                   {\n" +
                "                   \"event\": \"impression\",\n" +
                "                   \"URL\": \"https://ads.staging.superawesome.tv/v2/video/impression?placement=481&creative=4907&line_item=932&sdkVersion=ios_5.2.3&rnd=8832683&dauid=8798453893251470766&device=phone\"\n" +
                "                   },\n" +
                "                   {\n" +
                "                   \"event\": \"err_impression\",\n" +
                "                   \"URL\": \"https://ads.staging.superawesome.tv/v2/video/impression?placement=481&creative=4907&line_item=932&sdkVersion=ios_5.2.3&rnd=8832683&dauid=8798453893251470766&device=phone\"\n" +
                "                   },\n" +
                "                   {\n" +
                "                   \"event\": \"err_impression\",\n" +
                "                   \"URL\": \"https://ads.staging.superawesome.tv/v2/video/tracking?event=skip&placement=481&creative=4907&line_item=932&sdkVersion=ios_5.2.3&rnd=1570851&dauid=8798453893251470766&device=phone\"\n" +
                "                   },\n" +
                "                   {\n" +
                "                   \"event\": \"err_impression\",\n" +
                "                   \"URL\": \"https://ads.staging\"\n" +
                "                   }],\n" +
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
                "            \"cdnUrl\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/\",\n" +
                "            \"height\": 480,\n" +
                "            \"zipFile\": null,\n" +
                "            \"duration\": 32,\n" +
                "            \"media\": {\n" +
                "                \"isOnDisk\": true,\n" +
                "                \"playableDiskUrl\": \"samov_19410.mp4\",\n" +
                "                \"playableMediaUrl\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4\",\n" +
                "                \"html\": null,\n" +
                "                \"type\": \"video/mp4\"\n" +
                "            },\n" +
                "            \"name\": null,\n" +
                "            \"video\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4\"\n" +
                "        },\n" +
                "        \"customPayload\": null,\n" +
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
        int expected_app = 1484;
        int expected_lineItemId = 932;
        int expected_campaignId = 0;
        int expected_placementId = 481;
        double expected_moat = 0.2;
        SACampaignType expected_campaignType = SACampaignType.CPM;
        String expected_device = null;
        boolean expected_test = false;
        boolean expected_isFallback = false;
        boolean expected_isFill = false;
        boolean expected_isHouse = false;
        boolean expected_safeAdApproved = true;
        boolean expected_showPadlock = true;

        int expected_creative_id = 4907;
        String expected_creative_name = null;
        int expected_creative_cpm = 0;
        SACreativeFormat expected_creative_format = SACreativeFormat.video;
        boolean expected_creative_live = false;
        boolean expected_creative_approved = false;
        String expected_creative_customPayload = null;
        String expected_creative_clickUrl =  "https://superawesome.tv";
        String expected_creative_installUrl = null;
        String expected_creative_impressionUrl = null;
        String expected_creative_bundleId = null;
        SATracking t1 = new SATracking();
        t1.event =  "impression";
        t1.URL =  "https://ads.staging.superawesome.tv/v2/video/impression?placement=481&creative=4907&line_item=932&sdkVersion=ios_5.2.3&rnd=8832683&dauid=8798453893251470766&device=phone";
        SATracking t2 = new SATracking();
        t2.event =  "impression";
        t2.URL =  "https://ads.staging.superawesome.tv/v2/video/impression?placement=481&creative=4907&line_item=932&sdkVersion=ios_5.2.3&rnd=8832683&dauid=8798453893251470766&device=phone";
        SATracking t3 = new SATracking();
        t3.event =  "err_impression";
        t3.URL =  "https://ads.staging.superawesome.tv/v2/video/impression?placement=481&creative=4907&line_item=932&sdkVersion=ios_5.2.3&rnd=8832683&dauid=8798453893251470766&device=phone";
        SATracking t4 = new SATracking();
        t4.event =  "err_impression";
        t4.URL =  "https://ads.staging.superawesome.tv/v2/video/tracking?event=skip&placement=481&creative=4907&line_item=932&sdkVersion=ios_5.2.3&rnd=1570851&dauid=8798453893251470766&device=phone";
        SATracking t5 = new SATracking();
        t5.event =  "err_impression";
        t5.URL =  "https://ads.staging";
        List<SATracking> expected_creative_events = Arrays.asList(t1, t2, t3, t4, t5);

        int expected_referral_configuration = -1;
        int expected_referral_campaignId = -1;
        int expected_referral_lineItemId = -1;
        int expected_referral_creativeId = -1;
        int expected_referral_placementId = -1;

        int expected_details_width = 600;
        int expected_details_height = 480;
        String expected_details_name = null;
        String expected_details_placementFormat =  "video";
        int expected_details_bitrate = 0;
        int expected_details_duration = 32;
        int expected_details_value = 0;
        String expected_details_image =  "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4";
        String expected_details_video =  "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4";
        String expected_details_tag = null;
        String expected_details_zipFile = null;
        String expected_details_url =  "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4";
        String expected_details_cdnUrl =  "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/";
        String expected_details_vast =  "https://ads.staging.superawesome.tv/v2/video/vast/481/932/4907/?sdkVersion=ios_5.2.3&rnd=621706701&dauid=8798453893251470766&device=phone";

        String expected_media_html = null;
        String expected_media_playableDiskUrl =  "samov_19410.mp4";
        String expected_media_playableMediaUrl =  "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/l2UWsR6EWLZ8amjR8dTierr9hNS1mkOP.mp4";
        String expected_media_type =  "video/mp4";
        boolean expected_media_isOnDisk = true;

        // then
        SAAd result = new SAAd(given);

        // assert
        assertNotNull(result);
        assertEquals(result.error, expected_error);
        assertEquals(result.advertiserId, expected_advertiserId);
        assertEquals(result.publisherId, expected_publisherId);
        assertEquals(result.app, expected_app);
        assertEquals(result.moat, expected_moat, 0.01);
        assertEquals(result.lineItemId, expected_lineItemId);
        assertEquals(result.campaignId, expected_campaignId);
        assertEquals(result.placementId, expected_placementId);
        assertEquals(result.campaignType, expected_campaignType);
        assertEquals(result.device, expected_device);
        assertEquals(result.test, expected_test);
        assertEquals(result.isFallback, expected_isFallback);
        assertEquals(result.isFill, expected_isFill);
        assertEquals(result.isHouse, expected_isHouse);
        assertEquals(result.safeAdApproved, expected_safeAdApproved);
        assertEquals(result.showPadlock, expected_showPadlock);

        assertNotNull(result.creative);
        assertEquals(result.creative.id, expected_creative_id);
        assertEquals(result.creative.name, expected_creative_name);
        assertEquals(result.creative.cpm, expected_creative_cpm);
        assertEquals(result.creative.format, expected_creative_format);
        assertEquals(result.creative.live, expected_creative_live);
        assertEquals(result.creative.approved, expected_creative_approved);
        assertEquals(result.creative.customPayload, expected_creative_customPayload);
        assertEquals(result.creative.clickUrl, expected_creative_clickUrl);
        assertEquals(result.creative.installUrl, expected_creative_installUrl);
        assertEquals(result.creative.impressionUrl, expected_creative_impressionUrl);
        assertEquals(result.creative.bundleId, expected_creative_bundleId);
        assertEquals(result.creative.events.size(), expected_creative_events.size());

        assertNotNull(result.creative.referralData);
        assertEquals(result.creative.referralData.configuration, expected_referral_configuration);
        assertEquals(result.creative.referralData.campaignId, expected_referral_campaignId);
        assertEquals(result.creative.referralData.lineItemId, expected_referral_lineItemId);
        assertEquals(result.creative.referralData.creativeId, expected_referral_creativeId);
        assertEquals(result.creative.referralData.placementId, expected_referral_placementId);
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_content%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_medium%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_term%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_campaign%3D-1"));
        assertTrue(result.creative.referralData.writeToReferralQuery().contains("utm_source%3D-1"));

        assertNotNull(result.creative.details);
        assertEquals(result.creative.details.width, expected_details_width);
        assertEquals(result.creative.details.height, expected_details_height);
        assertEquals(result.creative.details.name, expected_details_name);
        assertEquals(result.creative.details.placementFormat, expected_details_placementFormat);
        assertEquals(result.creative.details.bitrate, expected_details_bitrate);
        assertEquals(result.creative.details.duration, expected_details_duration);
        assertEquals(result.creative.details.value, expected_details_value);
        assertEquals(result.creative.details.image, expected_details_image);
        assertEquals(result.creative.details.video, expected_details_video);
        assertEquals(result.creative.details.tag, expected_details_tag);
        assertEquals(result.creative.details.zipFile, expected_details_zipFile);
        assertEquals(result.creative.details.url, expected_details_url);
        assertEquals(result.creative.details.cdnUrl, expected_details_cdnUrl);
        assertEquals(result.creative.details.vast, expected_details_vast);

        assertNotNull(result.creative.details.media);
        assertEquals(result.creative.details.media.html, expected_media_html);
        assertEquals(result.creative.details.media.playableDiskUrl, expected_media_playableDiskUrl);
        assertEquals(result.creative.details.media.playableMediaUrl, expected_media_playableMediaUrl);
        assertEquals(result.creative.details.media.type, expected_media_type);
        assertEquals(result.creative.details.media.isOnDisk, expected_media_isOnDisk);
    }
}