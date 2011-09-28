package demo.design.mediator;

import utils.LoggerUtils;

class ConcreteColleagueC extends Colleague {

	public ConcreteColleagueC(String name) {
        super(name);
    }
    public void run() {
    	mediator.consultation(this);
    	
    }
    public void advice(String msg) {
        System.out.println("Called ..." + LoggerUtils.getSig() + "; msg:" + msg);
    }
}
