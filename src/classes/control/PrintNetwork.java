package classes.control;

import classes.repository.Network;

public class PrintNetwork extends Network {

	public void printnetwork() {
		try {
			System.out.println("## REDES WIFI EM ABERTO ##");
			int arrNum = 0;
			while (getNetworks().size() > arrNum) {
				System.out.println("+Rede(ID): " + getNetworks().get(arrNum).getId());
				System.out.println("TIPO: " + getNetworks().get(arrNum).getProtecao());
				System.out.println("FREQ/CANAL: " + getNetworks().get(arrNum).getFreqCanal());
				System.out.println("\n");
				arrNum++;
			}
			System.out.println("## TOTAL: " + getNetworks().size() + " REDES ##");
		} catch (NullPointerException exc) {
			System.out.println("Erro! a interface não é wireless! por favor escolher outra!");

		}
	}

}
