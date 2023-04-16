package pl.GrupaC3.PogoApp.model;

import java.util.ArrayList;

public class Smog {
	private int[] amountUGM = new int[6];
	private int index = 0;

	public Smog() {
		for (int i = 0; i < 6; i++) {
			amountUGM[i] = 0;
		}
	}

	public int getAmountUGM3(int value) {
		return amountUGM[value];
	}

	public void setAmountUGM3(int value) {
		if (index == 6) {
			index = 0;
		}
		amountUGM[index] = value;
		index++;
	}

}