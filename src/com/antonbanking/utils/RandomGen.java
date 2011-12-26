package com.antonbanking.utils;

import java.util.Random;

public class RandomGen {
	
	public static int GenerateID() {
		Random rand = new Random(System.currentTimeMillis());
		
		return rand.nextInt();
	}

}
