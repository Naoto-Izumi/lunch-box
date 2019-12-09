package function;

public class CutURL{
    public static String getString(String uri){
        int index = uri.indexOf("image");
        return uri.substring(index);
    }
}