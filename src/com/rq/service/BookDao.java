package com.rq.service;
import com.rq.bean.Book;
import com.rq.bean.State;
import java.util.List;


public interface BookDao {
    public List<Book> getBooklist(Book book);
   public List<Book> selectBookByWhere(Book book) throws Exception;
    public Book getBookByid(Integer id);
   public boolean updateBook(Book book) throws Exception;
   public boolean deleteByid(Book book) throws Exception;
   public boolean Register(Book book) throws Exception;
    public boolean lend(State state)throws Exception;
    public boolean lendUpdate(Integer id)throws Exception;
}
