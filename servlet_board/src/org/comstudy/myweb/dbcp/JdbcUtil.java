package org.comstudy.myweb.dbcp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class JdbcUtil {
    public static Connection getConnection() {
        // JNDI를 이용한 커넥션 풀 - 커넥션 드라이버 찾기
        Connection conn = null;
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("jdbc/H2DB");

            conn = ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection obj) {
        try {
            if(obj != null) obj.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet obj) {
        try {
            if(obj != null) obj.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement obj) {
        try {
            if(obj != null) obj.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        close(rs);
        close(stmt);
        close(conn);
    }


}
