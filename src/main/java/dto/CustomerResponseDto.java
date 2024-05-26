package dto;

import model.enums.AccountType;

import java.util.ArrayList;
import java.util.List;

public class CustomerResponseDto {
    private UserResponseDto userResponseDto;
    private Integer credit;
    private AccountType accountType;
    private List<OrderResponseDto> orderResponseDtoList;
    private Integer score;

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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
