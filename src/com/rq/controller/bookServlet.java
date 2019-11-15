//package com.rq.controller;
//
//import com.rq.service.BookDao;
//import com.rq.service.BookDaoImpl;
//import com.rq.bean.Book;
//import com.rq.bean.State;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//import java.util.List;
//
//public class bookServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    String flag = req.getParameter("flag");
//    if (flag != null && flag.equals("bookList")){
//        BookDao bookDao =new BookDaoImpl();
//        try {
//            List<Book>   bookList = bookDao.getBooklist();
//            HttpSession session = req.getSession();
//            req.setAttribute("bookList",bookList);
//            req.getRequestDispatcherr("billList.jsp").forwad(req,resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }else if (flag != null && flag.equals("bookList2")){
//        BookDao bookDao =new BookDaoImpl();
//        try {
//            List<Book>  bookList = bookDao.getBooklist();
//            req.setAttribute("bookList",bookList);
//            req.getRequestDispatcher("bill2.jsp").forward(req,resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }else if (flag != null && flag.equals("bookView")){
//
//        Integer id = Integer.parseInt(req.getParameter("id"));
//        BookDao dao = new BookDaoImpl();
//        Book book = null;
//        try {
//            book = dao.getBookByid(id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (book != null) {
//            req.setAttribute("book", book);
//            req.getRequestDispatcher("billView.jsp").forward(req, resp);
//        } else {
//            req.getRequestDispatcher("userList.jsp");
//
//        }
//    }else if (flag != null && flag.equals("selectById")){
//        Integer id = Integer.parseInt(req.getParameter("id"));
//        BookDao dao = new BookDaoImpl();
//        Book book = null;
//        try {
//            book = dao.getBookByid(id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (book != null) {
//            req.setAttribute("book", book);
//            req.getRequestDispatcher("billUpdate.jsp").forward(req, resp);
//        } else {
//            req.getRequestDispatcher("userList.jsp");
//        }
//
//
//        }else if (flag != null && flag.equals("register")){
//        String bookName = req.getParameter("productName");
//        String author = req.getParameter("productUnit");
//        String publisher = req.getParameter("proId");
//        String lend=req.getParameter("payed");
//
//        Book book = new Book();
//        book.setName(bookName);
//        book.setAuthor(author);
//        book.setPublisher(publisher);
//        book.setLend(lend);
//        BookDao dao = new BookDaoImpl();
//        boolean registerSuccess = false;
//        try {
//            registerSuccess =dao.Register(book);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (registerSuccess){
//            resp.sendRedirect("/bookServlet?flag=bookList");
//        }
//
//
//    }else if (flag != null && flag.equals("delete")){
//            Integer id = Integer.parseInt(req.getParameter("id"));
//            BookDao dao = new BookDaoImpl();
//            try {
//                boolean b=dao.deleteByid(id);
//                resp.sendRedirect("/bookServlet?flag=bookList");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//        }else if (flag != null && flag.equals("search")){
//        String name = req.getParameter("productName");
//        String author =req.getParameter("proName");
//        String lend = req.getParameter("payed");
//        BookDao dao = new BookDaoImpl();
//        try {
//            List<Book> bookList = dao.selectByWhere(name,author,lend);
//            req.setAttribute("bookList",bookList);
//            req.getRequestDispatcher("billList.jsp");
//            req.setAttribute("searchName", name);
//            req.setAttribute("searchauthor",author);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }else if (flag != null && flag.equals("update")){
//            String bookName = req.getParameter("productName");
//            String author = req.getParameter("productUnit");
//            String publisher = req.getParameter("proId");
//            String lend =req.getParameter("payed");
//            Integer id =Integer.parseInt(req.getParameter("id"));
//        Book book = new Book();
//        book.setName(bookName);
//        book.setAuthor(author);
//        book.setPublisher(publisher);
//        book.setLend(lend);
//        book.setId(id);
//        BookDao dao = new BookDaoImpl();
//        boolean update = false;
//        try {
//            update = dao.update(book);
//            resp.sendRedirect("/bookServlet?flag=bookList");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//     }else if (flag != null && flag.equals("lend")){
//     Integer bookId =Integer.parseInt(req.getParameter("id")) ;
//     Integer userId = (Integer) req.getSession().getAttribute("id");
//        State state = new State();
//        state.setBookId(bookId);
//        state.setUserId(userId);
//
//        BookDao dao = new BookDaoImpl();
//
//        try {
//            boolean b = dao.lend(state);
//            if (b){
//                resp.sendRedirect("/bookServlet?flag=bookList2");
//            }
//        } catch (Exception e) {
//             e.printStackTrace();
//        }
//    }
//    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req,resp);
//    }
//}
