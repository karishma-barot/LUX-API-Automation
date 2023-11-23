package api.payload;

public class Centre {

    String centre_id;
    String country="US";
    String dining_image_ref="google.com";
    String dining_image_medium_ref="google.com";
    String dining_image_small_ref="google.com";
    String email_address;
    String hero_image_ref="google.com";
    Double latitude=0.00;
    Double longitude=0.00;
    String name;
    String phone_number;
    String street_address = "2023-11-14T21:43:56Z";


    public String getEnabled_at() {
        return enabled_at;
    }

    public void setEnabled_at(String enabled_at) {
        this.enabled_at = enabled_at;
    }

    String enabled_at;

    public String getCentre_id() {
        return centre_id;
    }

    public void setCentre_id(String centre_id) {
        this.centre_id = centre_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDining_image_ref() {
        return dining_image_ref;
    }

    public void setDining_image_ref(String dining_image_ref) {
        this.dining_image_ref = dining_image_ref;
    }

    public String getDining_image_medium_ref() {
        return dining_image_medium_ref;
    }

    public void setDining_image_medium_ref(String dining_image_medium_ref) {
        this.dining_image_medium_ref = dining_image_medium_ref;
    }

    public String getDining_image_small_ref() {
        return dining_image_small_ref;
    }

    public void setDining_image_small_ref(String dining_image_small_ref) {
        this.dining_image_small_ref = dining_image_small_ref;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getHero_image_ref() {
        return hero_image_ref;
    }

    public void setHero_image_ref(String hero_image_ref) {
        this.hero_image_ref = hero_image_ref;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }
}
