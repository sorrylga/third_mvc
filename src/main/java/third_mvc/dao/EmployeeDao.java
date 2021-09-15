package third_mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import third_mvc.pojo.Department;
import third_mvc.pojo.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 陆
 * @Date: 2021/08/11/19:27
 * @Description:
 */
//员工dao
@Repository
public class EmployeeDao {

//    模拟数据库数据
    private static Map<Integer, Employee> employees = null;
//    员工有所属的部门
    @Autowired   //自动装配，前后两个类都需要@Repository注解进行托管
    private DepartmentDao departmentDao;
//    数据
    static {
    employees = new HashMap<>();//创建一个部门表
    employees.put(10001,new Employee(10001,"su en","A15103@qq.com",1,new Department(101,"技术部")));
    employees.put(10002,new Employee(10002,"zhang san","B15103@qq.com",0,new Department(102,"市场部")));
    employees.put(10003,new Employee(10003,"zhao si","C15103@qq.com",1,new Department(103,"管理部")));
    employees.put(10004,new Employee(10004,"wang wu","D15103@qq.com",0,new Department(104,"销售部")));
    employees.put(10005,new Employee(10005,"li shi","E15103@qq.com",1,new Department(105,"事业部")));

}
//    主键自增
    private Integer initId = 10006;

//    增加一个员工
    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDeparmentById(employee.getId()));
        employees.put(employee.getId(),employee);

    }

//    查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

//    根据id获取员工信息
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

//    删除员工信息 根据id
    public void deleteById(Integer id){
        employees.remove(id);
    }


}
