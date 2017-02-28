package superawesome.tv.samodelspacedemo;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import tv.superawesome.lib.samodelspace.vastad.SAVASTEvent;
import tv.superawesome.lib.samodelspace.vastad.SAVASTAd;
import tv.superawesome.lib.samodelspace.vastad.SAVASTAdType;
import tv.superawesome.lib.samodelspace.vastad.SAVASTMedia;

public class SAVAST_ModelSpace_Tests1 extends ApplicationTestCase<Application> {
    public SAVAST_ModelSpace_Tests1() {
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
}
