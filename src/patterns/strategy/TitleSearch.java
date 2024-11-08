package patterns.strategy;

public class TitleSearch implements SearchStrategy {
    @Override
    public String search(String query) {
        return "Поиск книги с названием: " + query;
    }
}
