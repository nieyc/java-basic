package spi.impl;

import spi.IShout;

public class Cat implements IShout{

	@Override
	public void shout() {
	  System.out.println("miao miao");
	}

}
