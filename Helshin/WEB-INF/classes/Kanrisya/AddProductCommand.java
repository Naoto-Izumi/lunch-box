package Kanrisya;
import java.util.Map;

public class AddProductCommand extends AbstractCommand{
	
	public String execute(){
		Product p=new Product();
		
		//parameterMap����name��price�����Ƃ�
		Map parameters = getParameters();
		
		String name = ((String[])parameters.get("name"))[0];	//request�ő����Ă����L�[�̃p�����[�^�[
		System.out.println(name);
		//String id = ((String[])parameters.get("id"))[0];	//request�ő����Ă����L�[�̃p�����[�^�[
		//String tel = ((String[])parameters.get("telphone"))[0];
		//String mail = ((String[])parameters.get("mail"))[0];
		
		//�󂯎��������product��set����
		p.setName(name);
		//p.setId(id);
		//p.setTelphone(tel);
		//p.setMail(mail);
		
		//�f�[�^�x�[�X�ɓo�^����
		DbDummy.addProduct(p);
		
		return "/view";
		
	}
}

	
		