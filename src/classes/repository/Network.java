package classes.repository;

import java.io.IOException;
import java.util.ArrayList;

import classes.control.GetRuntime;

public class Network {

	private static ArrayList<Network> networks = new ArrayList<>();
	private static String network;
	private static String password;
	private String id;
	

	private String protecao;
	private String freqCanal;

	public Network(String id, String protecao, String freqCanal) {
		this.id = id;
		this.protecao = protecao;
		this.freqCanal = freqCanal;

	}

	public Network() {
	}

	public void network(String dispositivo) {
		networks.clear();
		try {
			System.out.println("++Escaneando redes disponíveis...");
			GetRuntime app = new GetRuntime();
			Runtime.getRuntime().exec("ifconfig " + dispositivo + " up");
			ArrayList<String> appDados = app.getruntime("iwlist " + dispositivo + " scan");
			for (String leitorApp : appDados) {
				if (leitorApp.contains("ESSID:")) {
					id = leitorApp.trim().replaceAll("ESSID:", "").replaceAll("\"", "");
					continue;
				}
				if (leitorApp.contains("WPA2")) {
					protecao = "WPA2/PSK";
					continue;
				} else if (leitorApp.contains("WEP")) {
					protecao = "WEP";
					continue;
				} else if (leitorApp.toLowerCase().contains("encryption key:off")) {
					protecao = "ABERTA";
					continue;
				} else if (leitorApp.toLowerCase().contains("wpa version 1")) {
					protecao = "WPA1";
					continue;
				}
				if (leitorApp.contains("Frequency:")) {
					freqCanal = leitorApp.trim().replaceAll("Frequency:", "").replaceAll("Channel", "CANAL");
					continue;
				}
				if (id != null && protecao != null && freqCanal != null) {
					networks.add(new Network(id, protecao, freqCanal));
					id = null;
					protecao = null;
					freqCanal = null;
				}

			}

		} catch (NullPointerException | IOException exc) {
			exc.printStackTrace();
			exc.getMessage();
		}

	}

	public String getId() {
		return id;
	}

	public String getProtecao() {
		return protecao;
	}

	public String getFreqCanal() {
		return freqCanal;
	}

	public static String getNetwork() {
		return network;
	}

	public static void setNetwork(String network) {
		Network.network = network;
	}

	public static ArrayList<Network> getNetworks() {
		return networks;
	}

	public static void setNetworks(ArrayList<Network> networks) {
		Network.networks = networks;
	}
	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Network.password = password;
	}

}
