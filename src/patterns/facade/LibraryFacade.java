package patterns.facade;

public class LibraryFacade {
    private final Inventory inventory = new Inventory();
    private final BorrowerRecords records = new BorrowerRecords();
    private final NotificationSystem notifications = new NotificationSystem();

    public String borrowBook(String borrower, String book) {
        if (inventory.checkAvailability(book).contains("наличия")) {
            records.addRecord(borrower, book);
            return notifications.notifyUser(borrower, "Вы взяли книгу: " + book);
        }
        return "Книга недоступна";
    }
}
