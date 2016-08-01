package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gabriel.coman on 01/08/16.
 */
public enum SACampaignType implements Parcelable {
    CPM {
        @Override
        public String toString() {
            return "CPM";
        }
    },
    CPI {
        @Override
        public String toString() {
            return "CPI";
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeInt(ordinal());
    }

    public static final Creator<SACampaignType> CREATOR = new Creator<SACampaignType>() {
        @Override
        public SACampaignType createFromParcel(final Parcel source) {
            return SACampaignType.values()[source.readInt()];
        }

        @Override
        public SACampaignType[] newArray(final int size) {
            return new SACampaignType[size];
        }
    };
}
