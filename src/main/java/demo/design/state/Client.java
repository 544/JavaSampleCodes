package demo.design.state;

class Client {
	
	public static void main(String[] args) {
		
		Context ctx = new Context(new ConcreteState_Morning());

		// 呼び出すたびに状態がかわる。
		ctx.doSomething();
		ctx.doSomething();
		ctx.doSomething();
		
		
	}

}
