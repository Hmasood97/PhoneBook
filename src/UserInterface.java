import java.util.Scanner;

public class UserInterface {
	private Scanner reader;
	private PhoneBook numbies;

	public UserInterface(Scanner r) {
		this.reader = r;
		this.numbies = new PhoneBook();
	}

	public void start() {
		// Set of Commands (7 IS IN PROGRESS)
		System.out.println("available operations:");
		System.out.println(" 1 add a number");
		System.out.println(" 2 search for a number");
		System.out.println(" 3 search for a person by phone number");
		System.out.println(" 4 add an address");
		System.out.println(" 5 search for personal information");
		System.out.println(" 6 delete personal information");
		// System.out.println(" 7 filtered listing");
		System.out.println(" x quit");
		System.out.println("command:");
		String operation = reader.nextLine();
		// adding a number for a person
		while (!operation.equals("x")) {
			if (operation.equals("1")) {
				System.out.println("whose number:");
				String perName = reader.nextLine();
				System.out.println("number:");
				String perNumber = reader.nextLine();
				numbies.addNumber(perName, perNumber);
				System.out.println("command:");
				operation = reader.nextLine();
			}
			// Search for a phone number by typing the persons name in
			if (operation.equals("2")) {
				System.out.println("whose number:");
				String search = reader.nextLine();
				if (numbies.searchForANumber(search) == null) {
					System.out.println("not found");
				} else {
					for (String s : numbies.searchForANumber(search)) {
						System.out.println("" + s);
					}
					// System.out.println("\n");
				}
				System.out.println("command:");
				operation = reader.nextLine();
			}
			// Type in the phone number to find whose it is
			if (operation.equals("3")) {
				System.out.println("number:");
				String perNumber = reader.nextLine();
				if (numbies.searchforPerbyNumb(perNumber) == null) {
					System.out.println("not found");
				} else {
					System.out.println(" " + numbies.searchforPerbyNumb(perNumber));
				}
				System.out.println("command:");
				operation = reader.nextLine();

			}
			// Add an address to a person
			if (operation.equals("4")) {
				System.out.println("whose address:");
				String person = reader.nextLine();
				System.out.println("street");
				String street = reader.nextLine();
				System.out.println("city");
				String city = reader.nextLine();
				String address = street + " " + city;
				numbies.addAddress(person, address);
				System.out.println("command:");
				operation = reader.nextLine();
			}
			// find the persons personal info
			if (operation.equals("5")) {
				System.out.println("whose information:");
				String dude = reader.nextLine();
				if (numbies.searchAddress(dude) == null & numbies.searchForANumber(dude) == null) {
					System.out.println("  not found");
				} else if (numbies.searchAddress(dude) == null && numbies.searchForANumber(dude) != null) {
					System.out.println("  address unknown");
					System.out.println("  phone numbers:");
					for (String s : numbies.searchForANumber(dude)) {
						System.out.println("   " + s);
					}
				} else if ((numbies.searchAddress(dude) != null && numbies.searchForANumber(dude) == null)) {
					for (String s : numbies.searchAddress(dude)) {
						System.out.println("  address: " + s);
					}
					System.out.println("  phone number not found");
				} else {
					for (String s : numbies.searchAddress(dude)) {
						System.out.println("  address: " + s);
					}
					System.out.println("  phone numbers:");
					for (String s : numbies.searchForANumber(dude)) {
						System.out.println("   " + s);
					}
					// System.out.println("\n");
				}
				System.out.println("command:");
				operation = reader.nextLine();
			}
			// Delete all of the personal info for a person
			if (operation.equals("6")) {
				System.out.println("whose information");
				String dude = reader.nextLine();
				numbies.deletePersonal(dude);
				System.out.println("command:");
				operation = reader.nextLine();
			}
			// STILL WORKING ON THIS COMMAND
			/*
			 * if (operation.equals("7")) {
			 * System.out.print("keyword (if empty, all listed: "); String search =
			 * reader.nextLine();
			 * 
			 * List<String> results = numbies.searchContain(search); System.out.println("");
			 * for (String name : results) { System.out.println(" " + name);
			 * ArrayList<Set<String>> info = numbies.getPersonalInfo(name);
			 * 
			 * if (info.get(0) == null) { if (info.get(1) == null) {
			 * System.out.println("  not found"); } else {
			 * System.out.println("  address unknown");
			 * System.out.println("  phone numbers:"); for (String s : info.get(1)) {
			 * System.out.println("   " + s); } } } else if (info.get(1) == null &&
			 * info.get(0) != null) { System.out.print("  address: "); for (String s :
			 * info.get(0)) { System.out.println(s); }
			 * System.out.println("  phone number not found"); }
			 * 
			 * System.out.println(""); } System.out.println("command:"); operation =
			 * reader.nextLine(); }
			 */
		}
	}
}
