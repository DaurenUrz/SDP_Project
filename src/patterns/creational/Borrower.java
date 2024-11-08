package patterns.creational;

public class Borrower extends User {
    public Borrower(String name) {
        super(name);
    }

    @Override
    public String getPermissions() {
        return "Права заемщика";
    }
}
