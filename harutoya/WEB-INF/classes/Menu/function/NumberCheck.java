package Menu.function;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberCheck{
public static boolean isNumber(String val) {
	String regex = "\\A[-]?[0-9]+\\z";
	Pattern p = Pattern.compile(regex);
	Matcher m1 = p.matcher(val);
	return m1.find();
}
}