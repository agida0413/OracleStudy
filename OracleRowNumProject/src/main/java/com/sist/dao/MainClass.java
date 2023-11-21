package com.sist.dao;
import java.util.*;
public class MainClass {
	public static void main(String[] args) {

			MovieDAO dao = new MovieDAO();
			Scanner scan =new Scanner(System.in);
			int total = dao.movieTotalPage();
			
			System.out.println("페이지 입력(1~ "+total+"):");
			int page = scan.nextInt();
			List<MovieVO> list = dao.movieListData(page);
			for(MovieVO vo : list) {
				System.out.println(vo.getMno()+"."+vo.getTitle());
				
			}
	}
}