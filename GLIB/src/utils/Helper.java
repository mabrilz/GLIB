package utils;

import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
	private static Pattern pattern;
	private static Matcher matcher;

	private static final String EMAIL_PATTERN =
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PASSWORD_PATTERN ="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%*]).{8,20})";
	private static final Pattern NIF_PATTERN = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
	
	public static String encrypt(String text) throws Exception {
		return Base64.getEncoder().encodeToString(text.getBytes("UTF-8"));
	}

	public static String decrypt(String cypheredText) throws Exception {
		return new String(Base64.getDecoder().decode(cypheredText), "UTF-8");
	}
	
	public static boolean validateEmail(String email){
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static boolean validatePassword(String pwd, String pwd2){
		if(!pwd.equals(pwd2)) return false;
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(pwd);
		return matcher.matches();
	}
	
	public static boolean validateNIF(String NIF){
		//si es NIE, eliminar la x,y,z inicial para tratarlo como nif
		if (NIF.toUpperCase().startsWith("X")||NIF.toUpperCase().startsWith("Y")||NIF.toUpperCase().startsWith("Z"))
		NIF = NIF.substring(1);
		Matcher m = NIF_PATTERN.matcher(NIF);
		if(m.matches()){
			String letra = m.group(2);
			//Extraer letra del NIF
			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
			int dni = Integer.parseInt(m.group(1));
			dni = dni % 23;
			String reference = letras.substring(dni,dni+1);
			if (reference.equalsIgnoreCase(letra)){
				return true;
			}else{
				return false;
			}
		}
		else return false;
	}
}
