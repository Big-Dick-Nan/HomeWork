package com.lixiaonan.category.web.servlet;

import com.lixiaonan.book.dao.BookDao;
import com.lixiaonan.book.domain.Book;
import com.lixiaonan.book.service.BookService;
import com.lixiaonan.util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CateGoryServlet",urlPatterns = "/cate")
public class CateGoryServlet extends BaseServlet {
    private BookDao bs = new BookDao();
    public String queryAll(HttpServletRequest request, HttpServletResponse response){
        List<Book> books = bs.queryAll();
        request.setAttribute("book",books);
        return  "f:/jsps/book/list.jsp";
    }

    public String queryCid(HttpServletRequest request,HttpServletResponse response){
        String cid = request.getParameter("cid");
        if (cid.equals("1")){
            List<Book> books = bs.queryByCid(cid);
            request.setAttribute("book",books);
        }else if (cid.equals("2")){
            List<Book> books = bs.queryByCid(cid);
            request.setAttribute("book",books);
        }else if (cid.equals("3")){
            List<Book> books = bs.queryByCid(cid);
            request.setAttribute("book",books);
        }
        return  "f:/jsps/book/list.jsp";
    }
}
