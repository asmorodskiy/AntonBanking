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
}
