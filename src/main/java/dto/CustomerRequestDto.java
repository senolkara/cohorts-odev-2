package dto;

import model.enums.AccountType;

import java.util.ArrayList;
import java.util.List;

public class CustomerRequestDto {
    private UserRequestDto userRequestDto;
    private Integer credit;
    private AccountType accountType;
    private List<OrderRequestDto> orderRequestDtoList;

    public UserRequestDto getUserRequestDto() {
        return userRequestDto;
    }

    public void setUserRequestDto(UserRequestDto userRequestDto) {
        this.userRequestDto = userRequestDto;
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

    public List<OrderRequestDto> getOrderRequestDtoList() {
        if (orderRequestDtoList ==  null) {
            return new ArrayList<>();
        }
        return orderRequestDtoList;
    }

    public void setOrderRequestDtoList(List<OrderRequestDto> orderRequestDtoList) {
        this.orderRequestDtoList = orderRequestDtoList;
    }
}
