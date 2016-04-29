import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InsertLanguage {
	
	public static void main(String args[]) throws IOException {
		FileReader in = new FileReader("queries1.csv");
		BufferedReader br = new BufferedReader(in);
		FileWriter out = new FileWriter("queries.csv");
	    BufferedWriter bw = new BufferedWriter(out);
		String line = null;
		String newLine = null;
		int i = 0;
		for (i = 0; i < 100; i++) {
		    line = br.readLine();
			newLine = line + ",en-US";
			bw.write(newLine + "\n");
		}
		for (i = 100; i < 200; i++) {
			line = br.readLine();
			newLine = line + ",zh-CN";
			bw.write(newLine + "\n");
		}
		for (i = 200; i < 300; i++) {
			line = br.readLine();
			newLine = line + ",zh-HK";
			bw.write(newLine + "\n");
		}
		for (i = 300; i < 400; i++) {
			line = br.readLine();
			newLine = line + ",fr-FR";
			bw.write(newLine + "\n");
		}
		for (i = 400; i < 500; i++) {
			line = br.readLine();
			newLine = line + ",de-DE";
			bw.write(newLine + "\n");
		}
		for (i = 500; i < 600; i++) {
			line = br.readLine();
			newLine = line + ",es-ES";
			bw.write(newLine + "\n");
		}
		for (i = 600; i < 700; i++) {
			line = br.readLine();
			newLine = line + ",es-XL";
			bw.write(newLine + "\n");
		}
		for (i = 700; i < 799; i++) {
			line = br.readLine();
			newLine = line + ",it-IT";
			bw.write(newLine + "\n");
		}
		line = br.readLine();
		newLine = line + ",it-IT";
		bw.write(newLine);

	in.close();
	bw.close();
		
	}
}