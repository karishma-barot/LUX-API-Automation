package api.payload;

public class Store {
        int[] category_ids;
        String centre_id;
        String name;
        int retailer_id;
        int salience;
        int[] store_type_ids;

    public int[] getCategory_ids() {
        return category_ids;
    }

    public void setCategory_ids(int[] category_ids) {
        this.category_ids = category_ids;
    }

    public String getCentre_id() {
        return centre_id;
    }

    public void setCentre_id(String centre_id) {
        this.centre_id = centre_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRetailer_id() {
        return retailer_id;
    }

    public void setRetailer_id(int retailer_id) {
        this.retailer_id = retailer_id;
    }

    public int getSalience() {
        return salience;
    }

    public void setSalience(int salience) {
        this.salience = salience;
    }

    public int[] getStore_type_ids() {
        return store_type_ids;
    }

    public void setStore_type_ids(int[] store_type_ids) {
        this.store_type_ids = store_type_ids;
    }
}
