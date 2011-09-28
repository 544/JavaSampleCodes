package demo.design.mediator;

class Client {
	public static void main(String[] args) {
		Mediator mediator = new ConcreteMediator();
		
		Colleague cA = new ConcreteColleagueA("ColleagueA");
		mediator.addColleague(cA);
		Colleague cB = new ConcreteColleagueB("ColleagueB");
		mediator.addColleague(cB);
		Colleague cC = new ConcreteColleagueC("ColleagueC");
		mediator.addColleague(cC);
		
		System.out.println("execute A...");
		cA.run();

		System.out.println("execute B...");
		cB.run();

	}

}
