package demo.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDao {

	private SimpleJdbcTemplate jdbcTemplate;

	@Autowired
	public void createTemplate(DataSource dataSource) {
		this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}

	public List<TestBean> findAll() {

		return jdbcTemplate.query("select * from test",
				new ParameterizedRowMapper<TestBean>() {

					@Override
					public TestBean mapRow(ResultSet rs, int rownum)
							throws SQLException {
						TestBean result = new TestBean();
						result.setId(rs.getInt(1));
						result.setName(rs.getString(2));
						return result;
					}
				});
	}

	public TestBean find(Integer id) {
		return (TestBean) jdbcTemplate.queryForObject("select * from test where id = ?",
				new ParameterizedRowMapper<TestBean>() {

					@Override
					public TestBean mapRow(ResultSet rs, int arg1)
							throws SQLException {
						TestBean result = new TestBean();
						result.setId(rs.getInt(1));
						result.setName(rs.getString(2));
						return result;
					}
				}, id);
	}

	public void insert(TestBean bean) {
		jdbcTemplate.update("insert into TEST VALUES ( ?, ? )", bean.getId(),
				bean.getName());

	}

	public void update(TestBean bean) {
		jdbcTemplate.update("update TEST SET NAME =  ? where id = ? ",
				bean.getName(), bean.getId());
	}

	public void delete(int id) {
		jdbcTemplate.update("delete TEST where id = ? ", id);

	}

}
