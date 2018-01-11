package com.lixiaonan.order.web.servlet;

import com.lixiaonan.util.BaseServlet;
import com.lixiaonan.book.dao.BookDao;
import com.lixiaonan.book.domain.Book;

import com.lixiaonan.cart.dao.CartDao;
import com.lixiaonan.cart.daomain.Cart;
import com.lixiaonan.order.domain.Order;
import com.lixiaonan.order.domain.OrderItem;
import com.lixiaonan.order.service.FailureException;
import com.lixiaonan.order.service.OrderService;

import com.lixiaonan.user.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@WebServlet(name = "OrderServlet",urlPatterns = "/order")
public class OrderServlet extends BaseServlet {
    private OrderService os = new OrderService();
    private CartDao cd = new CartDao();
    private BookDao bs = new BookDao();
    public String add(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        String total = request.getParameter("total");
        Order order = new Order();
        BigDecimal bigDecimal = new BigDecimal(total);
        order.setTotal(bigDecimal);
        User user = (User)request.getSession().getAttribute("user");
        order.setUid(user.getUid());
        os.add(order);
        request.getSession().setAttribute("order",order);
        os.addOrderItem(cart, order);
        request.getSession().setAttribute("ordercart",cart);
        request.getSession().setAttribute("cart",new Cart());

        return  "r:/jsps/order/desc.jsp";
    }
    public String myOrders(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Book> books = bs.queryAll();
        request.getSession().setAttribute("books",books);
        User user = (User)request.getSession().getAttribute("user");
        List<Order> order = os.findByUid(user.getUid());
        Map<Order,List<OrderItem>> orders = os.findByOid(order);
        request.getSession().setAttribute("orderitem",orders);

        return "r:/jsps/order/list.jsp";

    }

    public String load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oid = request.getParameter("oid");
        List<OrderItem> byOid = os.findOrderItemByOid(oid);
        request.setAttribute("byoid",byOid);
        Order order = os.findByOid(oid);
        request.getSession().setAttribute("order",order);
        return "r:/jsps/order/desc.jsp";
    }


    public String confirm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String oid = request.getParameter("oid");
        try {
            os.confirm(oid);
            request.setAttribute("msg","已确认收货");

            return "r:/jsps/order/list.jsp";
        } catch (FailureException e) {
            request.getSession().setAttribute("msg",e.getMessage());

            return "r:/jsps/msg.jsp";
        }


    }


}
