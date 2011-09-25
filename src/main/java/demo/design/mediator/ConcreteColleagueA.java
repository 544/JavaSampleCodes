package demo.design.mediator;

import utils.LoggerUtils;

class ConcreteColleagueA extends Colleague {

	public ConcreteColleagueA(String name) {
        super(name);
    }
    public void run() {
    	mediator.consultation(this);
    	
    }
    public void advice(String msg) {
        System.out.println("Called ..." + LoggerUtils.getSig() + "; msg:" + msg);
    }
}
