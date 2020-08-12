package test.main4;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainClass01 {
	public static void main(String[] args) {
		//비밀번호라고 가정
		String pwd = "abcd1234";
		CharSequence pwd2 = "abcd1234";   
		//비밀번호 인코딩
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//비밀번호를 암호화한 문자열 얻어내기
		String result = encoder.encode(pwd2);
		//결과 출력해보기
		System.out.println(result);
	}
}
