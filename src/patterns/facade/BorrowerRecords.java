package patterns.facade;

public class BorrowerRecords {
    public String addRecord(String borrower, String book) {
        return borrower + " взял книгу: " + book;
    }
}
