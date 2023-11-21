package com.sist.dao;
import java.util.*;

import oracle.jdbc.OracleTypes;

import java.sql.*;

public class EmpDAO {
//연결
	private Connection conn;
	//함수호출(프로시저 호출)
	private CallableStatement cs;
	//sql 전송
	private PreparedStatement ps;
	private final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public EmpDAO() {
		try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(url,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void disConnection() {
		try {
			if (cs!=null) {
				cs.close();
				
			}
			if (conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public List<EmpVO> empALLdata(){
		List<EmpVO>list =new ArrayList<EmpVO>();
		try {
			getConnection();
			String sql="{CALL empALLData(?)}";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1,OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs = (ResultSet)cs.getObject(1);
			while(rs.next()) {
				EmpVO vo=new EmpVO();
	            vo.setEmpno(rs.getInt(1));
	            vo.setEname(rs.getString(2));
	            vo.setJob(rs.getString(3));
	            vo.setMgr(rs.getInt(4));
	            vo.setHiredate(rs.getDate(5));
	            vo.setSal(rs.getInt(6));
	            vo.setComm(rs.getInt(7));
	            vo.setDeptno(rs.getInt(8));
	            list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			disConnection();
		}
		return list;
	}
	
}
