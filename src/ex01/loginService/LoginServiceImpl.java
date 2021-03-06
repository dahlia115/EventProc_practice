package ex01.loginService;

import ex01.Controller;
import ex01.database.DatabaseService;
import ex01.database.DatabaseServiceImpl;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class LoginServiceImpl implements LoginService {

	@Override
	public void loginCheck(Parent root) {
		TextField id = (TextField) root.lookup("#fxId");
		TextField pwd = (TextField) root.lookup("#fxPw");
		
		if(id.getText().isEmpty()) {
			Controller.cs.alert("아이디를 입력하세요");
		}
		
		System.out.println("로그인 체크 합니다");
		System.out.println("id : "+id.getText());
		System.out.println("pw : "+pwd.getText());
		
		DatabaseService ds = new DatabaseServiceImpl();
		String dbPwd = ds.loginCheck(id.getText());
		if(dbPwd == null) {
			Controller.cs.alert("존재하지 않는 아이디입니다");
		}else {
			if(dbPwd.equals(pwd.getText())) {
				Controller.cs.alert("인증 통과");
			}else {
				Controller.cs.alert("비밀번호가 틀렸습니다");				
			}
		}
	}

}
