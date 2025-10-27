# java-racingcar-precourse


🚗 자동차 경주 게임 구현 체크리스트

 도메인
 
  - 0~9 난수 생성 [ O ]
  - 4 이상 전진 여부 판단 [ O ]
  - 위치 관리 [ O ]
  - RaceParticipant 참가자 공통 규격 정의 (인터페이스) [ O ]
  - Car : 이름 + 위치, move() 구현 [ O ]
  - RaceResult : 최대 거리, 우승자 계산 [ O ]
  - RaceParticipants : 전체 이동, 결과 생성 [ O ]

 검증 & 입출표 
  - 쉼표 구분, 5자 이하 검사 [ O ]
  - 이름, 시도 횟수 입력 [ O ]
  - 실행 결과, 우승자 출력 [ O ]

흐름 제어
  - 전체 게임 로직 실행 [ O ]
  - main 진입점 [ O ]


---

## 실행 순서 (Top-Down)

### 1. `Application.java`
- 메인 진입점
- 프로그램 시작 시 사용자 입력을 받고 게임을 실행합니다.

### 2. `RacingGame.java`
- 게임 로직 제어 (컨트롤러)
- 사용자 입력을 기반으로 자동차를 생성하고, 라운드 진행과 결과 관리를 수행합니다.

### 3. `domain/` (게임 핵심 도메인)
- `Car.java` : 자동차 한 대를 나타내는 객체  
- `Position.java` : 자동차 위치 값 객체  
- `RaceParticipant.java` : 자동차 및 참가자 관련 인터페이스  
- `RacingParticipants.java` : 자동차 집합 관리  
- `RaceResult.java` : 라운드별 결과 및 최종 결과 저장  
- `rule/RacingRule.java` : 전진 규칙 정의 (난수 기반)

### 4. `io/` (입출력, View)
- `InputView.java` : 사용자 입력 처리 (자동차 이름, 시도 횟수)  
- `ResultView.java` : 라운드별 경기 결과와 최종 우승자 출력

### 5. `util/` (유틸리티)
- `NameValidator.java` : 자동차 이름 유효성 검사  
- `NumberGenerator.java` : 난수 생성 인터페이스  
- `RandomNumberGenerator.java` : 난수 생성 구현체


---
### 설계 목표와 어떤 점을 중점으로 봐주면 감사하겠습니다. 
- 축약하지 않는다
- Java에서 제공하는 API를 적극 활용한다
- 이름을 통해 의도를 드러낸다
--- 
