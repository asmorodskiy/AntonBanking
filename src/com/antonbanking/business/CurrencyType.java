package com.antonbanking.business;

public enum CurrencyType {
	dollar,hrivna,euros,piastras;
	
	public int getInt()
	{
		switch (this) {
		case dollar:
			return 1;
		case hrivna:
			return 2;		
		case euros:
			return 3;			
		case piastras:
			return 4;					
		}
		return 0;
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
