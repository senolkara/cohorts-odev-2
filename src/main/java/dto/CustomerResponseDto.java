package dto;

import model.Address;
import model.enums.AccountType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CustomerResponseDto {
    private UserResponseDto userResponseDto;
    private Integer credit;
    private Set<Address> addresses;
    private AccountType accountType;
    private List<OrderResponseDto> orderResponseDtoList;

    public UserResponseDto getUserResponseDto() {
        return userResponseDto;
    }

    public void setUserResponseDto(UserResponseDto userResponseDto) {
        this.userResponseDto = userResponseDto;
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

    public List<OrderResponseDto> getOrderResponseDtoList() {
        if (orderResponseDtoList ==  null) {
            return new ArrayList<>();
        }
        return orderResponseDtoList;
    }

    public void setOrderResponseDtoList(List<OrderResponseDto> orderResponseDtoList) {
        this.orderResponseDtoList = orderResponseDtoList;
    }
}
