import java.util.Scanner;
import patterns.creational.*;
import patterns.structural.*;
import patterns.facade.*;
import patterns.observer.*;
import patterns.strategy.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        DatabaseConnection db1 = DatabaseConnection.getInstance(); // Singleton

        LibraryObservable libraryObservable = new LibraryObservable();
        Observer user1 = new UserObserver("Alice");
        Observer user2 = new UserObserver("Bob");
        libraryObservable.addSubscriber(user1);
        libraryObservable.addSubscriber(user2);

        LibraryFacade libraryFacade = new LibraryFacade();
        EbookService ebookService = new EbookService();
        EbookInterface adaptedService = new EbookAdapter(ebookService);
        LibrarySearch searchByTitle = new LibrarySearch(new TitleSearch());
        LibrarySearch searchByAuthor = new LibrarySearch(new AuthorSearch());

        System.out.println("Добро пожаловать в библиотечную систему!");

        while (!exit) {
            System.out.println("\nВыберите опцию:");
            System.out.println("1. Показать подключение к базе данных (Singleton)");
            System.out.println("2. Создать пользователя (Factory Method)");
            System.out.println("3. Получить электронную книгу (Adapter)");
            System.out.println("4. Взять книгу (Facade)");
            System.out.println("5. Получить уведомление о новой книге (Observer)");
            System.out.println("6. Поиск книги (Strategy)");
            System.out.println("7. Выйти");

            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Очищаем буфер после ввода числа

            switch (choice) {
                case 1 -> {
                    DatabaseConnection db2 = DatabaseConnection.getInstance();
                    System.out.println("Подключение к базе данных успешно. Один экземпляр: " + (db1 == db2));
                }
                case 2 -> {
                    System.out.print("Введите тип пользователя (Admin или Borrower): ");
                    String userType = scanner.nextLine();
                    System.out.print("Введите имя пользователя: ");
                    String name = scanner.nextLine();
                    User user = UserFactory.createUser(userType, name);
                    System.out.println("Создан пользователь: " + name + " с правами: " + user.getPermissions());
                }
                case 3 -> System.out.println("Электронная книга получена: " + adaptedService.getEbook());
                case 4 -> {
                    System.out.print("Введите имя пользователя: ");
                    String borrower = scanner.nextLine();
                    System.out.print("Введите название книги: ");
                    String book = scanner.nextLine();
                    System.out.println(libraryFacade.borrowBook(borrower, book));
                }
                case 5 -> {
                    System.out.print("Введите название новой книги для уведомлений: ");
                    String newBook = scanner.nextLine();
                    libraryObservable.addNewBook(newBook);
                }
                case 6 -> {
                    System.out.println("Выберите стратегию поиска: ");
                    System.out.println("1. Поиск по названию");
                    System.out.println("2. Поиск по автору");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();  // Очищаем буфер

                    if (searchChoice == 1) {
                        System.out.print("Введите название книги: ");
                        String title = scanner.nextLine();
                        System.out.println(searchByTitle.executeSearch(title));
                    } else if (searchChoice == 2) {
                        System.out.print("Введите имя автора: ");
                        String author = scanner.nextLine();
                        System.out.println(searchByAuthor.executeSearch(author));
                    } else {
                        System.out.println("Неверный выбор.");
                    }
                }
                case 7 -> {
                    System.out.println("Выход из системы...");
                    exit = true;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
        scanner.close();
    }
}
