//package com.rq.controller;
//
//import com.rq.service.UserDao;
//import com.rq.service.UserDaoImpl;
//import com.rq.bean.User;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.List;
//
//public class userServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String flag = req.getParameter("flag");
////        登录验证
//        if (flag != null && flag.equals("login")) {
//            String name = req.getParameter("name");
//            String password = req.getParameter("password");
//            User user = new User();
//            user.setName(name);
//            user.setPassword(password);
//            UserDao login = new UserDaoImpl();
//            try {
//                User loginUser = login.Login(user);
//                if (loginUser != null) {
//                    Integer id = loginUser.getId();
//                    String power = loginUser.getPower();
//                    req.setAttribute("name", name);
//                    HttpSession session = req.getSession();
//                    session.setAttribute("name", name);
//                    session.setAttribute("id", id);
//                    session.setAttribute("power", power);
//                    req.getRequestDispatcher("frame.jsp").forward(req, resp);
//                } else {
//                    req.setAttribute("errrormsg", "用户名密码错误");
//                    req.getRequestDispatcher("login.jsp").forward(req, resp);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        } else if (flag != null && flag.equals("getList")) {
//            UserDao list = new UserDaoImpl();//新建显示列表方法接口
//            try {
//                List<User> userlist = list.getUserlist();//调用显示列表方法
//                req.setAttribute("userlist", userlist);
//                req.getRequestDispatcher("userList.jsp").forward(req, resp);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            //注册
//
//
//        } else if (flag != null && flag.equals("register")) {
//            String name = req.getParameter("name");
//            String loginName = req.getParameter("loginName");
//            String password = req.getParameter("password");
//            String sex = req.getParameter("sex");
//            String birth = req.getParameter("birthDate");
//            String telNo = req.getParameter("telNo");
//            String home = req.getParameter("home");
//            String userType = req.getParameter("userType");
//
//
//            User user = new User();
//            user.setLoginName(loginName);
//            user.setTel(telNo);
//            user.setName(name);
//            user.setPassword(password);
//            user.setHome(home);
//            user.setSex(sex);
//            user.setBirth(birth);
//            user.setPower(userType);
//
//
//            UserDao dao = new UserDaoImpl();
//            boolean registerSuccess = false;
//            try {
//                registerSuccess = dao.Register(user);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            if (registerSuccess) {
//                UserDao list = new UserDaoImpl();//新建显示列表方法接口
//
//                List<User> userlist = null;//调用显示列表方法
//                try {
//                    userlist = list.getUserlist();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                resp.sendRedirect("/userServlet?flag=getList");
//            } else {
//                req.setAttribute("errorMag", "注册失败");
//                req.getRequestDispatcher("userList.jsp").forward(req, resp);
//            }
//
//
//            //搜索
//        } else if (flag != null && flag.equals("search")) {
//            String name = req.getParameter("name");
//            UserDao dao = new UserDaoImpl();
//            try {
//                List<User> userList = dao.selectByWhere(name);
//                req.setAttribute("userlist", userList);
//                req.getRequestDispatcher("userList.jsp").forward(req, resp);
//                req.setAttribute("searchName", name);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//            //视图
//        } else if (flag != null && flag.equals("view")) {
//            Integer id = Integer.parseInt(req.getParameter("id"));
//            UserDao dao = new UserDaoImpl();
//            User user = null;
//            try {
//                user = dao.getUserByid(id);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            if (user != null) {
//                req.setAttribute("user", user);
//                req.getRequestDispatcher("userView.jsp").forward(req, resp);
//            } else {
//                req.getRequestDispatcher("userList.jsp");
//            }
//
//            //更新
//
//        } else if (flag != null && flag.equals("getUserById")) {
//
//            Integer id = Integer.parseInt(req.getParameter("id"));
//            UserDao dao = new UserDaoImpl();
//            User user = null;
//            try {
//                user = dao.getUserByid(id);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            if (user != null) {
//                req.setAttribute("user", user);
//                req.getRequestDispatcher("userUpdate.jsp").forward(req, resp);
//            } else {
//                req.getRequestDispatcher("userList.jsp");
//
//            }
//        } else if (flag != null && flag.equals("update")) {
//
//            Integer id = Integer.parseInt(req.getParameter("id"));
//            String name = req.getParameter("name");
//            String sex = req.getParameter("sex");
//            String birth = req.getParameter("birth");
//            String home = req.getParameter("home");
//            String tel = req.getParameter("tel");
//            String power = req.getParameter("power");
//
//            User user = new User();
//            user.setId(id);
//            user.setTel(tel);
//            user.setName(name);
//            user.setBirth(birth);
//            user.setHome(home);
//            user.setSex(sex);
//            user.setPower(power);
//
//            UserDao dao = new UserDaoImpl();
//            boolean update = false;
//            try {
//                update = dao.update(user);
//                if (update) {
//                    resp.sendRedirect("/userServlet?flag=getList");
//                } else {
//                    resp.sendRedirect("update.jsp");
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        } else if (flag != null && flag.equals("delete")) {
//            Integer id = Integer.parseInt(req.getParameter("id"));
//            UserDao dao = new UserDaoImpl();
//            try {
//                boolean b = dao.deleteByid(id);
//                resp.sendRedirect("/userServlet?flag=getList");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else if (flag != null && flag.equals("modifyPS")) {
//            String ops = req.getParameter("oldPassword");
//            Integer id = (Integer) req.getSession().getAttribute("id");
//            String nps = req.getParameter("newPassword");
//            User user = new User();
//            user.setPassword(ops);
//            user.setId(id);
//            UserDao dao = new UserDaoImpl();
//            try {
//                boolean b = dao.checkPassword(user);
//                if (b == false) {
//                    User user1 = new User();
//                    UserDao dao1 = new UserDaoImpl();
//                    user1.setPassword(nps);
//                    user1.setId(id);
//                    boolean modify = false;
//                    modify = dao1.modifyPs(user1);
//                    resp.sendRedirect("main.jsp");
//                } else {
//                    req.getRequestDispatcher("updatePwd2.jsp").forward(req, resp);
//
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else if (flag != null && flag.equals("modifyPS2")) {
//            String ops = req.getParameter("oldPassword");
//            Integer id = Integer.parseInt(req.getParameter("id2"));
//            String nps = req.getParameter("newPassword");
//            User user = new User();
//            user.setPassword(ops);
//            user.setId(id);
//            UserDao dao = new UserDaoImpl();
//            try {
//                boolean b = dao.checkPassword(user);
//                if (b == false) {
//                    User user1 = new User();
//                    UserDao dao1 = new UserDaoImpl();
//                    user1.setPassword(nps);
//                    user1.setId(id);
//                    boolean modify = false;
//                    modify = dao1.modifyPs(user1);
//                    resp.sendRedirect("main.jsp");
//                } else {
//                    req.getRequestDispatcher("updatePwd2.jsp").forward(req, resp);
//
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }else if (flag != null && flag.equals("getId")){
//            String id2 = req.getParameter("id");
//            req.setAttribute("id2",id2);
//            req.getRequestDispatcher("updatePwd2.jsp").forward(req,resp);
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req,resp);
//    }
//}
