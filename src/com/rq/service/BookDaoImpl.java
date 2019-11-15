package com.rq.service;

import com.rq.bean.Book;
import com.rq.bean.State;
import com.rq.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookDaoImpl implements BookDao {
    @Autowired
    BookMapper bookMapper;
    @Override
    public List<Book> getBooklist(Book book){
        return bookMapper.getBooklist(book);
    }

    @Override
    public List<Book> selectBookByWhere(Book book) throws Exception {
        return bookMapper.selectBookByWhere(book);
    }

    @Override
    public Book getBookByid(Integer id) {

        return bookMapper.getBookByid(id);
    }

    @Override
    public boolean updateBook(Book book) throws Exception {
        return bookMapper.updateBook(book);
    }

    @Override
    public boolean deleteByid(Book book) throws Exception {
        return bookMapper.deleteByid(book);
    }

    @Override
    public boolean Register(Book book) throws Exception {
        return bookMapper.Register(book);
    }

    @Override
    public boolean lend(State state) throws Exception {
        return bookMapper.lend(state);
    }

    @Override
    public boolean lendUpdate(Integer id) throws Exception {
        return bookMapper.lendUpdate(id);
    }
//    @Override
//    public List<Book> getBooklist() throws Exception {
//        Connection connection = DbConnection.getConnection();
//        List<Book> booklist = new ArrayList<>();
//        String sql = "select  b.id,b.name,b.author,b.publisher,u.name from book as b left join state as s on s.bookid=b.id left join user u on s.userid = u.id";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            Book book = new Book();
//            book.setId(resultSet.getInt(1));
//            book.setName(resultSet.getString(2));
//            book.setAuthor(resultSet.getString(3));
//            book.setPublisher(resultSet.getString(4));
//            book.setLendName(resultSet.getString(5));
//            String LendName = book.getLendName();
//            if (LendName == null || LendName == "") {
//                book.setLend("否");
//            } else {
//                book.setLend("是");
//            }
//            booklist.add(book);
//        }
//        DbConnection.closeSource(resultSet, preparedStatement, connection);
//        return booklist;
//    }
//
//    @Override
//    public List<Book> selectByWhere(String name, String author,String lend) throws Exception {
//        List<Book> bookList = new ArrayList<>();
//        Book book = null;
//        String sql = "";
//        PreparedStatement preparedStatement = null;
//        Connection connection = DbConnection.getConnection();
//        if (name != null && !name.equals("") &&author != null && !author.equals("")&&lend != null && lend.equals("是")){
//            sql = "select b.id,b.name,b.author,b.publisher,u.name from  state as s left join book as b on s.bookid=b.id left join user u on s.userid = u.id";
//            preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                if (resultSet.getString(2)==name && resultSet.getString(3)==author){
//                        book.setName(name);
//                    book.setId(resultSet.getInt(1));
//                    book.setAuthor(resultSet.getString(3));
//                    book.setPublisher(resultSet.getString(4));
//                    book.setLend("是");
//                    bookList.add(book);
//                }
//            }
//        } else if (name == null && name.equals("") &&author != null && !author.equals("")&&lend != null && lend.equals("是")){
//            sql = "select b.id,b.name,b.author,b.publisher,u.name from  state as s left join book as b on s.bookid=b.id left join user u on s.userid = u.id";
//            preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                if (resultSet.getString(3)==author){
//                    book.setName(resultSet.getString(2));
//                    book.setId(resultSet.getInt(1));
//                    book.setAuthor(resultSet.getString(3));
//                    book.setPublisher(resultSet.getString(4));
//                    book.setLend("是");
//                    bookList.add(book);
//                }
//            }
//        }else if (name != null && !name.equals("") &&author == null && author.equals("")&&lend != null && lend.equals("是")){
//            sql = "select b.id,b.name,b.author,b.publisher,u.name from  state as s left join book as b on s.bookid=b.id left join user u on s.userid = u.id";
//            preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                if (resultSet.getString(2)==name){
//                    book.setName(resultSet.getString(2));
//                    book.setId(resultSet.getInt(1));
//                    book.setAuthor(resultSet.getString(3));
//                    book.setPublisher(resultSet.getString(4));
//                    book.setLend("是");
//                    bookList.add(book);
//                }
//        }
//        } else if (name == null && name.equals("") &&author == null && author.equals("")&&lend != null && lend.equals("是")){
//            sql = "select b.id,b.name,b.author,b.publisher,u.name from  state as s left join book as b on s.bookid=b.id left join user u on s.userid = u.id";
//            preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                    book.setName(resultSet.getString(2));
//                    book.setId(resultSet.getInt(1));
//                    book.setAuthor(resultSet.getString(3));
//                    book.setPublisher(resultSet.getString(4));
//                    book.setLend("是");
//                    bookList.add(book);
//            }
//        }else if (name != null && !name.equals("") &&author != null && !author.equals("")&&lend != null && lend.equals("否")){
//            sql = "select b.id,b.name,b.author,b.publisher,u.name from book as b  left join state as s on s.bookid=b.id left join user u on s.userid = u.id";
//            preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                if (resultSet.getString(5)==null && resultSet.getString(2)==name&& resultSet.getString(3)==author){
//                    book.setName(resultSet.getString(2));
//                    book.setId(resultSet.getInt(1));
//                    book.setAuthor(resultSet.getString(3));
//                    book.setPublisher(resultSet.getString(4));
//                    book.setLend("是");
//                    bookList.add(book);
//                }
//            }
//        }else if (name == null && name.equals("") &&author != null && !author.equals("")&&lend != null && lend.equals("否")){
//            sql = "select b.id,b.name,b.author,b.publisher,u.name from book as b  left join state as s on s.bookid=b.id left join user u on s.userid = u.id";
//            preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                if (resultSet.getString(5)==null && resultSet.getString(3)==author){
//                    book.setName(resultSet.getString(2));
//                    book.setId(resultSet.getInt(1));
//                    book.setAuthor(resultSet.getString(3));
//                    book.setPublisher(resultSet.getString(4));
//                    book.setLend("是");
//                    bookList.add(book);
//                }
//            }
//        }else if (name != null && !name.equals("") && author == null && author.equals("")&&lend != null && lend.equals("否")){
//            sql = "select b.id,b.name,b.author,b.publisher,u.name from book as b  left join state as s on s.bookid=b.id left join user u on s.userid = u.id";
//            preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                if (resultSet.getString(5)==null && resultSet.getString(2)==name){
//                    book.setName(resultSet.getString(2));
//                    book.setId(resultSet.getInt(1));
//                    book.setAuthor(resultSet.getString(3));
//                    book.setPublisher(resultSet.getString(4));
//                    book.setLend("是");
//                    bookList.add(book);
//                }
//            }
//        }else if (name == null && name.equals("") &&author == null && author.equals("")&&lend != null && lend.equals("否")){
//            sql = "select b.id,b.name,b.author,b.publisher,u.name from book as b  left join state as s on s.bookid=b.id left join user u on s.userid = u.id";
//            preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                if (resultSet.getString(5)==null){
//                    book.setName(resultSet.getString(2));
//                    book.setId(resultSet.getInt(1));
//                    book.setAuthor(resultSet.getString(3));
//                    book.setPublisher(resultSet.getString(4));
//                    book.setLend("是");
//                    bookList.add(book);
//                }
//            }
//        }else {
//            sql = "select  b.id,b.name,b.author,b.publisher,u.name from book as b left join state as s on s.bookid=b.id left join user u on s.userid = u.id";
//            preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                book.setId(resultSet.getInt(1));
//                book.setName(resultSet.getString(2));
//                book.setAuthor(resultSet.getString(3));
//                book.setPublisher(resultSet.getString(4));
//                book.setLendName(resultSet.getString(5));
//                String LendName = book.getLendName();
//                if (LendName == null || LendName == "") {
//                    book.setLend("否");
//                } else {
//                    book.setLend("是");
//                }
//            }
//        } return bookList;
//    }
//    @Override
//    public Book getBookByid(Integer id) throws Exception {
//        Book book = null;
//        Connection connection = DbConnection.getConnection();
//        String sql = "select * from book where id=?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, id);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            book = new Book();
//            book.setId(resultSet.getInt(1));
//            book.setName(resultSet.getString(2));
//            book.setPublisher(resultSet.getString(4));
//            book.setAuthor(resultSet.getString(3));
//            book.setLend(resultSet.getString(5));
//        }
//        return book;
//    }
//
//    @Override
//    public boolean update(Book book) throws Exception {
//        Connection connection = DbConnection.getConnection();
//        String sql = "update book  set name=?,author=?,publisher=? ,lend=? where id=?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, book.getName());
//        preparedStatement.setString(2, book.getAuthor());
//        preparedStatement.setString(3, book.getPublisher());
//        preparedStatement.setString(4, book.getLend());
//        preparedStatement.setInt(5, book.getId());
//        int i = preparedStatement.executeUpdate();
//        if (i > 0) {
//            return true;
//        }
//        DbConnection.closeSource(null, preparedStatement, connection);
//        return false;
//    }
//
//    @Override
//    public boolean deleteByid(Integer id) throws Exception {
//        Connection connection = DbConnection.getConnection();
//        String sql = "delete  from  book  where id=?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, id);
//        int i = preparedStatement.executeUpdate();
//        if (i > 0) {
//            return true;
//        }
//        DbConnection.closeSource(null, preparedStatement, connection);
//        return false;
//    }
//
//    @Override
//    public boolean Register(Book book) throws Exception {
//        Connection connection = DbConnection.getConnection();
//        String sql = "insert into book values(?,?,?,?,?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, 0);
//        preparedStatement.setString(2, book.getName());
//        preparedStatement.setString(3, book.getAuthor());
//        preparedStatement.setString(4, book.getPublisher());
//        preparedStatement.setString(5, book.getLend());
//        int result = preparedStatement.executeUpdate();
//        if (result > 0) {
//            return true;
//        }
//        DbConnection.closeSource(null, preparedStatement, connection);
//        return false;
//    }
//    @Override
//    public boolean lend(State state) throws Exception {
//        Connection connection = DbConnection.getConnection();
//        String sql = "insert into state values(?,?,?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, 0);
//        preparedStatement.setInt(2,state.getBookId());
//        preparedStatement.setInt(3,state.getUserId());
//        int result = preparedStatement.executeUpdate();
//        if (result > 0) {
//            return true;
//        }
//        DbConnection.closeSource(null, preparedStatement, connection);
//        return false;

}
