package jrx.data.report.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import sun.misc.Version;

import java.util.ArrayList;

/**
 * @author xiaocongcong
 * @date 2020/6/3
 */
@Configuration
@EnableSwagger2//开启swagger2
public class SwaggerConfig {

    //配置Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){

        //这是接受一个String类型的数组，设置要显示的Swagger环境
        Profiles profiles =Profiles.of("dev","test");
        //通过environment.acceptsProfiles判断是否处于在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);


    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .enable(flag)//要在select上面写，因为select下面是一个整体不能分开
            .select()
             //RequestHandlerSelectors,配置要扫描接口的方式
            //basePackage：指定要扫描的包
            //any():扫描全部
            //none()：不扫描全部
            //withClassAnnotation：扫描类上的注解，参数是一个注解的反射对象
            //withMethodAnnotation：扫描方法上的注解
            .apis(RequestHandlerSelectors.basePackage("jrx.data.report"))
            //paths().过滤什么路径,只扫描url中带有/huang/**的路径
            //.paths(PathSelectors.ant("/huang/**"))
            .build()
            ;

    }

    //配置swagger信息=apiInfo
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("黄聪","https://huangconghc.github.io/","1254675032@qq.com");
        return new ApiInfo("小聪聪的SwaggerAPI文档",
                "目标：徒手撕源码，光脚造轮子，闭着眼睛深度调优，最后吊打面试官",
                "v1.0"
                ,""
                ,contact
                ,"Apache 2.0"
                ,"http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()

        );
    }

}
