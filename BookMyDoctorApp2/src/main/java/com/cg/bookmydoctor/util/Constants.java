package com.cg.bookmydoctor.util;

public class Constants {
	
	public static final String  NAME_CANNOT_BE_EMPTY = "Name cannot be Empty and contains alphabets only";
	public static final String PHONENUMBER_CANNOT_BE_EMPTY="Phone number must contain 10 digits";
	public static final String EMAIL_CANNOT_BE_EMPTY = "Enter a valid Email Example: example@example.com";
	public static final String PASSWORD_PATTERN="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
	public static final String NAME_PATTERN ="([a-zA-Z]+|[A-Za-z]+[ ]{1}[a-zA-Z]+)";
	public static final String PASSWORD_NOT_STRONG ="Password should contain atleast one uppercase alphatbet, one lowercase alphabet, one digit, one special character. Min size:8, Max Size:32";
	
	public static final String ADMIN_NOT_FOUND ="Admin not found";
	

}
