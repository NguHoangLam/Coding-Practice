package UserSevice;

import java.util.Scanner;

import Model.DataStorge;
import Model.User;

public class Menu {

	private Scanner sc;
	private UserManager mngUser;
	private DataStorge dateStorage;
	private User user = null;

	public Menu() {
		dateStorage = new DataStorge("D:\\SavePoint", "BackupData.dat");
		mngUser = new UserManager(dateStorage);
		sc = new Scanner(System.in);
	}

	public void doTask() {

		int get;
		do {
			printMenu();
			get = sc.nextInt();
			sc.nextLine();
			switch (get) {

			case 1:
				doAddAccount();
				break;
			case 2:
				doLogin();
				break;
			case 3:
				doFindFriendByName();
				break;
			case 4:
				break;
			default:
				System.out.println("Wrong input");

			}
			System.out.println("");
		} while (get != 10);
	}

	private void printMenu() {
		if (user != null) {
			System.out.println("Welcome " + user.getUserName());
		}
		System.out.println("----------------\n1.Add Full-time Employee" + "\n2.Login" + "\n3.Search" + "\n10.Exit");
	}

	public void doAddAccount() {
		String lastName, firstName, password, gender, dateOfBirth, userName;
		System.out.print("Enter username: ");
		userName = sc.nextLine();
		System.out.print("Enter password: ");
		password = sc.nextLine();
		System.out.print("Enter First Name: ");
		firstName = sc.nextLine();
		System.out.print("Enter Last Name: ");
		lastName = sc.nextLine();
		System.out.print("Enter Gender : ");
		gender = sc.nextLine();
		System.out.print("Enter Date of Birth: ");
		dateOfBirth = sc.nextLine();
		if (mngUser.addNewUser(lastName, firstName, password, gender, dateOfBirth, userName)) {
			System.out.println("Add Account successful");
		} else {
			System.out.println("Add Account unsuccessful");
		}

	}

	public void doLogin() {
		String userName, password;
		System.out.print("Enter username: ");
		userName = sc.nextLine();
		System.out.print("Enter password: ");
		password = sc.nextLine();
		User temporary = mngUser.login(userName, password);
		if (temporary != null) {
			this.user = temporary;
			System.out.println("Login successful");
		} else {
			System.out.println("Login unsuccessful");
		}

	}

	public void doFindFriendByName() {
		String keyword;
		System.out.print("Enter keyword: ");
		keyword = sc.nextLine();
		String result = mngUser.Search(keyword);
		if (result.length() > 0) {
			System.out.println(result);
		} else {
			System.out.println("Cannot Find");
		}

	}

}
