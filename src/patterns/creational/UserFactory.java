package patterns.creational;

public class UserFactory {
    public static User createUser(String userType, String name) {
        return switch (userType) {
            case "Admin" -> new Admin(name);
            case "Borrower" -> new Borrower(name);
            default -> throw new IllegalArgumentException("Неизвестный тип пользователя");
        };
    }
}
