package test.java;

import static org.junit.Assert.*;

import java.util.HashMap;

import main.java.com.guoruifeng.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guoruifeng.StringUtils;
import com.guoruifeng.UserUtils;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:redis.xml")
public class Usertest {
		@Autowired
		RedisTemplate redistemple;
	@Test
	public void test() {
		
		User user =new User();
		//实体类Users
		for (int i = 0; i < 50000; i++) {
			user.setId(i);
			//设置id
			user.setName(UserUtils.getName());
			//设置名字
			user.setSex(UserUtils.getSex());
			//设置性别
			user.setBirthday(UserUtils.getBirthday());
			//设置生日
			user.setMail(UserUtils.getMail());
			//设置邮箱
			user.setPhone(UserUtils.getPhone());
			//设置手机号
			redistemple.opsForValue().set("users"+i, user);
			//jdk序列化到数据库中
			System.out.println(user);
			
		}
		System.out.println("ok");
		System.out.println("jdk");
	}
	@Test
	public void test2() {
		
		User user =new User();
		//实体类Users
		for (int i = 0; i < 50000; i++) {
			user.setId(i);
			//设置id
			user.setName(UserUtils.getName());
			//设置名字
			user.setSex(UserUtils.getSex());
			//设置性别
			user.setBirthday(UserUtils.getBirthday());
			//设置生日
			user.setMail(UserUtils.getMail());
			//设置邮箱
			user.setPhone(UserUtils.getPhone());
			//设置手机号
			redistemple.opsForValue().set("users2"+i, user);
			//json序列化到数据库
			System.out.println(user);
			
		}
		System.out.println("ok");
		System.out.println("json");
	}

@Test
public void test3() {

	User user =new User();
	//设置实体类
	for (int i = 0; i < 50000; i++) {
		user.setId(i);
		//设置id
		user.setName(UserUtils.getName());
		//设置名字
		user.setSex(UserUtils.getSex());
		//设置性别
		user.setBirthday(UserUtils.getBirthday());
		//设置生日
		user.setMail(UserUtils.getMail());
		//设置邮箱
		user.setPhone(UserUtils.getPhone());
		//设置手机号
		redistemple.opsForHash().put("userss"+i, "userss"+i, user);
		//hash序列化到数据库
		
	}

	System.out.println("ok");
	System.out.println("hash");
}
	
}
