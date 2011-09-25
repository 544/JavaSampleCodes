package demo.design.mediator;

import java.util.HashMap;
import java.util.Iterator;

import utils.LoggerUtils;

class ConcreteMediator implements Mediator {

	HashMap<String, Colleague> colleagues = new HashMap<String, Colleague>();

	public void addColleague(Colleague colleague) {
		colleague.setMediator(this);
		colleagues.put(colleague.getName(), colleague);

	}

	public void consultation(Colleague colleague) {

		String name = colleague.getName();
		
		
		System.out.println("Called ..." + LoggerUtils.getSig() + "; from..."  + name );
		Iterator<String> it = colleagues.keySet().iterator();
		while (it.hasNext()) {
			Colleague colleagueTmp = (Colleague) colleagues.get(it.next());
			if (!(colleagueTmp.getName().equals(colleague.getName()))) {
				colleagueTmp.advice("advice from " + name);
			}
		}

	}

}
