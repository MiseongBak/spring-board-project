# Spring Boot CRUD & 회원 관리 프로젝트

> 『이것이 스프링 부트다』 교재 내용을 기반으로 학습 목적으로 진행한 클론 코딩 프로젝트입니다.
> Spring Boot 기반 웹 애플리케이션 구조와 MVC 패턴, Spring Security, JPA 흐름을 익히기 위해 구현했습니다.

---

# 프로젝트 소개

Spring Boot와 Thymeleaf를 활용하여 게시글 CRUD 및 회원 관리 기능을 구현한 웹 애플리케이션입니다.
Spring Security 기반 로그인/회원가입 기능과 JPA를 이용한 데이터 처리 흐름을 학습하는 데 목적을 두었습니다.

교재의 예제를 따라 구현하며 다음 내용을 중점적으로 학습했습니다.

* Spring Boot 프로젝트 구조 이해
* MVC 패턴 기반 웹 애플리케이션 개발
* Spring Data JPA를 활용한 데이터 처리
* Spring Security 인증/인가 흐름 이해
* Thymeleaf 기반 서버 사이드 렌더링
* DTO / Entity 분리 및 서비스 계층 구성

---

# 기술 스택

| 구분         | 기술              |
| ---------- | --------------- |
| Language   | Java 21         |
| Framework  | Spring Boot 3   |
| View       | Thymeleaf       |
| Database   | H2 Database     |
| ORM        | Spring Data JPA |
| Security   | Spring Security |
| Build Tool | Gradle          |
| Library    | Lombok          |

---

# 주요 기능

## 회원 기능

* 회원가입
* 로그인 / 로그아웃
* 회원 목록 조회
* 회원 정보 수정
* 비밀번호 변경
* Spring Security 기반 인증 처리

## 게시글 기능

* 게시글 작성
* 게시글 목록 조회
* 게시글 상세 조회
* 게시글 수정
* 게시글 삭제

---

# 프로젝트 구조

```text
src/main/java/com/example/demo
├── config
│   └── SecurityConfiguration.java
├── controller
│   ├── ArticleController.java
│   ├── HomeController.java
│   └── MemberController.java
├── dto
│   ├── ArticleDto.java
│   ├── ArticleForm.java
│   ├── MemberDto.java
│   ├── MemberForm.java
│   └── PasswordForm.java
├── model
│   ├── Article.java
│   ├── Authority.java
│   ├── Member.java
│   └── MemberUser.java
├── repository
│   ├── ArticleRepository.java
│   ├── AuthorityRepository.java
│   └── MemberRepository.java
└── service
    ├── ArticleService.java
    └── MemberService.java
```

---

# 실행 방법

## 1. 프로젝트 클론

```bash
git clone [repository-url]
```

## 2. 프로젝트 실행

```bash
./gradlew bootRun
```

## 3. 접속

```text
http://localhost:8080
```

---

# 학습 포인트

이번 프로젝트를 통해 아래 내용을 실제 코드로 경험했습니다.

* Controller → Service → Repository 계층 분리 구조
* DTO와 Entity 역할 분리
* Spring Security 인증 처리 흐름
* JPA Repository 기반 CRUD 구현
* Thymeleaf 템플릿 렌더링 방식
* Form 데이터 검증 및 바인딩

특히 Spring Security 설정과 사용자 인증 흐름을 직접 구현하며, 스프링 기반 백엔드 개발 구조를 이해하는 데 큰 도움이 되었습니다.

---

# 아쉬웠던 점

교재 기반 클론 코딩 프로젝트이기 때문에 다음 부분은 추가 개선이 필요합니다.

* 예외 처리 구조 고도화
* 테스트 코드 작성 부족
* API 기반 구조로 확장 필요
* Docker / CI-CD 미적용
* 프론트엔드 UI 개선 필요

향후에는 해당 프로젝트를 기반으로 REST API 구조 및 JWT 인증 방식까지 확장해볼 계획입니다.

---

# 느낀 점

단순히 기능을 구현하는 것보다, Spring Boot의 전체 흐름과 구조를 이해하는 데 집중했습니다.
클론 코딩 프로젝트였지만 직접 실행 오류를 해결하고 흐름을 분석하면서 Spring MVC와 Security 구조를 익힐 수 있었습니다.

앞으로는 단순 구현을 넘어 성능, 테스트, 아키텍처 설계까지 고려한 프로젝트를 진행해보고자 합니다.
