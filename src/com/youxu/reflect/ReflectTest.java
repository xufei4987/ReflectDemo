package com.youxu.reflect;

import java.io.FileInputStream;
import java.util.Properties;

public class ReflectTest {
	
	public static void main(String[] args) throws Exception {
		MainBoard mb = new MainBoard();
		mb.run();
		//每次添加一个设备都需要修改代码，传递一个新创建的对象，能不能不修改代码就能完成这个动作？
//		mb.usePCI(new SoundCard());
		FileInputStream fis = new FileInputStream("pci.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		for(int i = 0; i < properties.size(); i++) {
			String pciName = properties.getProperty("pci" + (i + 1));
			Class<?> clazz = Class.forName(pciName);
			PCI pci = (PCI) clazz.newInstance();
			pci.open();
			pci.close();
		}
	}
}
