package demo.design.state;

import utils.LoggerUtils;

class ConcreteState_Night implements State{

	@Override
	public void greeting(Context ctx) {
		System.out.println("Good Night !! " + LoggerUtils.getSig());
		ctx.setState(new ConcreteState_Morning());
		
	}

}
