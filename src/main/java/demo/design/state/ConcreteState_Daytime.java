package demo.design.state;

import utils.LoggerUtils;

class ConcreteState_Daytime implements State {

	@Override
	public void greeting(Context ctx) {
		System.out.println("Hello !! " + LoggerUtils.getSig());
		ctx.setState(new ConcreteState_Night());
	}

}
