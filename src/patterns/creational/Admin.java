package patterns.creational;

public class Admin extends User {
    public Admin(String name) {
        super(name);
    }

    @Override
    public String getPermissions() {
        return "Права администратора";
    }
}
