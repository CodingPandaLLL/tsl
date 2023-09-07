import com.cpl.tsl.TslApplication;
import com.cpl.tsl.service.EmployeeService;
import com.cpl.tsl.utils.ReadTxt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

//添加SpringRuner启动时会启动application，可以注入服务
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = TslApplication.class)
public class TslTest {

    @Resource
    private EmployeeService employeeService;

    @Test
    public void test() {
        String filePath = "D:\\LLL\\2.txt";
//      "res/";
        ReadTxt.readTxtFile(filePath);
    }
}
