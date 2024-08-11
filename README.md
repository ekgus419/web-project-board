# 게시판 서비스

가장 기본적이고 보편적인 게시판 기능을 둘러볼 수 있는 서비스.
[어드민 프로젝트](https://github.com/ekgus419/web-project-board-admin)의 개발과 기능 사용은 이 프로젝트와 연관이 있습니다.
패스트캠퍼스의 강의를 수강하며 스프링 부트와 관련 기술들, 자바 17 기능들, 개발 도구들을 경험하였습니다.

## 개발 환경

* Intellij IDEA Ultimate
* Java 17
* Gradle 7.4.1
* Spring Boot 2.7.0

## 기술 세부 스택

Spring Boot

* Spring Boot Actuator
* Spring Web
* Spring Data JPA
* Rest Repositories
* Rest Repositories HAL Explorer
* Thymeleaf
* Spring Security
* H2 Database
* MySQL Driver
* Lombok
* Spring Boot DevTools
* Spring Configuration Processor

그 외

* QueryDSL 5.0.0
* Bootstrap 5.2.0-Beta1
* Heroku
* 유즈케이스 다이어그램
![usecase](https://github.com/user-attachments/assets/9fee3d37-cf9c-4421-97b9-0a05c677e224)

| 종류   | uri                                             | method       | 기능                     | 설명                                      |
|--------|-------------------------------------------------|--------------|--------------------------|-------------------------------------------|
| 뷰     | /                                               | GET          | 루트 페이지              | 게시판 페이지로 이동                      |
|        | /error                                          | GET          | 에러 페이지              |                                           |
|        | /login                                          | GET          | 로그인 페이지            |                                           |
|        | /sign-up                                        | GET          | 회원 가입 페이지         |                                           |
|        | /articles                                       | GET          | 게시판 페이지            |                                           |
|        | /articles/{article-id}                          | GET          | 게시글 페이지            |                                           |
|        | /articles/search                                | GET          | 게시판 검색 전용 페이지  |                                           |
|        | /articles/search-hashtag                        | GET          | 게시판 해시태그 검색 전용 페이지 |                                           |
| api    | /api/sign-up                                    | POST         | 회원 가입                |                                           |
|        | /api/login                                      | GET          | 로그인 요청              |                                           |
|        | /api/articles                                   | GET          | 게시글 리스트 조회       |                                           |
|        | /api/articles/{article-id}                      | GET          | 게시글 단일 조회         |                                           |
|        | /api/articles                                   | POST         | 게시글 추가              |                                           |
|        | /api/articles/{article-id}                      | PUT, PATCH   | 게시글 수정              |                                           |
|        | /api/articles/{article-id}                      | DELETE       | 게시글 삭제              |                                           |
|        | /api/articleComments                            | GET          | 댓글 리스트 조회         |                                           |
|        | /api/articleComments/{article-comment-id}       | GET          | 댓글 단일 조회           |                                           |
|        | /api/articles/{article-id}/articleComments      | GET          | 게시글에 연관된 댓글 리스트 조회 |                                           |
|        | /api/articles/{article-id}/articleComments/{article-comment-id} | GET | 게시글에 연관된 댓글 단일 조회 |                                           |
|        | /api/articles/{article-id}/articleComments      | POST         | 댓글 등록                |                                           |
|        | /api/articles/{article-id}/articleComments/{article-comment-id} | PUT, PATCH | 댓글 수정              |                                           |
|        | /api/articles/{article-id}/articleComments/{article-comment-id} | DELETE | 댓글 삭제              |                                           |
