package A9_MobileContact_Hashing;

public class Contact {

	String name;
	long mob;
	String email;

	Contact(String n, long m, String e) {
		this.name = n;
		this.mob = m;
		this.email = e;
	}

	void display() {
		System.out.println("Name : " + name);
		System.out.println("Mobile : " + mob);
		System.out.println("Email : " + email);
		System.out.println();
	}
}
