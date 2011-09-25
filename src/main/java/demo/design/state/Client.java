package demo.design.state;

class Client {
	
	public static void main(String[] args) {
		
		Context ctx = new Context(new ConcreteState_Morning());

		// ŒÄ‚Ño‚·‚½‚Ñ‚Éó‘Ô‚ª‚©‚í‚éB
		ctx.doSomething();
		ctx.doSomething();
		ctx.doSomething();
		
		
	}

}
