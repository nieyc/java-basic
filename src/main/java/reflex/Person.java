package reflex;

public class Person {
	
	public String name;
	
    private int age;
	
    private String sex;
	
	
	
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void say(String name,String sex) {
		System.out.println("my name is:"+name +"and sex is:"+sex);		
	}

	

}
