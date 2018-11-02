package com.youxu.reflect;

public class Cpu implements PCI {

	@Override
	public void open() {
		System.out.println("cpu is open...");
	}

	@Override
	public void close() {
		System.out.println("cpu is close...");
	}

}
