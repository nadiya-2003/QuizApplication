public class Questions {
    private String question;
    private String[] options;
    private int correctOption;
    private int reward;

    public Questions(String question, String[] options, int correctOption, int reward)
    {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
        this.reward = reward;
    }
    
    
    public void setQuestion(String question) 
    { 
    	this.question = question; 
    }
    public void setOptions(String[] options) 
    { 
    	this.options = options;
    }
    public void setCorrectOption(int correctOption)
    {
    	this.correctOption = correctOption;
    }
    public void setReward(int reward) 
    {
    	this.reward = reward; 
    }

    public String getQuestion()
    { 
    	return question;
    }
    public String[] getOptions() 
    {
    	return options;
    }
    public int getCorrectOption() 
    {
    	return correctOption;
    }
    public int getReward()
    { 
    	return reward;
    }

   
}

