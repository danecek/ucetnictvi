package biapj.model;

import java.io.Serializable;

public class LibReader implements Serializable {

    private final ReaderId id;
    private final String name;
    private final Address address;

    public LibReader(int id, String name, Address address) {
        this.id = new ReaderId(id);
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        return ((LibReader) obj).getId().equals(id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    /**
     * @return the id
     */
    public ReaderId getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return String.format("LibReader{%s, %s, %s}", id, name, address);
    }

}
