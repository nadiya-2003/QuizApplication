public class PlayerDetails {
    private String firstName;
    private String lastName;
    private String place;
    private String email;
    private String contactNumber;
    private int Points; 

    public PlayerDetails(String firstName, String lastName, String place, String email, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.place = place;
        this.email = email;
        this.contactNumber = contactNumber;
        this.Points = 0; 
    }

   
    public void setFirstName(String firstName)
    {
    	this.firstName = firstName; 
    }
    public void setLastName(String lastName) 
    {
    	this.lastName = lastName; 
    	
    }
    public void setPlace(String place)
    {
    	this.place = place; 
    	
    }
    public void setEmail(String email) 
    {
    	this.email = email; 
    	
    }
    public void setContactNumber(String contactNumber) 
    { 
    	this.contactNumber = contactNumber; 
    	
    }

    public String getFirstName() 
    {
    	return firstName;
    }
    public String getLastName()
    { 
    	return lastName; 
    	
    }
    public String getPlace()
    { 
    	return place; 
    	
    }
    public String getEmail() 
    { 
    	return email;
    }
    public String getContactNumber()
    {
    	return contactNumber;
    }
    
    public int getTotalPoints()
    { 
    	return Points; 
    }
    public void addPoints(int points)
    {
    	this.Points += points; } 
}
