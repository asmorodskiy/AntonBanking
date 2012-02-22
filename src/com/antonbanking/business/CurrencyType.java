package com.antonbanking.business;

public enum CurrencyType {
	dollar(1,"dollar"),hrivna(2,"hrivna"),euros(3,"euros"),piastras(4,"piastras");
	
	/**
	 * @uml.property  name="id"
	 */
	private int id;
	/**
	 * @return
	 * @uml.property  name="id"
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * @uml.property  name="name"
	 */
	private String name;
	
	CurrencyType(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	
	public static CurrencyType getCurrency(int cur_id)
	{
		switch (cur_id) {
			case 1:
				return dollar;
			case 2:
				return hrivna;		
			case 3:
				return euros;			
			case 4:
				return piastras;					
			}
			return dollar;
	}	
}
