# 1.4 제어의 역전

### 팩토리
- 객체 생성 방법을 결정하고 만들어진 오브젝트를 돌려준다.
- 객체를 생성하는 쪽과 사용하는 쪽의 역할과 책암울 분리
- 설계도와 같은 역할

### 장점
- 애플리케이션의 컴포넌트와 구조를 결정하는 오브젝트를 분리

### 제어의 역전
- 기존에는 사용하는 쪽에서 오브젝트를 만들지를 결정
- 제어의 역전에서는 권한을 다른 대상에게 위임, 특별한 오브젝트에 의해 결정
- 서블릿: 제어 권한을 가진 컨테이너가 적절한 시점에 만듬
- 템플릿 메소드: 제어권을 상위 템플릿 메소드에 넘기고 자신은 필요할때 호출되어 사용
- 프레임워크: 코드가 프레임워크에 의해 사용

































































































































































































