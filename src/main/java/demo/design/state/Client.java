package demo.design.state;

class Client {
	
	public static void main(String[] args) {
		
		Context ctx = new Context(new ConcreteState_Morning());

		// �Ăяo�����тɏ�Ԃ������B
		ctx.doSomething();
		ctx.doSomething();
		ctx.doSomething();
		
		
	}

}
