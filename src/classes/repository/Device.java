package classes.repository;

import java.util.ArrayList;

import classes.control.GetRuntime;

public class Device {
	
	private static String device;

	public ArrayList<String> device() {
		ArrayList<String> dispositivos = new ArrayList<>();
		try {
			GetRuntime app = new GetRuntime();
			for (String leitorApp : app.getruntime("ip link show")) {
				String[] leitorSplit = leitorApp.trim().split(" ");
				if (leitorSplit[0].contains(":")) {
					dispositivos.add(leitorSplit[1].replaceAll(":", ""));
				}
			}

		} catch (NullPointerException exc) {
			exc.printStackTrace();

		}
		return dispositivos;

	}

	public static String getDevice() {
		return device;
	}

	public static void setDevice(String device) {
		Device.device = device;
	}

}
