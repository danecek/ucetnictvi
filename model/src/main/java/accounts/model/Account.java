package accounts.model;

import java.io.Serializable;

public class Account implements Serializable {

    /**
     * @return the no
     */
    public int getOrder() {
        return order;
    }

    /**
     * @return the skupina
     */
    public AccountGroup getSkupina() {
        return group;
    }

    private final AccountId id;
    private AccountGroup group;
    private int order;
    private final String name;

    public Account(int id, AccountGroup group, int order, String name) {
        this.group = group;
        this.order = order;
        this.id = new AccountId(id);
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Account)) {
            return false;
        }
        return ((Account) obj).getId().equals(id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    /**
     * @return the id
     */
    public AccountId getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public String getNumber() {
        return getSkupina().toString() + order;
    }

    @Override
    public String toString() {
        return String.format("LibReader{%s, %s}", id, name);
    }

}
