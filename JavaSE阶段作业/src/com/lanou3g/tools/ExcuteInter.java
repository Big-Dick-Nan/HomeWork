package com.lanou3g.tools;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface ExcuteInter {

Statement execute(Connection conn) throws SQLException;
}
