 class CutURL{
    public static void main(String[]args){
        String uri = "http://localhost:8080/bento/image/1.jpg";
        int index = uri.indexOf("image");
        System.out.println("index"+index);
        uri = uri.substring(index);
        System.out.println("uri"+uri);
    }
}