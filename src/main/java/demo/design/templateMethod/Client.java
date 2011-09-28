package demo.design.templateMethod;

import utils.LoggerUtils;

class Client {
	public static void main(String[] args) {
		// ConcreteClassの実装次第で独自ロジックを切り替える。共通処理は親クラスで実装。
		AbstractClass c1 = new ConcreteClass();
		c1.templateMethod();
		
		System.out.println("--------------------");
		
		// 無名クラスを使ってみたり。
		AbstractClass c2 = new AbstractClass() {
			@Override
			void method() {
				System.out.println("独自処理:" + LoggerUtils.getSig());
			}
		};
		c2.templateMethod();

	}
}
