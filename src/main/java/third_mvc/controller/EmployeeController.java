package third_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import third_mvc.dao.DepartmentDao;
import third_mvc.dao.EmployeeDao;
import third_mvc.pojo.Department;
import third_mvc.pojo.Employee;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 陆
 * @Date: 2021/08/15/15:32
 * @Description:
 */
@Controller
public class EmployeeController {

//    调用dao层
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
//        alt + enter快捷键
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);

        return "emp/table-data";
    }

//    添加员工页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        // 获取部门的真正名字
        Collection<Department> dep = departmentDao.getDeparments();
        model.addAttribute("deparments",dep);
        return "emp/add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        // 添加操作
        System.out.println("save->>"+employee);
        employeeDao.save(employee);//增加一个员工
        return "redirect:/emps";
    }


}
