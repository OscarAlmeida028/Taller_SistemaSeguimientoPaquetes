public class Address {
    private String street, city, state, zipCode;

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return  "\nCalle: " + street +
                "\nCiudad: " + city +
                "\nEstado: " + state +
                "\nCódigo Zip: " + zipCode;
    }
}
