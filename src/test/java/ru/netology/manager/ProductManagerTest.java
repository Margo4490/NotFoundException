package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager managers = new ProductManager(repository);
    private final Book book = new Book(1, "Алхимик", 2000, "Пауло Коэльо");
    private final Book book1 = new Book(2, "Снежная королева", 1000, "Ганс Христиан Андерсен");
    private final Book book2 = new Book(3, "Унесенные ветром", 999, "Маргарет Митчел");
    private final Smartphone smartphone = new Smartphone(4, "Iphone 11", 55000, "Apple");
    private final Smartphone smartphone1 = new Smartphone(5, "Samsung Galaxy s21", 51000, "Samsung");
    private final Book book3 = new Book(6, "Алхимик", 2050, "Майкл Скотт");

    @Test

    public void addAllProducts() {
        managers.add(book);
        managers.add(book1);
        managers.add(book2);
        managers.add(smartphone);
        managers.add(smartphone1);
        managers.add(book3);


        Product[] expected = new Product[]{book, book1, book2, smartphone, smartphone1, book3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test

    public void addSmartphone() {
        managers.add(smartphone);

        Product[] expected = new Product[]{smartphone};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test

    public void add() {
        managers.add(smartphone);
        managers.add(book);
        managers.add(book1);

        Product[] expected = new Product[]{smartphone, book, book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test

    public void searchByУнесенныеВетром() {
        managers.add(book2);

        Product[] expected = new Product[]{book2};
        Product[] actual = managers.searchBy("Унесенные ветром");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBySamsungGalaxy() {
        managers.add(smartphone1);

        Product[] expected = new Product[]{smartphone1};
        Product[] actual = managers.searchBy("Samsung Galaxy s21");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByIphone() {
        managers.add(smartphone);

        Product[] expected = new Product[]{smartphone};
        Product[] actual = managers.searchBy("Iphone 11");
        assertArrayEquals(expected, actual);

    }

    @Test
    public void searchByСнежнаяКоролева() {
        managers.add(book1);

        Product[] expected = new Product[]{book1};
        Product[] actual = managers.searchBy("Снежная королева");
        assertArrayEquals(expected, actual);

    }

    @Test
    public void searchByManufacture() {

        Product[] expected = new Product[]{};
        Product[] actual = managers.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByAuthorАлхимик() {

        Product[] expected = new Product[]{};
        Product[] actual = managers.searchBy("Пауло Коэльо");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByAuthorBook1() {

        Product[] expected = new Product[]{};
        Product[] actual = managers.searchBy("Ганс Христиан Андерсен");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void searchByNameАлхимик() {
        managers.add(book);
        managers.add(book3);

        Product[] expected = new Product[]{book,book3};
        Product[] actual = managers.searchBy("Алхимик");
        assertArrayEquals(expected, actual);
    }
}