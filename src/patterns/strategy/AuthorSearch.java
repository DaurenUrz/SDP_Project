package patterns.strategy;

public class AuthorSearch implements SearchStrategy {
    @Override
    public String search(String query) {
        return "Поиск книг автора: " + query;
    }
}
