package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class PhoneAppWhileIf {
	public static void main(String[] args) throws IOException {

		BufferedReader bfFR = new BufferedReader(new FileReader("./PhoneDB.txt"));
		BufferedReader bfR = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bfW = new BufferedWriter(new OutputStreamWriter(System.out));

		List<Person> pList = new ArrayList<Person>();

		bfW.write("********************************\n" + "*       전화번호 관리 프로그램        *\n"
				+ "********************************");
		bfW.newLine();

		while (true) {
			bfW.write("1.리스트  2.등록  3.삭제  4.검색  5.종료\n" + "--------------------------------\n" + ">메뉴번호: ");
			bfW.flush();
			String num = bfR.readLine();

			if ("1".equals(num)) {

				bfW.write("<1.리스트>");
				bfW.flush();
				bfW.newLine();
				while (true) {
					String s = bfFR.readLine();

					if (s == null) {
						for (int i = 0; i < pList.size(); i++) {
							bfW.write((i + 1) + ".   ");
							bfW.flush();
							pList.get(i).showInfo();
						}
						bfW.newLine();
						break;
					}
					String[] sArray = s.split(",");
					Person person = new Person(sArray[0], sArray[1], sArray[2]);
					pList.add(person);
				}

			} else if ("2".equals(num)) {
				bfW.write("<2.등록>");
				bfW.newLine();
				bfW.flush();
				bfW.write(">이름: ");
				bfW.flush();
				String name = bfR.readLine();
				bfW.write(">휴대전화: ");
				bfW.flush();
				String hp = bfR.readLine();
				bfW.write(">회사전화: ");
				bfW.flush();
				String company = bfR.readLine();
				bfW.write("[등록되었습니다]");
				bfW.newLine();
				bfW.flush();
				bfW.newLine();

				Person p = new Person(name, hp, company);
				pList.add(p);

			} else if ("3".equals(num)) {
				bfW.write("<3.삭제>");
				bfW.newLine();
				bfW.flush();
				bfW.write(">번호: ");
				bfW.flush();
				String dNum = bfR.readLine();
				bfW.write("[삭제되었습니다.]");
				bfW.newLine();
				bfW.newLine();
				bfW.flush();

				int menuNum = Integer.parseInt(dNum);
				pList.remove(menuNum - 1);

			} else if ("4".equals(num)) {
				bfW.write("<4.검색>");
				bfW.newLine();
				bfW.write(">이름: ");
				bfW.flush();
				String search = bfR.readLine();
				for (int i = 0; i < pList.size(); i++) {
					if ((pList.get(i).getName()).contains(search)) {
						bfW.write(
								pList.get(i).getName() + "," + pList.get(i).getHp() + "," + pList.get(i).getCompany());
						bfW.newLine();
					}
				}
				bfW.newLine();

			} else if ("5".equals(num)) {
				bfW.newLine();
				bfW.write("********************************\n" + "*            감사합니다            *\n"
						+ "********************************");
				bfW.newLine();
				bfW.newLine();
				bfW.flush();
				break;

			} else {
				bfW.write("[다시 입력해 주세요.]");
				bfW.newLine();
				bfW.newLine();
				bfW.flush();
			}
		}

		BufferedWriter bfFW = new BufferedWriter(new FileWriter("./PhoneDB.txt"));
		for (int i = 0; i < pList.size(); i++) {
			bfFW.write(pList.get(i).getName() + "," + pList.get(i).getHp() + "," + pList.get(i).getCompany());
			bfFW.newLine();
		}

		bfFR.close();
		bfR.close();
		bfW.close();
		bfFW.close();
	}

}
