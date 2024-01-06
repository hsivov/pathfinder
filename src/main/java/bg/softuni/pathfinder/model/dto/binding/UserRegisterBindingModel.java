package bg.softuni.pathfinder.model.dto.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {
    @Size(min = 3, message = "Username length must be more than 3 characters")
    private String username;
    @Size(min = 3, message = "Full name length must be more than 3 characters")
    private String fullName;
    @Email
    @NotBlank(message = "Must be valid email")
    private String email;
    @Positive(message = "Must be valid age")
    private int age;
    @Size(min = 5, max = 20, message = "Password length must be between 5 and 20 characters and passwords should match.")
    private String password;
    @Size(min = 5, max = 20, message = "Password length must be between 5 and 20 characters and passwords should match.")
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
