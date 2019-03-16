package tema4;

public interface BankProc {
	/**
	 * adds Person p in hashMap holder
	 * @pre  p != null
	 * @post holder.containsKey(p);
	 * @post holder.size() == holder.size()@pre+1
	 */
	public void addPerson(Person p);
	
	/**removes Person p from HashMap holder
	 * @pre holder.size() > 0
	 * @pre p != null
	 * @pre p != null
	 * @post holder.size() == holder.size()@pre - 1
	 * 
	 */
	public void removePerson(Person p);
	/**
	 * adds Account a in  HashMap at key Person p in value ArrayList
	 * @pre p!= null && a != null
	 * @post holder.get(p).contains(a)
	 * @post holder.get(p).size() == holder.get(p).size()@pre + 1
	 */
	public void addAccount(Person p, Account a);
	
	/**
	 * removes Account a from HashMap at key Person p in value ArrayList
	 * @pre p!= null && a!= null && holder.get(p).size() > 0
	 * @post holder.get(p).size() == holder.get(p).size()@pre - 1
	 */
	public void removeAccount(Person p, Account a);
	

}
