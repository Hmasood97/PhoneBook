import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhoneBook {
	// Store names
	private Set<String> names;
//Store numbers, key is name. Can have infinite numbers for each person.
	private HashMap<String, Set<String>> phoneNumbers;
//store addresses, key is name. an have infinite addresses for each person.
	private HashMap<String, Set<String>> addresses;

	public PhoneBook() {
		this.names = new HashSet<String>();
		this.phoneNumbers = new HashMap<String, Set<String>>();
		this.addresses = new HashMap<String, Set<String>>();
	}

	public void addPerson(String name) {
		if (!names.contains(name)) {
			this.names.add(name);
		}
	}

	public void addNumber(String name, String number) {
		addPerson(name);
		if (!this.phoneNumbers.keySet().contains(name)) {
			this.phoneNumbers.put(name, new HashSet<String>());
			this.phoneNumbers.get(name).add(number);
		} else {
			this.phoneNumbers.get(name).add(number);
		}
	}

	public void addAddress(String name, String address) {
		if (!this.addresses.keySet().contains(name)) {
			this.addresses.put(name, new HashSet<String>());
			this.addresses.get(name).add(address);
		} else {
			this.addresses.get(name).add(address);
		}
	}

	public void deletePersonal(String person) {
		addresses.remove(person);
		phoneNumbers.remove(person);

	}

	public Set<String> searchForANumber(String search) {
		for (String s : this.phoneNumbers.keySet()) {
			if (search.equals(s)) {
				return this.phoneNumbers.get(s);
			}
		}

		return null;
	}

	public String searchforPerbyNumb(String search) {
		for (String s : this.phoneNumbers.keySet()) {
			for (String t : this.phoneNumbers.get(s))
				if (search.equals(t)) {
					return s;
				}
		}

		return null;
	}

	public Set<String> searchAddress(String person) {
		for (String s : this.addresses.keySet()) {
			if (person.equals(s)) {
				return this.addresses.get(s);
			}
		}
		return null;
	}

	// used for command 7. Working on it still
	public List<String> searchContain(String search) {
		Set<String> results = new HashSet<String>();
		List<String> orderedResults = new ArrayList<String>();
		for (String name : names) {
			if (name.contains(search))
				results.add(name);
		}
		for (String name : this.addresses.keySet()) {
			for (String address : this.addresses.get(name)) {
				if (address.contains(search))
					results.add(name);
			}
		}

		for (String name : results) {
			orderedResults.add(name);
		}
		Collections.sort(orderedResults);

		return orderedResults;
	}

	// used for command 7. Working on it still
	public ArrayList<Set<String>> getPersonalInfo(String name) {
		ArrayList<Set<String>> info = new ArrayList<Set<String>>();
		info.add(searchAddress(name));
		info.add(searchForANumber(name));

		return info;
	}
}
