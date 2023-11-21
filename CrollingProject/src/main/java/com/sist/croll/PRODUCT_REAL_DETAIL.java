package com.sist.croll;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.PRODUCT_REAL_DETAILDAO;
import com.sist.dao.ProductDetailDAO;
import com.sist.dao.ProductDetailVO;
import com.sist.dao.*;

public class PRODUCT_REAL_DETAIL {
	 public static void main(String[] args) {
		   
		  int testcount = 0;
	      // TODO Auto-generated method stub
	    PRODUCT_REAL_DETAILDAO dao = new PRODUCT_REAL_DETAILDAO();

	      
	      for(int k =1; k<=37;k++) {
	      try
	      {
	         Document doc=Jsoup.connect("https://www.dogpang.com/shop/goods/goods_best.php?page="+k).get();

	         Elements product_name = doc.select("div.flex-contents > a.flex-link > span");
	     	Elements sub = doc.select("div.user-num a.flex-link");
	     	
			
	         
			
	         		
	         		for(int i =0; i<product_name.size();i++) {
	         			
	         			String subUrl="https://www.dogpang.com";
	         			String subPlus =sub.get(i).attr("href");
	         			String subLink = subUrl+subPlus;
	         			Document detail=Jsoup.connect(subLink).get();
	         			
	         			
	         			Element detail_text = detail.selectFirst("div#content_view_desc"); 
	         			Element detail_inform_image =detail.selectFirst("div.long_sangse img");

	         			
	         			PRODUCT_REAL_DETAILVO vo =new PRODUCT_REAL_DETAILVO();
	         			
	         			
//	         			if (detail_text==null) {
//							vo.setDetail_text("");
//						}
//	         			else {
//	         				vo.setDetail_text(detail_text.text());
//						}
	         				
	         			
//	         				if (detail_inform_image==null) {
////								vo.setDetail_inform_image("");
//	         					System.out.println("없음");
//							}
//	         				else {
////	         					vo.setDetail_inform_image(detail_inform_image.attr("src"));
//	         					System.out.println(detail_inform_image.attr("src"));
//							}
	         				testcount++;
	         				System.out.println(testcount);
	         		
	         			
	         		
	         			
	         			
	         			
	         				
	         			
//	         				dao.product_real_detail_insert(vo);
//	         				testcount++;
//	         				System.out.println(testcount);
	         			
	         			
	         
	         			
	         			
	         		
	         			
	         	

	     	
	         		}
	         		
	         		
	         		
	   
	        		 			
	        	 
	        	 
	         }
	        	
	      
	        
	        	
					
				
	      
	       
	        
	         
	        	 			 
	        	

	         
	         
	      catch(Exception ex) {}
	      }
	      
	   
		System.out.println("END...");

	   }
	 
	 
}
	      

