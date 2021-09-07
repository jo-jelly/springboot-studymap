# studymap
# 1. Project Summary
![09월-05일 02시 28분 001](https://user-images.githubusercontent.com/74187226/132103805-7044ef9b-4254-419e-b688-52ab8cedef28.png)

StudyMap(http://ec2-52-79-164-120.ap-northeast-2.compute.amazonaws.com/)은 혼자서 만든 토이 프로젝트로 프로젝트 또는 스터디원 구인 및 포럼 커뮤니티 기능을 제공하는 서비스 플랫폼입니다. 사용자는 스터디 및 프로젝트 모집, 질문 포럼 커뮤니티 기능을 활용하여 다른 사용자와 소통을 할 수 있습니다.


## 1.2. Project target
개발자 또는 학생 등 스터디가 필요하거나 프로젝트 협업이 필요한 사용자들끼리 스터디 또는 프로젝트에 참여하거나 모집할 수 있도록 사용자 타겟을 설정하였습니다. 

<br>

# 2 개발 환경
-  운영 체제: window10
-  IDE: intelli J 2021.2.1
-  Back-end: Spring Framework 2.4.1.RELEASE, MySQL 5.5.68 
-  Front-end: mustache
-  Server: AWS EC2 , IAM
-  Data Base: AWS RDS, H2 Console
-  Web browser: Chrome
-  CI Tool : Travis CI
  
<br>
  
# 3. Main features
## 3.0 프로젝트 기능
 본 프로젝트의 초기에 구상한 기능은 가장 기본적인 기능인 CRUD 즉, 게시판에 올라오는 게시물을 대상으로 Create, Read, Update, Delete가 가능한 게시판이었습니다. 그러나 전부 완성되어 갈 때 쯤, 아쉬운 부분이 계속해서 생겨나서 몇몇 기능들을 추가하게 되었습니다. 아래가 그 내용입니다.
<br>

초기 기능

+ 게시물을 작성하여 DataBase에 저장한다.
+ DataBase에서 게시물을 조회하여 웹 페이지 상에 표시한다.
+ 게시물을 수정하여 DataBase에 저장한다.
+ 게시물을 삭제할 시 DataBase에서 삭제한다.

<br>

추가 기능

+ 스프링시큐리티 oaith2 를 사용해서 sns 로그인을 설정
+ aws사용해서 해당소스를 실제 배포까지 구현
+ Visitor - 게시판에 존재하는 게시물들에 대한 Read에 로그인이 되어있지 않으면 접근 제어.
+ Read 기능에서 페이징 처리를 통해 한 페이지 당 보여주는 게시물의 수를 5개로 제한
+ Read 기능에서 특정 게시물을 제목으로 검색이 가능하게 함.
+ +(반복적인het, set을 줄이기위해 lombok 사용)

<br>
<br>

## 3.1 Authentication

<img src="https://user-images.githubusercontent.com/74187226/132283802-4d76ecf8-9759-4770-9e74-8de1a2871a71.png" width="350" height="450">  <img src="https://user-images.githubusercontent.com/74187226/132132583-58391dc7-ce43-49d9-bee0-49036ebbb410.png" width="350" height="450" >

소셜 회원가입도 지원하여 사용자의 편의성을 증대하였습니다. 
## 3.2CRUD
### 3.2.1 Create
![createGIF](https://user-images.githubusercontent.com/74187226/132140282-799c0d65-d381-4913-83aa-a2b802a6110e.gif)

### 3.2.2 Read
![ReadGIF](https://user-images.githubusercontent.com/74187226/132140181-992ff5d6-033e-4197-8419-2a53f47d814e.gif)

### 3.2.3 Update
![uodateGIF](https://user-images.githubusercontent.com/74187226/132139612-b7c1f821-f461-4702-8da7-c324e4616bc1.gif)

### 3.2.4 Delete
![deleteGIF](https://user-images.githubusercontent.com/74187226/132139624-c190a005-a367-467d-b4a6-0c58d638ecda.gif)

## 3.4 paging
![pagingGIF](https://user-images.githubusercontent.com/74187226/132140186-a76ad650-d1d9-47fb-b6ef-d9e6885dc656.gif)

## 3.5 Comment
![comment](https://user-images.githubusercontent.com/74187226/132140192-5a7574fa-79c5-4859-8ca9-b7a57c81ac05.gif)

## 3.6 View
![viewGIF](https://user-images.githubusercontent.com/74187226/132140203-49d7ec4e-5c50-44fd-9dd6-5e5409924185.gif)


# 4. 사용 스택
## 4.1 Spring Date JPA 인터페이스
 생산성이 뛰어나고 유지보수가 용이하며, SQL을 직접적으로 작성하지 않고 객체를 사용하여 동작는 장점에 선택하였습니다.


## 4.2 서버 템플릿 엔진
 심플한 문법과 로직코드가 없어 뷰 역할에 충실하게 사용할 수 있으며, 인텔리제이에서 플러그인을 무료로 사용할 수 있어서 선택했습니다. 
<br>

## 4.3 CI Tool
 깃허브에서 무료로 제공하고있으며 따로 설치가 필요없기때문에 Travis CI 오픈소스 웹서비스를 사용했습니다.
 <br>
 
# 5. DATABASE ERD
![09월-06일 05시 55분 001](https://user-images.githubusercontent.com/74187226/132141212-826f539a-4c0c-4ef0-a250-b4f1d0effa23.png)
<br>

# Cloud Computing
✔ AWS-EC2 (Ubuntu)

하드웨어에 선투자할 필요가 없어 더 빠르게 애플리케이션을 개발하고 배포할 수 있어 EC2를 사용했습니다.

처음 배포를 해보았기 때문에 풍부한 문서, 온라인 커뮤니티를 통해 충분히 학습할 수 있는 Ubuntu를 사용했습니다.

✔ AWS-IAM

IAM을 사용하여 인증(로그인)된 대상을 제어하여 보안을 강화하였습니다.
