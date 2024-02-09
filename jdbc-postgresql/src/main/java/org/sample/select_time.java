package org.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class select_time {
    // localhost の 5432 ポート、データベース test に接続
    private static final String URL = "jdbc:postgresql://localhost:5432/test";
    private static final String SQL = "SELECT create_time FROM memo WHERE id = ?";
    
    public static void main(String[] args) throws SQLException {
        // DB のユーザ名を usr、パスワードを pass に設定
        Properties props = new Properties();
        props.setProperty("user", "usr");
        props.setProperty("password", "111");
        
        // 要查询的记录的 ID
        int idToQuery = 5; // 要查询的记录的 ID
        
        try (
            // 获取连接并创建 PreparedStatement
            Connection con = DriverManager.getConnection(URL, props);
            PreparedStatement ps = con.prepareStatement(SQL)
        ) {
            // 设置 PreparedStatement 中的参数为要查询的记录的 ID
            ps.setInt(1, idToQuery);
            
            // 执行查询操作并获取结果集
            try (ResultSet rs = ps.executeQuery()) {
                // 遍历结果集并处理结果
                while (rs.next()) {
                    // 从结果集中获取 create_time 字段的值并打印
                    String createTime = rs.getString("create_time");
                    System.out.println("Create Time: " + createTime);
                }
            }
        }
    }
}

