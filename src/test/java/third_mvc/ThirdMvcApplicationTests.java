package third_mvc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import third_mvc.pojo.Department;

@SpringBootTest
class ThirdMvcApplicationTests {

    @Test
    void contextLoads() {
    }
//    测试@Data是否包含无参有参构造方法
//    不包含
//    注解后在编译时会自动加进去。
    @Test
    void contextLoads01() {
        Department d1 = new Department();
        d1.setId(11);
        Department d2 = new Department(1,"技术部");
        d1.setDepartmentName("销售部");
        System.out.println(d1.toString());
        System.out.println("-------------------");
        System.out.println(d2.toString());

    }

}
