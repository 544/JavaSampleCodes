package demo.spring.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import utils.SimpleLogger;

public class SimpleJdbcClient {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"context/jdbcContext.xml");

		// dataSourceはSpringで作成。
		DataSource source = (DataSource) ctx.getBean("dataSource");
		Connection con = source.getConnection();
		Statement stat = con.createStatement();
		
		stat.execute("DELETE FROM TEST");
		stat.execute("INSERT INTO TEST VALUES (1,'huge')");
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM TEST WHERE NAME = ?");

		// バインドパラメータの設定
		ps.setString(1, "huge");
		
		// クエリ実行
		ResultSet resultset = ps.executeQuery();

		while (resultset.next()) {
			String a = resultset.getString(1);
			String b = resultset.getString(2);

			SimpleLogger.debug(a + ":" + b);
		}

		// コミット
		con.commit();
		
		resultset.close();
		stat.close();
		con.close();

	}
}
