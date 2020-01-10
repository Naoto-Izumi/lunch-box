package Kanrisya.Lock.Dao;
import java.util.List;

import Kanrisya.Lock.Beans.LockUserBox;

public interface ProductsDao{
	//各メソッドをオーバーライドする。
	public void addLockUserBox(LockUserBox p);
	public List getLockUserBox(String pid);
	public List getAllLockUserBoxs();
}
