package repositories;


import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class UserRepository {
	private Map<String, String> users;
	
	public UserRepository() {
		this.users = new HashMap<>();
		loadData();
	}
	
	public void addUser(String username, String password) {
		users.put(username, password);
		saveData();
	}
	
	public boolean verifyUser(String username, String password) {
		String pw = users.get(username);
		return users.containsKey(username) && pw.equals(password);
	}
	
	private void loadData() {
		try(BufferedReader br = new BufferedReader(new FileReader("users.txt"))){
			String line;
			while((line = br.readLine())!=null) {
				String[] user = line.split(",");
				users.put(user[0], user[1]);
			}
		} catch(IOException e) {
			System.out.println("Error loading user data");
		}
	}
	
	private void saveData() {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt"))){
			for(Map.Entry<String, String> entry : users.entrySet()) {
				bw.write(entry.getKey() + "," + entry.getValue());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Erro saving user data");
		}
	}
}
