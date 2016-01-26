package publisher.data;

public class User
{
	private Long id;
	private String username;
	private String password;
	private String accessKey;
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getAccessKey()
	{
		return accessKey;
	}
	public void setAccessKey(String accessKey)
	{
		this.accessKey = accessKey;
	}
}
