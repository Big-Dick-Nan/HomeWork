package com.lixiaonan.category.dao;

import com.lixiaonan.category.domain.Category;
import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class CategoryDao {
    private QueryRunner qr = new QueryRunner();

    public Category queryAll() {
        Connection conn = null;
        String sql = "select * from category";
        try {
           Category formDb = qr.query(conn, sql, new BeanHandler<Category>(Category.class));
            return formDb;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
