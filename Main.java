import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			br.readLine();
			String[] split = br.readLine().trim().split(" ");
			int NG = Integer.parseInt(split[0]);
			int NM = Integer.parseInt(split[1]);
			String godzillaArmyString[] = br.readLine().trim().split(" ");
			int godzillaArmy[] = new int[godzillaArmyString.length];
			int gMax = 0;
			for (int j = 0; j < NG; j++) {
				godzillaArmy[j] = Integer.parseInt(godzillaArmyString[j]);
				if (godzillaArmy[j] > gMax) {
					gMax = godzillaArmy[j];
				}
			}
			String[] mechaArmyString = br.readLine().trim().split(" ");
			int[] mechaArmy = new int[mechaArmyString.length];
			int mMax = 0;
			for (int j = 0; j < mechaArmyString.length; j++) {
				mechaArmy[j] = Integer.parseInt(mechaArmyString[j]);
				if (mechaArmy[j] > mMax) {
					mMax = mechaArmy[j];
				}
			}
			System.out.println(mMax > gMax ? "MechaGodzilla" : "Godzilla");

		}

	}
}
