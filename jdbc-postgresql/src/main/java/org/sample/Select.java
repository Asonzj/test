package org.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Select {
  // localhost の 5432 ポート、データベース test に接続
  private static final String URL = "jdbc:postgresql://localhost:5432/test";
  private static final String SQL = "SELECT id, txt FROM memo WHERE id = ?";
  public static void main(String[] args) throws SQLException {
    // DB のユーザ名を usr、パスワードを pass に設定
    Properties props = new Properties();
    props.setProperty("user", "usr");
    props.setProperty("password", "111");
    try (
      // コネクションを取得してプリペアド文を作成
      Connection con = DriverManager.getConnection(URL, props);
      PreparedStatement ps = con.prepareStatement(SQL)
    ) {
      // SQL の１番目の ? に数値を設定して実行
      ps.setInt(1, 2);
      try (ResultSet rs = ps.executeQuery()) {
        // 実行結果のデータを表示
        while (rs.next()) {
          System.out.print("id=");
          System.out.print(rs.getInt(1));
          System.out.print(", txt=");
          System.out.println(rs.getString(2));
        }
      }
    }
  }
}
