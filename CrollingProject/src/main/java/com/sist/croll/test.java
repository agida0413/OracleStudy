package com.sist.croll;

import com.sist.dao.ProductDAO;
import com.sist.dao.ProductVO;

public class test {

	public static void main(String[] args) {
		ProductVO vo = new ProductVO();
		ProductDAO dao = new ProductDAO();
		vo.setProduct_name("테스트");
		vo.setProduct_sale("15");
		vo.setProduct_price("asda");
		
		dao.productInsert(vo);
	}
}
