package com.example.cityandimage4;


import android.os.Parcel;
import android.os.Parcelable;

public class CityModel implements Parcelable {
    private int cityImage;
    private String cityName;
    private String cityUrl;

    public CityModel(int cityImage, String cityName, String cityUrl) {
        this.cityImage = cityImage;
        this.cityName = cityName;
        this.cityUrl = cityUrl;
    }

    protected CityModel(Parcel in) {
        cityImage = in.readInt();
        cityName = in.readString();
        cityUrl = in.readString();
    }

    public static final Creator<CityModel> CREATOR = new Creator<CityModel>() {
        @Override
        public CityModel createFromParcel(Parcel in) {
            return new CityModel(in);
        }

        @Override
        public CityModel[] newArray(int size) {
            return new CityModel[size];
        }
    };

    public int getCityImage(){
        return  cityImage;
    }

    public String getCityName(){
        return  cityName;
    }

    public String getCityUrl(){
        return  cityUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(cityImage);
        dest.writeString(cityName);
        dest.writeString(cityUrl);
    }
}
