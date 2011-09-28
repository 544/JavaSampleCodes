package demo.spring.aop;

import org.springframework.stereotype.Service;

import utils.LoggerUtils;

@Service
class Service1 {

	public String doIt(String str) {
		System.out.println("Called .. " + LoggerUtils.getSig());

		return str;
	}
}
