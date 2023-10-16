package pack;

public class Login {

	private String uid;
	private String pass;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public boolean status(Login l){
		if(uid.equals(pass)){
			return true;
		}
		else{
			return false;
		}
	}
}
