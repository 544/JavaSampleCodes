package demo.spring.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import utils.SimpleLogger;

@Service
public class SampleService {

	@Autowired
	private SampleDao dao;

	@Transactional
	public void doSomeThing() {
		
		TestBean bean1 = new TestBean(3,"piyoxs");
		dao.update(bean1);
		
		
		
		List<TestBean> list = dao.findAll();

		for (TestBean bean : list) {
			SimpleLogger.debug("..." +bean.toString());
		}

	}

	/**
	 * @return the dao
	 */
	public SampleDao getDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(SampleDao dao) {
		this.dao = dao;
	}

}
