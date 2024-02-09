package org.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Delete {
  // localhost の 5432 ポート、データベース test に接続
  private static final String URL = "jdbc:postgresql://localhost:5432/test";
  private static final String SQL = "DELETE FROM memo WHERE id = ?";
  public static void main(String[] args) throws SQLException {
    // DB のユーザ名を usr、パスワードを pass に設定
    Properties props = new Properties();
    props.setProperty("user", "usr");
    props.setProperty("password", "111");
    try (
      // コネクションを取得して、プリペアド文を作成
      Connection con = DriverManager.getConnection(URL, props);
      PreparedStatement ps = con.prepareStatement(SQL)
    ) {
      // SQL の１番目の ? に値を設定して実行
      ps.setInt(1, 4);
      ps.executeUpdate();
    }
  }
}
