package cn.jutta.user.web;

//import cn.jutta.user.config.PatternProperties;
import cn.jutta.user.pojo.User;
import cn.jutta.user.service.UserService;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    //    @NacosValue("${pattern.dateformat}")

    @Value("${pattern.dateformat}")
    private String dateformat;

//    @Autowired
//    private PatternProperties properties2;

    @GetMapping("now")
    public String now() {
//        Date date = new Date();
        //return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties2.getDateformat()));
    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }
}
