package kh_jdbc.dao;

import kh_jdbc.common.Common;
import kh_jdbc.vo.EmpVo;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// DAO : Data Access Object, 데이터베이스에 접근해 데이터를 조회하거나 수정 위해 사용(DML과 유사한 기능)
public class EmpDao {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    public List<EmpVo> empSelect() {
        List<EmpVo> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM EMP";
            rs = stmt.executeQuery(sql); // executeQuery SELECT 문에서 사용

            while (rs.next()) { // 결과에서 읽은 내용이 있으면 True(테이블의 행의 개수 만큼 순회)
                int empNo = rs.getInt("EMPNO");
                String name = rs.getString("ENAME");
                String job = rs.getString("JOB");
                int mgr = rs.getInt("MGR");
                Date date = rs.getDate("HIREDATE");
                BigDecimal sal = rs.getBigDecimal("sal");
                BigDecimal comm = rs.getBigDecimal("comm");
                int deptNo = rs.getInt("DEPTNO");
                list.add(new EmpVo(empNo, name, job, mgr, date, sal, comm, deptNo));
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void empSelectPrint(List<EmpVo> list) {
        for (EmpVo e : list) {
            System.out.print(e.getEmpNo() + " ");
            System.out.print(e.getName() + " ");
            System.out.print(e.getJob() + " ");
            System.out.print(e.getMgr() + " ");
            System.out.print(e.getDate() + " ");
            System.out.print(e.getSal() + " ");
            System.out.print(e.getComm() + " ");
            System.out.print(e.getDeptNo() + " ");
            System.out.println();
        }
    }
}