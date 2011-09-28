package demo.design.templateMethod;

import utils.LoggerUtils;

class ConcreteClass extends AbstractClass {

	@Override
	void method() {
		System.out.println("独自処理:" + LoggerUtils.getSig());

	}

}
