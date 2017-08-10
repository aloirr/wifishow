package classes.model;


import java.io.IOException;

import classes.repository.Device;
import classes.repository.Menu;

public class SelectDevice extends Device {
Menu menu = new Menu();
	public boolean SoTemNumeros(String texto) {
		for (int i = 0; i < texto.length(); i++) {
			if (!Character.isDigit(texto.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public void selectdevice() {
		try {
			String opcao = "0";
			System.out.println("++ DISPOSITIVOS DETECTADOS ++");
			Device.setDevice("null");
			while (Device.getDevice() == "null") {
				for (String arr : device()) {
					System.out.println((device().indexOf(arr) + 1) + ") " + arr);
				}
				System.out.println("Informe o número da opção desejado:\n");
				opcao = menu.getScanner().nextLine();
				if (SoTemNumeros(opcao) == true && device().size() >= Integer.parseInt(opcao)) {
					Device.setDevice(device().get(Integer.parseInt(opcao) - 1));
					System.out.println("Dipositivo Wireless selecionado: " + Device.getDevice());
					Runtime.getRuntime().exec("ip link set " + Device.getDevice() + " up");

				} else {
					System.out.println("Opção inválida! Tente novamente!");
					Device.setDevice("null");
				}
			}
			
		} catch (IOException exc) {
			exc.getMessage();
			exc.printStackTrace();
		}
	}

}
