package classes.control;

import java.io.IOException;

import classes.repository.Device;
import classes.repository.Network;

public class ConnectNetwork extends Network {

	GetRuntimeInput getruntimeinput = new GetRuntimeInput();

	public void connectnetwork() {
		try {

			String arquivoConf = System.getProperty("user.home") + "/wpa_" + getNetwork() + ".conf";
			getruntimeinput.getruntimeinput(arquivoConf, "wpa_passphrase " + getNetwork() + " " + getPassword());
			Runtime.getRuntime().exec("killall wpa_supplicant");
			Runtime.getRuntime().exec("killall dhclient");
			Runtime.getRuntime().exec("ip link set " + Device.getDevice() + " up");
			Runtime.getRuntime().exec("wpa_supplicant -i " + Device.getDevice() + " -c " + arquivoConf + " -B -D wext");
			Runtime.getRuntime().exec("dhclient " + Device.getDevice());
		} catch (IOException | NullPointerException exc) {
			exc.printStackTrace();
		}
	}

}