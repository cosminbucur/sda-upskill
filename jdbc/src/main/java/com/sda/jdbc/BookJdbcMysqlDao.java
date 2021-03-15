package com.sda.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// implement this using jdbc prepared statements
public class BookJdbcMysqlDao implements BookRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_tutorial";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    @Override
    public Book create(Book book) {
        String query = "INSERT INTO book (title, author, publish_date) VALUES (? ,?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, String.valueOf(book.getPublishDate()));

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Insert failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    book.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Failed to get generated id");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> result = null;
        String query = "SELECT * FROM book";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            ResultSet resultSet = statement.executeQuery(query);

            result = new ArrayList<>();

            while (resultSet.next()) {
                Book bookInDb = new Book();
                bookInDb.setId(resultSet.getLong(1));
                bookInDb.setTitle(resultSet.getString(2));
                bookInDb.setAuthor(resultSet.getString(3));
                bookInDb.setPublishDate(resultSet.getDate(4).toLocalDate());
                result.add(bookInDb);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> result = null;
        String query = "SELECT * FROM book WHERE author = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            result = new ArrayList<>();
            statement.setString(1, author);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong(1));
                book.setTitle(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                book.setPublishDate(resultSet.getDate(4).toLocalDate());
                result.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Optional<Book> findById(Long id) {
        String query = "SELECT * FROM book WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            Book result = null;

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result = new Book();
                result.setId(resultSet.getLong(1));
                result.setTitle(resultSet.getString(2));
                result.setAuthor(resultSet.getString(3));
                result.setPublishDate(resultSet.getDate(4).toLocalDate());
            }
            return Optional.ofNullable(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        String query = "SELECT * FROM book WHERE title = ?";
        Book result = null;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result = new Book();
                result.setId(resultSet.getLong(1));
                result.setTitle(resultSet.getString(2));
                result.setAuthor(resultSet.getString(3));
                result.setPublishDate(resultSet.getDate(4).toLocalDate());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(result);
    }

    @Override
    public Book update(Long id, Book book) {
        String query = "UPDATE book SET title = ?, author = ?, publish_date = ?  WHERE id = ?";
        Book result = null;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setDate(3, Date.valueOf(book.getPublishDate()));
            statement.setLong(4, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Update failed, no rows affected.");
            } else {
                result = book;
                return result;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM book WHERE id = ? ; ";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setLong(1, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Delete failed, no rows affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
