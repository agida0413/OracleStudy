package com.sist.dao;


import java.util.*;

import com.sist.dao.ProductVO;

import java.sql.*;
public class ProductDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@211.238.142.102:1521:XE";
   // 에러 => output => thin.conn NULL
   // => 1. URL="jdbc:oracle:thin:@localhost:1521:XE" 입력값 확인
   // => 2. Class.forName("oracle.jdbc.driver.OracleDriver") 입력값 확인
   // 에러 => IN OUT =>? 값을 안채워줌 (인덱스 번호 오류)
   public ProductDAO()
   {
      try
      {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         // new 대신 사용 => 틀래스명으로 메모리 할당 => 리플렉션  
      }catch(Exception ex) {}
   }
   // 오라클 연동
   public void getConnection()
   {
      try
      {
         conn=DriverManager.getConnection(URL,"hr","happy");
         // => conn hr/happy
      }catch(Exception ex) {}
   }
   // 오라클 닫기
   public void disconnection()
   {
      try
      {
         if(ps!=null) ps.close();
         if(conn!=null) conn.close();
      }catch(Exception ex) {}
   }
   public void productInsert(ProductVO vo)
   {
      try
      {
         getConnection();
//         String sql="INSERT INTO hr.product_list VALUES("
//               + "PRODUCTLIST_SEQ.nextval,?,?,?,?,?,?,?)";
//         ps=conn.prepareStatement(sql);
//         ps.setString(1, vo.getProduct_name());
//         ps.setDouble(2, vo.getProduct_grade());
//         ps.setInt(3, vo.getProduct_rank());
//         ps.setString(4, vo.getProduct_price());
//         ps.setString(5 ,vo.getP_image());
//         ps.setString(6, vo.getProduct_sale());
//         ps.setString(7, vo.getSale_price());
         
         
        
         String sql="INSERT INTO hr.PRODUCT_LIST VALUES("
                 + "PRODUCTLIST_SEQ.nextval,?,?,?,?,?,?,?)";
         ps=conn.prepareStatement(sql);
       
         ps.setString(1, vo.getProduct_name());
         ps.setDouble(2, vo.getProduct_grade());
         ps.setInt(3, vo.getProduct_rank());
         ps.setString(4, vo.getProduct_price());
         ps.setString(5, vo.getP_image());
         ps.setString(6, vo.getProduct_sale());
         ps.setString(7, vo.getSale_price());
         
//         
         
         ps.executeUpdate();
      }
      catch(Exception ex)
      {
         ex.printStackTrace();
      }
      finally
      {
         disconnection();
      }
   }
}