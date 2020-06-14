package jrx.code;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaocongcong
 * @date 2020/6/4
 */
@RestController
@Slf4j
public class ControllerTest {

    @GetMapping(value = "test")
    public String test() {
        log.info("这是log4j2的日志测试，info级别");
        log.warn("这是log4j2的日志测试，warn级别");
        log.error("这是log4j2的日志测试，error级别");
        log.info("这是带参数的输出格式:{}");
        return "HELLO-BUG";
    }

    @Bean
    public UndertowServletWebServerFactory embeddedServletContainerFactory() {
        UndertowServletWebServerFactory factory =
                new UndertowServletWebServerFactory();

        factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
            @Override
            public void customize(io.undertow.Undertow.Builder builder) {
//                builder.addHttpListener(8080, "localhost");
            }
        });

        return factory;
    }

}