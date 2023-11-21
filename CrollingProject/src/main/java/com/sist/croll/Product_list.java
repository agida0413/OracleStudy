package com.sist.croll;


import java.util.*;

import java.io.*;
import java.text.DecimalFormat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.*;
public class Product_list {

   public static void main(String[] args) {
	   
	   int testCount =0;
      // TODO Auto-generated method stub
      ProductDAO dao=new ProductDAO();
      ArrayList<ProductVO>list2 = new ArrayList<ProductVO>();
      ArrayList<String> list =new ArrayList<String>();
      ArrayList<String>img_list=new ArrayList<String>();
      
//      for(int k =1; k<=37;k++) {
//    	  Document doc;
//		try {
//			doc = Jsoup.connect("https://www.dogpang.com/shop/goods/goods_best.php?page="+k).get();
//			 Elements product_img =doc.select("img.list-img-source");
//		       	Elements product_img2=doc.select("img.list-img-source-full");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	 
//      }
//      
      
      for(int k =1; k<=37;k++) {
      try
      {
         Document doc=Jsoup.connect("https://www.dogpang.com/shop/goods/goods_best.php?page="+k).get();

         Elements product_name = doc.select("div.flex-contents > a.flex-link > span");
       
     	Elements product_sale = doc.select("div.flex-contents span");
     	Elements product_price = doc.select("div.flex-contents strong.price");
     	Elements product_rank = doc.select("span[style=\"line-height: 30px;\"] > span[style=\"font-size:16px;font-weight: 500;\"]");
     	Elements product_grade = doc.select("div.grade strong");
     	Elements product_img =doc.select("img.list-img-source ,img.list-img-source-full");
     	Elements sub = doc.select("div.user-num a.flex-link");
     	//할인리스트
		for (Element element : product_sale) {
	    	   
			if ((element.text().contains("%")&&element.text().length()<=3) || element.text().equals("")) {
				list.add(element.text());
			}
		}
		//할인리스트 애드 종료
         
		
         		
         		for(int i =0; i<product_name.size();i++) {
         			
//         			String subUrl="https://www.dogpang.com";
//         			String subPlus =sub.get(i).attr("href");
//         			String subLink = subUrl+subPlus;
//         			
//         			System.out.println(subLink);
         		
         			
         			//할인계산 변수들
         			double convertPercent=1 ;
         			int salePrice=1;
         			String real_saleprice="";
         			double halinpersecnt=1;
         			//할인계산 변수 끝
         			
         			
         			ProductVO vo =new ProductVO();
         			vo.setProduct_name(product_name.get(i).text());
         			vo.setProduct_sale(list.get(i));
         			vo.setProduct_price(product_price.get(i).text());
         			
         			//할인가격계산 ------------------------------------------------------------------[
         			if (list.get(i)!="") {
         				 convertPercent = Integer.parseInt(list.get(i).substring(0,list.get(i).indexOf("%")));
					}
         			else {
         				convertPercent = 1;
					}
         			
         			String firstConvertPrice = product_price.get(i).text().substring(0,product_price.get(i).text().indexOf("원"));
         			String secondConvertPrice = firstConvertPrice.replace(",", "");
         			int lastConvertPrice = Integer.parseInt(secondConvertPrice);
         			
         			
         			if (convertPercent!=1) {
         				double halin1 = convertPercent/100;
             			double halin2 = 1-halin1; 
             			halinpersecnt= Math.round(halin2 * 100.0) / 100.0;
					}
         			
         			salePrice = (int)((int)lastConvertPrice*halinpersecnt);
         			
         			DecimalFormat dc = new DecimalFormat("#,###,###원");
         			real_saleprice =  dc.format(salePrice);
         			//할인가격 계산코드 끝 - ---------------------------------
         			
         			vo.setSale_price(real_saleprice);
         			
         			//랭크
         		
         			vo.setProduct_rank(Integer.parseInt(product_rank.get(i).text()));
         			//평점
         			
         			
         			vo.setProduct_grade(Double.parseDouble(product_grade.get(i).text().substring(0,product_grade.get(i).text().indexOf("점"))));
         			
         			//이미지
         			
         			
         			
             			
					
         		
         				
         			
         			
         			
         			vo.setP_image(product_img.get(i).attr("src"));
//         			
         			
         			
         		
         			
         			dao.productInsert(vo);
////         		
//         	
         		}
         		
         		
         		
   
        		 			
        	 
        	 
         }
        	
      
        
        	
				
			
      
       
        
         
        	 			 
        	

         
         
      catch(Exception ex) {}
      }
      
   
	System.out.println("END...");
	
	
   }
}
     

         
         

   
   
   


