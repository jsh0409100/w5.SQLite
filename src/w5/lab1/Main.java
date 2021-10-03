package w5.lab1;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManger;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) {
		Connetion con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String dbFile = "myfirst.db";
			con = DriverManager.getConnection("jdbc:sqlite:" +dbFile);
			
			System.out.println("\n***������ ��ȸ ***\n");
			Statement stat1 = con.createStatement();
			String sql1 = "select * from g_artists";
			ResultSet rs1 = stat1.executeQuery(sql1);
			while (rs1.next()) {
				Sting id = rs1.getString("id");
				String name = rs1.getString("name");
				System.out.println(id + " " + name);
			}
			stat1.close();
			
			System.out.println("\n***�� ������ �߰�***");
			Statement stat2 = con.createeStatement();
			String sql2 = "insert into g_artists (anem, a_type, a_year, debut, regdate)" + " values ('��ź�ҳ��, '����', '2010���', '2013��', datetime('now', 'localtime'));";
			int cnt = stat2.executeUpdate(sql2);
			if (cnt>0)
				System.out.println("���ο� �����Ͱ� �߰��Ǿ����ϴ�!");
			else
				System.out.println("[Error] �������߰� ����!");
			stat2.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {}
				
				}
			}
		}
		System.out.print("Hello World");
	}

}
