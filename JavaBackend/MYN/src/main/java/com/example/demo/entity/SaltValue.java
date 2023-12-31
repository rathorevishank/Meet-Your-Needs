package com.example.demo.entity;
import org.springframework.beans.factory.annotation.Value;
 import org.springframework.stereotype.Component;
 @Component
public class SaltValue
{


@Value("${spring.saltvalue}")
String salt;
public String getsalt()
{
	return salt;
}


public void setSalt(String salt) 
{
  this.salt=salt;
}
}