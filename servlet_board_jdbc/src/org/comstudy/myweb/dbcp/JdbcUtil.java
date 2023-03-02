package org.comstudy.myweb.dbcp;

import java.sql.*;

public class JdbcUtil {
    public static Connection getConnection() {
        // JDBC 연동 - 커넥션 드라이버 찾기
        String url = "jdbc:h2:~/test";
        String user = "sa";
        String password = "";
        Connection conn = null;
        try {
            Class.forName("org.h2.Driver"); // 드라이보 검색 => 인스턴스화
            System.out.println("드라이버 검색 성공");
            conn = DriverManager.getConnection(url,user,password);
            System.out.println(conn);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 검색 실패");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("SQL 오류");
            throw new RuntimeException(e);
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
