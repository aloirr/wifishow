package classes.model;

import classes.control.ConnectNetwork;
import classes.control.PrintNetwork;
import classes.repository.Device;
import classes.repository.Menu;
import classes.repository.Network;
import classes.test.TestNetwork;

public class SelectMenu {


	public void selectmenu(String opcaoMenu) {
		Network network = new Network();
		SelectNetwork selectnetwork = new SelectNetwork();
		SelectDevice selectdevice = new SelectDevice();
		PrintNetwork printnetwork = new PrintNetwork();
		ConnectNetwork connectnetwork = new ConnectNetwork();
		TestNetwork testnetwork = new TestNetwork();
		Menu menu = new Menu();
	
		switch (opcaoMenu) {
		case "1":
			String conexao = null;
			while (conexao != "true") {
				selectdevice.selectdevice();
				network.network(Device.getDevice());
				printnetwork.printnetwork();
				selectnetwork.selectnetwork();
				connectnetwork.connectnetwork();
				conexao = testnetwork.testnetwork();
				}
			menu.menu();
			break;
		case "2":
			testnetwork.testnetwork();
			menu.menu();
			break;
		case "3":
			System.out.println("Programa finalizado com sucesso!");
			break;
		default:
			System.out.println("Opção inválida! Tente novamente!");
			menu.menu();
			break;
		}
	}
}
