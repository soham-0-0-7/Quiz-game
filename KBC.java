//This program requires proper sql installation and setup followed by database creation
//I personally have used Xammpp.

package d_SQLConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class KBC {
	public static int idx = 0;

	public static void main(String args[]) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://root@localhost:3306/KBC");
		Statement stmt = null;

		if(c==null) {
			System.out.print("FAILURE !!");
			System.exit(0);
		} else {
			System.out.print("SUCCESS !!");
		}

		stmt = c.createStatement();


		DatabaseMetaData databaseMetaData = c.getMetaData();
		ResultSet resultSet = databaseMetaData.getTables(null, null, "GAME", null);
		String sql = "";
		String Q = "";
		String RA = "";
		String WA1 = "";
		String WA2 = "";
		String WA3 = "";

		if(resultSet.next()){
			System.out.println("exists");

			sql = "DROP TABLE GAME";
			stmt.execute(sql);

			sql = "CREATE TABLE GAME(" +
					"Sr int(10), " +
					"Question varchar(1000), " +
					"Right_Answer varchar(100), " +
					"Wrong_Answer_A varchar(100), " +
					"Wrong_Answer_B varchar(100), " +
					"Wrong_Answer_C varchar(100)) ";
			stmt.execute(sql);

		} else {
			System.out.println("doesnt exists");
			sql = "CREATE TABLE GAME(" +
					"Sr int(10), " +
					"Question varchar(1000), " +
					"Right_Answer varchar(100), " +
					"Wrong_Answer_A varchar(100), " +
					"Wrong_Answer_B varchar(100), " +
					"Wrong_Answer_C varchar(100)) ";
			stmt.execute(sql);
		}

			Q = "'Who has the highest ODI score?'";
			RA = "'Rohit Sharma'";
			WA1 = "'Virat Kohli'";
			WA2 = "'Martin Guptill'";
			WA3 = "'Chris Gayle'";

			sql = "INSERT INTO GAME VALUES (1," + Q + "," + RA + "," + WA1 + "," + WA2 + "," + WA3 + ")";
			stmt.execute(sql);

			Q = "'Which planet in the solar system is known as the Red Planet'";
			RA = "'Mars'";
			WA1 = "'Jupiter'";
			WA2 = "'Saturn'";
			WA3 = "'Uranus'";

			sql = "INSERT INTO GAME VALUES (2," + Q + "," + RA + "," + WA1 + "," + WA2 + "," + WA3 + ")";
			stmt.execute(sql);

			Q = "'What is the capital of Japan?'";
			RA = "'Tokyo'";
			WA1 = "'Beijing'";
			WA2 = "'Bangkok'";
			WA3 = "'Kyoto'";

			sql = "INSERT INTO GAME VALUES (3," + Q + "," + RA + "," + WA1 + "," + WA2 + "," + WA3 + ")";
			stmt.execute(sql);

			Q = "'What animal is the national symbol of Australia?'";
			RA = "'Kangaroo'";
			WA1 = "'Koala'";
			WA2 = "'Tiger'";
			WA3 = "'Lion'";

			sql = "INSERT INTO GAME VALUES (4," + Q + "," + RA + "," + WA1 + "," + WA2 + "," + WA3 + ")";
			stmt.execute(sql);

			Q = "'What chemical element is designated as “Hg”'";
			RA = "'Mercury'";
			WA1 = "'Tin'";
			WA2 = "'Copper'";
			WA3 = "'Silver'";

			sql = "INSERT INTO GAME VALUES (5," + Q + "," + RA + "," + WA1 + "," + WA2 + "," + WA3 + ")";
			stmt.execute(sql);

			Q = "' Which is the largest island?'";
			RA = "'Greenland'";
			WA1 = "'Hawaii'";
			WA2 = "'Andaman Nicobar'";
			WA3 = "'New Guinea'";

			sql = "INSERT INTO GAME VALUES (6," + Q + "," + RA + "," + WA1 + "," + WA2 + "," + WA3 + ")";
			stmt.execute(sql);

			Q = "'What is considered the lung of the Earth?'";
			RA = "'Amazon rainforest'";
			WA1 = "'Mississippi River'";
			WA2 = "'The Sahara'";
			WA3 = "'Everest'";

			sql = "INSERT INTO GAME VALUES (7," + Q + "," + RA + "," + WA1 + "," + WA2 + "," + WA3 + ")";
			stmt.execute(sql);

			Q = "'Which county is the biggest grower of coffee?'";
			RA = "'Brazil'";
			WA1 = "'Ethiopia'";
			WA2 = "'India'";
			WA3 = "'Spain'";

			sql = "INSERT INTO GAME VALUES (8," + Q + "," + RA + "," + WA1 + "," + WA2 + "," + WA3 + ")";
			stmt.execute(sql);

			Q = "'How many bones are in the body of an adult human?'";
			RA = "'206'";
			WA1 = "'207'";
			WA2 = "'208'";
			WA3 = "'209'";

			sql = "INSERT INTO GAME VALUES (9," + Q + "," + RA + "," + WA1 + "," + WA2 + "," + WA3 + ")";
			stmt.execute(sql);

			Q = "'What element is the main constituent of diamonds?'";
			RA = "'Carbon'";
			WA1 = "'Oxygen'";
			WA2 = "'Silver'";
			WA3 = "'Gold'";

			sql = "INSERT INTO GAME VALUES (10," + Q + "," + RA + "," + WA1 + "," + WA2 + "," + WA3 + ")";
			stmt.execute(sql);


		ResultSet rs = stmt.executeQuery("SELECT * FROM GAME");

		ArrayList<Questions> questions = new ArrayList<>();

		while(rs.next()) {
			questions.add(new Questions(rs.getString("Question"),rs.getString("Right_Answer"),rs.getString("Wrong_Answer_A"),rs.getString("Wrong_Answer_B"),rs.getString("Wrong_Answer_C")));
		}

//		System.out.println(questions);


		JFrame window = new JFrame("GAME");
		window.setLayout(new GridLayout(2,1));

		window.setVisible(true); window.setSize(500,500); window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel Qp = new JPanel(new FlowLayout(FlowLayout.CENTER)); Qp.setBackground((Color.BLUE));
		JPanel Ap = new JPanel(new GridLayout(2,2));

		JLabel ll = new JLabel(questions.get(idx).q); ll.setForeground(Color.white);

		JPanel o1 = new JPanel(new FlowLayout()); o1.setBackground(Color.blue);
		JPanel o2 = new JPanel(new FlowLayout());o2.setBackground(Color.blue);
		JPanel o3 = new JPanel(new FlowLayout());o3.setBackground(Color.blue);
		JPanel o4 = new JPanel(new FlowLayout());o4.setBackground(Color.blue);

		OB ww0 = new OB(questions.get(idx).ro);
		ww0.setRight();
		OB ww1 = new OB(questions.get(idx).wo1);
		OB ww2 = new OB(questions.get(idx).wo2);
		OB ww3 = new OB(questions.get(idx).wo3);

		Random rng = new Random();
		int arrangement = rng.nextInt(1,5);

//		System.out.println(arrangement);
		if(arrangement == 1) {
			o1.add(ww0);
			o2.add(ww1);
			o3.add(ww2);
			o4.add(ww3);
		} else if(arrangement == 2 ){
			o1.add(ww3);
			o2.add(ww0);
			o3.add(ww1);
			o4.add(ww2);
		} else if(arrangement == 3){
			o1.add(ww3);
			o2.add(ww2);
			o3.add(ww0);
			o4.add(ww1);
		}else {
			o1.add(ww2);
			o2.add(ww3);
			o3.add(ww1);
			o4.add(ww0);
		}

		Ap.add(o1);
		Ap.add(o2);
		Ap.add(o3);
		Ap.add(o4);

		Qp.add(ll);

		window.add(Qp);window.add(Ap);

		ww0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ww0.isRight) {
					idx++;
					int arrng = rng.nextInt(1, 5);


					if (idx < questions.size()) {
						ll.setText(questions.get(idx).q);
						if(arrng == 1) {
							ww0.setText(questions.get(idx).ro);
							ww0.setRight();
							ww1.setText(questions.get(idx).wo1);
							ww1.setWrong();
							ww2.setText(questions.get(idx).wo2);
							ww2.setWrong();
							ww3.setText(questions.get(idx).wo3);
							ww3.setWrong();
						} else if(arrng == 2 ){
							ww1.setText(questions.get(idx).ro);
							ww1.setRight();
							ww0.setText(questions.get(idx).wo1);
							ww0.setWrong();
							ww2.setText(questions.get(idx).wo2);
							ww2.setWrong();
							ww3.setText(questions.get(idx).wo3);
							ww3.setWrong();
						} else if(arrng == 3){
							ww2.setText(questions.get(idx).ro);
							ww2.setRight();
							ww1.setText(questions.get(idx).wo1);
							ww1.setWrong();
							ww0.setText(questions.get(idx).wo2);
							ww0.setWrong();
							ww3.setText(questions.get(idx).wo3);
							ww3.setWrong();
						} else {
							ww3.setText(questions.get(idx).ro);
							ww3.setRight();
							ww1.setText(questions.get(idx).wo1);
							ww1.setWrong();
							ww0.setText(questions.get(idx).wo2);
							ww0.setWrong();
							ww2.setText(questions.get(idx).wo3);
							ww2.setWrong();
						}
					} else {
						JOptionPane.showMessageDialog(window, "You WON!!!", "WINNER", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
				} else {
					JOptionPane.showMessageDialog(window, "You LOST!!!", "SORRY", JOptionPane.WARNING_MESSAGE);
					System.exit(0);
				}
			}
		});

		ww1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ww1.isRight) {
					idx++;
					int arrng = rng.nextInt(1, 5);


					if (idx < questions.size()) {
						ll.setText(questions.get(idx).q);
						if(arrng == 1) {
							ww0.setText(questions.get(idx).ro);
							ww0.setRight();
							ww1.setText(questions.get(idx).wo1);
							ww1.setWrong();
							ww2.setText(questions.get(idx).wo2);
							ww2.setWrong();
							ww3.setText(questions.get(idx).wo3);
							ww3.setWrong();
						} else if(arrng == 2 ){
							ww1.setText(questions.get(idx).ro);
							ww1.setRight();
							ww0.setText(questions.get(idx).wo1);
							ww0.setWrong();
							ww2.setText(questions.get(idx).wo2);
							ww2.setWrong();
							ww3.setText(questions.get(idx).wo3);
							ww3.setWrong();
						} else if(arrng == 3){
							ww2.setText(questions.get(idx).ro);
							ww2.setRight();
							ww1.setText(questions.get(idx).wo1);
							ww1.setWrong();
							ww0.setText(questions.get(idx).wo2);
							ww0.setWrong();
							ww3.setText(questions.get(idx).wo3);
							ww3.setWrong();
						}else {
							ww3.setText(questions.get(idx).ro);
							ww3.setRight();
							ww1.setText(questions.get(idx).wo1);
							ww1.setWrong();
							ww0.setText(questions.get(idx).wo2);
							ww0.setWrong();
							ww2.setText(questions.get(idx).wo3);
							ww2.setWrong();
						}
					} else {
						JOptionPane.showMessageDialog(window, "You WON!!!", "WINNER", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
				} else{
					JOptionPane.showMessageDialog(window, "You LOST!!!", "SORRY", JOptionPane.WARNING_MESSAGE);
					System.exit(0);
				}
			}
		});

		ww2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ww2.isRight) {
					idx++;
					int arrng = rng.nextInt(1, 5);


					if (idx < questions.size()) {
						ll.setText(questions.get(idx).q);
						if(arrng == 1) {
							ww0.setText(questions.get(idx).ro);
							ww0.setRight();
							ww1.setText(questions.get(idx).wo1);
							ww1.setWrong();
							ww2.setText(questions.get(idx).wo2);
							ww2.setWrong();
							ww3.setText(questions.get(idx).wo3);
							ww3.setWrong();
						}
						else if(arrng == 2 ){
							ww1.setText(questions.get(idx).ro);
							ww1.setRight();
							ww0.setText(questions.get(idx).wo1);
							ww0.setWrong();
							ww2.setText(questions.get(idx).wo2);
							ww2.setWrong();
							ww3.setText(questions.get(idx).wo3);
							ww3.setWrong();
						} else if(arrng == 3){
							ww2.setText(questions.get(idx).ro);
							ww2.setRight();
							ww1.setText(questions.get(idx).wo1);
							ww1.setWrong();
							ww0.setText(questions.get(idx).wo2);
							ww0.setWrong();
							ww3.setText(questions.get(idx).wo3);
							ww3.setWrong();
						}else {
							ww3.setText(questions.get(idx).ro);
							ww3.setRight();
							ww1.setText(questions.get(idx).wo1);
							ww1.setWrong();
							ww0.setText(questions.get(idx).wo2);
							ww0.setWrong();
							ww2.setText(questions.get(idx).wo3);
							ww2.setWrong();
						}
					} else {
						JOptionPane.showMessageDialog(window, "You WON!!!", "WINNER", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
				} else{
					JOptionPane.showMessageDialog(window, "You LOST!!!", "SORRY", JOptionPane.WARNING_MESSAGE);
					System.exit(0);
				}
			}
		});

		ww3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ww3.isRight) {
					idx++;
					int arrng = rng.nextInt(1, 5);


					if (idx < questions.size()) {
						ll.setText(questions.get(idx).q);
						if(arrng == 1) {
							ww0.setText(questions.get(idx).ro);
							ww0.setRight();
							ww1.setText(questions.get(idx).wo1);
							ww1.setWrong();
							ww2.setText(questions.get(idx).wo2);
							ww2.setWrong();
							ww3.setText(questions.get(idx).wo3);
							ww3.setWrong();
						}
						else if(arrng == 2 ){
							ww1.setText(questions.get(idx).ro);
							ww1.setRight();
							ww0.setText(questions.get(idx).wo1);
							ww0.setWrong();
							ww2.setText(questions.get(idx).wo2);
							ww2.setWrong();
							ww3.setText(questions.get(idx).wo3);
							ww3.setWrong();
						} else if(arrng == 3){
							ww2.setText(questions.get(idx).ro);
							ww2.setRight();
							ww1.setText(questions.get(idx).wo1);
							ww1.setWrong();
							ww0.setText(questions.get(idx).wo2);
							ww0.setWrong();
							ww3.setText(questions.get(idx).wo3);
							ww3.setWrong();
						}else {
							ww3.setText(questions.get(idx).ro);
							ww3.setRight();
							ww1.setText(questions.get(idx).wo1);
							ww1.setWrong();
							ww0.setText(questions.get(idx).wo2);
							ww0.setWrong();
							ww2.setText(questions.get(idx).wo3);
							ww2.setWrong();
						}
					} else {
						JOptionPane.showMessageDialog(window, "You WON!!!", "WINNER", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
				} else{
					JOptionPane.showMessageDialog(window, "You LOST!!!", "SORRY", JOptionPane.WARNING_MESSAGE);
					System.exit(0);
				}
			}
		});

	}
}

class Questions{
	public String q;
	public String ro;
	public String wo1;
	public String wo2;
	public String wo3;

	public Questions(String q, String ro, String wo1, String wo2, String wo3) {
		this.q = q;
		this.ro = ro;
		this.wo1 = wo1;
		this.wo2 = wo2;
		this.wo3 = wo3;
	}
}

class OB extends JButton  {
	public boolean isRight = false;

	public void setRight(){
		this.isRight = true;
	}

	public void setWrong(){
		this.isRight = false;
	}

	OB(){}

	OB(String m){
		super(m);
	}
}
