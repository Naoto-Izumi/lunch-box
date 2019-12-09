package Kanrisya.Lock;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class AbstractDaoFactory{
	public static AbstractDaoFactory getFactory(){
		AbstractDaoFactory factory = null;
		
		Properties prop = new Properties();
		
		try{
			//プロパティファイルを読み込む。
			prop.load(new FileInputStream("c:/Helshin/dao.properties"));
			
			//キーに対応した文字列を取得。
			String name = prop.getProperty("dao");
			
			//指定された名前のクラスに対応したClassクラスのインスタンスを取得する。
			Class c = Class.forName(name);
			
			//Classクラスのインスタンスを利用して対応するクラスのインスタンス化を行う。
			factory = (AbstractDaoFactory) c.newInstance();
			
		}catch(FileNotFoundException e){
			throw new RuntimeException(e.getMessage(),e);
		}catch(IOException e){
			throw new RuntimeException(e.getMessage(),e);
		}catch(ClassNotFoundException e){
			throw new RuntimeException(e.getMessage(),e);
		}catch(InstantiationException e){
			throw new RuntimeException(e.getMessage(),e);
		}catch(IllegalAccessException e){
			throw new RuntimeException(e.getMessage(),e);
		}
		return factory;
	}
	public abstract ProductsDao getProductsDao();
}
