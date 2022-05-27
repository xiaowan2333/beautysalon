package com.whx.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: XiaoWan
 * @Date: 2022/5/14 11:50
 */
@Configuration
@EnableKnife4j
@EnableSwagger2
public class Swagger2Config {
//    /**
//     * 创建API应用
//     * apiInfo() 增加API相关信息
//     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
//     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
//     *
//     * @return
//     */
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.whx.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    /**
//     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
//     * 访问地址：http://项目实际地址/swagger-ui.html
//     * @return
//     */
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("美容预约平台后端API接口文档")
//                .description("小程序后端接口文档")
//                .termsOfServiceUrl("http://127.0.0.1:8080")
//                .contact(new Contact("whx","http://127.0.0.1:8080","1106405244@qq.com"))
//                .version("1.0")
//                .build();
//    }
    /**
     * 【重要】指定Controller包路径
     */
    private String basePackage = "com.whx.controller";
    /**
     * 分组名称
     */
    private String groupName = "base-knife4j";
    /**
     * 主机名
     */
    private String host = "http://localhost";
    /**
     * 标题
     */
    private String title = "API在线文档工具";
    /**
     * 简介
     */
    private String description = "Knife4j演示";
    /**
     * 服务条款URL
     */
    private String termsOfServiceUrl = "http://www.apache.org/licenses/LICENSE-2.0";
    /**
     * 联系人
     */
    private String contactName = "jzg";
    /**
     * 联系网址
     */
    private String contactUrl = "http://aaa";
    /**
     * 联系邮箱
     */
    private String contactEmail = "qq@qq.cn";
    /**
     * 版本号
     */
    private String version = "1.0.0";

    @Autowired
    private OpenApiExtensionResolver openApiExtensionResolver;

    @Bean
    public Docket docket() {
        String groupName = "1.0.0";
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .host(host)
                .apiInfo(apiInfo())
                .groupName(groupName)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .extensions(openApiExtensionResolver.buildExtensions(groupName));
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(new Contact(contactName, contactUrl, contactEmail))
                .version(version)
                .build();
    }
}
