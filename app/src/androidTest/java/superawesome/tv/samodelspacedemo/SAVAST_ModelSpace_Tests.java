package superawesome.tv.samodelspacedemo;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import tv.superawesome.lib.samodelspace.vastad.SAVASTEvent;
import tv.superawesome.lib.samodelspace.vastad.SAVASTAd;
import tv.superawesome.lib.samodelspace.vastad.SAVASTAdType;
import tv.superawesome.lib.samodelspace.vastad.SAVASTMedia;

public class SAVAST_ModelSpace_Tests extends ApplicationTestCase<Application> {
    public SAVAST_ModelSpace_Tests() {
        super(Application.class);
    }

    @SmallTest
    public void testSAVASTMedia1 () {

        String json = "{\n" +
                "\t\"type\": \"video/mp4\",\n" +
                "\t\"url\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/c0sKSRTuPu8dDkok2HQTnLS1k3A6vL6c.mp4\",\n" +
                "\t\"bitrate\": 720,\n" +
                "\t\"width\": 600,\n" +
                "\t\"height\": 480\n" +
                "}";

        SAVASTMedia savastMedia = new SAVASTMedia(json);
        assertNotNull(savastMedia);

        String expected_type = "video/mp4";
        String expected_mediaUrl = "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/c0sKSRTuPu8dDkok2HQTnLS1k3A6vL6c.mp4";
        int expected_bitrate = 720;
        int expected_width = 600;
        int expected_height = 480;

        assertEquals(expected_type, savastMedia.type);
        assertEquals(expected_mediaUrl, savastMedia.url);
        assertEquals(expected_bitrate, savastMedia.bitrate);
        assertEquals(expected_width, savastMedia.width);
        assertEquals(expected_height, savastMedia.height);
        assertTrue(savastMedia.isValid());
    }

    @SmallTest
    public void testSAVASTMedia2 () {

        String json = "{\n" +
                "\t\"type\": \"video/mp4\",\n" +
                "\t\"url\": \"https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/c0sKSRTuPu8dDkok2HQTnLS1k3A6vL6c.mp4\",\n" +
                "\t\"height\": 480\n" +
                "}";

        SAVASTMedia savastMedia = new SAVASTMedia(json);
        assertNotNull(savastMedia);

        String expected_type = "video/mp4";
        String expected_mediaUrl = "https://s3-eu-west-1.amazonaws.com/sb-ads-video-transcoded/c0sKSRTuPu8dDkok2HQTnLS1k3A6vL6c.mp4";
        int expected_bitrate = 0;
        int expected_width = 0;
        int expected_height = 480;

        assertEquals(expected_type, savastMedia.type);
        assertEquals(expected_mediaUrl, savastMedia.url);
        assertEquals(expected_bitrate, savastMedia.bitrate);
        assertEquals(expected_width, savastMedia.width);
        assertEquals(expected_height, savastMedia.height);
        assertTrue(savastMedia.isValid());
    }

    @SmallTest
    public void testSAVASTMedia3 () {

        String json = "{\n" +
                "\t\"type\": \"video/mp4\",\n" +
                "\t\"url\": \"https://s3-eu-west-1.amazonaws.com/sbh\": 600,\n" +
                "\t\"height\": 480\n" +
                "}";

        SAVASTMedia savastMedia = new SAVASTMedia(json);
        assertNotNull(savastMedia);

        String expected_type = null;
        String expected_mediaUrl = null;
        int expected_bitrate = 0;
        int expected_width = 0;
        int expected_height = 0;

        assertEquals(expected_type, savastMedia.type);
        assertEquals(expected_mediaUrl, savastMedia.url);
        assertEquals(expected_bitrate, savastMedia.bitrate);
        assertEquals(expected_width, savastMedia.width);
        assertEquals(expected_height, savastMedia.height);
        assertFalse(savastMedia.isValid());
    }

    @SmallTest
    public void testSAVASTMedia4 () {

        String json = null;

        SAVASTMedia savastMedia = new SAVASTMedia(json);
        assertNotNull(savastMedia);

        String expected_type = null;
        String expected_mediaUrl = null;
        int expected_bitrate = 0;
        int expected_width = 0;
        int expected_height = 0;

        assertEquals(expected_type, savastMedia.type);
        assertEquals(expected_mediaUrl, savastMedia.url);
        assertEquals(expected_bitrate, savastMedia.bitrate);
        assertEquals(expected_width, savastMedia.width);
        assertEquals(expected_height, savastMedia.height);
        assertFalse(savastMedia.isValid());

    }

    @SmallTest
    public void testSAVASTAd1 () {
        String json = "{\n" +
                "\t\"redirect\": null,\n" +
                "\t\"type\": 0,\n" +
                "\t\"url\": null,\n" +
                "\t\"media\": []\n" +
                "}";

        SAVASTAd savastAd = new SAVASTAd(json);
        assertNotNull(savastAd);
        assertFalse(savastAd.isValid());

        String expected_vastRedirect = null;
        SAVASTAdType expected_vastType = SAVASTAdType.Invalid;
        String expected_mediaUrl = null;
        int expected_medias = 0;
        int expected_events = 0;

        assertEquals(expected_vastRedirect, savastAd.redirect);
        assertEquals(expected_vastType, savastAd.type);
        assertEquals(expected_mediaUrl, savastAd.url);
        assertNotNull(savastAd.media);
        assertEquals(expected_medias, savastAd.media.size());
        assertNotNull(savastAd.events);
        assertEquals(expected_events, savastAd.events.size());
    }

    @SmallTest
    public void testSAVASTAd2 () {
        String json = "{\n" +
                "\t\"redirect\": null,\n" +
                "\t\"type\": 1,\n" +
                "\t\"url\": \"https://ads.superawesome.tv/v2/demo_images/video.mp4\",\n" +
                "\t\"media\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"video/mp4\",\n" +
                "\t\t\t\"url\": \"https://ads.superawesome.tv/v2/demo_images/video.mp4\",\n" +
                "\t\t\t\"bitrate\": 720,\n" +
                "\t\t\t\"width\": 600,\n" +
                "\t\t\t\"height\": 400 \n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"events\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"event\": \"creativeView\",\n" +
                "\t\t\t\"URL\": \"https://ads.superawesome.tv/v2/video/tracking?event=creativeView&amp;placement=30479&amp;creative=-1&amp;line_item=-1&amp;sdkVersion=unknown&amp;rnd=4240693&amp;device=web&amp;country=GB\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"event\": \"complete\",\n" +
                "\t\t\t\"URL\": \"https://ads.superawesome.tv/v2/video/tracking?event=complete&amp;placement=30479&amp;creative=-1&amp;line_item=-1&amp;sdkVersion=unknown&amp;rnd=2312316&amp;device=web&amp;country=GB\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";

        SAVASTAd savastAd = new SAVASTAd(json);
        assertNotNull(savastAd);
        assertTrue(savastAd.isValid());

        String expected_vastRedirect = null;
        SAVASTAdType expected_vastType = SAVASTAdType.InLine;
        String expected_mediaUrl = "https://ads.superawesome.tv/v2/demo_images/video.mp4";
        int expected_medias = 1;
        int expected_events = 2;

        assertEquals(expected_vastRedirect, savastAd.redirect);
        assertEquals(expected_vastType, savastAd.type);
        assertEquals(expected_mediaUrl, savastAd.url);
        assertNotNull(savastAd.media);
        assertEquals(expected_medias, savastAd.media.size());
        assertNotNull(savastAd.events);
        assertEquals(expected_events, savastAd.events.size());

        for (SAVASTEvent tracking : savastAd.events) {
            assertTrue(tracking.isValid());
        }
        for (SAVASTMedia media : savastAd.media) {
            assertTrue(media.isValid());
        }
    }

    @SmallTest
    public void testSAVASTAd3 () {
        String json = "{\n" +
                "\t\"redirect\": null,\n" +
                "\t\"type\": 2,\n" +
                "\t\"url\": \"https://ads.superawesome.tv/v2/demo_images/video.mp4\",\n" +
                "\t\"media\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"video/mp4\",\n" +
                "\t\t\t\"url\": \"https://ads.superawesome.tv/v2/demo_images/video.mp4\",\n" +
                "\t\t\t\"bitrate\": 720,\n" +
                "\t\t\t\"width\": 600,\n" +
                "\t\t\t\"height\": 400 \n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"video/m3u8\",\n" +
                "\t\t\t\"url\": \"https://ads.superawesome.tv/v2/demo_images/video.m3u8\",\n" +
                "\t\t\t\"bitrate\": 1800,\n" +
                "\t\t\t\"width\": 640,\n" +
                "\t\t\t\"height\": 480 \n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"events\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"event\": \"creativeView\",\n" +
                "\t\t\t\"URL\": \"https://ads.superawesome.tv/v2/video/tracking?event=creativeView&amp;placement=30479&amp;creative=-1&amp;line_item=-1&amp;sdkVersion=unknown&amp;rnd=4240693&amp;device=web&amp;country=GB\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"event\": \"complete\",\n" +
                "\t\t\t\"URL\": \"https://ads.superawesome.tv/v2/video/tracking?event=complete&amp;placement=30479&amp;creative=-1&amp;line_item=-1&amp;sdkVersion=unknown&amp;rnd=2312316&amp;device=web&amp;country=GB\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"event\": \"midpoint\",\n" +
                "\t\t\t\"URL\": \"https://ads.superawesome.tv/v2/video/tracking?event=midpoint&amp;placement=30479&amp;creative=-1&amp;line_item=-1&amp;sdkVersion=unknown&amp;rnd=6657530&amp;device=web&amp;country=GB\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";

        SAVASTAd savastAd = new SAVASTAd(json);
        assertNotNull(savastAd);
        assertTrue(savastAd.isValid());

        String expected_vastRedirect = null;
        SAVASTAdType expected_vastType = SAVASTAdType.Wrapper;
        String expected_mediaUrl = "https://ads.superawesome.tv/v2/demo_images/video.mp4";
        int expected_medias = 2;
        int expected_events = 3;

        assertEquals(expected_vastRedirect, savastAd.redirect);
        assertEquals(expected_vastType, savastAd.type);
        assertEquals(expected_mediaUrl, savastAd.url);
        assertNotNull(savastAd.media);
        assertEquals(expected_medias, savastAd.media.size());
        assertNotNull(savastAd.events);
        assertEquals(expected_events, savastAd.events.size());

        for (SAVASTEvent tracking : savastAd.events) {
            assertTrue(tracking.isValid());
        }
        for (SAVASTMedia media : savastAd.media) {
            assertTrue(media.isValid());
        }
    }

    @SmallTest
    public void testSAVASTAd4 () {
        String json = "{\n" +
                "\t\"redirect\": null,\n" +
                "\t\"type\": 2,\n" +
                "\t\"url\": \"https://ads.superawesome.tv/v2/demo_images/video.mp4\",\n" +
                "\t\"media\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"video/mp4\",\n" +
                "\t\t\t\"url\": \"https://ads.superawesome.tv/v2/demo_images/video.mp4\",\n" +
                "\t\t\t\"bitrate\": 720,\n" +
                "\t\t\t\"width\": 600,\n" +
                "\t\t\t\"height\": 400 \n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"type\": \"video/mp4\",\n" +
                "\t\t\t\"url\": \"https://ads.superawesome.tv/v2/demo_\n" +
                "\t\t\t\"event\": \"complete\",\n" +
                "\t\t\t\"URL\": \"https://ads.superawesome.tv/v2/video/tracking?event=complete&amp;placement=30479&amp;creative=-1&amp;line_item=-1&amp;sdkVersion=unknown&amp;rnd=2312316&amp;device=web&amp;country=GB\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"event\": \"midpoint\",\n" +
                "\t\t\t\"URL\": \"https://ads.superawesome.tv/v2/video/tracking?event=midpoint&amp;placement=30479&amp;creative=-1&amp;line_item=-1&amp;sdkVersion=unknown&amp;rnd=6657530&amp;device=web&amp;country=GB\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";

        SAVASTAd savastAd = new SAVASTAd(json);
        assertNotNull(savastAd);
        assertFalse(savastAd.isValid());

        String expected_vastRedirect = null;
        SAVASTAdType expected_vastType = SAVASTAdType.Invalid;
        String expected_mediaUrl = null;
        int expected_medias = 0;
        int expected_events = 0;

        assertEquals(expected_vastRedirect, savastAd.redirect);
        assertEquals(expected_vastType, savastAd.type);
        assertEquals(expected_mediaUrl, savastAd.url);
        assertNotNull(savastAd.media);
        assertEquals(expected_medias, savastAd.media.size());
        assertNotNull(savastAd.events);
        assertEquals(expected_events, savastAd.events.size());
    }
}
