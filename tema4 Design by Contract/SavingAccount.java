package tema4;


//allows a large sum deposit and withdrawal
//computes an interest during deposit period
public class SavingAccount extends Account{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  boolean actionDeposit=false;
	private  boolean actionWithdrawal=false;
	private  boolean insuficient=false;
	//Interface fr=new Interface();
	
	public SavingAccount(int id,double m,String idP) {
		super(id,m,idP);
		this.money=this.money+this.money*3/100;
		this.tip="Saving";
		
	}
	@SuppressWarnings("deprecation")
	@Override
	public void deposit(double sum) {
		if(this.actionDeposit == false) {
			this.money+=sum;
			this.money=this.money+this.money*3/100;
			this.setActionDeposit(true);
			//System.out.println("Deposit made from account:"+this.getId()+". Current sum = "+this.getMoney());
			setChanged();
			notifyObservers(person+", it was deposited "+sum+" into account "+this.getId()+". Current sum: "+this.getMoney());
		}
		//else {
		//	System.out.println("Only one deposit is permitted");
		//}
		
	}
	@Override
	public String toStringDeposit() {
		if(this.actionDeposit == false) {
			if(insuficient == false) {
				return "\nIt was made a deposit in holder's \n"+this.getIdPerson()+" account "+this.getId()+". Current sum: "+this.getMoney();
			}
			else
				return "\nNot enough money";
		}
		else {
			return "\nOnly one deposit is permitted";
		}
	}
	@Override
	public String toStringWithdrawal() {
		if(this.actionDeposit == false) {
			return "\nIt was made a withdrawal from holder's \n"+this.getIdPerson()+" account "+this.getId()+". Current sum: "+this.getMoney();
		}
		else {
			return "\nOnly one withdrawal is permitted";
		}
	}
	@SuppressWarnings("deprecation")
	@Override
	public void withdrawal(double sum) {
		if(this.actionWithdrawal == false) {
		if(this.money-sum >= 0) {
			this.money-=sum;
			this.money=this.money+this.money*3/100;
			this.setActionWithdrawal(true);
			setChanged();
			//fr.toStringOperation("Withdrawal made from account:"+this.getId()+". Current sum = "+this.getMoney());
			notifyObservers(person+", it was withdrawed "+sum+" from account "+this.getId()+". Current sum: "+this.getMoney());
		}
		else {
			System.out.println("Not enough money");
		}
		}
		else {
			System.out.println("Only one withdrawal is permitted");
		}
	}
	public  void setActionDeposit(boolean actionDeposit) {
		this.actionDeposit = actionDeposit;
	}
	public  void setActionWithdrawal(boolean actionWithdrawal) {
		this.actionWithdrawal = actionWithdrawal;
	}
	public  boolean isActionDeposit() {
		return actionDeposit;
	}
	public  boolean isActionWithdrawal() {
		return actionWithdrawal;
	}
	
	

}
