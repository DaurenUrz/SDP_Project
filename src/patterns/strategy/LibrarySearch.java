package patterns.strategy;

public class LibrarySearch {
    private SearchStrategy strategy;

    public LibrarySearch(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public String executeSearch(String query) {
        return strategy.search(query);
    }

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }
}
