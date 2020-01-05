package com.ysyang.sbmarket;

// import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class SbmarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbmarketApplication.class, args);

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ" + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);

            // new ConditionEvaluationReportLoggingListener(LogLevel.ERROR);
        }

    /*
        new SpringApplicationBuilder(SbmarketApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .logStartupInfo(false)
                .build()
                .run(args);
     */
    }

}
