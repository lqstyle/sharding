package com.example.sharding.config;

import com.google.common.base.Predicate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket createRestApi() {
    Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
      @Override
      public boolean apply(RequestHandler input) {
        Class<?> declaringClass = input.declaringClass();
        if (declaringClass == BasicErrorController.class)// 排除
        {
          return false;
        }
        if (declaringClass.isAnnotationPresent(RestController.class)) // 被注解的类
        {
          return true;
        }
        if (input.isAnnotatedWith(ResponseBody.class)) // 被注解的方法
        {
          return true;
        }
        return false;
      }
    };
    ParameterBuilder tokenPar = new ParameterBuilder();
    ParameterBuilder sourcePar = new ParameterBuilder();
    List<Parameter> pars = new ArrayList<Parameter>();
    tokenPar.name("X-Auth-Token").description("令牌").modelRef(new ModelRef("string"))
        .parameterType("header").required(false).build();
    sourcePar.name("REQUEST-SOURCE").description("请求来源").modelRef(new ModelRef("string"))
        .parameterType("header").required(false).build();
    pars.add(tokenPar.build());
    pars.add(sourcePar.build());
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(openApiInfo())
        .useDefaultResponseMessages(false)
        .select()
        .apis(predicate)
        .build()
        .globalOperationParameters(pars);
  }


  private ApiInfo openApiInfo() {
    return new ApiInfoBuilder()
        .title("International Costing Center Open Platform API")
        .description("OpenAPI")
        .version("1.0")
        .termsOfServiceUrl("NO terms of domain")
        .build();
  }

}
