package demo.design.strategy;

import utils.LoggerUtils;

class ConcreteStrategyA implements Strategy {

	@Override
	public void logic1() {
		System.out.println("�Ǝ�����1 " + LoggerUtils.getSig());

	}

	@Override
	public void logic2() {
		System.out.println("�Ǝ�����2 " + LoggerUtils.getSig());

	}

}
