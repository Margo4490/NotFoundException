package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager managers = new ProductManager(repository);
    private final Book book = new Book(1, "Война и мир", 2000, "Л.Н.Толстой");
    private final Book book1 = new Book(2, "Снежная королева", 1000, "Ганс Христиан Андерсен");
    private final Book book2 = new Book(3, "Унесенные ветром", 999, "Маргарет Митчел");
    private final Smartphone smartphone = new Smartphone(4, "Iphone 11", 55000, "Apple");
    private final Smartphone smartphone1 = new Smartphone(5, "Samsung Galaxy s21", 51000, "Samsung");

    @Test

    public void add() {
        managers.add(book);
        managers.add(book1);
        managers.add(book2);
        managers.add(smartphone);
        managers.add(smartphone1);


        Product[] expected = new Product[]{book, book1, book2, smartphone, smartphone1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test

    public void add1() {
        managers.add(smartphone);

        Product[] expected = new Product[]{smartphone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test

    public void add2() {
        managers.add(smartphone);
        managers.add(book);
        managers.add(book1);
        Product[] expected = new Product[]{smartphone, book, book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test

    public void searchBy() {
        managers.add(book2);

        Product[] expected = new Product[]{book2};
        Product[] actual = managers.searchBy("Унесенные ветром");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBy1() {
        managers.add(smartphone1);

        Product[] expected = new Product[]{smartphone1};
        Product[] actual = managers.searchBy("Samsung Galaxy s21");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBy2() {
        managers.add(book);

        Product[] expected = new Product[]{book};
        Product[] actual = managers.searchBy("Война и мир");

        assertArrayEquals(expected, actual);

    }

    @Test
    public void searchBy3() {
        managers.add(book1);

        Product[] expected = new Product[]{book1};
        Product[] actual = managers.searchBy("Снежная королева");

        assertArrayEquals(expected, actual);

    }

    @Test
    public void searchByAuthorBook1() {

        Product[] expected = new Product[] {};
        Product[] actual = managers.searchBy("Ганс Христиан Андерсен");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByManufacture(){

        Product[] expected = new Product[]{};
        Product[] actual = managers.searchBy("Apple");

        assertArrayEquals(expected,actual);
    }


}