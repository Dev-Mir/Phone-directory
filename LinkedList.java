
//task2 LinkedList with tail
//task3 method that takes head as parameter and detect weather linked list contains cycle
import java.util.*;

import javax.print.DocFlavor.STRING;

class Node {
	String name;
	String number;
	Node next;
	Node prev;

	Node(String name2, String number2) {
		this.name = name2;
		this.number = number2;
		next = null;
	}
}

class LinkedList {
	Node head = null;
	Node tail = null;

	public void addContact(String name, String number) {
		Node node = new Node(name, number);
		// Node node2 = new Node(number);

		if (head != null) {
			node.prev = tail;
			tail.next = node;
			tail = node;
		} else {
			head = node;
			tail = head;
		}
		System.out.println("Contact is added");
		showContacts();
	}

	public void delete(String name) {
		// Node rem = new Node(name, number);
		if (head == null) {
			System.out.println("value deos not exist in list");
			showContacts();
		}

		Node temp = head;
		Node prev = head;

		if (temp.name.equals(name)) {
			head = temp.next; // Change head
			System.out.println("head is removed");
			showContacts();
		}
		boolean b = false;
		while (temp.next != null) {
			prev = temp;
			temp = temp.next;
			if (temp.name.equals(name)) {
				prev.next = temp.next;
				// temp = temp.next;
				System.out.println("deleted successfully..");
				b = true;
			}
		}
		if (!b)
			System.out.println("value deos not exist in list");
		
		showContacts();

	}

	public void search(String nam) {
		Node temp = head;

		boolean bol = false;
		while (temp != null) {
			if (temp.name.equals(nam)) {
				System.out.println("the contact : " + nam + "  is in the contact list \n\n");
				bol = true;
				menu();
			}
			temp = temp.next;
		}

		if (bol == false) {
			System.out.println("the contact is not found\n\n");
			menu();
		}

	}

	public void showContacts() {
		Scanner sc = new Scanner(System.in);
		Node temp = head;
		if (temp != null) {
			System.out.println("*****Contacts******");
			System.out.println("Name  	   :  	    Number");
			while (temp != null) {
				System.out.println("*************************");
				System.out.println(temp.name + "	   :     	" + temp.number);
				temp = temp.next;
			}
		} else {
			System.out.println("Contacts not found");
		}
		System.out.println("\nif you want add more contacts type y, if not type n");
		String n = sc.next();
		if (n.equals("y")) {
			System.out.println("enter the name:");
			String name = sc.next();
			System.out.println("now enter number: ");
			String number = sc.next();
			addContact(name, number);
		} else if (n.equals("n")) {
			System.out.println();
			menu();
		}
	}

	public void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"what would you like? \n 1) Show all contacts.\n 2) Add new Contact. \n 3) Delete any contact. \n 4) search any contact \n 5) Exit");

		int a = sc.nextInt();

		if (a == 1) {
			showContacts();
		} else if (a == 2) {
			System.out.println("enter the name:");
			String name = sc.next();
			System.out.println("now enter number: ");
			String number = sc.next();
			addContact(name, number);
		} else if (a == 3) {
			System.out.println("enter the name to delete contact");
			String nam = sc.next();
			delete(nam);
		} else if (a == 4) {
			System.out.println("Enter name to search the contact :");
			String na = sc.next();
			search(na);

		} else if (a == 5) {
			System.out.println();
		}
	}

	public static void main(String[] args) {

		LinkedList li = new LinkedList();
		li.menu();

	}
}