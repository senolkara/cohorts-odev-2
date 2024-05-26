package dto;

public class AuthorRequestDto {
    private UserRequestDto userRequestDto;
    private String bio;

    public UserRequestDto getUserRequestDto() {
        return userRequestDto;
    }

    public void setUserRequestDto(UserRequestDto userRequestDto) {
        this.userRequestDto = userRequestDto;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
