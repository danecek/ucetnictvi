/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.model;

public enum AccountClass {
    DlouhodobyMajetek("0", "Dlouhodoby majetek"),
    FinancniUcty("2", "Financni ucty"),
    ZuctovaciVztahy("3", "Zuctovaci vztahy"),
    VlastniJmeni("9", "Vlastni jmeni");

    String number;
    String name;

    private AccountClass(String number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return number;
    }

}
