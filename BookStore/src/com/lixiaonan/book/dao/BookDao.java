package com.lixiaonan.book.dao;

import com.lixiaonan.book.domain.Book;
import com.lixiaonan.user.domain.User;
import com.lixiaonan.util.JdbcUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class BookDao {
    private QueryRunner qr = new QueryRunner();


    public List<Book> queryByCid(String Cid){
        String sql  = "select * from book where cid=?";
        Connection conn= JdbcUtil.getConnection();
        try {
            List<Book> books = qr.query(conn, sql, new BeanListHandler<Book>(Book.class),Cid);
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public List<Book> queryAll(){
        String sql = "select * from book";
        Connection coon = JdbcUtil.getConnection();
        try {
            List<Book> book = qr.query(coon, sql, new BeanListHandler<Book>(Book.class));
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public  Book queryByBid(String bid){
        String sql  = "select * from book where bid=?";
        Connection conn= JdbcUtil.getConnection();
        try {
           Book book = qr.query(conn, sql, new BeanHandler<Book>(Book.class),bid);
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
