package demo.design.strategy;

class Client {
	public static void main(String[] args) {
		Context cx = new Context();
		cx.strategy = new ConcreteStrategyA();
		
		cx.doSomething();
	}
}
