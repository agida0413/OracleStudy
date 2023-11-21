package com.sist.croll;


import java.util.*;

import java.io.*;
import java.text.DecimalFormat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.*;
public class product_detail_list {

   public static void main(String[] args) {
	   
	  
      // TODO Auto-generated method stub
     ProductDetailDAO dao= new ProductDetailDAO();
     

      
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
         			
         			
         			Element category=detail.selectFirst("div#location a"); //카테고리
         			Element shipment=detail.selectFirst("dl.price-basic span.free_delivery_check ");
         			Element product_stack = detail.selectFirst("div.jss821 div.layerPopWrapper span.important");
         			Element product_expireDate=detail.selectFirst("a.expire_layer");
         			

         			
         			
         			ProductDetailVO vo =new ProductDetailVO();
         			
         			//이름
         			vo.setProduct_name(product_name.get(i).text());
         			//카테고리
         			vo.setProduct_category(category.text());
         			
         	
         			
         			
         			//배송비
         			vo.setShipment(shipment.text());
         			//재고
         			if (product_stack==null) {
						vo.setProduct_stack(0);
					}
         			else {
         				vo.setProduct_stack(Integer.parseInt(product_stack.text()));
					}
             	
         			
         				
         			

         			//유통기한
         			String expireD = product_expireDate.text().replace("상세보기", "").trim();
         			vo.setProduct_expire_date(expireD);
         			
         			
         			dao.product_detail_Insert(vo);
         			
         			
         				
         			
         			
         			
         
         			
         			
         		
         			
         	

     	
         		}
         		
         		
         		
   
        		 			
        	 
        	 
         }
        	
      
        
        	
				
			
      
       
        
         
        	 			 
        	

         
         
      catch(Exception ex) {}
      }
      
   
	System.out.println("END...");
	
	
   }
}
     

         
         

   
   
   


