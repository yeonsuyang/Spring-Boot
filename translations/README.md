---

---

# Spring Boot 2.1.5 레퍼런스 번역해보기

우리가 번역시도해 본 원본 : https://app.gitbook.com/@wannaqueen/s/spring5/spring-boot by ys, ks, sh

<br>

[TOC]

<br>

## Spring Boot 의 소개 

<br>

<br>



### 8.Spring Boot의 소개 by ks 

Spring Boot를 사용하면 실행할 수있는 독립 실행형 프로덕션 급 Spring 기반 응용 프로그램을 쉽게 만들 수 있습니다. 우리는 Spring 플랫폼 및 써드 파티 라이브러리에 대한 의견을 수렴하여 최소한의 소동으로 시작할 수 있습니다. (많은 작업 안해도 된다.) 대부분의 Spring Boot 응용 프로그램은 Spring 구성이 거의 필요하지 않습니다.

<br>

`java -jar` 로 실행하는 Spring boot 를 사용하거나 전통적인 war 파일 배포 방식을 통해 Java 응용 프로그램을 만들 수 있습니다 . 또한 "spring scripts"를 실행하는 명령 줄 도구도 제공합니다.

<br>

우리의 주요 목표는 다음과 같습니다.

<br>

- 모든 Spring 개발을 위해 급격히 빠르고 광범위하게 접근 할 수있는 시작 경험을 제공한다.
- 추가적인 설정없이 사용하는 것을 지향하지만, 기본 설정과 다른 요구사항이 있으면 바로 변경이 가능하다. 
- 임베디드 서버, 보안, 메트릭, 상태 확인 및 외부화 된 구성과 같은 대규모 프로젝트 클래스에 공통적으로 사용되는 다양한 비 기능적인 기능(non-functional function)을 제공한다. 
- 절대적인 코드 생성이없고 XML 구성에 대한 요구 사항이 없습니다.

<br>

> out of the box : 1. **기존 틀을 깨는 사고**(생각) / 아이디어, 2. 설정(설치) 없이 **즉시 사용**이 가능한
>
> Out-of-the-box features include: (기본 제공 기능은 다음과 같습니다.)
>
> thick out of the box : 생각의 틀을 깨다. 
>
> Be opinionated: 지향하다



<br>

## Spring Boot의 기능

# Part IV. Spring Boot features 

<br>

이 섹션에서는 스프링 부트에 대해 자세히 설명합니다. 여기에선 사용하고 사용자가 지정할 수있는 주요 기능에 대해 배울 수 있습니다. 아직 그 정도의 수준이 되지 않았다면 "[제 2 부,시작하기](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started)" 및 "[제 3 부, 스프링 부트 사용하기](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot) "단원 을 읽고 기본적인 기초 지식을 얻을 수 있습니다.

<br>

## 23. SpringApplication by ys

이 SpringApplication클래스는** **main()****메소드에서 시작되는** Spring 애플리케이션을 단순한 요소로부터 구축하는(bootstrap)하는 편리한 방법을 제공한다 . 다음 예제와 같이 많은 경우를 정적 메서드**SpringApplication.run****에 위임 할 수 있습니다 .**

```java
public  static  void main (String [] args) {
	SpringApplication.run (MySpringConfiguration. class , args);
}
```

<br>

> 부트스트랩(bootstrap) 또는 부트스트래핑은 "현재 상황에서 어떻게든 한다"는 뜻이다. 또, 사물의 초기 단계에서 단순 요소로부터 복잡한 체계를 구축하는 과정을 가리키는 경우도 있다.
>
> 시스템에서는 '스스로 생각하여서 더 높은 수준의 지능으로 그 자신의 능력을 향상 시키는 것'이라는 의미로 사용된다. 

<br>

응용 프로그램이 시작되면 다음 출력과 비슷한 내용이 표시됩니다.

```
 .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::   v2.1.5.RELEASE

2013-07-31 00:08:16.117  INFO 56603 --- [           main] o.s.b.s.app.SampleApplication            : Starting SampleApplication v0.1.0 on mycomputer with PID 56603 (/apps/myapp.jar started by pwebb)
2013-07-31 00:08:16.166  INFO 56603 --- [           main] ationConfigServletWebServerApplicationContext : Refreshing org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6e5a8246: startup date [Wed Jul 31 00:08:16 PDT 2013]; root of context hierarchy
2014-03-04 13:09:54.912  INFO 41370 --- [           main] .t.TomcatServletWebServerFactory : Server initialized with port: 8080
2014-03-04 13:09:56.501  INFO 41370 --- [           main] o.s.b.s.app.SampleApplication            : Started SampleApplication in 2.992 seconds (JVM running for 3.658)
```



기본적으로 `INFO`응용 프로그램을 시작한 사용자와 같은 관련 시작 정보를 비롯하여 로깅 메시지가 표시됩니다. `INFO`로그 레벨이 아닌 다른 로그 레벨이 필요한 경우, [26.4 절. "로그 레벨"](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-custom-log-levels)에서 설명 된 것처럼 로그 레벨 을 설정할 수 있습니다 .



#### 23.1 startup 실패

응용 프로그램이 시작되지 않으면 **등록된** **FailureAnalyzers** **가 전용 오류 메시지와 문제를 해결 하기위한 구체적인 조치를 제공합니다.** 예를 들어 포트 `8080`에서 웹 응용 프로그램을 시작하고 해당 포트가 이미 사용 중이면 다음 메시지와 비슷한 내용을 볼 수 있습니다.

```
***************************
APPLICATION FAILED TO START
***************************

Description:
Embedded servlet container failed to start. Port 8080 was already in use.

Action:
Identify and stop the process that's listening on port 8080 or configure this application to listen on another port.
```



| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| Spring Boot는 다양한 `FailureAnalyzer`구현을 제공하며 , [사용자가 직접 추가](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-failure-analyzer) 할 수 있습니다 . |



**failure analyzers 가 예외를 처리 할 수없는 경우에**도 전체 조건 보고서를 표시하여 무엇이 잘못되었는지보다 잘 이해할 수 있습니다. 이렇게하려면,  **디버그 등록 정보를 활성화하거나** **org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener****에 DEBUG 로깅을 활성화해야합니다.**



예를 들어, 응용 프로그램을 실행하는 경우 **java -jar** 을 사용하여 다음과 같이 `debug`속성을 활성화 할 수 있습니다 .

```
$ java -jar myproject-0.0.1-SNAPSHOT.jar --debug
```



#### 23.2 배너를 내가 원하는 대로 바꾸기

> Springboot를 기동할때 콘솔을 보면 “Spring” 텍스트 이모티콘을 보게된다. 이것을 “Springboot banner”라고 합니다.

```
 .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::   v2.1.5.RELEASE
```



시작할때 출력되는 배너를 클래스 패스상에 `banner.txt`파일을 추가하거나 `spring.banner.location` 프라퍼티에 그 파일의 위치를 설정해서 바꿀 수 있습니다.  만약 파일의 인코딩이 UTF-8이 아니면 `spring.banner.charset` 설정을 해야 합니다. 텍스트 파일 이외에도 `banner.gif`, `banner.jpg` 또는 `banner.png` 이미지 파일을 클래스 피스상에 위치하거나 `spring.banner.image.location` 프라퍼티 설정을 이용해 추가할 수있다. 이미지들은 ASCII art로 변환되어 text 배너로 출력됩니다.

<br>

banner.txt 파일안에 다음과 같은 플레이스홀더를 사용할 수있습니다. 

<br>

**표 23.1. 배너에서 사용하는 변수들**

| 변수                                                         | 설명                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| `${application.version}`                                     | `MAINFEST.MF` 파일에 선언된 어플리케이션의 버전. 예를 들어 `Implementation-Version: 1.0` 은 `1.0`으로 출력된다. |
| `${application.formatted-version}`                           | `MANIFEST>MF`에 선언된 어플리케이션의 버전번호를 보여주기 위한 형식(소괄호로 감싸고 `v`를 접두어로 붙인다)으로 보여준다. 예 : `(v1.0)` |
| `${spring-boot.version}`                                     | 사용하고 있는 스프링 버전. 예: `2.0.0.BUILD-SNAPSHOT`        |
| `${spring-boot.formatted-version}`                           | 사용하고 있는 스프링 버전을 보여주기 위한 형식(소괄호로 감싸고 `v`를 접두어로 붙인다.)으로 보여준다. 예 : `(v2.0.0.BUILD-SNAPSHOT)` |
| `${Ansi.NAME}`(또는 `${AnsiColor.NAME}`, `${AnsiBackground.NAME}`, `${AnsiStyle.NAME}`) | `NAME`은 ANSI 이스케이프코드의 이름이다. 자세한 것은 `[AnsiPropertySource](`[`https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot/src/main/java/org/springframework/boot/ansi/AnsiPropertySource.java`](https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot/src/main/java/org/springframework/boot/ansi/AnsiPropertySource.java)`)`를 보시오. |
| `${application.title}`                                       | `MANIFEST.MF`에 선언된 어플리케이션 제목. 예를 들어 `Implementation-Title: MyApp`은 `MyApp`으로 출력된다. |

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| SpringApplication.setBanner(…)` 메소드를 이용해 프로그램적으로 Banner를 생성할 수있습니다. `org.springframework.boot.Banner` 인터페이스를 상속받고 ` printBanner()` 메소드를 구현하면됩니다. |

<br>

또한 `spring.main.banner-mode` 프라퍼티를 사용해 배너가 `System.out`(`console`)로 출력되거나, 설정되 있는 logger(`log`)로 전달되거나 또는 생산되지 않도록(`off`) 설정할 수있습니다.



출력된 배너는 `springBootBanner` 란 이름의 싱글톤 빈으로 등록됩니다.

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| YAML 은 `off`가 `false`를 의미 하므로 어플리케이션에서 배너를 사용 안하려면 따옴표를 추가해야만 합니다. |

```java
     spring:
              main:
                      banner-mode: "off"
```

<br>

<br>

#### 23.3 SpringApplication 커스터마이징하기

만약 `SpringApplication`의 기본 설정 들이 맘에들지 않으면 로컬객체를 생성해서 커스터마이징해서 대신 사용할 수 있습니다. 예를 들어 배너를 끄고 싶으면 다음과 같이 쓸 수 있습니다.

<br>

```java
public static void main(String[] args) { 	
   SpringApplication app = new SpringApplication(MySpringConfiguration.class);
   app.setBannerMode(Banner.Mode.OFF); 	
   app.run(args);
}
```

<br>

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| `SpringApplication`로 전달 되는 생성자 인수들은 스프링 빈들을 위한 설정 소스들입니다. 대부분의 경우 `@Configuration` 클래스들을 참조 시키지만 XML설정이나 스캔될 패키지를 참조시킬 수도 있습니다. |

`SpringApplication`는 `application.properties`파일을 사용해서 설정 할 수도 있다. 자세한 것은 [24. 외부설정](https://kgmyh.github.io/blog/2017/12/10/spring-boot-chapter04/#heading-24-외부설정)를 보시오

설정 옵션들의 전체목록은 [`SpringApplication` Javadoc](https://docs.spring.io/spring-boot/docs/2.0.0.BUILD-SNAPSHOT/api/org/springframework/boot/SpringApplication.html)을 보시오.

<br>

#### 23.4  Fluent Builder API

> Fluent : 유창한, 완만한

<br>

만약 `ApplicationContext` 계층(부모 / 자식 관계가있는 다중 컨텍스트) 를 생성해야 하는 경우나 "fluent" builder API를 사용하는 것을 선호하는 경우 `SpringApplicationBuilder`를 사용할 수 있습니다.

> ApplicationContext : 전체 계층 구조에서 최상단에 위치한 컨텍스트
>
> ​									 서로 다른 서블릿 컨텍스트에서 공유해야 하는 Bean들을 등록해놓고 사용할 수 있다.
>
> ​									  서블릿 컨텍스트에 등록된 bean은 이용하지 못하며, 동일한 bean의 경우 
>
> ​									 서블릿 컨텍스트의 빈이 우선 된다. 
>
> ​					 				웹 어플리케이션 전체에 적용 가능한 프로퍼티, DB, 연결, 로딩 기능 등에 이용한다.
>
> 출처: <https://hoonmaro.tistory.com/31>

<br>

`SpringApplicationBuilder`는 여러 메소드 호출을 연결해서 method chain 할 수있게 하고 계층관계를 만들수 있는 `parent`와 `child` 메소드를 포함하고 있습니다. 

> 메서드가 객체를 반환하게 되면, 메서드의 반환 값인 객체를 통해 또 다른 함수를 호출할 수 있습니다. 이러한 프로그래밍 패턴을 메서드 체이닝(Method Chaining) 이라 부릅니다.
>
> 출처: <https://recoveryman.tistory.com/368> [회복맨 블로그]

예)

```java
new SpringApplicationBuilder()
               .sources(Parent.class)
               .child(Application.class)
               .bannerMode(Banner.Mode.OFF)
               .run(args);
```

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| `ApplicationContext` 계층관계를 생성할 때 몇몇 제약이 있습니다. 예를 들어 웹 컴포넌트는 **반드시** 자식 context에 포함되 있어야 합니다. 그리고 같은 `Environment`가 부모와 자식 컨텍스트들 양쪽에서 사용되어야 합니다. 자세한 사항은 [`SpringApplicationBuilder`Javadoc](https://docs.spring.io/spring-boot/docs/2.0.0.BUILD-SNAPSHOT/api/org/springframework/boot/builder/SpringApplicationBuilder.html)을 참조하십시오. |

<br>

#### 23.5 어플리케이션 이벤트와 리스너들

`SpringApplication`은 [`ContextRefreshedEvent`](https://docs.spring.io/spring/docs/5.0.2.RELEASE/javadoc-api/org/springframework/context/event/ContextRefreshedEvent.html)와 같은 스프링 프레임워크가 발생시키는 이벤트들과 더불어 몇몇 추가적인 어플리케이션 이벤트들을 발생시킵니다.

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 몇몇 이벤트들은 `ApplicationContext`가 생성되기 전에 발생하기 때문에 리스너를 `@Bean`으로 등록할 수 없습니다. 그런 리스너들은 `SpringApplication.addListeners(..)`나 `SpringApplicationBuilder.listeners(...)` 메소드들을 사용해 등록할 수있습니다. 어플리케이션이 생성되는 방식과 관계없이 이 리스너들이 **자동적으로** 등록되도록 하길 원하면, `META-INF/spring.factories` 파일을 프로젝트에 추가하고 거기에 리스너(들) `org.springframework.context.ApplicationListener` 키값을 사용해 다음과 같이 참조시키면 됩니다. |

> org.springframework.context.ApplicationListener=com.example.project.MyListener

<br>

Application 이벤트들은 실행시 다음과 같은 순서대로 발생합니다.

<br>

1. `ApplicationStartingEvent`은 실행이 시작될 때, 리스너들과 Initializer들의 등록을 제외한 어떠한 프로세스도 진행 되지 않았을 때 전송된다.
2. `ApplicationEnvironmentPreparedEvent`은 Context에서 사용될 `Environment`을 찾았지만 아직 Context가 생성되기 전에 전송된다.
3. `ApplicationPreparedEvent`은 정의된 빈들이 로딩되고 refresh가 시작되기 바로전에 전송된다.
4. `ApplicationReadyEvent `는 refresh되고 관련 callback 들이 진행 된 이후에 전송된다. 이 시점은 어플리케이션이 요청에 대해서 서비스할 준비 되었음을 가리킨다.
5. `ApplicationFailedEvent`은 시작 도중 예외가 발생하면 전송된다.



[^어플리케이션 이벤트들을 사용할 필요가 없는 경우가 자주있다. 그러나 이벤트들을 알고 있으면 훨씬 편리할 수있습니다. 내부적으로 스프링 부트는 많은 일들을 처리하기 위해 이벤트들을 사용합니다.]: 

어플리케이션 이벤트들은 스프링 프레임워크의 이벤트 발생 메카니즘을 사용해 전송됩니다. 이 메카니즘에서는 자식 컨텍스트의 리스너들에게 발생한 이벤트는 조상 컨텍스트들의 리스너에게도 발생되도록 합니다. 이 결과로 만약 어플리케이션이 `SpringApplication` 객체의 계층관계를 사용한다면 리스너는 같은 타입의 어플리케이션 이벤트 객체들을 여러개 받게 됩니다.

<br>

리스너가 자신의 컨텍스트에서 발생한 이벤트인지 자식 컨텍스트에서 발생한 이벤트인지를 구별하게 하기 위해, 그것의 어플리케이션 컨텍스트를 주입받아서 이벤트가 발생한 Context와 비교해야 합니다. **컨텍스트는** **ApplicationContextAware****를 구현하거나 리스너가 빈일 경우** **@Autowired****를 사용해서 주입받을 수있습니다.**

<br>

#### 23.6 웹 환경

`SpringApplication`은 어플리케이션에 맞는 타입의 `ApplicationContext`를 생성하기 위해 시도합니다.  기본적으로, **웹어플리케이션인지 아닌지를 기반으로** **AnnotationConfigApplicationContext****나** **AnnotationConfigServletWebServerApplicationContext****가 사용됩니다**

<br>

`웹 환경`인지를 결정하기 위해 사용하는 알고리즘은 꽤 단순합니다. (이것은 몇몇 클래스들이 존재하는지에 기초합니다.) 만약 기본설정을 재정의하려고 하면 `setWebEnvironment(boolean webEnvironment)` 메소드를 사용합니다.

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| **JUnit test에서** **SpringApplication****을 사용할 때 종종** **setWebEnvironment(false)****를 사용합니다.** |

<br>

#### 23.7 Application 인자에 접근하기

`SpringApplication.run(...)` 으로 전달 된 어플리케이션 인수들에 접근하려면 `**org.springframework.boot.ApplicationArguments` 빈을 주입** 받으면 됩니다. `ApplicationArguments` 인터페이스가 인수의 원래 타입인 `String[]`의 인수와 마찬가지로  parsing `option` 과 `non-option` 타입의 인수로 접근하는 방법을 제공합니다. 다음은 그 예제코드 입니다.

```java
import org.springframework.boot.*
import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*

@Component
public class MyBean {

	@Autowired
	public MyBean(ApplicationArguments args) {
		boolean debug = args.containsOption("debug");
		List<String> files = args.getNonOptionArgs();
		// if run with "--debug logfile.txt" debug=true, files=["logfile.txt"]
	}
}
```

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 스프링 부트는 `CommandLinePropertySource`를 스프링 `Environment`에 등록할 수있습니다. 그렇게 하면 `@Value` 어노테이션을 사용해 하나의 어플리케이션 인수들을 주입할 수있습니다. |

<br>

#### 23.8 ApplicationRunner 또는 CommandLineRunner 사용

만약 **SpringApplication이 시작할 때 특정 코드를 한번 실행 시킬 필요**가 있으면 **`ApplicationRunner` 나 `CommandLineRunner` 인터페이스를 구현** 할 수 있습니다. 

두 인터페이스는 같은 방식으로 작동하며**`SpringApplication.run(...)` 메소드 실행이 완료되기 직전에 호출 되는 `run` 메소드를 하나 제공** 합니다. `CommandLineRunner` 인테페이스는 어플리케이션 인수를 한개의 스트링 배열로 접근해 사용 하는 방법을 제공 하지만 `ApplicationRunner`는 이전에 우리가 봤던 `ApplicationArguments`인터페이스를 사용합니다.

```java
import org.springframework.boot.*
import org.springframework.stereotype.* 
@Component 
public class MyBean implements CommandLineRunner { 
   	public void run(String... args) { 		
       // Do something... 	
   }
}
```

```java
package org.springframework.boot;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * Interface used to indicate that a bean should <em>run</em> when it is contained within
 * a {@link SpringApplication}. Multiple {@link ApplicationRunner} beans can be defined
 * within the same application context and can be ordered using the {@link Ordered}
 * interface or {@link Order @Order} annotation.
 *
 * @author Phillip Webb
 * @since 1.3.0
 * @see CommandLineRunner
 */
@FunctionalInterface
public interface ApplicationRunner {

	/**
	 * Callback used to run the bean.
	 * @param args incoming application arguments
	 * @throws Exception on error
	 */
	void run(ApplicationArguments args) throws Exception;

}

```



`CommandLineRunner`나 `ApplicationRunner`빈들을 여러개 정의 하고 그들의 실행 순서를 정의 해야 하는 경우 추가적으로 `org.springframework.core.Ordered` 인터페이스를 구현하거나 `org.springframework.core.annotation.Order` 어노테이션을 사용할 수 있습니다.

<br>

#### 23.9 어플리케이션 종료

각 `SpringApplication`은 종료시 `ApplicationContext`를 정상적으로 close하는 것을 보장하도록 JVM에 shutdown hook을 등록합니다. 모든 표준 스프링 생명주기 콜백들(`DisposableBean` 인터페이스나 `@PreDestroy`어노테이션)이 사용될 수 있습니다.

> @postConstruct : 객체의 초기화 부분, 객체가 생성된 후 별도의 초기화 작업을 위해 실행하는 메소드 
>
> ​		                        init메소드 선언, WAS가 띄워 질때 실행
>
> @preDestroy : 마지막 소멸 단계, 스프링 컨테이너에서 객체(빈)을 제거하기 전에 해야할 작업을 위해 destroy()에  사용
>
> ​						   close() 하기 직전에 실행 

<br>

거기에 더해 `SpringApplication.exit()`이 호출 될 때 특정 종료코드를 반환하기를 원하면 빈들이 `org.springframework.boot.ExitCodeGenerator` 인터페이스를 구현하면 됩니다. 이 종료코드는 `System.exit()`으로 전달되어 `System.exit()`의 상태코드로 반환됩니다. 다음은 그 예제 입니다.

```java
@SpringBootApplication
public class ExitCodeApplication {

	@Bean
	public ExitCodeGenerator exitCodeGenerator() {
		return () -> 42;
	}

	public static void main(String[] args) {
		System.exit(SpringApplication
				.exit(SpringApplication.run(ExitCodeApplication.class, args)));
	}

}
```

또한 `ExitCodeGenerator` 인터페이스는 예외Exception에서 구현할 수도 있습니다. 특정 예외가 발생하면 스프링 부트는 구현된 `getExitCode()` 메소드가 제공하는 종료코드를 반환합니다.

<br>

#### 23.10 관리자 기능

`spring.application.admin.enabled` 프라퍼티를 사용하면 어플리케이션에 관리자-관련 기능을 활성화 시킬 수 있습니다. 이것은 `MBeanServer` 플랫폼에 [`SpringApplicationAdminMXBean`](https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot/src/main/java/org/springframework/boot/admin/SpringApplicationAdminMXBean.java)을 노출시킵니다. 이것을 이용해 스프링 부트 어플리케이션의 관리자 기능을 원격으로 사용할 수있습니다. 이 기능은 서비스 어떤 랩퍼 구현에도 유용할 수있습니다.

> 실행중인 자바 애플리케이션의 정보를 MBeanServer 에 등록하는 MBean 클라이언트 기능을 `spring.application.admin.enabled`속성으로 활성화할 수 있다. 이 속성이 활성화되면 JConsole 등 MBean 사양을 따르는 감시 및 관리도구에서 접근하여 애플리케이션 정보를 살펴보고 종료하는 등의 원격제어가 가능해진다.
>
> 출처 :  <http://honeymon.io/tech/spring-boot/2018/02/28/sprngbootapplication-admin.html>

<br>

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 만약 어플리케이션이 실행 중인 HTTP 포트번호를 알려면, `local.server.port` 키로 프라퍼티를 조회하면 됩니다. |

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 주의 : 이 기능을 활성화 시킬때 MBean이 어플리케이션을 종료 Shutdown하는 메소드를 노출하므로 주의해야 합니다. |

<br>

### 24. 외부화된 구성 by ys

Spring Boot를 사용하면 구성을 외부화하여 다른 환경에서 동일한 응용 프로그램 코드로 작업 할 수 있습니다. 외부화는 특성 파일, YAML 파일, 환경 변수 및 명령 행 인수를 사용하여 구성 할 수 있습니다. 설정된 프라퍼티들은 `@Value`를 사용해 직접 빈들에 주입할 수도 있고, Spring의 환경 추상화를 통해 액세스하거나 @ConfigurationProperties를 통해 구조화 된 객체에 바인딩(24.8) 할 수 있습니다.

<br>

스프링 부트는 현명하게 값들을 오버라이딩하도록 설계한 매우 특별한 `PropertySource` 순서를 사용합니다. 

프라퍼티들은 다음 순서대로 적용된다.

1. devtools 홈 디렉토리의 전역 설정(20.4)  등록 정보(devtools가 활성화 된 경우  `~/.spring-boot-devtools.properties`)
2. 테스트의 `@TestPropertySource` 어노테이션
3. 테스트의 properties 속성.  `@SpringBootTest` 어노테이션 및 애플리케이션의 특정 슬라이스를 테스트하기 위한 테스트 주석에서 사용 가능한..?
4. Command-Line 인수
5. `SPRING_APPLICATION_JSON`에 설정된 프라퍼티들(환경변수나 시스템 프라퍼티 내장된 inline JSON)
6. `ServletConfig` 초기파라미터
7. `ServletContext` 초기파라미터
8. `java:comp/env`로 부터의 JNDI 속성
9. Java 시스템 프라퍼티(`System.getProperties()`).
10. 운영체제 환경변수
11. `random.*` 에 있는 속상만 가진 `RandomValuePropertySource`
12. 패키지된 jar 파일 외부의 [프로파일 관련 어플리케이션 프라퍼티들](https://kgmyh.github.io/blog/2017/12/10/spring-boot-chapter04/#heading-244-프로파일-관련-프라퍼티들)(`application-{profile}.properties`와 YAML 문서)
13. 패키지된 jar 파일 내부의 [프로파일 관련 어플리케이션 프라퍼티들](https://kgmyh.github.io/blog/2017/12/10/spring-boot-chapter04/#heading-244-프로파일-관련-프라퍼티들)(`application-{profile}.properties`와 YAML 문서)
14. 패키지된 jar 파일 외부의 어플리케이션 프라퍼티들 (`application.properties`와 YAML 문서)
15. 패키지된 jar 파일 내부의 어플리케이션 프라퍼티들 (`application.properties`와 YAML 문서)
16. `@Configuration`클래스에 선언한 `@PropertySource` 어노테이션
17. 기본 프라퍼티들 (`SpringApplication.setDefaultProperties`를 사용해 작성된)

<br>

구체적인 예제를 제공하기 위해, `name` 프라퍼티를 사용하는 `@Component`를 다음 예제와 같이 개발하고 있다고 가정했을 때

```java
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

@Component
public class MyBean {

	@Value("${name}")
	private String name;

    // ...
}
```

<br>

1. 어플리케이션의 클래스패스(jar파일 내)상에 `application.properties` 파일이 `name`에 대한 기본 프라퍼티 값을 제공할 수있습니다.

2. 새로운 환경이 실행될 때, `name`을 재정의한 `application.properties` 파일이 jar파일 외부에서 제공될 수도 있습니다. 

3. 일회성 테스트를 위해 시작할 때 Command-Line 인수를 이용해 전달 할 수 있습니다. (예를 들어 `java -jar app.jar --name="Spring"`).

   

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| `SPRING_APPLICATION_JSON` 프라퍼티는 환경변수로 Command line상에서 제공될 수 있습니다.                              예를 들어 다음 라인을 UNI*X 쉘에서 사용할 수있습니다.                                                                                                       **$ SPRING_APPLICATION_JSON='{"acme":{"name":"test"}}' java -jar myapp.jar**                                          위 예가 실행되면, 스프링 `Environment`에서는 `acme.name=test`로 됩니다.  JSON을 시스템 프라퍼티에서 `spring.application.json`을 사용해 다음 예처럼 제공할 수도 있습니다.                                                                          **$ java -Dspring.application.json='{"name":"test"}' -jar myapp.jar**                                                           JSON을 Command-line 인수를 사용해 다음 예 처럼 제공할 수도 있다.                                                                               **$ java -jar myapp.jar –spring.application.json='{"name":"test"}'**                                                                      다음과 같이 JNDI 변수를 이용해 JSON을 제공을 할 수도 있다.  `**java:comp/env/spring.application.json** |

#### 

#### 24.1 임의의 값 구성

`RandomValuePropertySource`는 임의의 값들을 주입할때 유용합니다. (예를 들어 비밀값 패스워드 또는 테스트 케이스들과 같은). 랜덤 값으로 Integer, long, uuid나 스트링 들을 다음 예와 같이 생성합니다.

```java
 my.secret = $ {random.value}
 my.number = $ {random.int}
 my.bignumber = $ {random.long}
 my.uuid = $ {random.uuid}
 my.number.less.than.ten = $ {random.int (10)}
 my.number.in.range = $ {random.int [1024,65536]}
```

`random.int*` 구문은 `OPEN value (,max) CLOSE`입니다. `OPEN,CLOSE`는 어떤 문자든 올수있고 `value, max`는 정수들이다. 만약 `max`가 제공되면 `value`는 최소값이고 `max`는 최대값이됩니다. (배타적)

<br>

#### 24.2 명령행 특성 액세스

기본적으로, `SpringApplication`은 모든 command line 옵션 인수(이 인수들은 '–'로 시작한다. 예를 들어 `--server.port=9000`)를 `property`로 변환한 뒤 Spring `Environment`에 추가합니다.

Command line 프라퍼티들이 `Environment`에 추가 안되게 하려면 `SpringApplication.setAddCommandLineProperties(false)`를 사용해서 비활성화 시킬 수 있습니다.

<br>

#### 24.3 응용 프로그램 속성 파일

`SpringApplication`은 다음 경로에 있는 `application.properties` 파일의 프라퍼티들을 가져와서 Spring `Environment`에 추가합니다.

1. 현재 디렉토리의 하위디렉토리인 `/config`
2. 현재 디렉토리
3. 클래스패스 상의 `/config` 패키지
4. 루트 클래스패스

위의 목록은 우선순위 순입니다. (목록의 상위에 정의한 프라퍼티들은 하위에 정의한 것을 우선한다.)

<br>

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 또한 '.properties'대신 [YAML ( '.yml') 파일](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-yaml) 을 [사용할](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-yaml) 수 있습니다 . |

<br>

파일명으로 `application.properties`말고 다른 것을                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   쓰려면 `spring.config.name` 환경 설정의 값으로 지정하면 됩니다. 또 `spring.config.location` 환경설정을 사용해 명시적으로 위치를 지정할 수 있습니다. (디렉토리 위치나 파일 경로를 여러개 설정할 경우 구분자로 쉼표를 사용합니다.) 다음 예제는 다른 파일명을 명시하는 방법을 보여줍니다.

```java
$ java -jar myproject.jar --spring.config.name=myproject
```

<br>

다음 예제는 두개의 경로를 어떻게 지정하는지 보여줍니다.

```
$ java -jar myproject.jar --spring.config.location=classpath:/default.properties,classpath:/override.properties
```

[^`spring.config.name`과 `spring.config.location`은 어떤 파일들을 로드할지 결정해야 하기 때문에 일찍 로드됩니다. 그래서 환경 설정Property로 정의해야만 합니다. (일반적으로 OS 환경변수, 시스템 프라퍼티 또는 Command line 인수)]: 

<br>

`spring.config.location`에 파일이 아닌 디렉토리가 있으면  `/`로 끝나도록 해야 합니다. (그러면, 런타임 때, 로드 되기 전에  `spring.config.name`에서 프로파일 관련 파일이름을 포함하여 생성 된 이름이 추가 됩니다. ) `spring.config.location`에 명시한 파일명은 프로파일 관련 변경 지원 없이 그대로 사용하고 모든 프로파일 관련 프라퍼티들을 덮어씁니다.

<br>

설정 위치는 작성된 역순으로 찾는다. 기본적인 설정 위치는 `classpath:/, classpath:/config/, file:./, file:./config/` 이다. 검색 순서 결과는 다음과 같습니다.

1. file:./config/
2. file:./
3. classpath:/config/
4. classpath:/

<br>

`spring.config.location`을 사용해 사용자 정의 위치를 설정하면 그 설정이 기본 위치를 대신한다. 예를 들어 `spring.config.location`에 `classpath:/custom-config/,file:./custom-config/`을 설정하면, 검색 순서는 다음과 같습니다.

1. file:./custom-config/

2. classpath:custom-config/

   <br>

또는 `spring.config.additional-location`을 사용해 사용자정의 구성 위치를 지정할 때, 기본 위치에 추가되어 사용됩니다. 추가 위치는 기본 위치 전에 검색됩니다. 예를 들어 `classpath:/custom-config/,file:./custom-config/`을 추가 위치로 설정하면, 검색 순서는 다음과 같습니다.

1. file:./custom-config/

2. classpath:custom-config/

3. file:./config/

4. file:./

5. classpath:/config/

6. classpath:/

   <br>

이 검색순서를 이용하면 하나의 설정파일에 기본 설정 값들을 명시해서 선택적으로 다른 값으로 대체할 수 있습니다. 어플리케이션을 위한 기본값들은 기본 경로중 한 곳에 있는 `application.properties`파일(또는 `spring.config.name`으로 선택한 다른 basename)로 제공할 수있습니다. 이 기본값들은 실행시 사용자정의 경로 중 하나에 있는 다른 파일로 대체될 수 있습니다.

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 시스템 프라퍼티 말고 환경변수를 사용하는 경우, 대부분의 운영체제는 키 이름을 `.`으로 구분하는 것을 허용하지 않습니다. 그래서 `.` 대신 `_`을 사용해야합니다. (예를 들어 `spring.config.name`은 대신 `SPRING_CONFIG_NAME`으로 합니다. |

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 만약 어플리케이션이 컨테이너에서 실행된다면 jndi 프라퍼티(`java:comp/env` 안의)나 Servlet Context 초기파라미터가 환경변수나 시스템 프라퍼티 대신(또는 뿐만 아니라) 사용될 수 있습니다. |

<br>

#### 24.4 프로파일 관련 프라퍼티들

`application.properties` 파일 외에도, 프로파일 관련 프라퍼티들을 `application-{profile}.properties` 이름 관례를 사용해 정의할 수있습니다. `Environment`는 프로파일들이 설정되 있지 않은 경우 사용할 기본 프로파일들(기본적으로 `[default]`) 이 있습니다. 즉, 프로파일들이 명시적으로 활성화 되있지 않으면 `application-default.properties`가 로드 집니다. 

<br>

프로파일 관련 프라퍼티들은 표준 `application.properties`와 같은 위치로 부터 로드되며, 프로파일 관련 파일들이 package.jar 안에 있던 밖에 있던 관계없이 프로파일 관련 아닌 non-specific 파일들의 설정보다 항상 우선시 됩니다.

<br>

프로파일 관련 파일들이 여러 개일 경우 마지막 것이 이기는 전략이 적용됩니다.(last-wins strategy) 예를 들어 `spring.profiles.active` 프라퍼티에 의해 명시된 프로피일들은 `SpringApplication` API를 통해 구성된 프로파일 다음에 추가되므로 우선 적용됩니다.

<br>

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| `spring.config.location`에 파일을 지정한 경우, 해당 파일의 프로파일 별 변형은 고려되지 않습니다. 프로파일 관련 프라퍼티들도 같이 사용하려면 `spring.config.location`에 디렉토리를 사용해야 합니다. |



#### 24.5 Placeholders in Properties

> placeholder : (computer code) 위치 표시자 

<br>

`application.properties` 에 설정된 값들은 사용될 때 `Environment`로 들어갑니다. 그래서 전에 정의한 값들을 참조할 수있습니다. (예를 들어 시스템 프라퍼티들로 부터)

```properties
app.name=MyApp
app.description=${app.name} is a Spring Boot application
```

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 이 기술은 이미 있는 Spring Boot 프라퍼티들의 이름을 짧게 만드는데 사용할 수있습니다. 자세한 것은 [73.4 "'짧은' Command Line 인수들 사용하기](http://localhost:4000/blog/2017/12/19/spring-boot-chapter09/#heading-734-짧은-command-line-인수들-사용하기)를 보십시오. |

<br>

#### 24.6 속성의 암호화

스프링 부트는 속성 값 암호화를위한 지원이 내장되어 있지는 않지만 스프링 `Environment`에 포함 된 값을 수정하는 데 필요한 후크 포인트를 제공합니다. `EnvironmentPostProcessor`인터페이스를 사용하면 응용 프로그램이 시작되기 전에 `Environment`조작 할 수 있습니다. 

자세한 내용 [은 76.3 절. "시작하기 전에 환경 또는 ApplicationContext를 사용자 정의"](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-customize-the-environment-or-application-context) 를 참조하십시오.

<br>

자격 증명과 패스워드를 안전하게 저장하는 방법을 찾고 있다면, [Spring Cloud Vault](https://cloud.spring.io/spring-cloud-vault/) 프로젝트는 [HashiCorp Vault에](https://www.vaultproject.io/) 외부화 된 설정을 저장하는 것을 지원한다 .

<br>

#### 24.7 Properties 대신 yaml 사용하기

[YAML](https://yaml.org/) 은 JSON의 상위 집합이며, 따라서 계층 적 구성 데이터를 지정하는 데 편리한 형식입니다. 이 `SpringApplication`클래스는 classpath에 [SnakeYAML](https://bitbucket.org/asomov/snakeyaml) 라이브러리가 있을 때마다 자동으로 YAML을 속성의 대안으로 지원합니다 .

| ![[노트]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| "Starters"를 사용하면 `spring-boot-starter`의해 snakeYAML이 자동으로 제공됩니다. |

<br>

##### 24.7.1 YAML로드

Spring Framework는 YAML 문서를 로드하는 데 사용할 수있는 두 가지 편리한 클래스를 제공합니다. `YamlPropertiesFactoryBean`은  YAML을 `Properties`로 로드하고, `YamlMapFactoryBean` 은 YAML을 `Map`으로 로드합니다.

예를 들어 다음 YAML 문서를 생각해보십시오.

```yaml
environments:
	dev:
		url: https://dev.example.com
		name: Developer Setup
	prod:
		url: https://another.example.com
		name: My Cool App
```

<br>

앞의 예는 다음 속성으로 변환됩니다.

```properties
environments.dev.url=https://dev.example.com
environments.dev.name=Developer Setup
environments.prod.url=https://another.example.com
environments.prod.name=My Cool App
```

YAML리스트는 `[index]` (dereferencers)와 함께 속성 키로 표시됩니다 . 예를 들어, 다음 YAML을 고려하십시오.

```yaml
my:
servers:
	- dev.example.com
	- another.example.com
```

앞의 예는 다음 속성으로 변환됩니다.

```properties
my.servers [0] = dev.example.com
my.servers [1] = another.example.com
```

Spring Boot의 `Binder`유틸리티 ( `@ConfigurationProperties`가 하는 것) 를 사용하여 속성에 바인딩하려면 `java.util.List` (or `Set`) 유형의 대상 bean에 속성이 있어야하며 setter를 제공하거나 또는 변경할 수있는 값으로 초기화하십시오. 예를 들어 다음 예제는 이전에 표시된 속성에 바인딩합니다.

```java
@ConfigurationProperties(prefix="my")
public class Config {

	private List<String> servers = new ArrayList<String>();

	public List<String> getServers() {
		return this.servers;
	}
}
```

<br>

##### 24.7.2 Spring 환경에서 YAML을 속성으로 노출시키기

`YamlPropertySourceLoader` 클래스는 같은 Spring `Environment`에서 YAML을 노출하는 데  `PropertySource` 로 노출 시키는데 사용될 수 있습니다. 이렇게하면 `@Value` annotation을 사용하여 YAML 속성에 액세스 할 수 있습니다.

<br>

##### 24.7.3 다중 프로필 YAML 문서

다음 예제와 같이 `spring.profiles` 키를 사용하여 문서가 적용되는 시기를 나타내는 단일 프로필에 여러 프로필 관련 YAML 문서를 지정할 수 있습니다 .

```yaml
server:
	address: 192.168.1.100
---
spring:
	profiles: development
server:
	address: 127.0.0.1
---
spring:
	profiles: production & eu-central
server:
	address: 192.168.1.120
```

앞의 예에서 `development `프로필이 활성화 된 경우  `server.address` 속성은 `127.0.0.1`입니다. 마찬가지로 `production` and 및 `eu-central` profiles이 활성화 된 경우 `server.address`속성은 `192.168.1.120`입니다. 

`development`, `production`및 `eu-central `프로파일이 활성화 되지 않은 경우, 속성 값은 `192.168.1.100`입니다.

| ![[노트]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| 그러므로 `spring.profiles`는 간단한 프로필 이름 (예 `production`:) 또는 프로파일 표현식을 포함 할 수 있습니다 . 프로파일 표현식은 보다 복잡한 프로파일 로직이 표현되도록 합니다.(예 : `production & (eu-central | eu-west)`.) 자세한 내용 은 [참조 가이드](https://docs.spring.io/spring/docs/5.1.7.RELEASE/spring-framework-reference/core.html#beans-definition-profiles-java) 를 확인하십시오. |

응용 프로그램 컨텍스트가 시작될 때 명시 적으로 활성화 된 것이 없으면 기본 프로파일이 활성화됩니다. 따라서 다음 YAML에서는 "default"프로필 에서만 사용할 수 있는  `spring.security.user.password` 값을 설정 합니다.

```yaml
server:
  port: 8000
---
spring:
  profiles: default
  security:
    user:
      password: weak
```

다음 예제에서 암호는 프로파일에 연결되지 않았기 때문에 항상 설정되며 필요에 따라 다른 모든 프로파일에서 명시적으로 재설정해야합니다.

```yaml
server:
  port: 8000
spring:
  security:
    user:
      password: weak
```

`spring.profiles` 요소 를 사용하여 지정된 스프링 프로파일 은 `!`문자 를 사용하여 선택적으로 무효화 될 수 있습니다 . 단일 문서에 대해 음수 및 음화가 아닌 프로파일이 모두 지정되면 음수가 아닌 하나 이상의 프로파일이 일치해야하며 음수 프로파일이 일치하지 않아야합니다.

<br>

##### 24.7.4 YAML 결점

YAML 파일은 `@PropertySource`주석을 사용하여로드 할 수 없습니다 . 그런 식으로 값을로드해야하는 경우 속성 파일을 사용해야합니다. 

프로필 관련 YAML 파일에서 다중 YAML 문서 구문을 사용하면, 예기치 않은 동작이 발생할 수 있습니다. 예를 들어  `dev`프로파일이 활성화 된  상태에서 `application-dev.yml`  파일에 다음 구성을 고려하십시오.

```yaml
server:
  port: 8000
---
spring:
  profiles: !test
  security:
    user:
      password: weak
```

위의 예에서 프로필 부정 및 프로필 식은 예상대로 작동하지 않습니다. 프로필 별 YAML 파일과 여러 YAML 문서를 결합하지 말고 하나만 사용하는 것이 좋습니다.

<br>

#### 24.8 Type-safe Configuration Properties

`@Value("${property}")`주석을 사용하여  configuration properties 정보를 주입하는 것은 때로는 특히 여러 속성을 사용하여 작업하거나 데이터가 사실상 계층 적이기 때문에 번거로운 작업이 될 수 있습니다. 



>    /** variable ottCmUri. */
>     @Value("${ott_auth.uri}")
>
> @Value("${spring.redis.sentinel.master}") String redisSentinelMaster
> 			, @Value("${spring.redis.sentinel.nodes}") String redisSentinelNodes
> 			, @Value("${spring.redis.password}") String redisPassword){
>
> }

Spring Boot는 다음 예제와 같이 강력하게 유형이 지정된 bean이 응용 프로그램의 구성을 관리하고 유효하게하는 등록 정보로 작업하는 대체 방법을 제공합니다.

```java
package com.example;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("acme")
public class AcmeProperties {

	private boolean enabled;

	private InetAddress remoteAddress;

	private final Security security = new Security();

	public boolean isEnabled() { ... }

	public void setEnabled(boolean enabled) { ... }

	public InetAddress getRemoteAddress() { ... }

	public void setRemoteAddress(InetAddress remoteAddress) { ... }

	public Security getSecurity() { ... }

	public static class Security {

		private String username;

		private String password;

		private List<String> roles = new ArrayList<>(Collections.singleton("USER"));

		public String getUsername() { ... }

		public void setUsername(String username) { ... }

		public String getPassword() { ... }

		public void setPassword(String password) { ... }

		public List<String> getRoles() { ... }

		public void setRoles(List<String> roles) { ... }

	}
}
```

위의 POJO는 다음 속성을 정의합니다.

- `acme.enabled`값은 `false`기본적으로입니다.
- `acme.remote-address`에서 강제로  `String`유형을 지정할 수 있습니다.
- `acme.security.username`속성의 이름에 따라 이름이 결정되는 중첩 된 "security"객체가 있습니다. 특히 반환 유형은 전혀 사용되지 않으며 `SecurityProperties` 가 될 수 있습니다.
- `acme.security.password`.
- `acme.security.roles`,`String`의 컬렉션과 함께.

<br>

> "getter / setter를 가진 단순한 자바 오브젝트"는 POJO이다. 

<br>

> ## ConfigurationProperties
>
> 두 번째는 `@ConfigurationProperties` 어노테이션과 관련된 설정이다. `@ConfigurationProperties` 속성에 대해서 알아볼 건 아니고 관련된 설정방법들을 알아볼 예정이다.
>
> ```java
> @ConfigurationProperties("foo")
> public class FooProperties {
>   private String name = "100";
>   //getter setter ...
> }
> ```
>
> 만약 위와 같은 프로퍼티가 있다고 가정하자. 위와 같이해서 컴파일을 해보면 `foo`라는 prefix로 json 파일이 자동으로 만들어진다. 물론 `configuration-processor`를 디펜더스 받아야 한다. name 이라는 프로퍼티는 `100`이라는 기본값을 갖고 있다.
> `application.properties` 파일에 `foo.name`이라는 속성을 입력할 수 있다. IDEA 경우에는 자동완성도 해준다.
> 기본적으로는 위와 같이 하면 자동으로 만들어 주지만 약간의 설정을 추가할 수 있다.
> `/resources/META-INF` 경로 아래에 `additional-spring-configuration-metadata.json` 파일을 만들어 추가하여 속성을 정의해주면 좀 더 나은 프로퍼티를 설정할 수 있다.
>
> 출처 : <http://wonwoo.ml/index.php/post/1599>

<br>

| ![[노트]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| Getter와 setter는 Spring MVC와 마찬가지로 표준 Java Beans 프로퍼티 디스크립터를 통해 바인딩되기 때문에 보통 필수이다. 다음과 같은 경우에는 setter를 생략 할 수 있습니다. |
| - Map들은 바인더로 변경 될 수 있기 때문에 초기화 될 때까지 getter가 필요하지만 setter 는 필요없습니다. |
| - 컬렉션과 배열은 인덱스 (일반적으로 YAML) 또는 쉼표로 구분 된 단일 값 (속성)을 사용하여 액세스 할 수 있습니다. 후자의 경우 setter는 필수입니다. 항상 이러한 유형의 setter를 추가하는 것이 좋습니다. 콜렉션을 초기화하는 경우, 콜렉션이 불변이 아닌지 확인하십시오 (앞의 예와 같이). |
| - 앞의 예제에서 `Security`와 같이 중첩 된 POJO 속성이 초기화 되면 setter가 필요하지 않습니다. 바인더가 기본 생성자를 사용하여 즉석에서 인스턴스를 만들려면 setter가 필요합니다. |
| 어떤 사람들은 Project Lombok을 사용하여 getter와 setter를 자동으로 추가합니다. Lombok이 컨테이너에서 자동으로 개체를 인스턴스화 할 때 사용되는 특정 형식의 생성자를 생성하지 않았는지 확인합니다. |

<br>

> Lombok은 자바에서 @Getter, @Setter 같은 annotation 기반으로 관련 기존 DTO, VO, Domain Class 작성할 때, 멤버 변수에 대한 Getter/Setter Method, Equals(), hashCode(), ToString()과 멤버 변수에 값을 설정하는 생성자 등등을 자동으로 생성해 주는 라이브러리다. 
>
> 출처: <https://ijbgo.tistory.com/5> [한량 개발자]



> mgmt: 
>
> ```yml
> // lombok
> compileOnly('org.projectlombok:lombok')
> annotationProcessor('org.projectlombok:lombok')
> ```

> ```java
> import lombok.Data;
> 
> @Data
> public class DeviceControlObject {
>     private String oid;
>     private String value;
>     // SMI syntax
>     private int type;
> }
> ```



마지막으로 표준 Java Bean 특성 만 고려되며 정적 특성에 대한 바인딩은 지원되지 않습니다.

<br>

| ![[노트]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| [@Value와 @ConfigurationProperties의 차이점](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-vs-value) 참조하십시오 . |

또한 다음 예와 같이 `@EnableConfigurationProperties` 주석 에 등록 할 속성 클래스를 나열해야합니다 .

```java
@Configuration
@EnableConfigurationProperties(AcmeProperties.class)
public class MyConfiguration {
}
```

> @EnableConfigurationProperties는 해당 클래스를 빈으로 등록하고 프로퍼티 값을 할당한다.

<br>

| ![[노트]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| 그런식으로 `@ConfigurationProperties`bean이 등록 되면, bean은 일반적인 이름인 `<prefix>-<fqn>`을 가진다. `<prefix>`는 `@ConfigurationProperties`주석에 명시된 환경 키 접두사 이고 `<fqn>`은 bean의 완전한 이름이다. 주석이 접두어를 제공하지 않으면 bean의 완전한 이름 만 사용됩니다. 위의 예제에서 bean 이름은 `acme-com.example.AcmeProperties`이다. |

> @ConfigurationProperties(prefix = "spring.datasource.hikari")
>
> @ConfigurationProperties(prefix = "security")

<br>

> ```java
> @ConfigurationProperties(prefix="mf.resource.ip-filter")
> class IpFilter{
> 
> }
> 
> @EnableConfigurationProperties(IpFilter.class)
> public class ResourceConfig extends ResourceServerConfigurerAdapter {
> 
> }
> ```

> ```java
> @EnableConfigurationProperties(value = {ExtendedSecurityProperties.class})
> public class SecurityConfig extends WebSecurityConfigurerAdapter {
> }
> ```



위의 구성은  `AcmeProperties`에 대한 일반 bean을 작성합니다. `@ConfigurationProperties` 는 환경만을 다루고, 특히 컨텍스트에서 다른 빈을 주입하지 않는 것이 좋습니다 . 

`@EnableConfigurationProperties`주석은 프로젝트에 자동으로 적용되어 `@ConfigurationProperties`로 주석 된 기존 Bean이  `Environment`에서 구성되도록 합니다.  `@EnableConfigurationProperties(AcmeProperties.class)` 로 `MyConfiguration`에 주석을 추가하는 대신, 다음 예제와 같이 `AcmeProperties` 을 Bean으로 만들 수 있습니다. :

```java
@Component
@ConfigurationProperties(prefix="acme")
public class AcmeProperties {

	// ... see the preceding example

}
```

이 구성 스타일은 `SpringApplication`외부 YAML 구성에서 특히 잘 작동합니다. (다음 예제참조)

```yaml
# application.yml

acme:
	remote-address: 192.168.1.1
	security:
		username: admin
		roles:
		  - USER
		  - ADMIN

# additional configuration as required
```

`@ConfigurationProperties` 빈을 사용하여 작업하려면, 다음 예제와 같이 다른 빈과 같은 방법으로 그것들을 삽입 할 수 있습니다 :

```java
@Service
public class MyService {

	private final AcmeProperties properties;

	@Autowired
	public MyService(AcmeProperties properties) {
	    this.properties = properties;
	}

 	//...

	@PostConstruct
	public void openConnection() {
		Server server = new Server(this.properties.getRemoteAddress());
		// ...
	}

}
```

| ![[노트]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| `@ConfigurationProperties`을 사용하면 IDE가 자신의 키에 대한 자동 완성을 제공하는 데 사용할 수있는 메타 데이터 파일을 생성 할 수 있습니다. 자세한 내용은 [부록 B, 구성 메타 데이터](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#configuration-metadata) 부록을 참조하십시오. |

<br>

##### 24.8.1  Third-party Configuration

 `@ConfigurationProperties` 를 사용하여 클래스에 주석을 추가하는 것은 물론, public `@Bean`  메소드에서도 사용할 수 있습니다. 이렇게하면 컨트롤 외부에있는 third-party components에 properties을 바인딩하려는 경우 특히 유용 할 수 있습니다.

`Environment`특성 에서 Bean을 구성하려면 `@ConfigurationProperties`를 다음 예와 같이 Bean 등록에 추가하십시오 .

```java
@ConfigurationProperties(prefix = "another")
@Bean
public AnotherComponent anotherComponent() {
	...
}
```

`another`접두어로 정의 된 모든 특성은 앞의 `AcmeProperties`예제 와 유사한 방식으로 해당   `AnotherComponent` Bean에 맵핑 됩니다.

<br>

##### 24.8.2 느슨한 바인딩

Spring Boot는 `@ConfigurationProperties` bean에 `Environment`속성을 바인딩 할 때 다소 완화 된 규칙을 사용하므로 `Environment`속성 이름과 bean 속성 이름이 완전히 일치 할 필요는 없습니다. 이 기능이 유용한 일반적인 예로는 대시로 구분 된 환경 속성 (예 : `context-path`가 `contextPath`에 바인딩 됨)과 대문자로 된 환경 속성 (예 : `PORT`가 `port`에 바인딩 됨)이 있습니다.

예를 들어 다음 `@ConfigurationProperties`클래스를 생각해보십시오 .

```java
@ConfigurationProperties(prefix="acme.my-project.person")
public class OwnerProperties {

	private String firstName;

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
```

앞의 예제에서 다음 속성 이름을 모두 사용할 수 있습니다.



###### 표 24.1. 느슨한 바인딩

| 재산                                | 노트                                                         |
| ----------------------------------- | ------------------------------------------------------------ |
| `acme.my-project.person.first-name` | 케밥 (Kebab) 케이스 . 파일 `.properties`과 `.yml`파일 에 사용하는 것이 좋습니다 . |
| `acme.myProject.person.firstName`   | 표준 camel 케이스 구문.                                      |
| `acme.my_project.person.first_name` | 밑줄표기법. `.properties`및 `.yml` 파일에서 사용하기 위한 대체 형식 입니다. |
| `ACME_MYPROJECT_PERSON_FIRSTNAME`   | 시스템 환경 변수를 사용할 때 권장되는 대문자 형식.           |





| ![[노트]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| `prefix`주석의 값 은 kebab case여야합니다* (소문자로 구분되고 `-`로 구분 됨. 예: `acme.my-project.person`). |



###### 표 24.2. 속성 소스 당 바인딩 규칙 완화

| 부동산 출처 | 단순한                                                       | 명부                                                         |
| ----------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 속성 파일   | 카멜 케이스, 케밥 케이스 또는 밑줄 표기법                    | `[ ]`또는 쉼표로 구분 된 값을 사용하는 표준 목록 구문        |
| YAML 파일   | 카멜 케이스, 케밥 케이스 또는 밑줄 표기법                    | 표준 YAML 목록 구문 또는 쉼표로 구분 된 값                   |
| 환경 변수   | 분리 문자로 밑줄이있는 대문자 형식입니다. `_`속성 이름 내에서 사용해서는 안됩니다. | 밑줄로 둘러싼 숫자 값 (예 : `MY_ACME_1_OTHER = my.acme[1].other`) |
| 시스템 속성 | 카멜 케이스, 케밥 케이스 또는 밑줄 표기법                    | `[ ]`또는 쉼표로 구분 된 값을 사용하는 표준 목록 구문        |

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 가능한 경우 속성을 `my.property-name=acme`같은 소문자 kebab 형식으로 저장하는 것이 좋습니다. |



`Map`속성에 바인딩 할 때 `key`에 소문자 영숫자가 또는 `-`이 아닌 다른 문자 가 포함 된 경우 대괄호 표기법을 사용하여 원래 값을 유지해야합니다. 키가 `[]`로  둘러싸여 있지 않으면 영숫자가 아니거나 `-`가 아닌 문자는 모두 제거됩니다. 예를 들어 다음 속성을 `Map`에 바인딩하는 것을 고려하십시오 .

```yaml
acme:
  map:
    "[/key1]": value1
    "[/key2]": value2
    /key3: value3
```

위의 속성은   `/key1`, `/key2`그리고 `key3`가 `Map`의 키로 바인딩 됩니다.



##### 24.8.3 복합 유형(Complex Types) 병합

목록이 둘 이상의 장소에서 구성된 경우 전체 목록을 대체하여 우선 적용됩니다.

예를 들어 기본적으로`null`인  `name` 및 `description`속성이 있는 `MyPojo`오브젝트가 있다고 가정합니다 . 다음 예제에서는`AcmeProperties` 의 `MyPojo` 객체 목록을 표시 합니다 .

```java
@ConfigurationProperties("acme")
public class AcmeProperties {

	private final List<MyPojo> list = new ArrayList<>();

	public List<MyPojo> getList() {
		return this.list;
	}

}
```

다음 구성을 고려하십시오.

```yaml
acme:
  list:
    - name: my name
      description: my description
---
spring:
  profiles: dev
acme:
  list:
    - name: my another name
```

 `dev`프로파일이 활성화되지 않은 경우, `AcmeProperties.list`는 이전에 정의된 대로 하나의 `MyPojo` 항목을 포함합니다.  그러나 `dev` 프로파일을 사용 가능한 경우에는 `list` *여전히* 하나의 항목 (이름이 `my another name` 이고  `null`값인 설명) 만 포함됩니다. 이 구성은 두 번째 `MyPojo`인스턴스를 목록에 추가 하지 않으며 항목을 병합하지 않습니다.‌

`List` 이 여러 프로파일에 지정 된 경우 우선 순위가 가장 높은 프로파일 (하나만 사용)이 사용됩니다. 다음 예제를 고려하십시오.

```yaml
acme:
  list:
    - name: my name
      description: my description
    - name: another name
      description: another description
---
spring:
  profiles: dev
acme:
  list:
    - name: my another name
```

앞의 예에서, 만약 `dev `프로파일이 활성화되어있으면, `AcmeProperties.list`에 하나의  `MyPojo` 항목이 포함되어있습니다.(이름 `my another name` 이고, 설명 값은 `null`).  YAML의 경우 쉼표로 구분 된 목록과 YAML 목록을 모두 사용하여 목록의 내용을 완전히 오버라이딩 할 수 있습니다.

 `Map` 속성의 경우, 당신은 여러 소스에서 가져온 속성 값으로 바인딩 할 수 있습니다. 그러나 여러 소스에서 동일한 속성의 경우 우선 순위가 가장 높은 속성이 사용됩니다. 다음 예제에서는`AcmeProperties` 의  `Map<String, MyPojo>`을 노출합니다.

```java
@ConfigurationProperties("acme")
public class AcmeProperties {

	private final Map<String, MyPojo> map = new HashMap<>();

	public Map<String, MyPojo> getMap() {
		return this.map;
	}

}
```

다음 구성을 고려하십시오.

```yaml
acme:
  map:
    key1:
      name: my name 1
      description: my description 1
---
spring:
  profiles: dev
acme:
  map:
    key1:
      name: dev name 1
    key2:
      name: dev name 2
      description: dev description 2
```

`dev`프로파일이 활성화되지 않은 경우,  `AcmeProperties.map` 에는 `key1`  키가 있는 항목이 하나 있습니다 (이름이  `my name 1`  설명이  `my description 1` 인 항목). 

그러나  `dev`  프로필을 사용하는 경우 `map` 에는 키가  `key1`  (이름이  `dev name 1` 이고 설명이  `my description 1`)과 `key2`가 있습니다 (이름이  `dev name 2` 이고 설명이 `dev description 2`인 항목) 인 두 개의 항목이 있습니다. 



| ![[노트]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| 위의 병합 규칙은 YAML 파일뿐만 아니라 모든 속성 소스의 속성에도 적용됩니다. |



##### 24.8.4 Properties Conversion

스프링 부트는 `@ConfigurationProperties`빈에 바인딩 할 때 외부 애플리케이션 특성을 올바른 유형으로 강제 변환하려고 시도합니다 . 사용자 정의 유형 변환이 필요한 경우 `ConversionService`bean (`conversionService` 로 이름 지정된 bean ) 또는 사용자 정의 특성 편집기 ( `CustomEditorConfigurer`bean을 통한 ) 또는 custom `Converters`(bean 정의가  `@ConfigurationPropertiesBinding`로 주석 된)을 제공 할 수 있습니다.



| ![[노트]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| 이 빈은(사용자가 편집한?) 애플리케이션 라이프 사이클 중 매우 일찍 요청되므로 `ConversionService`가 사용중인 의존성을 제한해야 합니다. 일반적으로 필요한 어떤 종속성은 작성시 완전히 초기화되지 않을 수 있습니다. 구성 키 강제 변환이 필요하지 않은 경우 사용자 지정 `ConversionService`의 이름을 바꾸고 `@ConfigurationPropertiesBinding`으로 정규화된 사용자 지정 변환기에만 의존 할 수 있습니다. |



###### **기간 변환**

스프링 부트 (Spring Boot)는 기간 표현을 위한 헌신적인 지원을 제공합니다. `java.time.Duration`속성을 노출하면 응용 프로그램 속성에서 다음 형식을 사용할 수 있습니다.

- 일반 `long`표현 ( `@DurationUnit`가 지정 되지 않은 경우 기본 단위로 밀리 초 사용 )
-  [`java.time.Duration`](https://docs.oracle.com/javase/8/docs/api//java/time/Duration.html#parse-java.lang.CharSequence-)에 [의해 사용 된 ](https://docs.oracle.com/javase/8/docs/api//java/time/Duration.html#parse-java.lang.CharSequence-)표준 ISO-8601 형식
- 값과 단위가 결합 된 더 읽기 쉬운 형식 (예 : `10s`10 초를 의미)

다음 예제를 고려하십시오.

```java
@ConfigurationProperties("app.system")
public class AppSystemProperties {

	@DurationUnit(ChronoUnit.SECONDS)
	private Duration sessionTimeout = Duration.ofSeconds(30);

	private Duration readTimeout = Duration.ofMillis(1000);

	public Duration getSessionTimeout() {
		return this.sessionTimeout;
	}

	public void setSessionTimeout(Duration sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	public Duration getReadTimeout() {
		return this.readTimeout;
	}

	public void setReadTimeout(Duration readTimeout) {
		this.readTimeout = readTimeout;
	}

}
```

30 초의 세션 타임 아웃을 지정하려면 `30`, `PT30S`, `30s `모두 동일합니다.  500ms의 읽기 시간 제한은  `500`, `PT0.5S`그리고 `500ms` 형식 중 하나로 지정할 수 있습니다.

<br>

지원되는 유닛을 사용할 수도 있습니다. 이것들은:

- `ns` 나노 초 동안
- `us` 마이크로 초 동안
- `ms` 밀리 초 동안
- `s` 초 동안
- `m` 분 동안
- `h` 몇 시간 동안
- `d` 몇일 동안

기본 단위는 밀리 초이며 위 샘플에서 설명한대로 `@DurationUnit `를 사용하여 재정의 할 수 있습니다 .



| ![[노트]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| `Duration`으로의 전환과 밀리초가 아닌 , 단순히  기간을 표현하기 위해 `Long`사용하는 이전 버전에서 업그레이드하는 경우 단위 (`@DurationUnit`사용) 를 정의해야 합니다 . 이렇게하면 훨씬 더 풍부한 형식을 지원하면서 투명한 업그레이드 경로가 제공됩니다. |



###### 데이터 크기 변환

Spring Framework는 `DataSize`크기를 바이트 단위로 표현할 수 있는 값 유형을 가지고 있습니다. `DataSize`속성 을 공개하면 응용 프로그램 속성에서 다음 형식을 사용할 수 있습니다.

- 정규 `long`표현 (`@DataSizeUnit`가 지정되어 있지 않은 한 바이트를 기본 단위로 사용 )
- 값과 단위가 결합 된 더 읽기 쉬운 형식 (예 : `10MB`10 메가 바이트를 의미)

다음 예제를 고려하십시오.

```java
@ConfigurationProperties("app.io")
public class AppIoProperties {

	@DataSizeUnit(DataUnit.MEGABYTES)
	private DataSize bufferSize = DataSize.ofMegabytes(2);

	private DataSize sizeThreshold = DataSize.ofBytes(512);

	public DataSize getBufferSize() {
		return this.bufferSize;
	}

	public void setBufferSize(DataSize bufferSize) {
		this.bufferSize = bufferSize;
	}

	public DataSize getSizeThreshold() {
		return this.sizeThreshold;
	}

	public void setSizeThreshold(DataSize sizeThreshold) {
		this.sizeThreshold = sizeThreshold;
	}

}
```

10메가바이트의 버퍼 크기를 지정하려면 `10`와 `10MB`동일합니다. 256 바이트의 크기 임계 값은 `256`또는 `256B`로 지정할 수 있습니다 .

지원되는 유닛을 사용할 수도 있습니다. 이것들은:

- `B` 바이트
- `KB` 킬로바이트
- `MB` 메가 바이트
- `GB` 기가 바이트
- `TB` 테라 바이트

기본 단위는 바이트이며 위 샘플에서 설명한대로 `@DataSizeUnit` 로 재정의 할 수 있습니다 .



| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| `DataSize` 로의 전환과 바이트가 아닌, 단순히 `Long`크기를 표현하는데 사용하는 이전 버전에서 업그레이드하는경우 단위 ( `@DataSizeUnit `사용) 를 정의해야 합니다. 이렇게하면 훨씬 더 풍부한 형식을 지원하면서 투명한 업그레이드 경로가 제공됩니다. |

<br>

##### 24.8.5 @ConfigurationProperties 유효성 검사

Spring Boot는 `@ConfigurationProperties` 클래스가 Spring의 `@Validated`주석으로 주석이 추가 될 때마다 클래스의 유효성 검사를 시도합니다 .구성 클래스에서 JSR-303  `javax.validation` 제약 주석을 직접 사용할 수 있습니다 . 이렇게하려면 다음 예와 같이 호환되는 JSR-303 구현이 클래스 경로에 있는지 확인한 다음 필드에 제약 조건 주석을 추가하십시오.

```java
@ConfigurationProperties(prefix="acme")
@Validated
public class AcmeProperties {

	@NotNull
	private InetAddress remoteAddress;
	// ... getters and setters

}
```

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| `@Validated`과 함께 configuration properties를 작성하는 메소드에  `@Bean` 주석을 달아 검증을 트리거 할 수도 있습니다. |

중첩 된 속성도 바운딩 될 때 유효성이 검사되지만 연관된 필드에도 `@Valid`주석을 추가하는 것이 좋습니다 . 이렇게하면 중첩 된 속성이없는 경우에도 유효성 검사가 트리거됩니다. 다음 예제는 앞의 `AcmeProperties`예제 를 기반으로합니다 .

<br>

```java
@ConfigurationProperties(prefix="acme")
@Validated
public class AcmeProperties {

	@NotNull
	private InetAddress remoteAddress;

	@Valid
	private final Security security = new Security();

	// ... getters and setters

	public static class Security {

		@NotEmpty
		public String username;

		// ... getters and setters

	}

}
```

<br>

또한 `configurationPropertiesValidator` 라는 빈 정의를 생성하여 커스텀 Spring `Validator`을 추가 할 수있다 . `@Bean`메서드는 `static`으로  선언해야합니다. 구성 등록 정보 유효성 검사기는 응용 프로그램의 수명주기 초기에 만들어지며 `@Bean`메서드를 정적으로 선언 하면 `@Configuration`클래스 를 인스턴스화하지 않고도 Bean을 만들 수 있습니다 . 이렇게하면 초기 인스턴스 생성으로 인해 발생할 수있는 문제를 피할 수 있습니다. 설정하는 방법을 보여주는 [속성 유효성 검사샘플](https://github.com/spring-projects/spring-boot/tree/v2.1.5.RELEASE/spring-boot-samples/spring-boot-sample-property-validation) 이 있습니다.

<br>

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| `spring-boot-actuator`모듈은 모든 `@ConfigurationProperties` 빈을 노출하는 엔드 포인트 포함합니다. 웹 브라우저에서  `/actuator/configprops`를 가리키거나 해당 JMX 엔드 포인트를 사용하십시오. 자세한 내용은 " [프로덕션 준비 기능](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready-endpoints) "단원을 참조하십시오. |

<br>

##### 24.8.6 @ConfigurationProperties VS @Value

`@Value`주석은 핵심 컨테이너 기능이며,   type-safe ConfigurationProperties과 동일한 기능을 제공하지 않습니다. 다음 표는 `@ConfigurationProperties`및 `@Value`가 지원되는 기능을 요약 한 것입니다 .

<br>

| 특색                                                         | `@ConfigurationProperties` | `@Value` |
| ------------------------------------------------------------ | -------------------------- | -------- |
| [Relaxed binding](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-relaxed-binding) | 예                         | 아니     |
| [메타 데이터 지원](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#configuration-metadata) | 예                         | 아니     |
| `SpEL` evaluation                                            | 아니                       | 예       |

<br>

자신의 구성 요소에 대한 구성 키 세트를 정의한 경우 `@ConfigurationProperties`주석이 달린 POJO로 그룹화하는 것이 좋습니다 . 또한 `@Value`은 느슨한 바인딩을 지원하지 않으므로 환경 변수를 사용하여 값을 제공해야하는 경우에는 적합하지 않습니다.

마지막으로 `SpEL`표현식을 작성할 수있는 동안 `@Value`이러한 표현식은 [애플리케이션 특성 파일](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-application-property-files) 에서 처리되지 않습니다 .

## <br>

### 25. 프로파일 by ks

스프링 프로파일은 응용 프로그램 구성의 일부를 분리하여 특정 환경에서만 사용할 수 있도록하는 방법을 제공합니다. 다음과 같이 임의의 `@Component`또는 `@Configuration` 을 표시하여 `@Profile`로드 될 때를 제한 할 수 있습니다 .

> @Profile을 사용하는 경우 : dev와 live의 설정이 달라야 하는 경우 프로파일 단위로 세분화해서 관리한다.
>
> 운영체제 레벨에서 환경변수를 SPRING_PROFILE_ACTIVE=dev 로 설정하면 별도로 옵션을 주지 않아도 해당 운영체제에서 동작한다. 그게 아니라면 실행단계에서 java -jar -Dspring.profiles.active-dev로 설정해서 실행한다.
>
> 출처 :  [https://effectivesquid.tistory.com/entry/Spring-boot-profile-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0](https://effectivesquid.tistory.com/entry/Spring-boot-profile-적용하기)
>
> <https://jsonobject.tistory.com/220>

<br>

```java
@Configuration 
@Profile ( "production")
 public  class ProductionConfiguration {

	// ...

}
```

`spring.profiles.active` `Environment`속성을 사용하여 활성화 된 프로필을 지정할 수 있습니다 . 이 장의 앞부분에서 설명한 방법으로 속성을 지정할 수 있습니다. 예를 들어, `application.properties`에 다음 예와 같이 포함시킬 수 있습니다 .

```properties
spring.profiles.active = dev, hsqldb
```

다음 스위치를 사용하여 명령 줄에서 지정할 수도 있습니다:  `--spring.profiles.active=dev,hsqldb`.

<br>

#### 25.1 Active 프로파일 더하기

이 `spring.profiles.active` 속성은 다른 속성과 동일한 순서 규칙을 따릅니다 : 가장 우선 순위가 높은  `PropertySource`가 이깁니다. 즉, application.properties에서 활성 프로파일(active profile)을 지정하고, 다음 명령 행 스위치를 사용하여 **대체 할** 수 있습니다.

<br>

> 지정하지 않으면 default 프로퍼티를 쓰고, 지정하면 값이override된다

<br>

때로는 활성 프로필을 대체하는 대신 **추가** 하는 프로필 관련 속성을 갖는 것이 유용 합니다. 이 `spring.profiles.include`속성은 무조건 활성 프로필을 추가하는 데 사용할 수 있습니다. `SpringApplication`진입 점은 추가 프로파일을 설정하기위한 자바 API를 가집니다.(즉,  `spring.profiles.active`속성에 의해 활성화된 것들의 가장 top 에서). [SpringApplication](https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/api/org/springframework/boot/SpringApplication.html) 의 `setAdditionalProfiles()`메소드를 [보십시오](https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/api/org/springframework/boot/SpringApplication.html) .

<br>

예를 들어, 스위치를 사용하여 다음 등록 정보가있는 응용 프로그램을 실행 `--spring.profiles.active=prod`하면  `proddb`및 `prodmq`profiles도 활성화됩니다.

```yaml
--- 
my.property : fromyamlfile
 --- 
spring.profiles : prod
 spring.profiles.include : 
  - proddb 
  - prodmq
```

<br>

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 기억할 것:  `spring.profiles`속성이 특정 문서가 구성에 포함 된 경우 결정하기 위해 YAML 문서에 정의 할 수 있습니다. 자세한 내용 [은 77.7 절](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-change-configuration-depending-on-the-environment) . ["환경에 따라 구성 변경"](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-change-configuration-depending-on-the-environment) 을 참조하십시오. |

<br>

#### 25.2 프로그램적으로 프로파일 세팅

 `SpringApplication.setAdditionalProfiles(…)`응용 프로그램을 실행하기 전에 호출 하여 활성 프로파일을 프로그래밍 방식으로 설정할 수 있습니다 . Spring의 `ConfigurableEnvironment`인터페이스 를 사용하여 프로필을 활성화 할 수도 있습니다 .

> setAdditionalProfiles
>
> ```java
> public void setAdditionalProfiles(String... profiles)
> ```
>
> Set additional profile values to use (on top of those set in system or command line properties).Parameters:`profiles` - the additional profiles to set
>
> 참조 : API 문서
>
> 인자를 위의 예제로 치면 dev를 입력하면 되는 듯

<br>

#### 25.3 프로파일 별 구성파일

 참조되는 파일 `application.properties`(또는 `application.yml`)과 참조되는 파일 의 프로파일 특정 변형은 파일은 `@ConfigurationProperties`로 간주되어 로드됩니다. 자세한 내용 [은 24.4 절. "프로파일 관련 등록 정보](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-profile-specific-properties) "를 참조하십시오.

> @ConfigurationProperties를 사용하는 이유는 : application.properties에 프로젝트 내부에서 사용하는 모든 프로퍼티가 들어있어서 무슨 모듈에 무엇이 쓰이는지 파악하기 어렵지만, 아래 예제처럼 사용하면 파악이 용이하다.
>
> 아래예제에서 prefix가 settlement인데 프로퍼티 내부에 settlement가 붙는 애들이 얘가 쓰는 프로퍼티인것 
>
> 참조 :<https://www.freeism.co.kr/wp/archives/1667>

![](/home/ysyang/image11.png)

<br>

### 26. 로깅 by ks

스프링 부트는 모든 내부 [로깅을](https://commons.apache.org/logging) 위해 [Commons Logging](https://commons.apache.org/logging) 을 사용 하지만 기본 로그 구현은 그대로 둡니다. [Java Util Logging](https://docs.oracle.com/javase/8/docs/api//java/util/logging/package-summary.html) , [Log4J2](https://logging.apache.org/log4j/2.x/) 및 [Logback에](https://logback.qos.ch/) 대한 기본 구성이 제공됩니다 . 각각의 경우 로거는 콘솔 출력을 사용하도록 사전 구성되어 있으며 선택적 파일 출력도 사용할 수 있습니다.

<br>

**기본적으로 "Starters"를 사용하면 Logback이 로깅에 사용됩니다.** Java Util Logging, Commons Logging, Log4J 또는 SLF4J를 모두 사용하는 종속 라이브러리가 올바르게 작동하도록 적절한 Logback 라우팅이 포함됩니다.

<br>

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| Java에서 사용할 수있는 많은 로깅 프레임 워크가 있습니다. 위의 목록이 혼란 스럽다면 걱정하지 마십시오. 일반적으로 로깅 의존성을 변경할 필요가 없으며 Spring Boot 기본값이 정상적으로 작동합니다 |

<br>

#### 26.1 로그 형식

Spring Boot의 기본 로그 출력은 다음 예제와 유사합니다.

```
2014-03-05 10:57:51.112  INFO 45469 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/7.0.52
2014-03-05 10:57:51.253  INFO 45469 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2014-03-05 10:57:51.253  INFO 45469 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1358 ms
2014-03-05 10:57:51.698  INFO 45469 --- [ost-startStop-1] o.s.b.c.e.ServletRegistrationBean        : Mapping servlet: 'dispatcherServlet' to [/]
2014-03-05 10:57:51.702  INFO 45469 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
```

다음 항목이 출력됩니다.

- 날짜 및 시간 : 밀리 초 단위의 정밀도로 쉽게 정렬 할 수 있습니다.
- 로그 레벨 : `ERROR`, `WARN`, `INFO`, `DEBUG`, 또는 `TRACE`.
- 프로세스 ID.
- `---`실제 로그 메시지의 시작을 구분 하는 구분 기호.
- 스레드 이름 : 대괄호로 묶습니다 (콘솔 출력을 위해 잘릴 수도 있음).
- 로거 이름 : 일반적으로 소스 클래스 이름입니다 (종종 축약됩니다).
- 로그 메시지.

<br>

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| Logback에는 `FATAL`레벨 이 없습니다. 대신 ERROR에 매핑됩니다. |

<br>

#### 26.2 콘솔 출력

기본 로그 구성은 메시지가 기록 될 때 콘솔에 메시지를 에코(출력)합니다. 기본적으로 `ERROR`-level, `WARN`-level 및 `INFO`-level 메시지가 기록됩니다. **응용 프로그램을** **--debug플래그 로 시작하여 "디버그"모드를 활성화 할 수도 있습니다 .**

```
$ java -jar myapp.jar --debug
```

<br>

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 당신은 또한 **application.properties에 debug=true를 지정**할 수 있습니다. |

<br>

디버그 모드가 활성화되면 코어 로거 (임베디드 컨테이너, Hibernate 및 Spring Boot) 중 일부가 자세한 정보를 출력하도록 구성됩니다. 디버그 모드를 사용 가능하게하면 DEBUG레벨과 함께 모든 메시지를 기록하도록 응용 프로그램이 구성 되지 *않습니다.*

또는 응용 프로그램을 `--trace`플래그 (또는 `trace=true`사용자 `application.properties`) 로 시작하여 "추적"모드를 사용할 수 있습니다 . 이렇게하면 코어 로거 (임베디드 컨테이너, Hibernate 스키마 생성 및 전체 Spring 포트폴리오) 중 일부에 대한 추적 로깅을 사용할 수 있습니다.

<br>

##### 26.2.1 색으로 구분된 출력‌

터미널이 ANSI (인코딩)를 지원하면 색상 출력이 가독성을 높이기 위해 사용됩니다. 당신은  [지원하는 값](https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/api/org/springframework/boot/ansi/AnsiOutput.Enabled.html) 자동 감지를 오버라이드 (override) 하기 위해 `spring.output.ansi.enabled `를 설정할 수 있습니다.

‌<br>

색 변환 은 변환 단어 `%clr`를 사용하여 구성됩니다 . 가장 간단한 형식의 변환기는 다음 예제와 같이 로그 수준에 따라 출력의 색상을 지정합니다.

```
%clr(%5p)
```

>   %*5p* : 우측 정렬로 로그 레벨을 남김.

<br>

다음 표에서는 로그 수준을 색상에 매핑하는 방법을 설명합니다.

| 수평    | 색깔 |
| ------- | ---- |
| `FATAL` | 빨간 |
| `ERROR` | 빨간 |
| `WARN`  | 노랑 |
| `INFO`  | 녹색 |
| `DEBUG` | 녹색 |
| `TRACE` | 녹색 |



또는 변환 옵션으로 제공하여 사용해야하는 색상이나 스타일을 지정할 수 있습니다. 예를 들어 텍스트를 노란색으로 만들려면 다음 설정을 사용합니다.



```
% clr (% d {yyyy-MM-dd HH : mm : ss.SSS}) {yellow}
```

‌

다음과 같은 색상 및 스타일이 지원됩니다.



- `blue`

- `cyan`

- `faint`

- `green`

- `magenta`

- `red`

- `yellow`

  <br>

#### 26.3 파일 출력

기본적으로 Spring Boot는 콘솔에만 로그를 남기고 로그 파일을 작성하지 않습니다. 콘솔 출력 외에 로그 파일을 쓰고 싶다면 `logging.file`또는 `logging.path`속성 을 설정해야 합니다 (예 : 사용자 `application.properties`).

‌

다음 표에서는 `logging.*`속성을 함께 사용할 수있는 방법을 보여줍니다 .



**표 26.1. 로깅 속성**

| `logging.file` | `logging.path` | 예         | 기술                                                         |
| -------------- | -------------- | ---------- | ------------------------------------------------------------ |
| *(none)*       | *(none)*       |            | 콘솔 전용 로깅.                                              |
| 특정 파일      | *(none)*       | `my.log`   | 지정된 로그 파일에 기록합니다. 이름은 정확한 위치 또는 현재 디렉토리와 관련 될 수 있습니다. |
| *(none)*       | 특정 디렉토리  | `/var/log` | `spring.log`지정된 디렉토리에 기록. 이름은 정확한 위치 또는 현재 디렉토리와 관련 될 수 있습니다. |

로그 파일은 10MB에 도달하면 회전하고 콘솔 출력처럼 `ERROR`-level, `WARN`-level 및 `INFO`-level 메시지가 기본적으로 기록됩니다. 크기 제한은 `logging.file.max-size`속성을 사용하여 변경할 수 있습니다 . 이전에 회전 된 파일은 `logging.file.max-history`속성이 설정되어 있지 않으면 무기한 보관됩니다 .

<br>

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 로깅 시스템은 응용 프로그램 수명주기 초기에 초기화됩니다. 따라서 `@PropertySource` 주석을 통해로드 된 속성 파일에는 로깅 속성이 없습니다 . |

<br>

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 로깅 속성은 실제 로깅 인프라와는 독립적입니다. **결과적으로 특정 구성 키 (예 :** **logback.configurationFileLogback)는 Spring Boot에 의해 관리되지 않습니다.** |

<br>

#### 26.4 로거 레벨

지원되는 모든 로깅 시스템은 `logging.level.<logger-name>=<level>`사용하여 Spring `Environment` 에서 로그 수준을 설정할 수 있습니다. (예 : `application.properties`) 

여기서 ` level`은  TRACE, DEBUG, INFO, WARN, ERROR, FATAL 또는 OFF 중 하나입니다. 

` root`  로거는  ` logging.level.root`  을 사용하여 구성될 수 있습니다.

‌

다음 예제는 `application.properties` 의 잠재적 인 로깅 설정을 보여줍니다.

```properties
logging.level.root = WARN
 logging.level.org.springframework.web = DEBUG
 logging.level.org.hibernate = ERROR
```

<br>

#### 26.5 로그 그룹

관련 로거를 모두 그룹화하여 모두 동시에 구성 할 수있는 것이 유용 할 때가 많습니다. 예를 들어 일반적으로 *모든* Tomcat 관련 로거 의 로깅 수준을 변경할 수 있지만 최상위 패키지는 쉽게 기억할 수 없습니다.

‌<br>

이를 지원하기 위해 Spring Boot는 Spring `Environment`에서 로깅 그룹을 정의 할 수있게 해줍니다. 예를 들어 `application.properties` 에 다음과 같이 "tomcat"그룹을 정의 할 수 있습니다 .

```properties
logging.group.tomcat = org.apache.catalina, org.apache.coyote, org.apache.tomcat
```

정의가 끝나면 한 줄로 그룹의 모든 로거 레벨을 변경할 수 있습니다.

```properties
logging.level.tomcat = TRACE
```

‌<br>

Spring Boot는 out-of-the-box에서 사용할 수있는 다음과 같은 미리 정의 된 로깅 그룹을 포함합니다 :

| 이름 | 로거                                                         |
| ---- | ------------------------------------------------------------ |
| web  | `org.springframework.core.codec`, `org.springframework.http`,`org.springframework.web` |
| SQL  | `org.springframework.jdbc.core`, `org.hibernate.SQL`         |

<br>

#### 26.6 사용자 정의 로그 설정

다양한 로깅 시스템은 클래스 경로에 적절한 라이브러리를 포함시켜 활성화 할 수 있으며 클래스 경로의 루트 또는 다음 Spring `Environment` 속성에 **지정된 위치에 적절한 구성 파일을 제공하여 추가로 사용자 정의 할 수 있습니다 :** **logging.config**.

‌<br>

`org.springframework.boot.logging.LoggingSystem`시스템 속성 을 사용하여 Spring Boot가 특정 로깅 시스템을 사용하게 할 수 있습니다. 값은 `LoggingSystem`구현 의 완전한 클래스 이름이어야합니다 . `none`값을 사용하여 스프링 부트의 로깅 구성을 완전히 비활성화 할 수도 있습니다.

| ![[노트]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| **ApplicationContex t생성되기 전에 로깅이 초기화되기 때문에 스프링 @Configuration 의 @PropertySources 에서 제어할 수 없습니다.** 로깅 시스템을 변경하거나 완전히 비활성화하는 유일한 방법은 시스템 등록 정보를 사용하는 것입니다. |

‌<br>

**로깅 시스템에 따라 다음 파일이로드됩니다.**

| 로깅 시스템             | 사용자 정의                                                  |
| ----------------------- | ------------------------------------------------------------ |
| logback                 | `logback-spring.xml`, `logback-spring.groovy`, `logback.xml`, 또는`logback.groovy` |
| Log4j2                  | `log4j2-spring.xml` 또는 `log4j2.xml`                        |
| JDK (Java Util Logging) | `logging.properties`                                         |

| ![[노트]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| 가능한 경우 로깅 구성에 `-spring` 변형을 사용하는 것이 좋습니다 (예를 들어, `logback-spring.xml`을 `logback.xml `대신에 사용). 표준 구성 위치를 사용하면 Spring은 로그 초기화를 완전히 제어 할 수 없습니다. |

| ![[경고]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/warning.png) |
| ------------------------------------------------------------ |
| '실행 가능한 jar' 에서 실행할 때 문제를 일으키는 Java Util Logging의 알려진 클래스로드 문제가 있습니다. 가능하다면 '실행 가능한 jar'에서 실행하는 것을 피하는 것이 좋습니다. |

> 그냥 그 라이브러리를 빼라..

사용자 정의를 돕기 위해 다음 표에 설명 된대로 일부 다른 속성이 Spring`Environment` 에서 System 속성으로 이동됩니다 .

<br>

> application.properties -> 변수 값으로

| spring 환경                         | 시스템 속성                     | 코멘트                                                       |
| ----------------------------------- | ------------------------------- | ------------------------------------------------------------ |
| `logging.exception-conversion-word` | `LOG_EXCEPTION_CONVERSION_WORD` | 예외를 기록 할 때 사용되는 변환 단어입니다.                  |
| `logging.file`                      | `LOG_FILE`                      | 정의 된 경우 기본 로그 구성에 사용됩니다.                    |
| `logging.file.max-size`             | `LOG_FILE_MAX_SIZE`             | 최대 로그 파일 크기 (LOG_FILE이 활성화 된 경우). (기본 로그백 설정에서만 지원됩니다.) |
| `logging.file.max-history`          | `LOG_FILE_MAX_HISTORY`          | 보관할 보관 로그 파일의 최대 수 (LOG_FILE이 활성화 된 경우). (기본 로그백 설정에서만 지원됩니다.) |
| `logging.path`                      | `LOG_PATH`                      | 정의 된 경우 기본 로그 구성에 사용됩니다.                    |
| `logging.pattern.console`           | `CONSOLE_LOG_PATTERN`           | 콘솔 (stdout)에서 사용할 로그 패턴. (기본 로그백 설정에서만 지원됩니다.) |
| `logging.pattern.dateformat`        | `LOG_DATEFORMAT_PATTERN`        | 로그 날짜 형식에 대한 Appender 패턴. (기본 로그백 설정에서만 지원됩니다.) |
| `logging.pattern.file`              | `FILE_LOG_PATTERN`              | 파일에서 사용할 로그 패턴 ( `LOG_FILE`사용 가능한 경우 ). (기본 로그백 설정에서만 지원됩니다.) |
| `logging.pattern.level`             | `LOG_LEVEL_PATTERN`             | 로그 수준을 렌더링 할 때 사용할 형식 (기본값 `%5p`). (기본 로그백 설정에서만 지원됩니다.) |
| `PID`                               | `PID`                           | 가능하면 현재 프로세스 ID (OS 환경 변수로 정의되지 않은 경우). |

‌

지원되는 모든 로깅 시스템은 구성 파일을 구문 분석 할 때 시스템 특성을 참조 할 수 있습니다. `spring-boot.jar`예를 들어 기본 구성을 참조하십시오 .



- [로그백](https://github.com/spring-projects/spring-boot/tree/v2.1.5.RELEASE/spring-boot-project/spring-boot/src/main/resources/org/springframework/boot/logging/logback/defaults.xml)
- [Log4j 2](https://github.com/spring-projects/spring-boot/tree/v2.1.5.RELEASE/spring-boot-project/spring-boot/src/main/resources/org/springframework/boot/logging/log4j2/log4j2.xml)
- [Java Util 로깅](https://github.com/spring-projects/spring-boot/tree/v2.1.5.RELEASE/spring-boot-project/spring-boot/src/main/resources/org/springframework/boot/logging/java/logging-file.properties)

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 로깅 속성에서 자리 표시자를 사용 하려면 기본 프레임 워크의 구문이 아닌 [Spring Boot의 구문](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-placeholders-in-properties) 을 사용해야합니다 . 특히 Logback을 사용 하는 경우 속성 이름과 기본값 사이의 구분 기호로 :- 가 아니라 :를 사용해야합니다. |

| ![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| MDC 및 기타 임시 콘텐트를 로그 라인에 추가 할 수 있습니다 `LOG_LEVEL_PATTERN`(또는 `logging.pattern.level`Logback 으로 대체 ). 예를 들어, 사용하는 경우 `logging.pattern.level=user:%X{user} %5p`, 다음 예제와 같이 기본 로그 형식에 "user"에 대한 MDC 항목이 있으면 이를 포함합니다. |

<br>

#### 26.7 로그백 확장

<br>

Spring Boot는 고급 구성을 도울 수있는 Logback에 대한 여러 가지 확장 기능을 포함합니다. `logback-spring.xml`구성 파일 에서 이 확장을 사용할 수 있습니다 .

| ![[노트]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| 표준 `logback.xml`구성 파일이 너무 일찍로드 되었기 때문에 확장을 사용할 수 없습니다. **logging.config 속성을 사용하거나 logback-spring.xml을 정의해야합니다.** |

| ![[경고]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/warning.png) |
| ------------------------------------------------------------ |
| 확장 기능은 Logback의[configuration scanning](https://logback.qos.ch/manual/configuration.html#autoScan) 과 함께 사용할 수 없습니다 . 그렇게 하려고 하면 구성 파일을 변경하면 다음 중 하나와 유사한 오류가 기록됩니다. |

<br>

```
ERROR in ch.qos.logback.core.joran.spi.Interpreter@4:71 - no applicable action for [springProperty], current ElementPath is [[configuration][springProperty]]
ERROR in ch.qos.logback.core.joran.spi.Interpreter@4:71 - no applicable action for [springProfile], current ElementPath is [[configuration][springProfile]]
```

 <br>

##### 26.7.1 프로파일 별 설정

`<springProfile>`태그를 사용하면 활성 Spring 프로파일을 기반으로 구성 섹션을 선택적으로 포함하거나 제외 할 수 있습니다. 프로필 섹션은 `<configuration>`요소 내 어디에서나 지원됩니다 .  `name` 속성을 사용하여 구성을 허용하는 프로필을 지정합니다. `<springProfile>`태그는 간단한 프로파일 이름 (예 : `staging`) 또는 프로파일 표현식을 포함 할 수 있습니다.  프로파일 표현식은보다 복잡한 프로파일 로직이 표현되도록합니다 (예 :`production & (eu-central | eu-west)`.) 자세한 내용 은 [참조 가이드](https://docs.spring.io/spring/docs/5.1.7.RELEASE/spring-framework-reference/core.html#beans-definition-profiles-java) 를 확인하십시오. 다음 목록은 세 가지 샘플 프로필을 보여줍니다.

> 참조 <https://supawer0728.github.io/2018/04/07/spring-boot-logging/

<br>

```xml
<springProfile name="staging">
	<!-- configuration to be enabled when the "staging" profile is active -->
</springProfile>


<springProfile name="dev | staging">
	<!-- configuration to be enabled when the "dev" or "staging" profiles are active -->
</springProfile>


<springProfile name="!production">
	<!-- configuration to be enabled when the "production" profile is not active -->
</springProfile>
```

‌<br>

##### 26.7.2 환경 프로퍼티‌

`<springProperty>` 태그는 Spring  `Environment`의 Logback 내에서 사용하기 위해 속성을 노출 할 수 있습니다. 이렇게하면 Logback 구성의`application.properties`파일에서 값에 액세스하려는 경우 유용 할 수 있습니다.

이 태그는 Logback의 표준 `<property>` 태그와 비슷한 방식으로 작동합니다. 그러나 직접 값을 지정하는 대신 (`Environment`에서) 특성 소스를 지정하십시오. 속성을 로컬 범위가 아닌 다른 곳에 저장해야하는 경우 scope 속성을 사용할 수 있습니다. 폴백 값이 필요한 경우 (환경에 속성을 설정하지 않은 경우) `defaultValue` 특성을 사용할 수 있습니다. 다음 예는 Logback에서 사용할 속성을 표시하는 방법을 보여줍니다.

```properties
<springProperty scope="context" name="fluentHost" source="myapp.fluentd.host"
		defaultValue="localhost"/>
<appender name="FLUENT" class="ch.qos.logback.more.appenders.DataFluentAppender">
	<remoteHost>${fluentHost}</remoteHost>
	...
</appender>
```

| ![[노트]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| `source`는 케밥 케이스로 (예: my.property-name) 구체화되어야한다. 그러나 느슨한 규칙을 사용하여 속성을 `Environment`에 추가 할 수 있습니다 . |

> 케밥 케이스 :  
>
> - [하이픈](https://zetawiki.com/w/index.php?title=하이픈&action=edit&redlink=1)으로 단어를 연결하는 표기법
> - HTML 태그의 id, class 속성으로 흔히 쓰임

<br>

### 27 국제화 by ks

Spring Boot는 응용 프로그램이 다른 언어 기본 설정의 사용자를 수용 하기위해 각 지역화 된 메세지를 지원합니다. 기본적으로 스프링 부트는 클래스 패스의 루트에서 `messages`리소스 번들의 존재 여부를 찾습니다 .

| ![[Note]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| 자동 구성은 구성된 리소스 번들의 기본 속성 파일이 사용 가능할 때 (즉 기본적으로`messages.properties`) 적용됩니다. 리소스 번들에 언어 별 특성 파일 만 들어 있으면 기본값을 추가해야합니다. |

‌<br>

다음 예제에서와 같이 `spring.messages`네임 스페이스를 사용하여 리소스 번들의 기본 이름과 다른 여러 속성을 구성 할 수 있습니다 .

```properties
spring.messages.basename = messages, config.i18n.messages
 spring.messages.fallback-to-system-locale = false
```

| ![[Tip]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| `spring.messages.basename` 는 쉼표로 구분 된 위치 목록 (패키지 목록 또는 클래스 경로 루트에서 확인된 리소스)을 지원합니다. |

<‌br>

더 많은 지원 옵션은 .[ `MessageSourceProperties`](https://github.com/spring-projects/spring-boot/tree/v2.1.5.RELEASE/spring-boot-project/spring-boot-autoconfigure/src/main/java/org/springframework/boot/autoconfigure/context/MessageSourceProperties.java)을 참조하십시오 

<br>

### 28. JSON by sh

Spring Boot는 세 개의 JSON 매핑 라이브러리와의 통합을 제공합니다:‌

- Gson
- Jackson
- JSON-B

**Jackson이 선호되고 기본 라이브러리**입니다.

> REST API의 경우 JSON 스트링 형태로 내용을 표현한다.
>
> 넘어온 JSON을 파싱하여 자바의 객체로 활용한다.
>
> JSON과 자바 변환 라이브러리!
>
>  <br>
>
> Jackson 
>
> - JSON 뿐만 아니라 XML과 YAML도 지원하는 라이브러리 
> - 속도가 빠르고 유연하며 고용량의 JSON 데이터 처리 성능도 탁월
>
> Google-gson 
>
> - JSON의 자바 오브젝트의 직렬화, 역직렬화를 해주는 오픈 소스 자바 라이브러리
> - 비교적 가벼우며 메이븐 저장소도 지원한다. 전반적으로 성능 좋음
>
> JSON-B (JSON 바인딩)
>
> - JSON 메시지를 Java 객체로 변환하고 다시 변환하기위한 새로운 Java EE 사양 
> - 스프링부트 2.0에서 소개됨.
>
>  <br>
>
> Jackson Vs. Gson 
>
> - Gson : 가벼운 JSON 데이터 처리 성능 탁월 
> - Jackson : 고용량 데이터를 파싱할 때 성능 탁월

<br>

#### 28.1 Jackson

Jackson의 자동 구성이 제공되며 Jackson은 `spring-boot-starter-json`의 일부입니다. Jackson이 클래스 경로에 있으면 `ObjectMapper`bean이 자동으로 구성됩니다. [customizing the configuration of the `ObjectMapper`](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-customize-the-jackson-objectmapper)를 위해 몇 가지 구성 속성이 제공됩니다. 

<br>

#### 28.2 Gson

 Gson의 자동 구성이 제공됩니다. Gson이 classpath에 있으면 `Gson`bean이 자동으로 구성됩니다. 구성을 사용자 정의하기 위해 몇 가지 `spring.gson.*`구성 등록 정보가 제공됩니다. 더 많은 제어를 위해 하나 이상의 `GsonBuilderCustomizer`빈을 사용할 수 있습니다. 

<br>

#### 28.3 JSON-B

 JSON-B의 자동 구성이 제공됩니다. JSON-B API 및 구현이 클래스 경로에 있으면 `Jsonb`bean이 자동으로 구성됩니다. 선호되는 JSON-B 구현은 의존성 관리가 제공되는 Apache Johnzon이다. 

<br>

### 29. 웹 응용 프로그램 개발 by sh

스프링 부트는 웹 응용 프로그램 개발에 매우 적합합니다. 내장된 Tomcat, Jetty, Undertow 또는 Netty를 사용하여 자체 포함 된 HTTP 서버를 만들 수 있습니다. 대부분의 웹 응용 프로그램은 **spring-boot-starter-web** 모듈을 사용하여 빠르게 실행됩니다. **spring-boot-starter-webflux** 모듈을 사용하여 사후 대응 웹 응용 프로그램을 구축하도록 선택할 수도 있습니다. 

<br>

Spring Boot 웹 응용 프로그램을 아직 개발하지 않았다면 [*Getting started*](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started-first-application) 섹션의 "Hello World!" 예제를 따라하십시오. 

<br>

#### 29.1 The “Spring Web MVC Framework”

[Spring Web MVC framework ](https://docs.spring.io/spring/docs/5.1.7.RELEASE/spring-framework-reference/web.html#mvc)(간단히 "Spring MVC"라고도 함)는 풍부한 "모델 뷰 컨트롤러"웹 프레임 워크입니다. **Spring MVC는 들어오는 HTTP 요청을 처리하기 위해 특별한 `@Controller` 또는 `@RestController` 빈을 생성하게합니다. 컨트롤러의 메서드는 `@RequestMapping` 어노테이션을 사용하여 HTTP에 매핑됩니다. **

‌<br>

다음 코드는 JSON 데이터를 처리하는 일반적인 `@RestController`를 보여줍니다. 

```java
@RestController
@RequestMapping(value="/users")
public class MyRestController {


	@RequestMapping(value="/{user}", method=RequestMethod.GET)
	public User getUser(@PathVariable Long user) {
		// ...
	}


	@RequestMapping(value="/{user}/customers", method=RequestMethod.GET)
	List<Customer> getUserCustomers(@PathVariable Long user) {
		// ...
	}


	@RequestMapping(value="/{user}", method=RequestMethod.DELETE)
	public User deleteUser(@PathVariable Long user) {
		// ...
	}


}
```

Spring MVC는 핵심 Spring 프레임 워크의 일부이며 자세한 정보는 [reference documentation](https://docs.spring.io/spring/docs/5.1.7.RELEASE/spring-framework-reference/web.html#mvc)에서 확인할 수있다. [spring.io/guides](https://spring.io/guides)에서 Spring MVC를 사용할 수있는 여러 가이드가있다. 

 <br>

##### 29.1.1 Spring MVC 자동 구성 

Spring Boot는 대부분의 어플리케이션에서 잘 동작하는 Spring MVC를위한 자동 설정 기능을 제공한다. 

‌<br>

자동 설정은 Spring의 기본값 위에 다음과 같은 기능을 추가합니다 :

- `ContentNegotiatingViewResolver` 및 `BeanNameViewResolver` 빈 포함
- WebJars에 대한 지원을 포함하여 정적 리소스 제공 지원 (covered [later in this document](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-spring-mvc-static-content))).
- `Converter`, `GenericConverter`, 및 `Formatter` 빈 자동 등록
- `HttpMessageConverters` 지원 (covered [later in this document](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-spring-mvc-message-converters)).
- `MessageCodesResolver 자동 등록` (covered [later in this document](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-spring-message-codes)).
- 정적`index.html` 지원
- 사용자 정의`Favicon` 지원 (covered [later in this document](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-spring-mvc-favicon)).
- `ConfigurableWebBindingInitializer` 빈 자동 사용 (covered [later in this document](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-spring-mvc-web-binding-initializer)).

‌<br>

**스프링 부트 MVC 기능을 유지하고 추가적인** [**MVC configuration**](https://docs.spring.io/spring/docs/5.1.7.RELEASE/spring-framework-reference/web.html#mvc) **(인터셉터, 포맷터, 뷰 컨트롤러 및 기타 기능)을 원하는 경우** **@EnableWebMvc가 아닌 WebMvcConfigurer유형의 @Configuration클래스를 추가 할 수 있습니다.** `RequestMappingHandlerMapping`, `RequestMappingHandlerAdapter`또는 `ExceptionHandlerExceptionResolver`의 사용자 정의 인스턴스를 제공하려는 경우 `WebMvcRegistrationsAdapter`인스턴스를 선언하여 이러한 구성 요소를 제공 할 수 있습니다. 

‌

**Spring MVC를 완벽하게 제어하려면 @EnableWebMvc로 주석이 달린 @Configuration을 추가하면 됩니다.**

> ```
> @EnableWebMvc
> ```
>
> - **어노테이션 기반의 Spring MVC를 구성할 때 필요한 빈 설정들을 자동으로 해주는 어노테이션**. 또한 기본적으로 등록해주는 빈들 이외에 추가적으로 개발자가 필요로 하는 빈들의 등록을 손쉽게할 수 있도록 도와준다. (웹 MVC를 이용하는 데에 있어서 스프링 컨테이너가 가져야 할 기본적인 빈 컴포넌트를 등록해서 편하게 MVC를 구축할 수 있는 Configuration 환경을 제공해준다)
>
> 예) 스프링 3에서 등장한 @MVC(@RequestMapping, @RequestBody, @ResponseBody) 등의 스타일을 위해서 등록되어야 하는 RequestMappingHandler, RequestMappingHandlerAdapter, ExceptionHandlerExceptionResolver 등의 등록을 자동으로 해준다.



> 자동 구성된 스프링 MVC 구성을 큰 변경 없이 추가적으로 조작하는 방법?
>
> - **@Configuration** 선언!
>   - **WebMvcConfigurer**
>     - **@EnableWebMvc 어노테이션에서 제공하는 빈을 커스터마이징할 수 있는 기능을 제공하는 인터페이스** (자동 구성된 스프링 MVC 구성에 Formatter, MessageConverter 등을 추가 등록할 수 있다)
>   - `WebMvnRegistrations`
>     - RequestMappingHandlerMapping, RequestMappingHandlerAdapter, ExceptionHandlerExceptionResolver를 재정의할 수 있다.

![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgHdvKAf6G9BmRJGVEk%2F-LgHlSyubqta5jCbJx_7%2Fimage.png?alt=media&token=ee6bdea1-928a-48d7-9367-454665bc980e)

<br>

> 자동 구성된 스프링 MVC 구성을 개발자가 완벽히 제어하는 방법? 
>
> - 첫 번째 방법:**@Configuration** **과** **@EnableWebMvc****를 함께 선언!**
>   - `@EnableWebMvc`를 선언하면 WebMvcConfigurationSupport에서 구성한 스프링 MVC 구성을 불러온다.

![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgHdvKAf6G9BmRJGVEk%2F-LgHoAvOQnsBDkYgGUo5%2Fimage.png?alt=media&token=d63eccd8-e6f4-44e4-8427-1eb115cd4115)

<br>

> 두 번째 방법: **@Configuration** **과** **@EnableWebMvc****를 함께 선언한 클래스가 WebMvcConfigurer 인터페이스 구현**
>
> - WebMvcConfigurationSupport에서 자동구성한 스프링 MVC 구성에 Formatter, MessageConverter 등을 추가적으로 등록할 수 있다.



![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgHdvKAf6G9BmRJGVEk%2F-LgHoJCOnxidYkojfh_k%2Fimage.png?alt=media&token=f6a369c0-85f0-4bc9-b4f2-a6127d284a74)

<br>

> 세 번째 방법: **@EnableWebMvc** **없이 스프링 MVC 구성을 변경하는 방법**

![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgHdvKAf6G9BmRJGVEk%2F-LgHoPNJaVfiUfYfmo2P%2Fimage.png?alt=media&token=64ae530a-5356-4e73-8bbc-583ec777ecb0)

<br>

##### 29.1.2 HttpMessageConverters

‌<br>

**Spring MVC는 HTTP 요청과 응답을 변환하기 위해** **HttpMessageConverter 인터페이스를 사용한다. 의미있는 기본값이 기본적으로 포함됩니다.** 예를 들어, 객체는 JSON (Jackson 라이브러리를 사용하여) 또는 XML (Jackson XML 확장이 사용 가능한 경우 이를 사용하거나 Jackson XML 확장을 사용할 수없는 경우 JAXB를 사용하여 자동으로 변환 될 수 있음)으로 자동적으로 변환될 수 있습니다. 기본적으로 문자열은 `UTF-8`로 인코딩됩니다. 

‌<br>

**컨버터를 추가하거나 사용자 정의해야하는 경우** 다음 목록과 같이 Spring Boot의 **HttpMessageConverters 클래스를 사용할 수 있습니다.** 

<br>

```java
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.*;
import org.springframework.http.converter.*;


@Configuration
public class MyConfiguration {


	@Bean
	public HttpMessageConverters customConverters() {
		HttpMessageConverter<?> additional = ...
		HttpMessageConverter<?> another = ...
		return new HttpMessageConverters(additional, another);
	}


}
```

컨텍스트에있는 `HttpMessageConverter`bean이 컨버터 목록에 추가됩니다. 같은 방법으로 기본 컨버터를 재정의 할 수도 있습니다. 

<br>

##### 29.1.3 사용자 정의 JSON Serializers and Deserializers

‌<br>

**Jackson을 사용하여 JSON 데이터를 serialize 및 deserialize하는 경우 사용자 고유의** **JsonSerializer** **및** **JsonDeserializer** **클래스를 작성할 수 있습니다.** 커스텀 Serializer는 일반적으로 모듈을 통해 Jackson에 등록되지만 Spring Boot는 Spring Bean을 직접 등록하기 쉬운 `@JsonComponent` 어노테이션을 제공합니다. 

‌<br>

**`JsonSerializer` 또는`JsonDeserializer` 구현에서 직접 `@JsonComponent` 어노테이션을 사용할 수 있습니다.** 다음 예제와 같이 내부 클래스로 serializer / deserializers가 포함 된 클래스에서 사용할 수도 있습니다. 



```java
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.springframework.boot.jackson.*;


@JsonComponent
public class Example {


	public static class Serializer extends JsonSerializer<SomeObject> {
		// ...
	}


	public static class Deserializer extends JsonDeserializer<SomeObject> {
		// ...
	}


}
```

**`ApplicationContext` 의 모든 `@JsonComponent` Bean은 자동으로 Jackson에 등록됩니다.** `@JsonComponent`는 `@Component`로 메타 주석이 붙어 있기 때문에 일반적인 구성 요소 검색 규칙이 적용됩니다.

<br>

> Ex. "favoriteColor" JSON을 객체화 ! (Serialize) 

![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgL7HHmDY2AXz5tr5o0%2F-LgLBNN2GLo8XJ5IwQYV%2Fimage.png?alt=media&token=fdbf6acb-d928-4963-8f91-9c57ec6c0a66)

![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgL7HHmDY2AXz5tr5o0%2F-LgLBYgVDtdjA605trWZ%2Fimage.png?alt=media&token=0b8dc7d1-4e50-4c27-bcc5-36f50f156888)

![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgL7HHmDY2AXz5tr5o0%2F-LgLBdKsPe2qtc4aMihR%2Fimage.png?alt=media&token=46644b5e-ec6f-49c7-9802-b432a16cd888)



Spring Boot는 또한 [`JsonObjectSerializer`](https://github.com/spring-projects/spring-boot/tree/v2.1.5.RELEASE/spring-boot-project/spring-boot/src/main/java/org/springframework/boot/jackson/JsonObjectSerializer.java)및 [`JsonObjectDeserializer`](https://github.com/spring-projects/spring-boot/tree/v2.1.5.RELEASE/spring-boot-project/spring-boot/src/main/java/org/springframework/boot/jackson/JsonObjectDeserializer.java)기본 클래스를 제공하여 객체를 직렬화 할 때 표준 Jackson 버전에 대한 유용한 대안을 제공합니다. 자세한 내용은 Javadoc의 [`JsonObjectSerializer`](https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/api/org/springframework/boot/jackson/JsonObjectSerializer.html)및 [`JsonObjectDeserializer`](https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/api/org/springframework/boot/jackson/JsonObjectDeserializer.html)를 참조하십시오. 

<br>

##### 29.1.4 MessageCodesResolver

Spring MVC는 **오류를 바인딩해서 오류 메시지를 렌더링하기위한 오류 코드를 생성하는 전략**을 가지고있습니다: `MessageCodesResolver`. **spring.mvc.message-codes-resolver.format 속성을  PREFIX_ERROR_CODE 또는 POSTFIX_ERROR_CODE 로 설정**하면 Spring Boot가 자동으로 생성합니다 ([`DefaultMessageCodesResolver.Format`](https://docs.spring.io/spring/docs/5.1.7.RELEASE/javadoc-api/org/springframework/validation/DefaultMessageCodesResolver.Format.html)의 enumeration  참조).

<br>

> **MessageCodesResolver**
>
> Errors 인터페이스 : 커멘드 객체의 검증 결과를 저장한다. 
>
> BindingResult 인터페이스 : 요청 파라미터 값을 커맨드 객체에 복사한 결과를 저장하며 에러 코드로부터 에러 메시지를 가져온다. 
>
> AbstractbindingResult 클래스 : BindingResult 인터페이스의 기본 구현 클래스. 검증 결과를 저장하고 에러 메시지를 추출하는 등의 기능을 제공한다.
>
>  
>
> **BindingResult 인터페이스의 기본 구현 클래스인 AbstractBindingResult 클래스는 MessageCodeResolver를 사용하여 에러 코드에 대한 에러 메시지를 추출한다.**
>
> - DefaultMessageCodeResolver를 기본으로 사용

<br>

##### 29.1.5 정적 콘텐츠

기본적으로 스프링 부트는 classpath 또는 `ServletContext`루트에서 **/static (또는 /public 또는 /resources 또는 /META-INF/resources**) 디렉토리의 정적 컨텐츠를 제공합니다. **Spring MVC의** **ResourceHttpRequestHandler를 사용하므로 addResourceHandlers 메소드를 재정의하는 WebMvcConfigurer 를 추가하여 해당 동작을 수정할 수 있습니다.** 

> ```
> ResourceHttpRequestHandler
> ```
>
> - 정적 리소스에 대한 처리 수행. 경로 잡거나 등등

<br>

독립형 웹 응용 프로그램에서, 컨테이너의 기본 서블릿도 활성화되어 Spring에서 처리하지 않기로 결정한 경우 `ServletContext`의 루트에서 컨텐트를 제공하는 대체 역할을 합니다. Spring이 항상 `DispatcherServlet`을 통해 요청을 처리 할 수 있기 때문에 대부분의 경우 이 작업은 수행되지 않습니다 

‌<br>

**기본적으로 리소스는** **/\**** **에 매핑되지만** **spring.mvc.static-path-pattern** **속성을 사용하여 튜닝 할 수 있습니다.** 예를 들어, 모든 리소스를 `/resources/**` 로 재배치하는 것은 다음과 같이 수행 할 수 있습니다. 

```properties
spring.mvc.static-path-pattern=/resources/**
```

‌<br>

> 기본 리소스 위치
>
> - classpath:/static
> - classpath:/public
> - classpath:/resources/
> - classpath:/META-INF/resources
>   - 예) "/hello.html" 접근시 /static/hello.html 응답
>
>  
>
> - spring.mvc.static-path-pattern: 맵핑 설정 변경 가능
>   - application.properties에서 `spring.mvc.static-path-pattern: /resources/**` 으로 설정 변경시
>   - localhost:8080/hello.html => localhost:8080/resources/hello.html로 접근

<br>

**spring.resources.static-locations** **등록 정보 (기본값을 디렉토리 위치 목록으로 바꾸기)를 사용하여 정적 자원 위치를 사용자 정의 할 수도 있습니다.** 루트 서블릿 컨텍스트 경로 `"/"`가 위치로 자동 추가됩니다. 

<br>

> spring.mvc.static-locations: 리소스 찾을 위치 변경 가능
>
> - 기존의 기본 리소스 위치를 사용하지 않고 변경한 위치만 사용하므로 권장하지 않는 방법이다.
> - 이 방법 보다는 WebMvcConfigurer를 구현상속받아서 addResourceHandlers로 커스터마이징 하는 방법이 더 좋다. 기본 리소스 위치를 사용하면서 추가로 필요한 리소스위치만 정의해서 사용할 수 있다.
>   - localhost:8080/m/hello.html 접근시 resources/m/hello.html 리턴



앞서 언급 한 "표준"정적 리소스 위치 외에도 [Webjars content](https://www.webjars.org/)에 특별한 경우가 있습니다. `/webjars/**`에 경로가있는 자원은 Webjars 형식으로 패키지 된 경우 jar 파일에서 제공됩니다.



| ![[Note]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| **응용 프로그램이 jar로 패키지화되어있는 경우** **src/main/webapp** **디렉토리를 사용하지 마십시오. 이 디렉토리는 일반적인 표준이지만, war 패키징에서만 작동하며 병?을 생성하면 대부분의 빌드 도구에서 자동으로 무시됩니다.** |

‌<br>

Spring Boot는 또한 Spring MVC가 제공하는 고급 리소스 처리 기능을 지원하므로 캐시 무효화 정적 리소스 또는 Webjars 용 버전 불가지론 URL 사용과 같은 사용 사례를 허용합니다. 

 <br>

**Webjars에 대해 버전에 관계없는 URL을 사용하려면** **webjars-locator-core** **종속성을 추가하십시오.** 그런 다음 Webjar를 선언하십시오. 예를 들어 jQuery를 사용하면 `"/webjars/jquery/jquery.min.js"`를 추가하면 `"/webjars/jquery/x.y.z/jquery.min.js"`가됩니다. 여기서 `x.y.z`는 Webjar 버전입니다. 

<br>

> Webjars
>
> - 클라이언트에서 사용하는 웹 라이브러리(jquery와 bootstrap)를 JAR 파일 안에 패키징한 것
>
> [참고사이트] <https://java.ihoney.pe.kr/428> 



![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgHylqVAhaDIj6HUSkz%2F-LgI-ZYCtkJYExX26uUK%2Fimage.png?alt=media&token=75c46f0e-e18b-4757-8023-113f769742b2)

![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgHylqVAhaDIj6HUSkz%2F-LgI-g0MkXAUmq9khG8h%2Fimage.png?alt=media&token=c38e09c3-a35b-48be-9152-7759583aadc9)

![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgHylqVAhaDIj6HUSkz%2F-LgI-ng8tmUFzuXDLQ8B%2Fimage.png?alt=media&token=9af714f7-39bf-4071-baaf-da2e625a41c8)

>  **webjars-locator-core** 의존성을 추가하면 리소스에서 webjars를 사용할 때, 버전을 생략할 수 있다. 이런 버전생략이 가능한 **원리**는 스프링에서 제공하는 리소스 체이닝이라는 기술과 관련이 있다. 리소스 트랜스포머를 체이닝하는 기능이 이러한 버전 생략을 가능하게 해준다. 깊게 알아야할 내용은 아니지만 버전 생략이 가능하다 라는 정도만 알아두면 된대.. 

<br>

| ![[Note]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| JBoss를 사용하는 경우 `webjars-locator-core` 대신 `webjars-locator-jboss-vfs` 종속성을 선언해야합니다. 그렇지 않으면 모든 Webjars가 `404`로 해결됩니다. |

 ‌

**캐시 무효화를 사용하기 위해 다음 구성에서는 모든 정적 리소스에 대한 캐시 무효화 솔루션을 구성**하여 URL에 `<link href="/css/spring-2a2d595e6ed9a0b24f027f2b63b134d6.css"/>`와 같은 콘텐츠 해시를 효과적으로 추가합니다. 

<br>

> 스프링 리소스 체인 활성화 
>
> 
>
> ```
> spring.resources.chain.strategy.content.enabled
> ```
>
> ResourceChainRegistration 의 기본 aspect을 설정할 수 있다. 이는 사용자가 캐시파열cache busting을 구현하기 위한 고유한 리소스 이름을 만들수 있게 해준다. **spring.resources.chain.strategy.content. 프로퍼티는 만약 사용자가 사용자의 fingerprint에 "고정된 버전"fixed version을 쓰길 원하면 리소스의 내용에 기초해 fingerprinting을 설정하는데 쓰인다.**
>
>  
>
> **Resource versioning**
>
> 이것을 **Fingerprinting URL**이라고 부르기도 한다. 스프링에 추가된 기능은 RoR의 asset pipeline에 기초를 둔다. 이 기능의 요점은 다음과 같다. **가령, /css/mystyle.css 이라는 파일이 있다고 하면 자동적으로 /css/mystyle-f1l521f.css 같은 이름으로 바꿔서 제공한다.** 이렇게 되면 **HTTP header의 캐시를 얼마든지 길게 하더라도 언제나 최신의 리소스를 제공할 수 있게 된다.** 특히, 저 버전은 css파일의 내용을 hash한 값이므로 **파일의 내용이 변경되지 않는다면 파일 이름에도 변경이 생기지 않아 캐시가 효율적으로 동작한다.**

```properties
spring.resources.chain.strategy.content.enabled=true
spring.resources.chain.strategy.content.paths=/**
```

<br>

| ![[Note]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| 리소스 링크는 Thymeleaf 및 FreeMarker에 대해 자동 구성되는 `ResourceUrlEncodingFilter`덕분에 런타임에 템플릿에 다시 작성됩니다. JSP를 사용할 때 이 필터를 수동으로 선언해야합니다. 다른 템플릿 엔진은 현재 자동으로 지원되지 않지만 사용자 지정 템플릿 매크로 / 도우미와 [`ResourceUrlProvider`](https://docs.spring.io/spring/docs/5.1.7.RELEASE/javadoc-api/org/springframework/web/servlet/resource/ResourceUrlProvider.html)를 사용할 수 있습니다. |

예를 들어 자바 스크립트 모듈 로더와 같이 리소스를 동적으로로드 할 때 파일 이름 바꾸기는 옵션이 아닙니다. 그래서 다른 전략도 지원되고 결합 될 수 있습니다. **"고정"전략은 다음 예와 같이 파일 이름을 변경하지 않고 URL에 정적 버전 문자열을 추가합니다.** ‌

```properties
spring.resources.chain.strategy.content.enabled=true
spring.resources.chain.strategy.content.paths=/**
spring.resources.chain.strategy.fixed.enabled=true
spring.resources.chain.strategy.fixed.paths=/js/lib/
spring.resources.chain.strategy.fixed.version=v12
```

**이 구성을 사용하면 "/js/lib/" 아래에있는 JavaScript 모듈은 고정 된 버전 관리 전략 ("/v12/js/lib/mymodule.js")을 사용**하지만 다른 리소스는 여전히 내용 하나 (`<link href="/css/spring-2a2d595e6ed9a0b24f027f2b63b134d6.css"/>`). 

‌

지원되는 옵션에 대해서는 [`ResourceProperties`](https://github.com/spring-projects/spring-boot/tree/v2.1.5.RELEASE/spring-boot-project/spring-boot-autoconfigure/src/main/java/org/springframework/boot/autoconfigure/web/ResourceProperties.java)를 참조하십시오. 

| ![[Tip]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 이 기능은 전용 [blog post](https://spring.io/blog/2014/07/24/spring-framework-4-1-handling-static-web-resources)와 Spring Framework의 [reference documentation](https://docs.spring.io/spring/docs/5.1.7.RELEASE/spring-framework-reference/web.html#mvc-config-static-resources)에 자세히 설명되어 있습니다. |



<br>

##### 29.1.6 Welcome Page

Spring Boot는 정적 및 템플릿된 웰컴 페이지를 모두 지원합니다. **먼저 구성된 정적 컨텐츠 위치에서** **index.html** **파일을 찾습니다. 하나도 찾지 못하면 index템플릿을 찾습니다. 둘 중 하나가 발견되면 자동으로 응용 프로그램의 시작 페이지로 사용됩니다.** 

<br>

##### 29.1.7 사용자 정의 Favicon

스프링 부트는 구성된 정적 컨텐츠 위치와 classpath의 루트 (순서대로)에서 `favicon.ico`를 찾습니다. 이러한 파일이 있는 경우 자동으로 응용 프로그램의 favicon으로 사용됩니다.

<br>

> 파비콘 
>
> - 웹 페이지에 접속했을 때 상단 탭에 보여지는 아이콘. (즐겨찾기에 웹 페이지를 등록할 때도 사용 - 웹 사이트를 대표하는 로고의 개념과 비슷)

<br>

##### 29.1.8 경로 일치 및 콘텐츠 협상 

‌**Spring MVC는 요청 경로를 보고 애플리케이션에 정의된 매핑 (예 : 컨트롤러 메소드의** **@GetMapping** **어노테이션)과 일치시켜 들어오는 HTTP 요청을 핸들러에 매핑 할 수있습니다.** 

<br>

**Spring Boot는 기본적으로 접미어 패턴 일치를 비활성화하도록 선택합니다. 즉** **"GET /projects/spring-boot.json" 과 같은 요청은** **@GetMapping("/projects/spring-boot")** **매핑과 일치하지 않습니다.** 이것은 [best practice for Spring MVC applications](https://docs.spring.io/spring/docs/5.1.7.RELEASE/spring-framework-reference/web.html#mvc-ann-requestmapping-suffix-pattern-match)로 간주됩니다. 이 기능은 적절한 "Accept"요청 헤더를 보내지 않은 HTTP 클라이언트에 대해 과거에는 주로 유용했습니다. 우리는 **올바른 Content Type을 클라이언트에 보내야합니다. 요즘, 콘텐츠 협상은 훨씬 더 신뢰할 수 있습니다.** 

‌<br>

적절한 "Accept"요청 헤더를 지속적으로 보내지 않는 HTTP 클라이언트를 다룰 수있는 다른 방법이 있습니다. 접미어 일치를 사용하는 대신 `"GET /projects/spring-boot?format=json"`과 같은 요청이 `@GetMapping("/projects/spring-boot")`에 매핑되도록 쿼리 매개 변수를 사용할 수 있습니다. T

<br>

```properties
spring.mvc.contentnegotiation.favor-parameter=true

# We can change the parameter name, which is "format" by default:
# spring.mvc.contentnegotiation.parameter-name=myparam

# We can also register additional file extensions/media types with:
spring.mvc.contentnegotiation.media-types.markdown=text/markdown
```

<br>

주의 사항을 이해하고 여전히 접미어 패턴 일치를 사용하려는 응용 프로그램을 원한다면 다음 구성이 필요합니다. 

<br>

```properties
spring.mvc.contentnegotiation.favor-path-extension=true
spring.mvc.pathmatch.use-suffix-pattern=true
```

또는 모든 접미어 패턴을 열지 않고 등록 된 접미사 패턴을 지원하는 것이 더 안전합니다. 

```properties
spring.mvc.contentnegotiation.favor-path-extension=true
spring.mvc.pathmatch.use-registered-suffix-pattern=true

# You can also register additional file extensions/media types with:
# spring.mvc.contentnegotiation.media-types.adoc=text/asciidoc

```

<br>

##### 29.1.9 ConfigurableWebBindingInitializer

**스프링 MVC는** **WebBindingInitializer 를 사용하여 특정 요청에 대해** **WebDataBinder 를 초기화한다. 자신만의** **ConfigurableWebBindingInitialize Bean을 생성하면 스프링 부트는 자동으로 스프링 MVC를 사용하도록 설정합니다.**

> `WebBindingInitializer`를 사용하여 특정 요청에 대해 `WebDataBinder`를 초기화?

![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgHylqVAhaDIj6HUSkz%2F-LgI4uHkiINexqkGLI6m%2Fimage.png?alt=media&token=9e3144b2-bbc8-455d-b1a1-71ce024c9d48)



<br>

> 커스텀한 컨버터를 바인딩할 때 자동으로 쓸 수 있도록하려면 2가지 방법 존재!
>
> - @InitBinder 사용
>   - 필요할 때마다 매번 생성해서 사용

<br>

![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgHylqVAhaDIj6HUSkz%2F-LgI5Re_SLOo5IPfDgiG%2Fimage.png?alt=media&token=2bf4bb96-d999-4c14-a35b-c32929c8231c)

> ConfigurableWebBinderInitializer 사용
>
> - 일괄 등록!



![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgHylqVAhaDIj6HUSkz%2F-LgI5iY-qwlmg46bW35O%2Fimage.png?alt=media&token=0ac32532-3160-4fed-8744-78d3a73a6ef3)

<br>

##### 29.1.10 Template Engines

REST 웹 서비스뿐만 아니라 Spring MVC를 사용하여 동적 HTML 컨텐츠를 제공 할 수도있다. **Spring MVC는 Thymeleaf, FreeMarker 및 JSP를 비롯한 다양한 템플릿 기술을 지원합니다.** 또한 많은 다른 템플릿 엔진에는 자체적인 Spring MVC 통합이 포함됩니다. 

‌<br>

Spring Boot는 다음 템플릿 엔진에 대한 자동 구성 지원을 포함합니다.  

‌

- [FreeMarker](https://freemarker.apache.org/docs/)
- [Groovy](http://docs.groovy-lang.org/docs/next/html/documentation/template-engines.html#_the_markuptemplateengine)
- [Thymeleaf](https://www.thymeleaf.org/)
- [Mustache](https://mustache.github.io/)

| ![[Tip]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 가능한 경우 JSP를 피해야합니다. 임베디드 서블릿 컨테이너에서 사용할 때 몇 가지 [known limitations](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-jsp-limitations)이 있습니다. |

<br>

**이 템플릿 엔진 중 하나를 기본 구성으로 사용하면 템플릿이** **src/main/resources/templates에서 자동으로 선택됩니다.** 

| ![[Tip]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 응용 프로그램을 실행하는 방법에 따라 IntelliJ IDEA는 클래스 경로를 다르게 정렬합니다. 주 방법에서 IDE에서 응용 프로그램을 실행하면 Maven 또는 Gradle을 사용하거나 응용 프로그램을 실행할 때와 패키지 순서가 다릅니다. 이로 인해 스프링 부트가 클래스 경로에서 템플릿을 찾지 못하게 될 수 있습니다. 이 문제가 발생하면 IDE의 클래스 경로를 재정렬하여 모듈의 클래스와 리소스를 먼저 배치 할 수 있습니다. 또는 다음과 같이 classpath의 모든 `templates`디렉토리를 검색하도록 템플리트 접두사를 구성 할 수 있습니다. `classpath*:/templates/`. |

‌<br>

##### 29.1.11 Error Handling

**기본적으로 스프링 부트는 모든 오류를 적절한 방식으로 처리하는 /error** **매핑을 제공하며 서블릿 컨테이너에 "전역" 오류 페이지로 등록됩니다.** 시스템 클라이언트의 경우, 오류, HTTP 상태 및 예외 메시지와 함께 JSON 응답을 생성합니다. 브라우저 클라이언트의 경우 동일한 데이터를 HTML 형식으로 렌더링하는 "whitelabel" error view가 있습니다 (`error`를 해결하는 `View`추가). **기본 동작을 완전히 바꾸려면** **ErrorController 를 구현하고 해당 유형의 Bean 정의를 등록하거나** **ErrorAttributes 유형의 Bean을 추가하여 기존 메커니즘을 사용하지만 내용을 바꿉니다.** 

| ![[Tip]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| `BasicErrorController`는 사용자 정의 `ErrorController`의 기본 클래스로 사용할 수 있습니다. 이 기능은 새 내용 유형에 대한 처리기를 추가하려는 경우에 특히 유용합니다. 기본값은 `text/html`을 구체적으로 처리하고 다른 모든 항목에 대체 기능을 제공하는 것입니다. 이렇게 하려면 `BasicErrorController`를 확장하고 `produces`속성이있는 `@RequestMapping`이있는 공용 메서드를 추가 한 다음 새 유형의 Bean을 만듭니다. |

다음 예제와 같이 **@ControllerAdvice 로 주석 된 클래스를 정의하여 특정 컨트롤러 및 / 또는 예외 유형에 대해 반환 할 JSON 문서를 사용자 정의 할 수도 있습니다.** 



```java
@ControllerAdvice(basePackageClasses = AcmeController.class)
public class AcmeControllerAdvice extends ResponseEntityExceptionHandler {


	@ExceptionHandler(YourException.class)
	@ResponseBody
	ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
		HttpStatus status = getStatus(request);
		return new ResponseEntity<>(new CustomErrorType(status.value(), ex.getMessage()), status);
	}


	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.valueOf(statusCode);
	}


}
```

‌

앞의 예에서 **YourException이  AcmeController 와 동일한 패키지에 정의 된 컨트롤러에 의해 throw 된 경우** **CustomErrorType POJO의 JSON 표현이** **ErrorAttributes 표현 대신 사용됩니다.** 

 <br>

**사용자 정의 Error Pages**

‌<br>

**주어진 상태 코드에 대한 사용자 정의 HTML 오류 페이지를 표시하려면** **/error** **폴더에 파일을 추가하십시오.** 오류 페이지는 정적 HTML (정적 리소스 폴더 아래에 추가됨)이거나 템플릿을 사용하여 빌드 될 수 있습니다. 파일의 이름은 정확한 상태 코드 또는 시리즈 마스크 여야합니다. 

‌<br>

예를 들어 `404`를 정적 HTML 파일에 매핑하려면 폴더 구조가 다음과 같습니다. 



```
src/
 +- main/
     +- java/
     |   + <source code>
     +- resources/
         +- public/
             +- error/
             |   +- 404.html
             +- <other public assets>
```

‌

FreeMarker 템플릿을 사용하여 `5xx` 오류를 모두 매핑하려면 폴더 구조가 다음과 같습니다. 



```
src/
 +- main/
     +- java/
     |   + <source code>
     +- resources/
         +- templates/
             +- error/
             |   +- 5xx.ftl
             +- <other templates>
```

‌

**보다 복잡한 매핑의 경우 다음 예제와 같이** **ErrorViewResolver 인터페이스를 구현하는 bean을 추가 할 수도 있습니다.** 



```java
public class MyErrorViewResolver implements ErrorViewResolver {


	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request,
			HttpStatus status, Map<String, Object> model) {
		// Use the request or status to optionally return a ModelAndView
		return ...
	}


}
```

‌**또한** [**@ExceptionHandler** **methods**](https://docs.spring.io/spring/docs/5.1.7.RELEASE/spring-framework-reference/web.html#mvc-exceptionhandlers)**와** [**@ControllerAdvice**](https://docs.spring.io/spring/docs/5.1.7.RELEASE/spring-framework-reference/web.html#mvc-ann-controller-advice)**와 같은 일반적인 Spring MVC 기능을 사용할 수 있습니다.** 그런 다음 `ErrorController`는 처리되지 않은 예외를 선택합니다. 

 ‌<br>

**Spring MVC 외부의 에러 페이지 매핑**

<br>

**Spring MVC를 사용하지 않는 응용 프로그램의 경우** **ErrorPageRegistrar 인터페이스를 사용하여** **ErrorPages 를 직접 등록 할 수 있습니다.** 이 추상화는 기본 내장된 서블릿 컨테이너와 직접 작동하며 Spring MVC `DispatcherServlet`이 없어도 작동합니다. 

```java
@Bean
public ErrorPageRegistrar errorPageRegistrar(){
	return new MyErrorPageRegistrar();
}


// ...


private static class MyErrorPageRegistrar implements ErrorPageRegistrar {


	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		registry.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400"));
	}


}
```

| ![[Note]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| Jersey와 Wicket과 같은 일부 비 Spring 웹 프레임 워크에서 일반적인 것처럼 `Filter`에 의해 처리되는 경로로 `ErrorPage`를 등록하면 `Filter`는 다음과 같이 `ERROR`디스패처로 명시적으로 등록되어야합니다. |



```java
@Bean
public FilterRegistrationBean myFilter() {
	FilterRegistrationBean registration = new FilterRegistrationBean();
	registration.setFilter(new MyFilter());
	...
	registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
	return registration;
}
```

‌기본 `FilterRegistrationBean`에는 `ERROR`디스패처 유형이 포함되어 있지 않습니다. 

‌

주의 : 서블릿 컨테이너에 배포할 때 Spring Boot는 오류 페이지 필터를 사용하여 오류 상태의 요청을 해당 오류 페이지로 전달합니다. 응답이 아직 커밋되지 않은 경우에만 요청을 올바른 오류 페이지로 전달할 수 있습니다. 기본적으로 WebSphere Application Server 8.0 이상은 서블릿의 서비스 메소드 완료시 응답을 커밋합니다. `com.ibm.ws.webcontainer.invokeFlushAfterService`를 `false`로 설정하여이 작동을 사용 불가능하게해야합니다. 

 <br>

##### ‌29.1.12 Spring HATEOAS

**하이퍼 미디어를 사용하는 RESTful API를 개발하면 Spring Boot는 대부분의 애플리케이션에서 잘 작동하는 Spring HATEOAS의 자동 구성을 제공한다.** 자동 구성은 @EnableHypermediaSupport를 사용할 필요성을 대체하고 a`LinkDiscoverers`(클라이언트 측 지원) 및 응답을 원하는 표현으로 올바르게 마샬링하도록 구성된 `ObjectMapper`를 포함하여 하이퍼 미디어 기반 응용 프로그램을 쉽게 만들 수 있도록 여러 Bean을 등록합니다. `ObjectMapper`는 다양한 `spring.jackson.*`속성을 설정하거나, 존재하는 경우 `Jackson2ObjectMapperBuilder`bean을 설정하여 사용자 정의됩니다. 

‌<br>

**`@EnableHypermediaSupport` 를 사용하여 Spring HATOAS의 설정을 제어 할 수있다.** 이렇게 하면 앞에서 설명한 `ObjectMapper`사용자 정의가 사용 불가능하게됩니다. 

<br>

Spring HATEOAS는 @EnableHypermediaSupport 어노테이션을 사용하여 특정 하이퍼 미디어 표현 형식을 활성화 할 수 있습니다. 이 어노테이션은 HypermediaType enum을 인수로 취합니다. 현재는 HAL 만 지원됩니다.

> - HATEOAS (Hypermedia As The Engine Of Application State) 
>
>   - 원칙은 클라이언트가 응용 프로그램 서버에 의해 동적으로 제공되는 하이퍼 미디어를 통해 네트워크 응용 프로그램과 완전히 상호 작용한다는 것.
>
>    
>
> - HAL 
>
>   - 하이퍼텍스트 애플리케이션 언어 JSON 또는 XML 코드로 외부 리소스 연결 하이퍼미디어를 정의하는 표준안

![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgHylqVAhaDIj6HUSkz%2F-LgI8uu7_WVH848favGy%2Fimage.png?alt=media&token=509b7ed3-6ab9-4802-934e-c6090e98d0c8)

‌<br>

##### 29.1.13 CORS 지원

[Cross-origin resource sharing](https://en.wikipedia.org/wiki/Cross-origin_resource_sharing) (CORS)는 [most browsers](https://caniuse.com/#feat=cors)에서 구현되는 [W3C specification](https://www.w3.org/TR/cors/)으로, IFRAME 또는 JSONP와 같이 덜 안전하고 덜 강력한 방법을 사용하는 대신 어떤 유형의 상호 도메인 요청이 유연하게 지정되도록 지정할 수 있습니다. 

<br>

**버전 4.2부터는 Spring MVC가 CORS를 지원합니다.** 컨트롤러 메소드 사용하기 Spring Boot 애플리케이션에서 [**@CrossOrigin**](https://docs.spring.io/spring/docs/5.1.7.RELEASE/javadoc-api/org/springframework/web/bind/annotation/CrossOrigin.html) **어노테이션이 있는** [**controller method CORS configuration**](https://docs.spring.io/spring/docs/5.1.7.RELEASE/spring-framework-reference/web.html#controller-method-cors-configuration)**에는 특정 구성이 필요하지 않습니다.** [**Global CORS configuration**](https://docs.spring.io/spring/docs/5.1.7.RELEASE/spring-framework-reference/web.html#global-cors-configuration)**은 다음 예제와 같이** **WebMvcConfigurer****bean을 사용자 정의된** **addCorsMappings(CorsRegistry)** **메소드로 등록하여 정의 할 수 있습니다.** 

> CORS(Cross-origin resource sharing)
>
> - 웹 페이지의 제한된 자원을 외부 도메인에서 접근을 허용해주는 메커니즘

> 스프링 RESTful Service에서 CORS를 설정은 @CrossOrigin 어노테이션을 사용하여 간단히 해결 할 수 있다. RestController를 사용한 클래스 자체에 적용할 수 도 있고, 특정 REST API method에도 설정 가능하다. 또한, 특정 도메인만 접속을 허용할 수도 있다.
>
> 1) @CrossOrigin 어노테이션을 통해 적용하는 방식
>
> - @CrossOrigin(origins = “허용주소:포트”)

<br>

![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgHylqVAhaDIj6HUSkz%2F-LgIARVvLtzYXbgkAAAd%2Fimage.png?alt=media&token=2c01cd96-741e-4fd7-84f2-2e7bd9ffede5)

> 2) WebMvcConfigurer를 통해 적용하는 방식

![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgHylqVAhaDIj6HUSkz%2F-LgIAzauDi-2Wcz85ykv%2Fimage.png?alt=media&token=81dc78af-0ac3-46e1-97e5-307db6a7c207)

```java
@Configuration
public class MyConfiguration {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**");
			}
		};
	}
}
```

<br>

<br>

#### 29.2 The “Spring WebFlux Framework”

**Spring WebFlux는 Spring Framework 5.0에서 소개된 새로운 사후 대응 웹 프레임 워크입니다.** Spring MVC와 달리 **서블릿 API를 필요로하지 않으며**, 완전히 **비동기적**이고 **비 블로킹**이며, [the Reactor project](https://projectreactor.io/)를 통해 [Reactive Streams](https://www.reactive-streams.org/) 사양을 구현합니다.

> 스프링 5부터 spring-wewbflux 등장.
>
> spring-webflux 와 spring-mvc 중 어느 것을 사용 할 지 결정하려면? 
>
> - non-blocking I/O가 어떻게 동작하며, 어떠한 효과를볼 수 있는 지 배워야한다
>
>  
>
> 프레임워크를 고르는 기준 중 하나! 
>
> - **의존성을 확인하는 것**
>   - 블로킹 방식의 persistence API(JPA, JDBC)나 network API를 사용한다면 spring-mvc가 적합
>   - Spring MVC 어플리케이션에 원격 서비스를 호출하는 일이 있다면, Reactive WebClient를 사용하는 것을 권장한다. 스프링 MVC 컨트롤러 메서드에서 Reactive 타입(Reactor, RxJava 등)을 직접 반환 가능. 호출 당 지연이 길수록, 호출 간 상호 의존이 클수록, 더 큰 이득을 볼 수 있음

<br>

**Spring WebFlux에는 기능적인 & 어노테이션 기반의 두 가지가 있습니다.** 

> Spring-web 모듈은 스프링 웹플럭스의 기초가 되는 리액티브 기반을 포함한다.
>
>  
>
> 스프링 웹 플럭스에서 제공하는 프로그래밍 모델? 
>
> 1) 웹 플럭스 컨트롤러 (어노테이션 기반) 
>
> 스프링 MVC와 일치(spring-web 모듈과 동일한 어노테이션 기반 컨트롤러) 
>
> 스프링 MVC와 WebFlux 컨트롤러는 반환 타입으로 리액티브(Reactor, RX java)를 지원 
>
> 스프링 MVC와 WebFlux 구별 어려움
>
>  
>
> 2) 웹 플럿프 fn 
>
> 가볍고, Java 8의 람다 기반의 함수형 프로그래밍 모델. 
>
> 라우팅과 Request 처리를 할 수 있는 작은 라이브러리 또는 유틸리티의 셋.

<br>

어노테이션 기반은 다음 예제와 같이 Spring MVC 모델에 매우 가깝습니다.

> Mono는 0-1개의 결과만을 처리하기 위한 Reactor의 객체이고, Flux는 0-N개인 여러 개의 결과를 처리하는 객체임.

<br>

```java
@RestController
@RequestMapping("/users")
public class MyRestController {


	@GetMapping("/{user}")
	public Mono<User> getUser(@PathVariable Long user) {
		// ...
	}


	@GetMapping("/{user}/customers")
	public Flux<Customer> getUserCustomers(@PathVariable Long user) {
		// ...
	}


	@DeleteMapping("/{user}")
	public Mono<User> deleteUser(@PathVariable Long user) {
		// ...
	}


}
```

‌

기능 변형인 "WebFlux.fn"은 다음 예와 같이 라우팅 구성을 실제 요청 처리와 분리합니다.

<br>

```java
@Configuration
public class RoutingConfiguration {


	@Bean
	public RouterFunction<ServerResponse> monoRouterFunction(UserHandler userHandler) {
		return route(GET("/{user}").and(accept(APPLICATION_JSON)), userHandler::getUser)
				.andRoute(GET("/{user}/customers").and(accept(APPLICATION_JSON)), userHandler::getUserCustomers)
				.andRoute(DELETE("/{user}").and(accept(APPLICATION_JSON)), userHandler::deleteUser);
	}


}


@Component
public class UserHandler {


	public Mono<ServerResponse> getUser(ServerRequest request) {
		// ...
	}


	public Mono<ServerResponse> getUserCustomers(ServerRequest request) {
		// ...
	}


	public Mono<ServerResponse> deleteUser(ServerRequest request) {
		// ...
	}
}
```

‌

WebFlux는 Spring Framework의 일부이며 자세한 정보는 [reference documentation](https://docs.spring.io/spring/docs/5.1.7.RELEASE/spring-framework-reference/web-reactive.html#webflux-fn)에서 확인할 수 있습니다. 

| ![[Tip]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 라우터 정의를 모듈화 할 때 원하는 만큼의 `RouterFunction`Bean을 정의 할 수 있습니다. 우선 순위를 적용해야 할 경우 bean에 순서를 매길 수 있습니다. |

‌<br>

**시작하려면 응용 프로그램에** **spring-boot-starter-webflux** **모듈을 추가하십시오.**

| ![[Note]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| **응용 프로그램에서** **spring-boot-starter-web 과** **spring-boot-starter-webflux** **모듈을 모두 추가하면 SpringBoot은 WebFlux가 아닌 Spring MVC를 자동 구성합니다.** 이 동작은 많은 Spring 개발자가 반응적인 `WebClient`를 사용하기 위해 Spring-MVC 애플리케이션에 `spring-boot-starter-webflux`를 추가하기 때문에 선택되었습니다. **선택한 응용 프로그램 유형을** **SpringApplication.setWebApplicationType(WebApplicationType.REACTIVE) 으로 설정하여 선택 사항을 적용 할 수 있습니다.** |

<br>

##### 29.2.1 Spring WebFlux 자동 구성 

‌

**Spring Boot는 대부분의 응용 프로그램에서 잘 작동하는 Spring WebFlux의 자동 구성 기능을 제공합니다.** 

‌<BR>

자동 설정은 Spring의 기본값 위에 다음과 같은 기능을 추가합니다.‌

- **HttpMessageReader 및** **HttpMessageWriter 인스턴스 용 코덱 구성 (이 문서의 뒷부분에서 설명 함)** 
- **WebJars에 대한 지원을 포함하여 정적 리소스 제공 지원 (이 문서의 뒷부분에서 설명)** 

‌<BR>

**Spring Boot WebFlux 기능을 유지하면서** [**WebFlux configuration**](https://docs.spring.io/spring/docs/5.1.7.RELEASE/spring-framework-reference/web.html#web-reactive)**을 추가하려는 경우** @EnableWebFlux가 아닌 **WebFluxConfigurer 형식의** **@Configuration** **클래스를 추가 할 수 있습니다.** 

‌<br>

**Spring WebFlux를 완벽하게 제어하려면** **@EnableWebFlux 로 주석이 달린** **@Configuration 을 추가하면됩니다.** 

 <br>

##### 29.2.2 HTTP Codecs with HttpMessageReaders and HttpMessageWriters

‌

Spring WebFlux는 **HTTP 요청과 응답을 변환하기 위해** **`HttpMessageReader` 와 `HttpMessageWriter`** **인터페이스를 사용한다. 클래스 경로에서 사용할 수 있는 라이브러리를 보고 합리적인 기본값을 갖도록** **`CodecConfigurer` 로 구성됩니다.**

‌<br>

Spring Boot는 `CodecCustomizer`인스턴스를 사용하여 추가 사용자 정의를 적용합니다. 예를 들어, `spring.jackson.*`구성 키는 Jackson 코덱에 적용됩니다. 

‌<br>

**코덱을 추가하거나 사용자 정의해야하는 경우 다음 예제와 같이 사용자 정의** **`CodecCustomizer`구성 요소를 만들 수 있습니다.** 

<br>

```java
import org.springframework.boot.web.codec.CodecCustomizer;


@Configuration
public class MyConfiguration {


	@Bean
	public CodecCustomizer myCodecCustomizer() {
		return codecConfigurer -> {
			// ...
		}
	}


}
```

[Boot’s custom JSON serializers and deserializers](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-json-components)를 활용할 수도 있습니다. 

<br>

##### 29.2.3 정적 콘텐츠

**기본적으로 스프링 부트는 classpath에있는** **/static** **(또는** **/public** **또는 /resources 또는 /META-INF/resources) 디렉토리의 정적 컨텐츠를 제공합니다. Spring WebFlux의 ResourceWebHandler 를 사용하므로WebFluxConfigurer 를 추가하고 addResourceHandlers 메소드를 재정 의하여 해당 동작을 수정할 수 있습니다.** 

‌<br>

**기본적으로 리소스는** /\****에 매핑되지만** **spring.webflux.static-path-pattern** **속성을 설정하여 조정할 수 있습니다.** 예를 들어, 모든 리소스를 `/resources/**` 로 재배치하는 것은 다음과 같이 수행 할 수 있습니다. 

```properties
spring.webflux.static-path-pattern=/resources/**
```

‌<Br>

**spring.resources.static-locations****를 사용하여 정적 자원 위치를 사용자 정의 할 수도 있습니다.** 이렇게하면 기본값이 디렉토리 위치 목록으로 바뀝니다. 이렇게하면 기본 시작 페이지 검색이 사용자 지정 위치로 전환됩니다. 따라서 시작시 임의의 위치에 `index.html`이 있으면 응용 프로그램의 홈 페이지입니다. 

<br>

앞에서 설명한 "표준"정적 리소스 위치 외에도 [Webjars content](https://www.webjars.org/)에 특별한 경우가 있습니다. `/webjars/**`에 경로가있는 자원은 Webjars 형식으로 패키지 된 경우 jar 파일에서 제공됩니다.

| ![[Tip]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| **Spring WebFlux 응용 프로그램은 Servlet API에 엄격하게 의존하지 않으므로 war 파일로 배포 할 수 없으며** **src/main/webapp directory를 사용하지 않습니다.** |

### <br>

##### 29.2.4 템플릿 엔진 

REST 웹 서비스뿐만 아니라 Spring WebFlux를 사용하여 동적 HTML 컨텐트를 제공 할 수도 있습니다. **Spring WebFlux는 Thymeleaf, FreeMarker 및 Mustache를 포함한 다양한 템플릿 기술을 지원합니다.** 

‌<br>

Spring Boot는 다음 템플릿 엔진에 대한 자동 구성 지원을 포함합니다.

‌

- [FreeMarker](https://freemarker.apache.org/docs/)
- [Thymeleaf](https://www.thymeleaf.org/)
- [Mustache](https://mustache.github.io/)

‌

**이 템플릿 엔진 중 하나를 기본 구성으로 사용하면 템플릿이** **src/main/resources/templates 에서 자동으로 선택됩니다.** 

 <br>

##### 29.2.5 Error Handling

‌

**스프링 부트 (Spring Boot)는 합리적인 방법으로 모든 오류를 처리하는** **WebExceptionHandler****를 제공합니다.** 처리 순서에서의 위치는 WebFlux가 제공한 핸들러 바로 직전이며 마지막으로 간주됩니다. 시스템 클라이언트의 경우, 오류, HTTP 상태 및 예외 메시지와 함께 JSON 응답을 생성합니다. 브라우저 클라이언트의 경우 동일한 데이터를 HTML 형식으로 렌더링하는 "whitelabel" 오류 핸들러가 있습니다. 오류를 표시하기 위해 자체 HTML 템플리트를 제공 할 수도 있습니다 ([next section](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-webflux-error-handling-custom-error-pages) 참조). 

‌<br>

이 기능을 사용자 지정하는 첫 번째 단계는 기존 메커니즘을 사용하지만 오류 내용을 대체하거나 보완하는 것입니다. 이를 위해`ErrorAttributes` 타입의 빈을 추가 할 수 있습니다. 

‌<br>

오류 처리 동작을 변경하려면 **`ErrorWebExceptionHandler`를 구현하고 해당 유형의 Bean 정의를 등록 할 수 있습니다.** `WebExceptionHandler`는 꽤 낮은 수준이기 때문에 **Spring Boot는 다음 예제와 같이 WebFlux 기능적 방식으로 오류를 처리 할 수있는 편리한** **AbstractErrorWebExceptionHandler 도 제공합니다.** 



```java
public class CustomErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {


	// Define constructor here


	@Override
	protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {


		return RouterFunctions
				.route(aPredicate, aHandler)
				.andRoute(anotherPredicate, anotherHandler);
	}


}
```

‌

보다 완벽한 그림을 보기 위해 `DefaultErrorWebExceptionHandler`를 직접 서브 클래스 화하고 특정 메소드를 대체 할 수 있습니다.

 <br>

‌

**사용자 정의 에러 페이지**

‌<br>

**주어진 상태 코드에 대한 사용자 정의 HTML 오류 페이지를 표시하려면** **/error 폴더에 파일을 추가하십시오.** 오류 페이지는 정적 HTML (정적 리소스 폴더 아래에 추가됨)이거나 템플릿으로 빌드 될 수 있습니다. 파일의 이름은 정확한 상태 코드 또는 시리즈 마스크 여야합니다.

‌<br>

예를 들어 `404`를 정적 HTML 파일에 매핑하려면 폴더 구조가 다음과 같습니다.



```
src/
 +- main/
     +- java/
     |   + <source code>
     +- resources/
         +- public/
             +- error/
             |   +- 404.html
             +- <other public assets>
```

‌

Mustache 템플릿을 사용하여 `5xx`오류를 모두 매핑하려면 폴더 구조가 다음과 같습니다. 



```
src/
 +- main/
     +- java/
     |   + <source code>
     +- resources/
         +- templates/
             +- error/
             |   +- 5xx.mustache
             +- <other templates>
```

###  <br>

##### 29.2.6 Web Filters

‌

**Spring WebFlux는 HTTP 요청 - 응답 교환을 필터링하기 위해 구현할 수있는** **WebFilter 인터페이스를 제공합니다.** 응용 프로그램 컨텍스트에서 발견 된 `WebFilter`bean은 자동으로 각 교환을-필터링하는 데 사용됩니다. 



![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgIBroWhprYDFYdDhlp%2F-LgIVPhqXi5cjYjnu0Wy%2Fimage.png?alt=media&token=b39895c6-af3e-4872-b12d-bb7fe2f2780c)



‌<Br>

필터의 순서가 중요 할 경우 `Ordered`를 구현하거나 `@Order`로 주석을 달 수 있습니다. 스프링 부트 자동 구성은 웹 필터를 구성 할 수 있습니다. 그렇게하면 다음 표에 표시된 Order가 사용됩니다. 

| Web Filter                              | Order                            |
| --------------------------------------- | -------------------------------- |
| `MetricsWebFilter`                      | `Ordered.HIGHEST_PRECEDENCE + 1` |
| `WebFilterChainProxy` (Spring Security) | `-100`                           |
| `HttpTraceWebFilter`                    | `Ordered.LOWEST_PRECEDENCE - 10` |

<br>

#### 29.3 JAX-RS and Jersey

**REST 엔드 포인트 용 JAX-RS 프로그래밍 모델을 선호한다면** Spring MVC 대신 사용 가능한 구현 중 하나를 사용할 수있다. [Jersey](https://jersey.github.io/) 와 [Apache CXF](https://cxf.apache.org/)work는 매우 잘 어울립니다. CXF를 사용하려면 응용 프로그램 컨텍스트에서 `@Bean`으로 `Servlet`또는 `Filter`를 등록해야합니다. **Jersey에는 기본 Spring 지원이 있으므로 Spring Boot에서 자동 구성 지원을 시작과 함께 제공**합니다. 



> Jersey 
>
> Sun의 311에서 구현된 JAX-RS: RESTful 웹 서비스용 Java API 
>
> - JAVA SE5에 소개된 어노테이션을 사용하여 정의된 사양 (대표적인 어노테이션으로 @Path, @GET, @POST, @PUT)
>
>  
>
> JSR-311에서 정의된 내용을 가지고 있기 때문에 개발자는 java 및 java JVM으로 Restful 웹 서비스를 쉽게 작성할 수 있음. 
>
> JSR에서 지정하지 않은 추가 기능도 지원

‌

**Jersey를 시작하려면** **spring-boot-starter-jersey를 종속성으로 포함**시킨 다음, 다음 예와 같이 **모든 끝점을 등록하는** **ResourceConfig 유형의** **@Bean 이 하나 필요합니다. **



```java
@Component
public class JerseyConfig extends ResourceConfig {


	public JerseyConfig() {
		register(Endpoint.class);
	}


}
```

| ![[Warning]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/warning.png) |
| ------------------------------------------------------------ |
| Jersey는 실행 가능한 아카이브 검사에 대한 지원을 제한합니다. 예를 들어, 실행 가능 war 파일을 실행할 때 `WEB-INF/classes`에있는 [fully executable jar file](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#deployment-install)에있는 패키지의 엔드 포인트를 스캔 할 수 없습니다. 이 제한을 피하려면 패키지 메소드를 사용하면 안되며, 앞의 예제와 같이 `register`메소드를 사용하여 엔드 포인트를 개별적으로 등록해야합니다. |

‌<br>

고급 사용자 정의를 위해 `ResourceConfigCustomizer`를 구현하는 임의의 수의 Bean을 등록 할 수도 있습니다. 

‌<br>

다음 예와 같이 **등록된 모든 엔드 포인트는 HTTP 자원 주석 (`@GET` 및 기타)이있는 `@Components` 여야합니다.** 



```java
@Component
@Path("/hello")
public class Endpoint {


	@GET
	public String message() {
		return "Hello";
	}


}
```

‌

**`Endpoint` 는 Spring `@Component`이므로 Spring의 라이프 사이클을 관리하고 @Autowired 주석을 사용하여 종속성을 주입하고** **@Value** **주석을 사용하여 외부 구성을 주입 할 수 있습니다. 기본적으로 Jersey 서블릿은 등록되고 /\*에 매핑됩니다.** `ResourceConfig`에 `@ApplicationPath`를 추가하여 매핑을 변경할 수 있습니다. 

‌

기본적으로 Jersey는 `jerseyServletRegistration`이라는 `jerseyServletRegistration`유형의 @Bean에 서블릿으로 설정됩니다. 기본적으로 서블릿은 느리게 초기화되지만 `spring.jersey.servlet.load-on-startup`을 설정하여 해당 동작을 사용자 정의 할 수 있습니다. 동일한 이름으로 고유 한 bean을 작성하여 해당 bean을 사용 불가능하게하거나 대체 할 수 있습니다. `spring.jersey.type=filter`를 설정하여 서블릿 대신 필터를 사용할 수도 있습니다 (이 경우 교체하거나 무시할 `@Bean`은 `jerseyFilterRegistration`입니다). 필터에는 `@Order`가 있으며 `spring.jersey.filter.order`를 사용하여 설정할 수 있습니다. 서블릿과 필터 등록 모두에 `spring.jersey.init.*`를 사용하여 속성의 맵을 지정하여 초기화 매개 변수를 제공 할 수 있습니다. 

‌

[Jersey sample](https://github.com/spring-projects/spring-boot/tree/v2.1.5.RELEASE/spring-boot-samples/spring-boot-sample-jersey)이 있으므로 설정 방법을 볼 수 있습니다. 

<br>

#### 29.4 내장된 서블릿 컨테이너 지원

**Spring Boot는 임베디드** [**Tomcat**](https://tomcat.apache.org/)**,** [**Jetty**](https://www.eclipse.org/jetty/) **및** [**Undertow**](https://github.com/undertow-io/undertow) **서버를 지원합니다.** 대부분의 개발자는 적절한 "Starter"를 사용하여 완전히 구성된 인스턴스를 얻습니다. **기본적으로 내장 서버는 포트** **8080****에서 HTTP 요청을 수신합니다.** 

‌<br>

##### 29.4.1 Servlets, Filters, and listeners

임베디드 서블릿 컨테이너를 사용할 때 스프링 빈을 사용하거나 서블릿 컴포넌트를 검색하여 서블릿, 필터 및 모든 리스너 (예 : `HttpSessionListener`)를 Servlet 스펙에서 등록 할 수 있습니다.

‌<br>

**Registering Servlets, Filters, and Listeners as Spring Beans**

‌<br>

**모든 `Servlet`,`Filter` 또는 Spring bean 인 서블릿 `*Listener` 인스턴스는 포함 된 컨테이너에 등록됩니다.** 구성 중에 `application.properties`의 값을 참조하려는 경우 특히 유용 할 수 있습니다. 

‌<br>

기본적으로 컨텍스트가 하나의 서블릿 만 포함하면 `/`에 매핑됩니다. 여러 서블릿 빈의 경우, 빈 이름이 경로 접두어로 사용됩니다. 필터는`/*`에 매핑됩니다. 

‌<Br>

**컨벤션 기반 매핑이 충분히 유연하지 않으면** **`ServletRegistrationBean`, `FilterRegistrationBean` 및`ServletListenerRegistrationBean`클래스를 사용하여 완벽한 제어가 가능합니다.**

> 스프링부트에서는 web.xml 이 더 이상 사용되지 않아 서블릿이나 필터를 org.springframework.boot.web.servlet 의 RegistrationBean 을 통해 등록해야합니다.
>
> 필터와 달리 서블릿 등록은 특별한 경우가 아니면 추천하지 않는 방법이래!



![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LgIXpnmH8csiz5_48gN%2F-LgI_VFeFVtwCWuIeIkz%2Fimage.png?alt=media&token=39b15021-eb12-44dc-bef4-ef0ee540f5ee)

<br>

Spring Boot는 Filter 빈을 정의 할 수있는 많은 자동 설정을 제공한다. 다음은 필터 및 각 광고 주문의 몇 가지 예입니다 (낮은 값은 우선 순위가 높음을 나타냄). 

| Servlet Filter                   | Order                            |
| -------------------------------- | -------------------------------- |
| `OrderedCharacterEncodingFilter` | `Ordered.HIGHEST_PRECEDENCE`     |
| `WebMvcMetricsFilter`            | `Ordered.HIGHEST_PRECEDENCE + 1` |
| `ErrorPageFilter`                | `Ordered.HIGHEST_PRECEDENCE + 1` |
| `HttpTraceFilter`                | `Ordered.LOWEST_PRECEDENCE - 10` |

‌

일반적으로 Filter Bean은 정렬되지 않은 상태로 두는 것이 안전합니다. 

‌<Br>

특정 순서가 필요한 경우 `Ordered.HIGHEST_PRECEDENCE`에서 요청 본문을 읽는 필터를 구성하지 마십시오. 응용 프로그램의 문자 인코딩 구성에 맞지 않을 수 있습니다. 서블릿 필터가 요청을 래핑하는 경우, 요청은 `OrderedFilter.REQUEST_WRAPPER_FILTER_MAX_ORDER`보다 작거나 같은 순서로 구성되어야합니다.



<br>

##### **29.4.2 서블릿 컨텍스트 초기화**‌

임베디드 서블릿 컨테이너는 Servlet 3.0+ `javax.servlet.ServletContainerInitializer` 인터페이스 또는 스프링의 `org.springframework.web.WebApplicationInitializer` 인터페이스를 직접 실행하지 않습니다. 이는 전쟁 중에 실행되도록 설계된 타사 라이브러리가 Spring Boot 응용 프로그램을 손상시킬 수있는 위험을 줄이기위한 의도적인 설계 결정입니다. 

‌<br>

**Spring 부트 애플리케이션에서 서블릿 컨텍스트 초기화를 수행해야한다면,** **`org.springframework.boot.web.servlet.ServletContextInitializer`** **인터페이스를 구현하는 빈을 등록해야한다.** 단일 `onStartup`메소드는 `ServletContext`에 대한 액세스를 제공하며, 필요한 경우 기존 `WebApplicationInitializer`에 대한 어댑터로 쉽게 사용할 수 있습니다. 

<br>

**Scanning for Servlets, Filters, and listeners**

‌<br>

포함 된 컨테이너를 사용할 때 **`@WebServlet`,`@WebFilter` 및 `@WebListener`로 주석 된 클래스의 자동 등록은** **`@ServletComponentScan`**을 사용하여 활성화 할 수 있습니다. 

| ![[Tip]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| `@ServletComponentScan`은 컨테이너의 내장 검색 메커니즘이 대신 사용되는 독립형 컨테이너에는 아무런 영향을 미치지 않습니다. |

‌<Br>

##### **29.4.3 The ServletWebServerApplicationContext**

‌

내부적으로 스프링 부트는 임베디드 서블릿 컨테이너 지원을 위해 다른 유형의 `ApplicationContext`를 사용합니다. `ServletWebServerApplicationContext`는 단일 `ServletWebServerFactory`빈을 검색하여 자체 부트 스트랩하는 특수 유형의 `WebApplicationContext`입니다. 보통 **TomcatServletWebServerFactory**, **JettyServletWebServerFactory**또는 **UndertowServletWebServerFactory**가 자동으로 구성되었습니다. 

| ![[Note]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| 대개 이러한 구현 클래스를 인식 할 필요는 없습니다. 대부분의 응용 프로그램은 자동으로 구성되며 사용자를 대신하여 적절한 `ApplicationContext`및 `ServletWebServerFactory`가 만들어집니다. |

<br>

##### **29.4.4 내장형 서블릿 컨테이너 사용자 정의**

**공통 서블릿 컨테이너 설정은 Spring** **Environment 등록 정보를 사용하여 구성 할 수 있습니다. 일반적으로** **application.properties** **파일에서 속성을 정의합니다.** 

‌<br>

일반적인 서버 설정에는 다음이 포함됩니다. 

‌

- 네트워크 설정 : 들어오는 HTTP 요청 (`server.port`), `server.address`에 바인드 할 인터페이스 주소 등을 수신합니다. 
- 세션 설정 : 세션이 지속적인지 여부 (`server.servlet.session.persistence`), 세션 시간 초과 (`server.servlet.session.timeout`), 세션 데이터 위치 (`server.servlet.session.store-dir`) 및 세션 쿠키 구성 (`server.servlet.session.cookie.*`). 
- 오류 관리 : 오류 페이지의 위치 (`server.error.path`). 
- [SSL](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-configure-ssl)
- [HTTP compression](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#how-to-enable-http-response-compression)

<br>

스프링 부트 (Spring Boot)는 가능한 한 공통 설정을 노출하려고 시도하지만, 항상 가능하지는 않습니다. 이 경우, 전용 네임 스페이스는 서버 별 사용자 정의를 제공합니다 (`server.tomcat` 및 `server.undertow` 참조). 예를 들어 [access logs](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-configure-accesslogs)는 임베디드 서블릿 컨테이너의 특정 기능으로 구성 될 수 있습니다. 

| ![[Tip]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
| ------------------------------------------------------------ |
| 전체 목록은 [`ServerProperties`](https://github.com/spring-projects/spring-boot/tree/v2.1.5.RELEASE/spring-boot-project/spring-boot-autoconfigure/src/main/java/org/springframework/boot/autoconfigure/web/ServerProperties.java) 클래스를 참조하십시오. |

‌<br>

**프로그래밍 방식의 사용자 정의**

‌<Br>

**임베디드 서블릿 컨테이너를 프로그래밍 방식으로 구성해야하는 경우** **WebServerFactoryCustomizer 인터페이스를 구현하는 Spring bean을 등록 할 수 있습니다.** `WebServerFactoryCustomizer`는 **수많은 사용자 정의 설정 메소드를 포함하는** **ConfigurableServletWebServerFactory 에 대한 액세스를 제공합니다.** 다음 예제에서는 프로그래밍 방식으로 포트를 설정하는 방법을 보여줍니다. 



```java
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomizationBean implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

	@Override
	public void customize(ConfigurableServletWebServerFactory server) {
		server.setPort(9000);
	}

}
```

| ![[Note]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png) |
| ------------------------------------------------------------ |
| `TomcatServletWebServerFactory`, `JettyServletWebServerFactory`및 `UndertowServletWebServerFactory`는 Tomcat, Jetty 및 Undertow에 대한 추가 사용자 정의 설정 메소드가있는 `ConfigurableServletWebServerFactory`전용 변형입니다. |

‌

**ConfigurableServletWebServerFactory의 직접 사용자 정의** 

‌

**이전의 사용자 정의 기술이 너무 제한적인 경우에는 `TomcatServletWebServerFactory`,`JettyServletWebServerFactory`또는 or `UndertowServletWebServerFactory` 빈을 직접 등록 할 수 있습니다.**



```java
@Bean
public ConfigurableServletWebServerFactory webServerFactory() {
	TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
	factory.setPort(9000);
	factory.setSessionTimeout(10, TimeUnit.MINUTES);
	factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
	return factory;
}
```

‌

Setter는 많은 구성 옵션에 대해 제공됩니다. 좀 더 이국적인 것을해야 할 때 몇 가지 보호 된 방법 "hooks"도 제공됩니다. 자세한 내용은 [source code documentation](https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/api/org/springframework/boot/web/servlet/server/ConfigurableServletWebServerFactory.html)를 참조하십시오.

<br>

##### **29.4.5 JSP 제한사항** 

‌

임베디드 서블릿 컨테이너를 사용하는 (그리고 실행 가능한 아카이브로 패키지 된) Spring Boot 애플리케이션을 실행할 때, JSP 지원에는 몇 가지 제한이 있습니다. 

‌<br>

- Jetty와 Tomcat에서는 war 패키징을 사용하면 작동합니다. 실행 가능한 war은 `java -jar`로 시작될 때 작동하며 모든 표준 컨테이너에도 배포 할 수 있습니다. JSP는 실행 가능한 jar를 사용할 때 지원되지 않습니다.
- Undertow는 JSP를 지원하지 않습니다.
- 사용자 정의 `error.jsp` 페이지를 작성해도 [error handling](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-error-handling)를 위한 기본 뷰가 대체되지 않습니다. 대신 [Custom error pages](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-error-handling-custom-error-pages)를 사용해야합니다. 

‌

설정하는 방법을 볼 수있는 [JSP sample](https://github.com/spring-projects/spring-boot/tree/v2.1.5.RELEASE/spring-boot-samples/spring-boot-sample-web-jsp)이 있습니다. 



<br>

#### 29.5 내장된 반응형 서버 지원

**Spring Boot는 Reactor Netty, Tomcat, Jetty 및 Undertow와 같은 임베디드 대응 웹 서버를 지원합니다.** 대부분의 개발자는 적절한 "Starter"를 사용하여 완전히 구성된 인스턴스를 얻습니다. **기본적으로 내장 서버는 포트 8080에서 HTTP 요청을 수신합니다.** 



<br>

#### 29.6 반응형 서버 리소스 구성

**Reactor Netty 또는 Jetty 서버를 자동 구성 할 때 Spring Boot는 서버 인스턴스에 HTTP 자원을 제공하는 특정 Bean을 작성합니다 (`ReactorResourceFactory`또는 `JettyResourceFactory`).** 

‌<br>

기본적으로 이러한 리소스는 Reactor Netty 및 Jetty 클라이언트와 공유되어 최적의 성능을 제공합니다. 

- 동일한 기술이 서버 및 클라이언트에 사용됩니다.
- 클라이언트 인스턴스는 스프링 부트에 의해 자동 구성 된 `WebClient.Builder` 빈을 사용하여 빌드됩니다.

‌<br>

개발자는 사용자 정의 `ReactorResourceFactory`또는 `JettyResourceFactory`빈을 제공하여 Jetty 및 Reactor Netty의 자원 구성을 대체 할 수 있습니다. 이는 클라이언트와 서버 모두에 적용됩니다. 

‌<br>

[WebClient Runtime section](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-webclient-runtime)에서 클라이언트 측의 리소스 구성에 대해 자세히 배울 수 있습니다. 

<br>