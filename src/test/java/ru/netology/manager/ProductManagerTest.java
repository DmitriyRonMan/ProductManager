package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(01, "12 Стульев", 450, "Дж. Толкин");
    Product book2 = new Book(02, "Тарас Бульба", 230, "Н. Гоголь");
    Product book3 = new Book(03, "Война и мир", 350, "Л. Толстой");
    Product smartphone1 = new Smartphone(04, "iPhone 12", 40_990, "Apple");
    Product smartphone2 = new Smartphone(05, "Galaxy S22Ultra 8", 74_990, "Samsung");
    Product smartphone3 = new Smartphone(06, "Redmi 10C", 10_990, "Xiaomi");

    @Test
    public void addProductTestMin() {
        manager.add(book1);

        Product[] expected = {book1};
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addProductTestMax() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.getItems();
    }

    @Test
    public void addProductTestWithin() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {book1, book2, smartphone2, smartphone3};
        Product[] actual = repository.getItems();
    }

    @Test
    public void searchProductTestName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        String name = "Тарас Бульба";

        Product[] expected = {book2};
        Product[] actual = manager.searchBy(name);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchProductTestNull() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        String name = "Nokia";

        Product[] expected = {};
        Product[] actual = manager.searchBy(name);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchProductTestTwoValues() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        String name = "12";

        Product[] expected = {book1, smartphone1};
        Product[] actual = manager.searchBy(name);

        Assertions.assertArrayEquals(expected, actual);
    }

}
