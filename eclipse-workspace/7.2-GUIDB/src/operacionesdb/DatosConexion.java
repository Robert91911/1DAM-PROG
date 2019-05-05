package operacionesdb;

public class DatosConexion {
	
	private String bd = "DATOS";
	private String login = "robert9191";
	private String password = "Clave_00";
	private String url = "jdbc:mysql://localhost/" + bd;
	
	
	public String getBd() {
		return bd;
	}
	public void setBd(String bd) {
		this.bd = bd;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
