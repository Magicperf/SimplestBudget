package com.magitech.simplestbudget;

public class System {
	public System(User user){
		Database db = new Database();
		db.SaveUserData(user);
	}
	public static void main(String[] args) {
		//Start
		//Load Database
		Database dBase = new Database();
		//Create Objects from Database File
		User user = dBase.LoadUserData();
		//GUI Display User Control
		GUI gui = new GUI(user);
		gui.prepareFrame();
		//Save User Changes in DB
		dBase.SaveUserData(user);
		//Exit
	}
}
