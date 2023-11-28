package service;

import dao.userdao;
import dto.userdto;
import helper.AES;

public class userservice {
	public boolean saveuser(userdto dto)
	{if(dto.getAge()<18)
	{
		return false;
		
	}
	else
	{
		userdao dao=new userdao();
		userdto dto1=dao.findbyemail(dto.getEmail());
		if(dto1!=null)
			return false;
		else
		{
			dto.setPassword(AES.encrypt(dto.getPassword(),"123"));
			dao.serveruser(dto);

		return true;
		}

	}
		
	}
	public boolean login(String email,String password)
	{
		userdao dao=new userdao();
		userdto dto=dao.findbyemail(email);
		if(dto==null)
		return false;
		else
		{
			if(password.equals(AES.decrypt(dto.getPassword(), "123")));
			return true;
		}
		
		
	}

}
