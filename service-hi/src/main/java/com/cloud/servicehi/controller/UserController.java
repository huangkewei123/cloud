package com.cloud.servicehi.controller;

import com.cloud.servicehi.entity.User;
import com.cloud.servicehi.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource  
    private UserService userService;

    public static final String SOURCES =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

      
    @RequestMapping("/showUser")  
    public String toIndex(HttpServletRequest request,Model model){  
        String userId = "1";  
        User user = userService.findById(userId);
        model.addAttribute("user", user);  
        return "showUser";
    }  
    /**
     * 测试登录后是否可正常访问方法
     * 
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1(@Valid User user) throws Exception {
    	return "test1";
    }

    /**
     * 测试登录后是否可正常访问方法
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/insertUser", method = RequestMethod.GET)
    @ResponseBody
    public String insertUser(@RequestParam(value="name") String name) throws Exception {
        for (int i =0 ; i<100000 ; i++){
            User user = new User();
            user.setUsername(name);
            user.setId(getRandomString(30));
            userService.insert(user);
        }

        return "test1";
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    @ResponseBody
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    public static String getRandomString(int length){
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //由Random生成随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //长度为几就循环几次
        for(int i=0; i<length; ++i){
            //产生0-61的数字
            int number=random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }
}
