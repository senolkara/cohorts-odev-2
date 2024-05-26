package model;

import model.enums.AccountType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    private User user;
    private Integer credit;
    private AccountType accountType;
    private List<Order> orderList;
    private Integer score;

    public Customer(String name, String surname, String email, String password, String address, LocalDate birthDate) {
        super(name, surname, email, password, address, birthDate);
        this.accountType = AccountType.STANDARD;
        this.score = 0;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
