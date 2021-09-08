# studymap
# 1. Project Summary
![09월-05일 02시 28분 001](https://user-images.githubusercontent.com/74187226/132103805-7044ef9b-4254-419e-b688-52ab8cedef28.png)

StudyMap (http://ec2-52-79-164-120.ap-northeast-2.compute.amazonaws.com/) 은 혼자서 만든 토이 프로젝트로 프로젝트 또는 스터디원 구인 및 포럼 커뮤니티 기능을 제공하는 서비스 플랫폼입니다. 사용자는 스터디 및 프로젝트 모집, 질문 포럼 커뮤니티 기능을 활용하여 다른 사용자와 소통을 할 수 있습니다.


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
### 3.2.1 Create & Read
![C RGIF](https://user-images.githubusercontent.com/74187226/132286261-fe0c3c99-7141-43ec-afb8-99c7dd2f155e.gif)

<br>

### 3.2.3 Update & Delete
![U DGIF](https://user-images.githubusercontent.com/74187226/132286315-d2e02985-01f4-486d-a78b-b0d9749025e3.gif)


## 3.4 paging
![pagingGIF](https://user-images.githubusercontent.com/74187226/132140186-a76ad650-d1d9-47fb-b6ef-d9e6885dc656.gif)

## 3.5 Comment & View
![V CGIF](https://user-images.githubusercontent.com/74187226/132557533-8276e2c3-b2fd-4f71-b021-5e185d6c7a52.gif)

# 4. Back-End

>src
>>main
>>>java
>>>>com.studymap
>>>>>config
>>>>>>auth
>>>>>>>CustomOAuth2UserService
>>>>>>>dto
>>>>>>
>>>>>domain
>>>>>>EntityClass
>>>>>>
>>>>>>Repository
>>>>>>
>>>>>BaseTimeEntity
>>>>
>>>>Service
>>>>
>>>>web
>>>>
>>>>>dto
>>>>>
>>>>>Controller

## 4.1 EntityClass
룸북 어노테이션들을 사용해 코드 변경량을 최소화 했으며 JPA어노테이션을 사용해 Entity 클래스를 구성하였습니다.
```java
@Getter //getter메소드를 자동생성
@NoArgsConstructor //기본생성자 자동생성
@Entity //테이블에 링크될 클래스를 명
public class Project extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    //@colume = 선언하지 않아도 이 클래스는 모두 컬럼이 되지만 변경하고자하는 옵션이 있을경우 사용한다.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    private Integer views;

    private String area;

    private Integer member;

    private String state;

    private String studyType;


    @Builder
    public Project(String title, String content, String author,String area, Integer views, Integer member, String state, long userId, String studyType) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.area = area;
        this.views = views;
        this.member = member;
        this.state = state;
        this.userId = userId;
        this.studyType = studyType;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;

    }
}

```
## 4.2 Repository (DAO)
등록/수정/삭제등은 JPA를 이용해 작성하였으며 SpringDataJPA에서 제공하지 않는 메소드는 아래처럼 @Query를 통해 SQL을 작성할 수 있었습니다.
또한 페이징 처리는 Pageable을 사용하였습니다.
```java
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p ORDER BY p.id DESC")
    List<Project> findAllDesc();

    //update문에는  @Modifying 와 @Transactional 가 들어가며 integer형태로 받기위해 인티저를 사용
    @Modifying
    @Transactional
    @Query("UPDATE Project SET views = views + 1 WHERE id = ?1 ")
     Integer findByIdView(long id);

    //JpaRepository에서는 By 뒷 부분은 SQL의 where 조건 절에 해당된다. 따라서, Containing을 붙여주면 Like 검색이 된다.
    Page<Project> findByTitleContaining(String title, Pageable pageable);

```
## 4.3 Service
Bean을 주입받을때 룸북의 @RequiredArgsConstructor를 이용하여 생성자를 대신 생성하여 해결하였습니다. 
Controller가 이용할 수 있는 메소드를 만들어주기위해 코드를 만드는 곳으로 JpaRepository를 활용하였습니다.  
update과정에서 EntityManager가 활성되어있기 때문에 쿼리변경없이 Entitiy의 값을 변경하여 update가 되는것을 확인하였습니다. 이부분을 더티체킹이라 하며 JPA의 영속성에 대해서 더욱 공부해야한다고 느끼게되었습니다.
```java
@RequiredArgsConstructor
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    public Long save(ProjectSaveRequestDto requestDto) {

        return projectRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ProjectUpdateRequestDto requestDto) {
        // 영속성 컨텍스트에 데이터가 있는지 조회
        Project posts = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다.gg id=" + id));
         /*
          Spring Data Jpa를 쓴다면 기본 옵션으로 EntityManager가 활성화되어 영속성 컨텍스트가 유지된 상태다. (영속성 컨텍스트에 엔티티 객체가 들어있는 상태)
          업데이트로 값만 바꿔주면 트랜잭션 끝나는 시점에 DB반영
          따라서 업데이트 쿼리 날리는 부분이 없다.
        */
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    //하나의 아이디를 찾아야할때
    @Transactional(readOnly = true)
    public ProjectResponseDto findById(Long id) {
        Project entity = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new ProjectResponseDto(entity);
    }

    //리스트
    @Transactional(readOnly = true) //readOnly = true는 트랜젝션 범위는 유지하되 조회기능만 남겨 조회속도가 개선된다.
    public List<ProjectListResponseDto> findAllDesc() {
        return projectRepository.findAllDesc().stream().map(ProjectListResponseDto::new).collect(Collectors.toList());
    }


    @Transactional
    public void delete (Long id) {
        Project posts = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        projectRepository.delete(posts);
    }
    //상세 글 페이지
    @Transactional(readOnly = true)
    public ProjectViewResponseDto findByIdView(Long id) {
        Project entity = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        //Integer형태로 받는다 조회수
        Integer views = projectRepository.findByIdView(id);
        System.out.println("views:"+views);
        return new ProjectViewResponseDto(entity);
    }


    //페이징
    @Transactional
    public Page<Project> getProjectList(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    //페이징 넥스트 버튼 비활성화
    @Transactional
    public Boolean getListCheck(Pageable pageable) {
        Page<Project> saved = getProjectList(pageable);
        Boolean check = saved.hasNext();

        return check;
    }

    //검색
    @Transactional
    public Page<Project> searchProjects(String keyword, Pageable pageable) {
        Page<Project> projectListResponseDtoList = projectRepository.findByTitleContaining(keyword, pageable);
        return projectListResponseDtoList;
    }
}
```

## 4.4 Controller
Model을 통해 서버 템플릿엔진에서 사용할 수 있는 객체를 저장시켰으며 @LoginUser SessionUser를 이용해 로그인 정보를 가져왔습니다. 페이징이 필요한 페이지는 PageableDefault를 통해 처리했습니다.
```java
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ProjectService projectService;
    private final StudyGroupService studyGroupService;
    private final ForumService forumService;
  /*  private final HttpSession httpSession;*/

    @GetMapping("/")
    public String index(Model model , @LoginUser SessionUser user, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        //httpSession.getAttribute("user")에서 기존에 가져오던 세션 정보값을 @LoginUeser만 사용하면 세션 정보를 가져올수 있도록 변경
        model.addAttribute("project", projectService.getProjectList(pageable));
        model.addAttribute("studyGroup", studyGroupService.getStudyGroupList(pageable));
        model.addAttribute("forum", forumService.getForumList(pageable));

       /* SessionUser user = (SessionUser) httpSession.getAttribute("user");*/

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
}
```
 
# 5. DATABASE ERD
![09월-06일 05시 55분 001](https://user-images.githubusercontent.com/74187226/132141212-826f539a-4c0c-4ef0-a250-b4f1d0effa23.png)
<br>

# 6. 배포
✔ AWS-EC2 (Ubuntu)

하드웨어에 선투자할 필요가 없어 더 빠르게 애플리케이션을 개발하고 배포할 수 있어 EC2를 사용했습니다.

처음 배포를 해보았기 때문에 풍부한 문서, 온라인 커뮤니티를 통해 충분히 학습할 수 있는 Ubuntu를 사용했습니다.

 ✔ CI Tool
 깃허브에서 무료로 제공하고있으며 따로 설치가 필요없기때문에 Travis CI 오픈소스 웹서비스를 사용했습니다.
