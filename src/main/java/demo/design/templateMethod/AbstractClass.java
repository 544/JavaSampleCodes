package demo.design.templateMethod;

import utils.LoggerUtils;

abstract class AbstractClass {
	abstract void method();

	public void templateMethod() {
		System.out.println("�O����:" + LoggerUtils.getSig());

		// �Ǝ������̓T�u�N���X�Ŏ���
		method();
		
		System.out.println("�㏈��:" + LoggerUtils.getSig());

	}

}
