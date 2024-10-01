# Validation Task using Spring Data JPA and Spring Validation

This project demonstrates a basic task to implement validation in a Spring Boot application using **Spring Data JPA** and **Spring Validation**. The task involves validating user input before saving it to the database.

## Task Description

The task is to create a user entity and apply validation rules to ensure that the user’s data is correctly formatted before being persisted to the database using **Spring Data JPA**.

## Key Technologies
- **Spring Boot**
- **Spring Data JPA**
- **Spring Validation**
- **MYSQL Database** (in-memory database for testing)
- **Maven**

## Validation Rules

1. **userName**: Should only contain alphabetic characters and spaces. Must be between 10 and 25 characters long.
   - Pattern: `^[a-zA-Z ]{10,25}$`
   
2. **userPassword**: Must contain at least one uppercase letter, one lowercase letter, one digit, and one special character. Length should be between 8 and 20 characters.
   - Pattern: `^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$`

3. **userEmail**: Must be a valid email format.
   - Pattern: `^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$`

4. **userNumberPhone**: Should be a valid Egyptian phone number, starting with 011, 012, 010, or 015 and followed by 8 digits.
   - Pattern: `^(011|012|010|015)\\d{8}$`

5. **userAddress**: Should be between 10 and 100 characters long.
   - Pattern: `^[a-zA-Z0-9\\s,.'-]{10,100}$`

## Example Code

### User Entity

```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Pattern(regexp = "^[a-zA-Z ]{10,25}$", message = "Name must be between 10 and 25 alphabetic characters")
    private String userName;

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$", message = "Password must be 8-20 characters long and include uppercase, lowercase, digits, and special characters")
    private String userPassword;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format")
    private String userEmail;

    @Pattern(regexp = "^(011|012|010|015)\\d{8}$", message = "Phone number must be a valid Egyptian number")
    private String userNumberPhone;

    @Pattern(regexp = "^[a-zA-Z0-9\\s,.'-]{10,100}$", message = "Address must be between 10 and 100 characters")
    private String userAddress;
}
