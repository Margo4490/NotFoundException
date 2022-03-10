package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private final ProductRepository repository = new ProductRepository();
    private final Book coreJava = new Book();
    private final Smartphone coreJava1 = new Smartphone();
    private final Product product = new Product();
    private final Book book = new Book(1, "Алхимик", 2000, "Пауло Коэльо");
    private final Book book1 = new Book(2, "Снежная королева", 1000, "Ганс Христиан Андерсен");
    private final Book book2 = new Book(3, "Унесенные ветром", 999, "Маргарет Митчел");
    private final Smartphone smartphone = new Smartphone(4, "Iphone 11", 55000, "Apple");
    private final Smartphone smartphone1 = new Smartphone(5, "Samsung Galaxy s21", 51000, "Samsung");
    private final Book book3 = new Book(6, "Алхимик", 2050, "Майкл Скотт");



    @Test
    public void shouldSaveOneProduct() {
        repository.save(coreJava1);

        Product[] expected = new Product[]{coreJava1};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void save() {
        repository.save(book);
        repository.save(book1);
        repository.save(smartphone);


        Product[] expected = {book, book1, smartphone};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAll() {
        Product book = new Book(1, "Алхимик", 2000, "Пауло Коэльо");
        Product book1 = new Book(2, "Снежная королева", 1000, "Ганс Христиан Андерсен");
        Product book2 = new Book(3, "Унесенные ветром", 999, "Маргарет Митчел");
        Product smartphone = new Smartphone(4, "Iphone 11", 55000, "Apple");
        Product smartphone1 = new Smartphone(5, "Samsung Galaxy s21", 51000, "Samsung");
        Product book3 = new Book (6, "Алхимик", 2050, "Майкл Скотт");

        Product[] expected = {};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        repository.save(book);
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone);
        repository.save(smartphone1);
        repository.save(book3);

        repository.removeById(2);

        Product[] expected = {book, book2, smartphone, smartphone1, book3};
        Product[] actual = repository.findAll();


        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById245() {
        repository.save(book);
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone);
        repository.save(smartphone1);
        repository.save(book3);

        repository.removeById(2);
        repository.removeById(4);
        repository.removeById(5);

        Product[] expected = {book, book2,book3};
        Product[] actual = repository.findAll();


        assertArrayEquals(expected, actual);
    }


    @Test
    public void removeById5() {
        repository.save(book);
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone);
        repository.save(smartphone1);
        repository.save(book3);

        repository.removeById(5);

        Product[] expected = {book, book1, book2, smartphone, book3};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    public void findById() {
        repository.save(book);
        repository.save(book1);
        repository.save(book2);
        repository.save(smartphone);
        repository.save(smartphone1);
        repository.save(book3);

        repository.findById(4);

        Product[] expected = {book, book1, book2, smartphone, smartphone1, book3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}


