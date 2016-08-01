package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SAJsonToList;
import tv.superawesome.lib.sajsonparser.SAJsonParser;
import tv.superawesome.lib.sajsonparser.SAListToJson;

/**
 * Created by gabriel.coman on 22/12/15.
 */
public class SAVASTCreative implements Parcelable, JSONSerializable {

    public SAVASTCreativeType type;
    public String id;
    public String sequence;
    public String duration;
    public String clickThrough;
    public String playableMediaUrl;
    public String playableDiskUrl;
    public boolean isOnDisk = false;
    public List<SAVASTMediaFile> mediaFiles;
    public List<SAVASTTracking> trackingEvents;
    public List<String> clickTracking;
    public List<String> customClicks;

    public SAVASTCreative() {

    }

    public SAVASTCreative(JSONObject json) {
        readFromJson(json);
    }

    protected SAVASTCreative(Parcel in) {
        type = in.readParcelable(SAVASTCreativeType.class.getClassLoader());
        id = in.readString();
        sequence = in.readString();
        duration = in.readString();
        clickThrough = in.readString();
        playableMediaUrl = in.readString();
        playableDiskUrl = in.readString();
        isOnDisk = in.readByte() != 0;
        mediaFiles = in.createTypedArrayList(SAVASTMediaFile.CREATOR);
        trackingEvents = in.createTypedArrayList(SAVASTTracking.CREATOR);
        clickTracking = in.createStringArrayList();
        customClicks = in.createStringArrayList();
    }

    public static final Creator<SAVASTCreative> CREATOR = new Creator<SAVASTCreative>() {
        @Override
        public SAVASTCreative createFromParcel(Parcel in) {
            return new SAVASTCreative(in);
        }

        @Override
        public SAVASTCreative[] newArray(int size) {
            return new SAVASTCreative[size];
        }
    };

    public void sumCreative(SAVASTCreative creative) {
        // call super

        this.id = creative.id;
        this.sequence = creative.sequence;
        this.duration = creative.duration;

        if (creative.clickThrough != null) {
            this.clickThrough = creative.clickThrough;
        }
        if (creative.playableMediaUrl != null) {
            this.playableMediaUrl = creative.playableMediaUrl;
        }
        if (creative.playableDiskUrl != null) {
            this.playableDiskUrl = creative.playableDiskUrl;
        }

        /** now add all other things */
        for (SAVASTMediaFile mediaFile : creative.mediaFiles) {
            this.mediaFiles.add(mediaFile);
        }
        for (SAVASTTracking trackingEvent : creative.trackingEvents) {
            this.trackingEvents.add(trackingEvent);
        }
        for (String aClickTracking : creative.clickTracking) {
            this.clickTracking.add(aClickTracking);
        }
        for (String customClick : creative.customClicks) {
            this.customClicks.add(customClick);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(type, flags);
        dest.writeString(id);
        dest.writeString(sequence);
        dest.writeString(duration);
        dest.writeString(clickThrough);
        dest.writeString(playableMediaUrl);
        dest.writeString(playableDiskUrl);
        dest.writeByte((byte) (isOnDisk ? 1 : 0));
        dest.writeTypedList(mediaFiles);
        dest.writeTypedList(trackingEvents);
        dest.writeStringList(clickTracking);
        dest.writeStringList(customClicks);
    }


    @Override
    public void readFromJson(JSONObject json) {
        id = SAJsonParser.getString(json, "id");
        sequence = SAJsonParser.getString(json, "sequence");
        duration = SAJsonParser.getString(json, "duration");
        clickThrough = SAJsonParser.getString(json, "clickThrough");
        playableMediaUrl = SAJsonParser.getString(json, "playableMediaUrl");
        playableDiskUrl = SAJsonParser.getString(json, "playableDiskUrl");
        isOnDisk = SAJsonParser.getBoolean(json, "isOnDisk");

        mediaFiles = SAJsonParser.getListFromJsonArray(json, "mediaFiles", new SAJsonToList<SAVASTMediaFile, JSONObject>() {
            @Override
            public SAVASTMediaFile traverseItem(JSONObject jsonObject) {
                return new SAVASTMediaFile(jsonObject);
            }
        });

        trackingEvents = SAJsonParser.getListFromJsonArray(json, "trackingEvents", new SAJsonToList<SAVASTTracking, JSONObject>() {
            @Override
            public SAVASTTracking traverseItem(JSONObject jsonObject) {
                return new SAVASTTracking(jsonObject);
            }
        });

        clickTracking = SAJsonParser.getListFromJsonArray(json, "clickTracking", new SAJsonToList<String, String>() {
            @Override
            public String traverseItem(String s) {
                return s;
            }
        });

        customClicks = SAJsonParser.getListFromJsonArray(json, "customClicks", new SAJsonToList<String, String>() {
            @Override
            public String traverseItem(String s) {
                return s;
            }
        });

        String typeStr = SAJsonParser.getString(json, "type", SAVASTCreativeType.Linear.toString());
        if (typeStr.equals(SAVASTCreativeType.Linear.toString())) {
            type = SAVASTCreativeType.Linear;
        }
        if (typeStr.equals(SAVASTCreativeType.NonLinear.toString())) {
            type = SAVASTCreativeType.NonLinear;
        }
        if (typeStr.equals(SAVASTCreativeType.CompanionAds.toString())) {
            type = SAVASTCreativeType.CompanionAds;
        }
    }

    @Override
    public JSONObject writeToJson() {

        return SAJsonParser.newObject(new Object[]{
                "id", id,
                "sequence", sequence,
                "duration", duration,
                "type", type.toString(),
                "clickThrough", clickThrough,
                "playableDiskUrl", playableDiskUrl,
                "playableMediaUrl", playableMediaUrl,
                "isOnDisk", isOnDisk,
                "mediaFiles", SAJsonParser.getJsonArrayFromList(mediaFiles, new SAListToJson<JSONObject, SAVASTMediaFile>() {
                        @Override
                        public JSONObject traverseItem(SAVASTMediaFile savastMediaFile) {
                            return savastMediaFile.writeToJson();
                        }
                    }),
                "trackingEvents", SAJsonParser.getJsonArrayFromList(trackingEvents, new SAListToJson<JSONObject, SAVASTTracking>() {
                        @Override
                        public JSONObject traverseItem(SAVASTTracking savastTracking) {
                            return savastTracking.writeToJson();
                        }
                    }),
                "clickTracking", SAJsonParser.getJsonArrayFromList(clickTracking, new SAListToJson<String, String>() {
                        @Override
                        public String traverseItem(String s) {
                            return s;
                        }
                    }),
                "customClicks", SAJsonParser.getJsonArrayFromList(customClicks, new SAListToJson<String, String>() {
                        @Override
                        public String traverseItem(String s) {
                            return s;
                        }
                    })
        });
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
