package com.sist.dao;

import java.util.*;

import com.sist.dao.ProductDetailVO;

import java.sql.*;
public class PRODUCT_REAL_DETAILDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@211.238.142.102:1521:XE";
   // 에러 => output => thin.conn NULL
   // => 1. URL="jdbc:oracle:thin:@localhost:1521:XE" 입력값 확인
   // => 2. Class.forName("oracle.jdbc.driver.OracleDriver") 입력값 확인
   // 에러 => IN OUT =>? 값을 안채워줌 (인덱스 번호 오류)
   public PRODUCT_REAL_DETAILDAO()
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
   public void product_real_detail_insert(PRODUCT_REAL_DETAILVO vo)
   {
      try
      {
         getConnection();

         
         
        
         String sql="INSERT INTO hr.PRODUCT_REAL_DETAIL VALUES("
                 + "PRODUCT_REAL_DETAIL_SEQ.nextval,PRODUCT_REAL_DETAIL_SEQ.currval,?,?)";
         ps=conn.prepareStatement(sql);
       
         ps.setString(1, vo.getDetail_text());
         ps.setString(2, vo.getDetail_inform_image());
        
         
         
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