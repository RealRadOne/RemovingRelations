package Model;
/**
 *
 * @author Sakshi Sinha
 */
public class User 
{
        private String UserID;
	private String Name;
	private String Email;
	
	public String getUserId() {
		return UserID;
	}
	public void setUserId(String UserID) {
		this.UserID = UserID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) 
        {
		this.Name = Name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}    
}
