package main.dto;

public class LoginResultDto {
    private final boolean success;
    private final String role;
    private final String userName;

    public LoginResultDto(boolean success, String role, String userName) {
        this.success = success;
        this.role = role;
        this.userName = userName;
    }
    public boolean isSuccess() { return success; }
    public String getRole() { return role; }
    public String getName() { return userName; }
}