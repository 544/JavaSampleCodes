package demo.design.strategy;

import utils.LoggerUtils;

class Context {
	Strategy strategy;
	
	public void doSomething() {
		
		System.out.println("共通処理 " + LoggerUtils.getSig());
		strategy.logic1();
		strategy.logic2();
		
	}

}
