package com.rq.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rq.bean.Book;
import com.rq.bean.State;
import com.rq.bean.User;
import com.rq.service.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BookContorller {
    @Autowired
    BookDao bookDao;
    @Autowired
    HttpServletRequest request;


    @RequestMapping("/BookList.action")
    public ModelAndView BookList(@RequestParam(required = false,defaultValue = "1",value = "page")int page, Model model, Book book){
        ModelAndView mav =new ModelAndView();
        PageHelper.startPage(page,4);
        List<Book> bookList = bookDao.getBooklist(book);
        PageInfo pageInfo = new PageInfo(bookList);
        model.addAttribute("searchName",book.getName());
        model.addAttribute("searchAuthor",book.getAuthor());
        model.addAttribute("pageInfo",pageInfo);
        request.setAttribute("bookList",bookList);
        mav.setViewName("billList");
        return mav;
    }
    @RequestMapping("/BookList2.action")
    public ModelAndView BookList2(@RequestParam(required = false,defaultValue = "1",value = "page")int page, Model model, Book book){
        ModelAndView mav =new ModelAndView();
        PageHelper.startPage(page,4);
        List<Book> bookList = bookDao.getBooklist(book);
        PageInfo pageInfo = new PageInfo(bookList);
        model.addAttribute("searchName",book.getName());
        model.addAttribute("searchAuthor",book.getAuthor());
        model.addAttribute("pageInfo",pageInfo);
        mav.addObject("bookList",bookList);
        mav.setViewName("bill2");
        return mav;
    }
    @RequestMapping("/getBookByid.action")
    public ModelAndView getBookByid(Integer id){
        ModelAndView mav =new ModelAndView();
        Book book = null;
        book = bookDao.getBookByid(id);
        mav.addObject("book",book);
        mav.setViewName("billView");
        return mav;
    }
    @RequestMapping("/selectById.action")
    public ModelAndView selectById(Integer id){
        ModelAndView mav =new ModelAndView();
        Book book = null;
        book = bookDao.getBookByid(id);
        mav.addObject("book",book);
        mav.setViewName("billUpdate");
        return mav;
    }
    @RequestMapping("/registerBook.action")
    public String register(Book book) throws Exception {
        bookDao.Register(book);
        return "redirect:/BookList.action";
    }

    @RequestMapping("/deleteBook.action")
    public String delete(Book book) throws Exception {
        bookDao.deleteByid(book);
        return "forward:/BookList.action";
    }

    @RequestMapping("/updateBook.action")
    public String updateBook(Book book) throws Exception {
       bookDao.updateBook(book);
       return "redirect:/BookList.action";
    }

//    @RequestMapping("/selectBookByWhere.action")
//    public String selectBookByWhere(Book book) throws Exception {
//        List<Book> bookList =bookDao.selectBookByWhere(book);
//        request.setAttribute("bookList",bookList);
//        return "bill2";
//    }

    @RequestMapping("/lend.action")
    public String lend(State state) throws Exception {
      Integer userId = (Integer) request.getSession().getAttribute("id");
       state.setUserId(userId);
       bookDao.lend(state);
       bookDao.lendUpdate(state.getBookId());
       return "redirect:/BookList2.action";
    }

    }
