package demo.design.mediator;

abstract class Colleague {

	protected Mediator mediator;
	private String name;

	public Colleague(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	public abstract void advice(String msg);

	public abstract void run();
}
