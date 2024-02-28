# 스프링 테스트 적용

### 테스트를 위한 애플리케이션 컨텍스트 관리
- 테스트 컨텍스트의 지원으로 애플리케이션 컨텍스트를 공유할 수 있다.
- springBootTest 를 통해 애플리케이션 컨텍스를 가져올 수 있다.
- 클래스, 메소드 사이에서 단 한번만 동일한 컨텍스트를 만들고 특별한 방법으로 주입해준다, 일종의 DI

### @Autowired
- DI에 사용되는 애노테이션
- 컨텍스트 내에 타입이 일치하는 빈을 찾는다. 
- 컨텍스트 자체도 빈으로 등록된다.

### 타입에 의한 자동 와이어링
- 별도의 설정 없이 필트 타입정보를 이용해 빈을 가져올 수 있다
- 필드 주입, 세터 주입, 생성자 주입
- 생성자 주입이 좋은 이유
    - 생성자 주입은 순환 참조를 컴파일 타임에 감지, 필드 주입은 리플렉션을 사용해서 무한 루프 위험 존재
    - 테스트하기 좋다.
    - 불변으로 설정하기 좋다

### 인터페이스 주입 vs 구현체 주입
- 코드가 느슨해지므로 왠만하면 인터페이스 주입이 좋다.

### 구현체가 하나인데 인터페이스 써야 하나
- 1. 소프트웨어 개발에서 절대로 바뀌지 않는 것은 없다.
    - 클래스 대신 인터페이스 쓰는건 쉽다. 
    - 구현체를 사용하면 나중에 변경되면 비용이 커진다.
- 2. 인터페이스를 사용하면 부가기능을 적ㅇ요하가 쉽다.
    - 기존 내용을 바꾸지 않고 부가기능을 얼마든지 추가할 수 있다.

### 테스트 코드에 의한 DI
- 테스트용 데이터소스를 SingleConnectionDataSource 를 사용하면 단일 커넥션을 사용해서 빠르다.
- 애플리케이션 컨텍스트를 상황별로 미리 구성해서 사용할 수 있다.

### 침투적 기술과 비침투적 기술
- 침투적 기술
  - 특정 인터페이스나 클래스 사용 강제
  - 기술 관련 API 등장
  - 애플리케이션 코드가 기술에 종속
- 비침투적 기술
  - 로직에 영향을 주지 않는다.
  - 스프링은 비침투적 기술
  - 컨테이너 없는 DI 테스트도 가능하므로

### DI를 이용한 테스트 방법 선택
- 컨테이너 없이 테스트할 방법을 우선적으로 고려
- 의존관계가 복잡하면 스프링 설정을 이용한 DI
- 예외적인 의존관계가 있다면 수동 DI하고 @DirtiesContext 붙여주기


