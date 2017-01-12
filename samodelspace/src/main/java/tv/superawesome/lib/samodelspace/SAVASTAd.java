/**
 * @Copyright:   SuperAwesome Trading Limited 2017
 * @Author:      Gabriel Coman (gabriel.coman@superawesome.tv)
 */
package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import tv.superawesome.lib.sajsonparser.SABaseObject;
import tv.superawesome.lib.sajsonparser.SAJsonParser;
import tv.superawesome.lib.sajsonparser.SAJsonToList;
import tv.superawesome.lib.sajsonparser.SAListToJson;

/**
 * Class that represents a VAST Ad
 *  - a VAST URL redirect
 *  - a VAST type (starting out as Invalid, but should either be InLine or Wrapper)
 *  - a media URL
 *  - an array of vast tracking elements
 */
public class SAVASTAd extends SABaseObject implements Parcelable {

    // member variables
    public String vastRedirect;
    public SAVASTAdType vastType = SAVASTAdType.Invalid;
    public String mediaUrl;
    public List<SATracking> vastEvents = new ArrayList<>();

    /**
     * Basic constructor
     */
    public SAVASTAd () {
        // do nothing
    }

    /**
     * Constructor with a JSON string
     *
     * @param json a valid JSON string
     */
    public SAVASTAd (String json) {
        JSONObject jsonObject = SAJsonParser.newObject(json);
        readFromJson(jsonObject);
    }

    /**
     * Constructor with a JSON object
     *
     * @param jsonObject a valid JSON object
     */
    public SAVASTAd (JSONObject jsonObject) {
        readFromJson(jsonObject);
    }

    /**
     * Constructor with a Parcel object
     *
     * @param in the parcel object to read data from
     */
    protected SAVASTAd(Parcel in) {
        vastRedirect = in.readString();
        mediaUrl = in.readString();
        vastEvents = in.createTypedArrayList(SATracking.CREATOR);
        vastType = in.readParcelable(SAVASTAdType.class.getClassLoader());
    }

    /**
     * Specific method that sums two ads together
     *
     * @param toBeAdded the ad that's going to be added
     */
    public void sumAd (SAVASTAd toBeAdded) {
        mediaUrl = toBeAdded.mediaUrl != null ? toBeAdded.mediaUrl : mediaUrl;
        vastEvents.addAll(toBeAdded.vastEvents);
    }

    /**
     * Overridden SAJsonSerializable method that describes the conditions for model validity
     *
     * @return true or false
     */
    @Override
    public boolean isValid() {
        return true;
    }

    /**
     * Overridden SAJsonSerializable method that describes how a JSON object maps to a Java model
     *
     * @param jsonObject a valid JSONObject
     */
    @Override
    public void readFromJson(JSONObject jsonObject) {
        vastRedirect = SAJsonParser.getString(jsonObject, "vastRedirect", null);
        mediaUrl = SAJsonParser.getString(jsonObject, "mediaUrl", null);
        vastType = SAVASTAdType.fromValue(SAJsonParser.getInt(jsonObject, "vastType", 0));
        vastEvents = SAJsonParser.getListFromJsonArray(jsonObject, "vastEvents", new SAJsonToList<SATracking, JSONObject>() {
            @Override
            public SATracking traverseItem(JSONObject jsonObject) {
                return new SATracking(jsonObject);
            }
        });
    }

    /**
     * Overridden SAJsonSerializable method that describes how a Java model maps to a JSON object
     *
     * @return a valid JSONObject
     */
    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[] {
                "vastRedirect", vastRedirect,
                "mediaUrl", mediaUrl,
                "vastType", vastType.ordinal(),
                "vastEvents", SAJsonParser.getJsonArrayFromList(vastEvents, new SAListToJson<JSONObject, SATracking>() {
                    @Override
                    public JSONObject traverseItem(SATracking saTracking) {
                        return saTracking.writeToJson();
                    }
                })
        });
    }

    /**
     * Method needed for Parcelable implementation
     */
    public static final Creator<SAVASTAd> CREATOR = new Creator<SAVASTAd>() {
        @Override
        public SAVASTAd createFromParcel(Parcel in) {
            return new SAVASTAd(in);
        }

        @Override
        public SAVASTAd[] newArray(int size) {
            return new SAVASTAd[size];
        }
    };

    /**
     * Method needed for Parcelable implementation
     *
     * @return always 0
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Method needed for Parcelable implementation
     *
     * @param dest  destination parcel
     * @param flags special flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(vastRedirect);
        dest.writeString(mediaUrl);
        dest.writeTypedList(vastEvents);
        dest.writeParcelable(vastType, flags);
    }
}