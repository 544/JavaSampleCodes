package demo.design.state;

import utils.LoggerUtils;

class ConcreteState_Morning implements State {

	@Override
	public void greeting(Context ctx) {
		System.out.println("Good Morning! " + LoggerUtils.getSig());
		ctx.setState(new ConcreteState_Daytime());
	}

}
