package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.AddressDto;
import singleton.Singleton;

// Data Access Object
public class AddressDao {
	// 데이터를 편집하는 클래스
	// 데이터를 다루는 클래스
	
	Scanner sc = new Scanner(System.in);
	
	//List<AddressDto> addressBook = new ArrayList<AddressDto>();
	//private List<AddressDto> addressList = null;
	
	public AddressDao() {	
		
	}
	
	public void insert() {//데이터 추가
		// TODO : insert()
		
		System.out.println("데이터를 추가합니다");
		
		System.out.print("이름 = ");
		String name = sc.next();
		
		System.out.print("나이 = ");
		int age = sc.nextInt();
		
		System.out.print("전화번호 = ");
		String phone = sc.next();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("주소 = ");
		String address = "";
		try {
			address = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("메모 = ");
		String memo = "";
		try {
			memo = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Singleton s = Singleton.getInstance();
		s.addressList.add(new AddressDto(name, age, phone, address, memo));
	
		System.out.println();
	}
	
	public void delete() {//데이터 삭제
		// TODO : delete()
		System.out.print("삭제할 이름 = ");
		String name = sc.next();
		
		int index = search(name);
		
		if(index == -1) {
			System.out.println("정보를 찾을 수 없습니다");
			
		}else {
			Singleton s = Singleton.getInstance();
			s.addressList.remove(index);
			System.out.println("삭제완료");
		}
	}
	
	public void select() {//데이터 검색 -> 이름으로 검색
		// TODO : select()
		System.out.print("검색할 지인의 이름 >> ");
		String name = sc.next();
		
		List<AddressDto> findNameList = new ArrayList<AddressDto>();
		
		Singleton s = Singleton.getInstance();
		
		for (int i = 0; i < s.addressList.size(); i++) {
			AddressDto dto = s.addressList.get(i);
			if(name.equals(dto.getName())) {
				findNameList.add(dto); // 같은 이름의 사람들을 출력
			}
		}
			
		if(findNameList.size() == 0) { // findNameList가 한명이 없을때
			System.out.println("입력하신 이름의 정보는 없습니다");
			return;
		}
		System.out.println("검색된 명단 입니다 ---");
		for (int i = 0; i < findNameList.size(); i++) {
			System.out.println(findNameList.get(i).toString());
		}
	}
	
	public void update() {//데이터 수정
		// TODO : update()
		System.out.print("검색할 이름 = ");
		String name = sc.next();
		
		//검색
		int index = search(name);
		if(index == -1) {
			System.out.println("정보를 찾을 수 없습니다");
		}
	}
	
	public int search(String name) {
		// TODO : search()
		int index = -1;
		Singleton s = Singleton.getInstance();
		for (int i = 0; i < s.addressList.size(); i++) {
			AddressDto dto = s.addressList.get(i); // 하나씩 뽑아서 dto에 담기
			if(name.equals(dto.getName())) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	
	// 확인용으로 만든것
	public void allDataPrint() {
		// TODO : allDataPrint()
		Singleton s = Singleton.getInstance();
		if(s.addressList.isEmpty()) { // addressList.size == 0
			System.out.println("데이터가 없습니다");
			return;
		}
		
		for (int i = 0; i < s.addressList.size(); i++) {
			System.out.println(s.addressList.get(i).toString());
		}		
	}
}
























