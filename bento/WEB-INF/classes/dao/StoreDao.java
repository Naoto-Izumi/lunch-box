package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import Bean.Product;

public  class StoreDao implements ProductsDao{
    public Product getProduct(String pid){return null;}
    public void addProduct(Product p){}
    public List getAllProducts(){
        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        List products=new ArrayList();

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            cn=DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl","info","pro"
            );

            cn.setAutoCommit(false);

            String sql="select * from storeTable";

            //PreparedStatement�C���^�[�t�F�C�X����������N���X���C���X�^���X������
			st=cn.prepareStatement(sql);

			//select�������s��
			//ResultSet�C���^�[�t�F�C�X�����������N���X��
			//�C���X�^���X���Ԃ�
			rs=st.executeQuery();

            //�J�[�\������s�����X�N���[�����A�f�[�^���t�F�b�`����
			while(rs.next()){

                Product p = new Product();
				String st_id = rs.getString(1);	//1��ڂ̃f�[�^���擾
				String st_name = rs.getString(2);	//2��ڂ̃f�[�^���擾
                String st_address = rs.getString(3);	
                String st_phone = rs.getString(4);	
                String st_hours = rs.getString(5);	
				p.setSt_id(st_id);
                p.setSt_name(st_name);
                p.setSt_address(st_address);
                p.setSt_phone(st_phone);
                p.setSt_hours(st_hours);

                products.add(p);
				
			}


        }catch(ClassNotFoundException e) {
			e.printStackTrace();

		//getConnection,createStatement,executeQuery�ŗ�O�����̏ꍇ
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//���\�[�X�̉���������s��
			try {
				if(rs != null){
					rs.close();
				}
				if(st != null){
					st.close();
				}
				if(cn!=null){
					cn.close();
				}
			} catch(SQLException e2) {
				e2.printStackTrace();
			}
		}
        return products;
    }

}