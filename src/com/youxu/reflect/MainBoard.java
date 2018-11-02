package com.youxu.reflect;

public class MainBoard {
	public void run() {
		System.out.println("MainBoard is running");
	}
	public void usePCI(PCI pci) {
		if(pci != null) {
			pci.open();
			pci.close();
		}
	}
}
