package tema4;
//allows multiple  sum deposits and withdrawals
//doensn't compute an interest during deposit period
public class SpendingAccount extends Account{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean insuficient=false;
	public SpendingAccount(int id,double m,String idP) {
		super(id,m,idP);
		this.tip="Spending";
	}
	@SuppressWarnings("deprecation")
	@Override
	public void deposit(double sum) {
		this.money+=sum;
		setChanged();
		notifyObservers(person+", it was deposited "+sum+" into account "+this.getId()+". Current sum: "+this.getMoney());
	}
	@Override
	public String toStringDeposit() {
		return "\nIt was made a deposit in holder's \n"+this.getIdPerson()+" account "+this.getId()+". Current sum: "+this.getMoney();
	}
	@Override
	public String toStringWithdrawal() {
		if(insuficient==false) {
			return "\nIt was made a withdrawal from holder's \n"+this.getIdPerson()+" account "+this.getId()+". Current sum: "+this.getMoney();
		}
		else
			return "\nNot enough money";
		}
		   
	@SuppressWarnings("deprecation")
	@Override
	public void withdrawal(double sum) {
		if(this.money-sum >= 0) {
			this.money-=sum;
			setChanged();
			notifyObservers(person+", it was withdrawed "+sum+" from account "+this.getId()+". Current sum: "+this.getMoney());
		}
		else {
			System.out.println("Not enough money");
			insuficient=true;
		}
		
		
	}
	


}
