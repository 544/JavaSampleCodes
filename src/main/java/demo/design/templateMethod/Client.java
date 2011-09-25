package demo.design.templateMethod;

import utils.LoggerUtils;

class Client {
	public static void main(String[] args) {
		// ConcreteClass�̎�������œƎ����W�b�N��؂�ւ���B���ʏ����͐e�N���X�Ŏ����B
		AbstractClass c1 = new ConcreteClass();
		c1.templateMethod();
		
		System.out.println("--------------------");
		
		// �����N���X���g���Ă݂���B
		AbstractClass c2 = new AbstractClass() {
			@Override
			void method() {
				System.out.println("�Ǝ�����:" + LoggerUtils.getSig());
			}
		};
		c2.templateMethod();

	}
}
