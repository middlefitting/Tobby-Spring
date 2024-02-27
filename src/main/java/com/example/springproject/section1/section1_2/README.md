# 1.2

# 개요
- 메소드 추출 기법을 활용한 리팩토링
- 상속을 활용한 추상화
- 템플릿 메서드 패턴 적용
- 팩토리 메서드 패턴 적용

### 템플릿 메서드 패턴
- 슈퍼클래스에 기본적인 로직을 정의하고 일부를 서브클래스에서 재정의해서 사용

### 팩토리 메서드 패턴
- 서브클래스에서 구체적인 오브젝트 생성 방법을 결정하게 하는 것
- 오브젝트를 생성하는 기능을 가진 팩토리 메서드와는 다른 의미를 가진다

# 문제점
- 상속을 사용한다는 것

### 상속의 문제점
- 자바는 다중 상속이 안된다
- 상속을 통한 상하위 클래스의 관계는 생각보다 밀접하다. 슈퍼클래스의 변경이 모든 서브클래스에 영향을 줄 수도 있다.
- 확장기능을 다른 DAO 클래스에 적용할 수 없다.

