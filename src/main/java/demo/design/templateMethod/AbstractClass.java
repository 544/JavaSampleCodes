package demo.design.templateMethod;

import utils.LoggerUtils;

abstract class AbstractClass {
	abstract void method();

	public void templateMethod() {
		System.out.println("前処理:" + LoggerUtils.getSig());

		// 独自処理はサブクラスで実装
		method();
		
		System.out.println("後処理:" + LoggerUtils.getSig());

	}

}
