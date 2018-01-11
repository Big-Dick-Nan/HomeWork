package com.lixiaonan.book.web.servlet;

import com.lixiaonan.book.dao.BookDao;
import com.lixiaonan.book.domain.Book;
import com.lixiaonan.util.BaseServlet;


import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends BaseServlet {
    private BookDao bookDao = new BookDao();

    public String queryBook(HttpServletRequest request, HttpServletResponse response) {
        //获得传进来的bid
        String bid = request.getParameter("bid");
        //通过bid查找到book
       Book book = bookDao.queryByBid(bid);

        //把book对象传进requset请求中 然后再jsp文件获得对象 显示出来
        request.setAttribute("book", book);
        request.getSession().setAttribute("book",book);

        return "f:/jsps/book/desc.jsp";
    }
}
