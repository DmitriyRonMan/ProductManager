package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Product book1 = new Book(01, "Властелин колец", 450, "Дж. Толкин");
    Product book2 = new Book(02, "Тарас Бульба", 230, "Н. Гоголь");
    Product book3 = new Book(03, "Война и мир", 350, "Л. Толстой");
    Product smartphone1 = new Smartphone(04, "iPhone 12", 40_990, "Apple");
    Product smartphone2 = new Smartphone(05, "Galaxy S22Ultra 8", 74_990, "Samsung");
    Product smartphone3 = new Smartphone(06, "Redmi 10C", 10_990, "Xiaomi");

    @Test
    public void saveProductTestMax() {
        repository.saveProduct(book1);
        repository.saveProduct(book2);
        repository.saveProduct(book3);
        repository.saveProduct(smartphone1);
        repository.saveProduct(smartphone2);
        repository.saveProduct(smartphone3);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveProductTestMin() {
        repository.saveProduct(book1);

        Product[] expected = {book1};
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveProductTestWithin() {
        repository.saveProduct(book1);
        repository.saveProduct(book2);
        repository.saveProduct(smartphone2);
        repository.saveProduct(smartphone3);

        Product[] expected = {book1, book2, smartphone2, smartphone3};
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveProductTestNull() {

        Product[] expected = {};
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void removeByIdProductTestMin() {
        repository.saveProduct(book1);
        repository.saveProduct(book2);
        repository.saveProduct(book3);
        repository.saveProduct(smartphone1);
        repository.saveProduct(smartphone2);
        repository.saveProduct(smartphone3);
        repository.removeByIdProduct(04);

        Product[] expected = {book1, book2, book3, smartphone2, smartphone3};
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdProductTestMax() {
        repository.saveProduct(book1);
        repository.saveProduct(book2);
        repository.saveProduct(book3);
        repository.saveProduct(smartphone1);
        repository.saveProduct(smartphone2);
        repository.saveProduct(smartphone3);
        repository.removeByIdProduct(01);
        repository.removeByIdProduct(02);
        repository.removeByIdProduct(03);
        repository.removeByIdProduct(04);
        repository.removeByIdProduct(05);
        repository.removeByIdProduct(06);

        Product[] expected = {};
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdProductTestWithin() {
        repository.saveProduct(book1);
        repository.saveProduct(book2);
        repository.saveProduct(book3);
        repository.saveProduct(smartphone1);
        repository.saveProduct(smartphone2);
        repository.saveProduct(smartphone3);
        repository.removeByIdProduct(01);
        repository.removeByIdProduct(02);
        repository.removeByIdProduct(05);
        repository.removeByIdProduct(06);

        Product[] expected = {book3, smartphone1};
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }


}
