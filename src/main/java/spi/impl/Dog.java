package spi.impl;

import spi.IShout;

public class Dog implements IShout{

	@Override
	public void shout() {
		System.out.println("wang wang");
	}

}
