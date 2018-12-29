package accounts.model;

public enum AccountGroup {

    UctyVBankach(AccountClass.FinancniUcty, "22"),
    DlouhodobiFinancniMajetek(AccountClass.DlouhodobyMajetek, "06");

    AccountClass t;
    String cislo;

    private AccountGroup(AccountClass t, String cislo) {
        this.t = t;
        this.cislo = cislo;
    }

    @Override
    public String toString() {
        return t + cislo;
    }

}
