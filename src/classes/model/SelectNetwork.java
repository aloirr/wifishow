package classes.model;

import classes.repository.Menu;
import classes.repository.Network;

public class SelectNetwork extends Network {
	private int idNum;
	private String senha;
	Menu menu = new Menu();

	public int findNet(String InputRede) {
		try {
			for (Network netfor : getNetworks()) {
				if (netfor.getId().equals(InputRede)) {
					return getNetworks().indexOf(netfor);
				}
			}
		} catch (NullPointerException exc) {
			System.out.println("Erro! a interface não é wireless! por favor escolher outra!");
		}
		return -1;
	}

	public void selectnetwork() {
		System.out.println("Digite a ID da rede");
		idNum = findNet(menu.getScanner().nextLine());
		while (idNum == -1) {
			System.out.println("ID de rede não encontrada! digite novamente!");
			idNum = findNet(menu.getScanner().nextLine());
		}
		setNetwork(getNetworks().get(idNum).getId());
		System.out.println("Digite a senha da rede (deixe em branco caso não haja)");
		senha = menu.getScanner().nextLine();
		setPassword(senha);
		System.out.println("idNum: " + idNum);
		System.out.println("senha: " + senha);
		System.out.println("getPassword: " + getPassword());
		System.out.println("getNetwork: " + getNetwork());
		System.out.println(getNetworks().get(idNum).getId());
	}

	public int getIdNum() {
		return idNum;
	}

	public String getSenha() {
		return senha;
	}

}
