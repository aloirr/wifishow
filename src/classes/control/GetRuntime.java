package classes.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GetRuntime {

	private static ArrayList<String> arrRun = new ArrayList<>();
	private String runExec;

		public ArrayList<String> getruntime(String runExec) {
		this.runExec = runExec;
		arrRun.clear();
		try {
			Process run = Runtime.getRuntime().exec(runExec);
			InputStream input = run.getInputStream();
			InputStreamReader iReader = new InputStreamReader(input);
			BufferedReader bReader = new BufferedReader(iReader);
			String leitorLinha;
			while ((leitorLinha = bReader.readLine()) != null) {
				arrRun.add(leitorLinha);
			}
			return arrRun;
		} catch (IOException exc) {
			exc.printStackTrace();
			arrRun.add("Erro de execução!");
			return arrRun;
		}
	}
		public GetRuntime(String runExec) {
			this.runExec = runExec;
		}

		public GetRuntime() {

		}

		public String getRunExec() {
			return runExec;
		}

		public void setRunExec(String runExec) {
			this.runExec = runExec;
		}

}
