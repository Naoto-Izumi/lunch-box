package Kanrisya.Lock;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class CommandFactory{
	public static AbstractCommand getCommand(RequestContext rc){
		AbstractCommand command = null;
		
		Properties prop = new Properties();
		
		try{
			//�v���p�e�B�t�@�C����ǂݍ��ށB
			prop.load(new FileInputStream("c:/Helshin/helshin.properties"));
			
			//�L�[�ɑΉ�������������擾�B
			String name = prop.getProperty(rc.getCommandPath());
			
			//�w�肳�ꂽ���O�̃N���X�ɑΉ�����Class�N���X�̃C���X�^���X���擾����B
			Class c = Class.forName(name);
			
			//Class�N���X�̃C���X�^���X�𗘗p���đΉ�����N���X�̃C���X�^���X�����s���B
			command = (AbstractCommand) c.newInstance();
			
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
		return command;
	}
}

		