package com.base.easy.core.access;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Identify implements ServiceIdentificable {
	public String getClientComputerName() {
		String computerName = null;
		try {
			computerName = InetAddress.getLocalHost().getHostName();
			if (computerName != null) {
				computerName = computerName.toUpperCase();
			}
		} catch (UnknownHostException e) {
		}
		return computerName;
	}

}
