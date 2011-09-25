package demo.design.state;

class Context {
	private State state;

	public Context(State state) {
		this.state = state;
	}
	
	public void setState(State state) {
		this.state = state;
	}

	public void doSomething() {
		state.greeting(this);
	}

}
