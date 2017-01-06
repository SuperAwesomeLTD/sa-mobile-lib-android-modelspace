package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

public enum SACampaignType implements Parcelable {
    CPM(0) {
        @Override
        public String toString() {
            return "CPM";
        }
    },
    CPI(1) {
        @Override
        public String toString() {
            return "CPI";
        }
    };

    private final int value;
    SACampaignType(int i) {
        this.value = i;
    }

    public static SACampaignType fromValue (int value) {
        if (value == 1) return CPI;
        return CPM;
    }

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
