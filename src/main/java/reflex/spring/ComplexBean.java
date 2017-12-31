package reflex.spring;

public class ComplexBean {
	
	private String name;
	 
    private User refUser;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public User getRefUser() {
        return refUser;
    }
 
    public void setRefUser(User refUser) {
        this.refUser = refUser;
    }
 
    @Override
    public String toString() {
        return "ComplexBean{" +
                "name='" + name + '\'' +
                ", refUser=" + refUser +
                '}';
    }

}
