package LmsLLD.models;

import LmsLLD.Enums.AccountStatus;

public class Account {
    Person person;
    AccountStatus accountStatus;
    String Password;
    LibraryCard libraryCard;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
