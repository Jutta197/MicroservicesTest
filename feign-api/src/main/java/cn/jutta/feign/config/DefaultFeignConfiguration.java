package cn.jutta.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

// java代码中配置feign的日志级别
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }
}
