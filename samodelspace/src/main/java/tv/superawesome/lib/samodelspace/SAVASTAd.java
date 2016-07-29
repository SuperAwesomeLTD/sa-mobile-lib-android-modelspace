package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SAJsonParser;

public class SAVASTAd implements Parcelable, JSONSerializable {

    public SAVASTAdType type;
    public String id;
    public String sequence;
    public String redirectUri;
    public boolean isImpressionSent;
    public List<String> errors;
    public List<String> impressions;
    public SAVASTCreative creative;

    public SAVASTAd(){

    }

    public SAVASTAd(JSONObject json) {
        readFromJson(json);
    }

    protected SAVASTAd(Parcel in) {
        type = in.readParcelable(SAVASTAdType.class.getClassLoader());
        id = in.readString();
        sequence = in.readString();
        redirectUri = in.readString();
        isImpressionSent = in.readByte() != 0;
        errors = in.createStringArrayList();
        impressions = in.createStringArrayList();
        creative = in.readParcelable(SAVASTCreative.class.getClassLoader());
    }

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

    public void sumAd(SAVASTAd ad){
        this.id = ad.id;
        this.sequence = ad.sequence;

        // add errors
        for (Iterator<String> i = ad.errors.iterator(); i.hasNext(); ){
            this.errors.add(i.next());
        }

        // add impressions
        for (String impression : ad.impressions) {
            this.impressions.add(impression);
        }

        this.creative.sumCreative(ad.creative);
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
        dest.writeString(redirectUri);
        dest.writeByte((byte) (isImpressionSent ? 1 : 0));
        dest.writeStringList(errors);
        dest.writeStringList(impressions);
        dest.writeParcelable(creative, flags);
    }

    @Override
    public void readFromJson(JSONObject json) {
        id = SAJsonParser.getString(json, "id");
        sequence = SAJsonParser.getString(json, "sequence");
        redirectUri = SAJsonParser.getString(json, "redirectUri");
        isImpressionSent = SAJsonParser.getBoolean(json, "isImpressionSent");
        creative = new SAVASTCreative(SAJsonParser.getJsonObject(json, "creative"));

        String typeStr = SAJsonParser.getString(json, "type", SAVASTAdType.Invalid.toString());
        if (typeStr.equals(SAVASTAdType.Invalid.toString())) {
            type = SAVASTAdType.Invalid;
        }
        if (typeStr.equals(SAVASTAdType.InLine.toString())){
            type = SAVASTAdType.InLine;
        }
        if (typeStr.equals(SAVASTAdType.Wrapper.toString())){
            type = SAVASTAdType.Wrapper;
        }

        errors = new ArrayList<>();
        JSONArray jsonArray1 = SAJsonParser.getJsonArray(json, "errors", new JSONArray());
        for (int i = 0; i < jsonArray1.length(); i++){
            try {
                errors.add(jsonArray1.getString(i));
            } catch (JSONException ignored) {}
        }

        impressions = new ArrayList<>();
        JSONArray jsonArray2 = SAJsonParser.getJsonArray(json, "impressions", new JSONArray());
        for (int i = 0; i < jsonArray2.length(); i++) {
            try {
                impressions.add(jsonArray2.getString(i));
            } catch (JSONException ignored) {}
        }
    }

    @Override
    public JSONObject writeToJson() {

        JSONArray errorsJsonArray = new JSONArray();
        for (String error : errors) {
            errorsJsonArray.put(error);
        }

        JSONArray impressionsJsonArray = new JSONArray();
        for (String impression : impressions) {
            impressionsJsonArray.put(impression);
        }

        return SAJsonParser.newObject(new Object[] {
                "type", type.toString(),
                "id", id,
                "redirectUri", redirectUri,
                "sequence", sequence,
                "isImpressionSent", isImpressionSent,
                "creative", creative.writeToJson(),
                "errors", errorsJsonArray,
                "impressions", impressionsJsonArray
        });
    }
}
