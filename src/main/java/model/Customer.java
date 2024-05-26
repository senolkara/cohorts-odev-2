package model;

import model.enums.AccountType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Customer extends User {

    private User user;
    private Integer credit;
    private Set<Address> addresses;
    private AccountType accountType;
    private List<Order> orderList;

    public Customer(String name, String surname, String email, String password) {
        super(name, surname, email, password);
        this.accountType = AccountType.STANDARD;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public List<Order> getOrderList() {
        if (orderList ==  null) {
            return new ArrayList<>();
        }
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }


}
