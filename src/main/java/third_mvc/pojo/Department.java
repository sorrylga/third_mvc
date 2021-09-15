package third_mvc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 陆
 * @Date: 2021/08/11/11:23
 * @Description:
 * 部门表
 */
@Data
@AllArgsConstructor //有参无参构造方法
@NoArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;


}
