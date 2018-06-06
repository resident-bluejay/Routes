package edu.andrews.kundani.routes;


import android.os.Parcel;
import android.os.Parcelable;

public class Information implements Parcelable {

    String name, location, phone_number;
    String food_supply, clothing_supply, toiletries, shoe_supply, blankets;
    String personId;
    public Information () {
        //constructor
    }
    private Information(Parcel in) {
        personId = in.readString();
        name = in.readString();
        location = in.readString();
        phone_number = in.readString();

    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    public static final Parcelable.Creator<Information> CREATOR = new Parcelable.Creator<Information>() {
        public Information createFromParcel(Parcel in) {
            return new Information(in);
        }

        public Information[] newArray(int size) {
            return new Information[size];

        }
    };
    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(personId);
        dest.writeString(name);
        dest.writeString(location);
        dest.writeString(phone_number);

    }

    public Information(String name, String phone_number, String location){
        this.name = name;
        this.location = location;
        this.phone_number = phone_number;
    }

    //setters

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void setPhoneNumber(String phone_number){
        this.phone_number = phone_number;
    }

    public void setBlankets(String blankets) {
        this.blankets = blankets;
    }

    public void setClothing_supply(String clothing_supply) {
        this.clothing_supply = clothing_supply;
    }

    public void setFood_supply(String food_supply) {
        this.food_supply = food_supply;
    }

    public void setToiletries(String toiletries) {
        this.toiletries = toiletries;
    }

    public void setShoe_supply(String shoe_supply) {
        this.shoe_supply = shoe_supply;
    }

    //getters

    public String getPersonId() {
        return personId;
    }

    public String getName() { return name;}

    public String getLocation() {
        return location;
    }

    public String getPhoneNumber() { return phone_number;}

    public String getBlankets() {return blankets;}

    public String getClothingSupply() {return clothing_supply;}

    public String getShoeSupply() {return shoe_supply;}

    public String getToiletries() {
        return toiletries;
    }

    public String getFoodSupply() {
        return food_supply;
    }

    @Override
    public String toString() {
        return this.name + this.phone_number + this.location;
    }
}
