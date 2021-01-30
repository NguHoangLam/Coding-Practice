package UserSevice;

import Model.DataStorge;

public class UserManager {
	DataStorge dataStorge;

	public UserManager(DataStorge dataStorge) {
		this.dataStorge = dataStorge;
	}

	public boolean addNewUser(String lastName, String firstName, String password, String gender, String dateOfBirth,
			String userName) {
		return dataStorge.addNewAccount(lastName, firstName, password, gender, dateOfBirth, userName);
	}

	public boolean login(String username, String password) {
		return dataStorge.checkAccount(username, password);
	}

	public String login(String keyword) {
		return dataStorge.findFriendByName(keyword);

	}

}
