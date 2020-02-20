import java.util.Date;

public class DatE {
	public static void main(String[] args) {
		
		String d=new Date().toString().replaceAll(":", "_");
		System.out.println(d);
		
	}
	

}
