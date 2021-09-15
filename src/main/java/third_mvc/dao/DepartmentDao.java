package third_mvc.dao;

import org.springframework.stereotype.Repository;
import third_mvc.pojo.Department;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 陆
 * @Date: 2021/08/11/19:11
 * @Description:
 */
//部门dao
@Repository
public class DepartmentDao {

//    模拟数据库的数据
    private static Map<Integer, Department> departments = null;
    static{
//        创建一个部门表
        departments = new HashMap<>();
        departments.put(101,new Department(101,"技术部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"管理部"));
        departments.put(104,new Department(104,"销售部"));
        departments.put(105,new Department(105,"事业部"));

    }
//  获得所有部门信息
    public Collection<Department> getDeparments(){
        return departments.values();
    }
//  通过id获得部门
    public Department getDeparmentById(Integer id){
        return departments.get(id);
    }




}
