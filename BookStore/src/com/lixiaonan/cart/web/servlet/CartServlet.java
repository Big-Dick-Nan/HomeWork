package com.lixiaonan.cart.web.servlet;


import com.lixiaonan.util.BaseServlet;
import com.lixiaonan.book.dao.BookDao;
import com.lixiaonan.book.domain.Book;

import com.lixiaonan.cart.dao.CartDao;
import com.lixiaonan.cart.daomain.Cart;
import com.lixiaonan.cart.daomain.Cartltem;


import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends BaseServlet {
    private BookDao bs = new BookDao();
    private CartDao cd = new CartDao();

    public String addCart(HttpServletRequest request, HttpServletResponse response) throws  IOException {

    String bid = request.getParameter("bid");
    Book book = bs.queryByBid(bid);
    Cartltem cartItem = new Cartltem();
    cartItem.setBook(book);
    cartItem.setAmount(request.getParameter("count"));
    System.out.println(cartItem.getAmount());
    Cart cart = (Cart) request.getSession().getAttribute("cart");

    System.out.println(cart);
    Map<String, Cartltem> map = cart.getCart();
    System.out.println(cart.getCart());
    map.put(book.getBid(),cartItem);
    return "r:/jsps/cart/list.jsp";


}

       public String delete( HttpServletRequest request, HttpServletResponse response) throws IOException {

        Cart cart = (Cart)request.getSession().getAttribute("cart");
        String bid = request.getParameter("bid");
        cd.delete(cart,bid);
        return "r:/jsps/cart/list.jsp";
        }

        public String clearCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
            Cart cart = (Cart)request.getSession().getAttribute("cart");
            cd.clear(cart);
            return "r:/jsps/cart/list.jsp";
        }





}
