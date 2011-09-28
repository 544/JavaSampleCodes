package demo.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class DemoService {

	@Autowired
	public DemoComponent comp;
}
