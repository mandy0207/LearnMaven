package modals;

public class Person {

	public String fisrtName, lastName, userName, city, state;
	public int zip;

	
	public Person(String fisrtName, String lastName, String userName, String city, String state, int zip) {
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.userName = userName;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}


	@Override
	public String toString() {
		return "Person [fisrtName=" + fisrtName + ", lastName=" + lastName + ", userName=" + userName + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + "]";
	}
	
}
