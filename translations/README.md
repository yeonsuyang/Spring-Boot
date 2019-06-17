#  Spring Boot 2.1.5 레퍼런스 번역해보기

[TOC]

## Spring Boot 의 소개 



### 8.Spring Boot의 소개 

Spring Boot를 사용하면 실행할 수있는 독립 실행형 프로덕션 급 Spring 기반 응용 프로그램을 쉽게 만들 수 있습니다. 우리는 Spring 플랫폼 및 써드 파티 라이브러리에 대한 의견을 수렴하여 최소한의 소동으로 시작할 수 있습니다. 대부분의 Spring Boot 응용 프로그램은 Spring 구성이 거의 필요하지 않습니다.



`java -jar` 로 실행하는 Spring boot 를 사용하거나 전통적인 war 파일 배포 방식을 통해 Java 응용 프로그램을 만들 수 있습니다 . 또한 "spring scripts"를 실행하는 명령 줄 도구도 제공합니다.



우리의 주요 목표는 다음과 같습니다.



- 모든 Spring 개발을 위해 급격히 빠르고 광범위하게 접근 할 수있는 시작 경험을 제공하십시오.
- 상자 밖에서 의견을 말하되 요구 사항이 기본값에서 벗어나기 시작하면 빨리 벗어나십시오.(여기서 상자가 프레임에 갇혀있다의 느낌인듯)
- 임베디드 서버, 보안, 메트릭, 상태 확인 및 외부화 된 구성과 같은 대규모 프로젝트 클래스에 공통적 인 다양한 비 기능적인 기능(non-functional function)을 제공합니다.
- 절대 코드 생성이없고 XML 구성에 대한 요구 사항이 없습니다.



## Spring Boot의 기능

### 23. Spring Aplication by ys



이 섹션에서는 스프링 부트에 대해 자세히 설명합니다. 여기에서 사용하고 사용자 지정할 수있는 주요 기능에 대해 배울 수 있습니다. 아직 그렇게하지 않았다면 " [제 2 부,시작하기](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started)" 및 "[제 3 부, 스프링 부트 사용하기](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot) "단원 을 읽고 기본적인 기초 지식을 얻을 수 있습니다.

이 SpringApplication클래스는** **main()****메소드에서 시작되는** Spring 애플리케이션을 부트스트랩하는 편리한 방법을 제공한다 . 다음 예제와 같이 많은 경우에 정적 **SpringApplication.run****메서드에 위임 할 수 있습니다 .**

```java
public  static  void main (String [] args) {
	SpringApplication.run (MySpringConfiguration. class , args);
}
```



> 부트스트랩(bootstrap) 또는 부트스트래핑은 "현재 상황에서 어떻게든 한다"는 뜻이다. 또, 사물의 초기 단계에서 단순 요소로부터 복잡한 체계를 구축하는 과정을 가리키는 경우도 있다.



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

응용 프로그램이 시작되지 않으면 **등록된** **FailureAnalyzers** **가 전용 오류 메시지와 문제를 해결 하기위한 구체적인 조치를 제공할 수 있습니다**. 예를 들어 포트 `8080`에서 웹 응용 프로그램을 시작하고 해당 포트가 이미 사용 중이면 다음 메시지와 비슷한 내용을 볼 수 있습니다.

```
***************************
APPLICATION FAILED TO START
***************************

Description:
Embedded servlet container failed to start. Port 8080 was already in use.

Action:
Identify and stop the process that's listening on port 8080 or configure this application to listen on another port.
```



![[Note]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png)

Spring Boot는 다양한 `FailureAnalyzer`구현을 제공하며 , [사용자가 직접 추가](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-failure-analyzer) 할 수 [있습니다](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-failure-analyzer) .



**failure analyzers 가 예외를 처리 할 수없는 경우에**도 전체 조건 보고서를 표시하여 무엇이 잘못되었는지보다 잘 이해할 수 있습니다. 이렇게하려면,  **디버그 등록 정보를 활성화하거나** **org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener****에 DEBUG 로깅을 활성화해야합니다.**



예를 들어, 응용 프로그램을 실행하는 경우 **java -jar** 을 사용하여 다음과 같이 `debug`속성을 활성화 할 수 있습니다 .

```
$ java -jar myproject-0.0.1-SNAPSHOT.jar --debug
```



#### 23.2 배너를 내가 원하는 대로 바꾸기

> Springboot를 기동할때 콘솔을 보면 “Spring” 텍스트 이모티콘을 보게된다. 이것을 “Springboot banner”라고 합니다.

![img](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWdhssr0w9IqAHmA-ke%2F-LfmEeo_c6TKC4Kr1bwU%2F-LfmEokSGc0HyqRwiK7V%2Fimage.png?alt=media&token=b35217db-aa31-4710-8a5c-53cd17a634d4)



시작할때 출력되는 배너를 클래스 패스상에 `banner.txt`파일을 추가하거나 `spring.banner.location` 프라퍼티에 그 파일의 위치를 설정해서 바꿀 수 있다. 만약 파일의 인코딩이 UTF-8이 아니면 `spring.banner.charset` 설정을 해야 한다. 텍스트 파일 이외에도 `banner.gif`, `banner.jpg` 또는 `banner.png` 이미지 파일을 클래스 피스상에 위치하거나 `spring.banner.image.location` 프라퍼티 설정을 이용해 추가할 수있다. 이미지들은 ASCII art로 변환되어 text 배너로 출력된다.



banner.txt 파일안에 다음과 같은 플레이스홀더를 사용할 수있다.



**표 23.1. 배너에서 사용하는 변수들**

| 변수                                                         | 설명                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| `${application.version}`                                     | `MAINFEST.MF` 파일에 선언된 어플리케이션의 버전. 예를 들어 `Implementation-Version: 1.0` 은 `1.0`으로 출력된다. |
| `${application.formatted-version}`                           | `MANIFEST>MF`에 선언된 어플리케이션의 버전번호를 보여주기 위한 형식(소괄호로 감싸고 `v`를 접두어로 붙인다)으로 보여준다. 예 : `(v1.0)` |
| `${spring-boot.version}`                                     | 사용하고 있는 스프링 버전. 예: `2.0.0.BUILD-SNAPSHOT`        |
| `${spring-boot.formatted-version}`                           | 사용하고 있는 스프링 버전을 보여주기 위한 형식(소괄호로 감싸고 `v`를 접두어로 붙인다.)으로 보여준다. 예 : `(v2.0.0.BUILD-SNAPSHOT)` |
| `${Ansi.NAME}`(또는 `${AnsiColor.NAME}`, `${AnsiBackground.NAME}`, `${AnsiStyle.NAME}`) | `NAME`은 ANSI 이스케이프코드의 이름이다. 자세한 것은 `[AnsiPropertySource](`[`https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot/src/main/java/org/springframework/boot/ansi/AnsiPropertySource.java`](https://github.com/spring-projects/spring-boot/blob/master/spring-boot-project/spring-boot/src/main/java/org/springframework/boot/ansi/AnsiPropertySource.java)`)`를 보시오. |
| `${application.title}`                                       | `MANIFEST.MF`에 선언된 어플리케이션 제목. 예를 들어 `Implementation-Title: MyApp`은 `MyApp`으로 출력된다. |

![[팁]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png)

`SpringApplication.setBanner(…)` 메소드를 이용해 프로그램적으로 Banner를 생성할 수있다. `org.springframework.boot.Banner` 인터페이스를 상속받고 `printBanner()` 메소드를 구현하면된다.



또한 `spring.main.banner-mode` 프라퍼티를 사용해 배너가 `System.out`(`console`)로 출력되거나, 설정되 있는 logger(`log`)로 전달되거나 또는 생산되지 않도록(`off`) 설정할 수있다.



출력된 배너는 `springBootBanner` 란 이름의 싱글톤 빈으로 등록된다.

![[노트]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/note.png)

YAML 은 `off`가 `false`를 의미 하므로 어플리케이션에서 배너를 사용 안하려면 따옴표를 추가해야만 한다.

```
     spring:
              main:
                      banner-mode: "off"
```



