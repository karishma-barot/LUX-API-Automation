package api.payload;

public class Retailer {
    int[] category_ids;
    String country;
    String name;
    String retailer_code;
    int retailer_id;

    public int[] getCategory_ids() {
        return category_ids;
    }

    public void setCategory_ids(int[] category_ids) {
        this.category_ids = category_ids;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRetailer_code() {
        return retailer_code;
    }

    public void setRetailer_code(String retailer_code) {
        this.retailer_code = retailer_code;
    }

    public int getRetailer_id() {
        return retailer_id;
    }

    public void setRetailer_id(int retailer_id) {
        this.retailer_id = retailer_id;
    }
}
