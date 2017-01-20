package lv.javaguru.java2.servlet.dto;

public class UserDto {

    private String userId;
    private String firstName;
    private String lastName;

    public UserDto() {
    }

    public UserDto(String userId){
        this.userId = userId;
    }

    public UserDto(String userId,
                   String firstName,
                   String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
