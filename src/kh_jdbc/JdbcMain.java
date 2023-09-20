package kh_jdbc;

import kh_jdbc.dao.EmpDao;
import kh_jdbc.vo.EmpVo;

import java.util.List;

public class JdbcMain {
    public static void main(String[] args) {
        menulist();
    }
    public static void menulist() {
        EmpDao dao = new EmpDao();
        List<EmpVo> list = dao.empSelect();
        dao.empSelectPrint(list);
    }
}
