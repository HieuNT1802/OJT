package fa.tranning.validate;

public class InputVal {
	public static boolean isId(String id) {
		id=id.trim();
		if(id.length()>7 && id.length()>0) {
			return true;
		}
		if(id.startsWith("FW")||id.startsWith("RW")||id.startsWith("AP")) {
			return true;
		}
		return false;	
	}
	public static boolean isModel(String model) {
		if(model.length()>0 && model.length()<40) {
			return true;
		}
		return false;
	}
	public static boolean isTypeWing(String wing) {
		if(wing.equals("CAG") && wing.equals("JET") && wing.equals("ALR")) {
			return true;
		}
		return false;
		
	}
}
