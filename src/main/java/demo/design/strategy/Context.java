package demo.design.strategy;

import utils.LoggerUtils;

class Context {
	Strategy strategy;
	
	public void doSomething() {
		
		System.out.println("���ʏ��� " + LoggerUtils.getSig());
		strategy.logic1();
		strategy.logic2();
		
	}

}
