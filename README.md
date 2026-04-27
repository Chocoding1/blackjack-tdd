# blackjack-tdd

## 구현 기능 목록
**1. [입력] 게임에 참여할 사람의 이름을 입력 받는다.(쉼표 기준으로 분리)**
   
   [예외처리] 쉼표 외의 다른 문자를 구분자로 한 경우 IllegalArgumentException 예외를 발생시킨다.
   
   [예외처리] 입력값이 공백일 경우 IllegalArgumentException 예외를 발생시킨다.

**2. [입력] 게임에 참여한 사람의 배팅 금액을 입력 받는다.**

   [예외처리] 입력값이 공백일 경우 IllegalArgumentException 예외를 발생시킨다.
   
   [예외처리] 입력값이 숫자가 아닐 경우 IllegalArgumentException 예외를 발생시킨다.
   
   [예외처리] 입력값이 0 이하일 경우 IllegalArgumentException 예외를 발생시킨다.
      
**3. [중간 과정] 딜러와 사용자에게 카드를 2장씩 나누어준다.**

   [카드 조건] 덱은 1개만 사용한다.(A ~ K : 13 * 4 = 52장)
   
**4. [중간 과정] 딜러와 사용자의 최초 카드 합계를 구하며, 블랙잭 여부를 판단한다.**

   [ACE 조건] ACE가 11이어도 21이 넘지 않는 경우에는 11, 넘는 경우에는 1로 계산한다.
   
**5. [출력] 카드 현황을 출력한다.**

   [출력 조건] 딜러는 첫 번째 카드만 출력한다.
   
**6. [입력] 사용자별로 카드 추가 지급 여부를 입력 받는다.**

   [예외처리] y, n 외의 다른 문자일 경우 IllegalArgumentException 예외를 발생시킨다.
   
   [입력 조건] 모든 사용자가 추가 지급을 완료할 때까지 반복한다.
   
   [지급 조건] 사용자가 y를 입력하고, 사용자의 현재 카드 합계가 21미만일 경우에 카드를 지급한다.
   
**7. [출력] 사용자별로 지급 현황을 출력한다.**
    
**8. [출력] 딜러의 카드 합계가 17 이상이 일 될 때까지 추가 지급 현황을 출력한다.**
   
**9. [출력] 사용자별 카드 현황 및 결과를 출력한다.**

**10. [중간 과정] 최종 승패 및 수익을 계산한다.**

**11. [출력] 참여자별 최종 수익을 출력한다.**

## tdd 사고 과정
### 기능 목록 1
- 사용자의 이름을 검증하는 거니까 User 클래스의 기능으로 분류하자.
  - UserTest를 우선 만들고 입력값이 공백일 경우 예외를 발생시키는 테스트를 작성하자.
    <img width="947" height="267" alt="image" src="https://github.com/user-attachments/assets/eb70e135-4777-4d3e-b2aa-988ccf655ccd" />
  - User가 존재하지 않아 컴파일 에러 발생
    <img width="1202" height="242" alt="image" src="https://github.com/user-attachments/assets/99b018a8-864e-4bce-92d2-4ced2c491c6c" />
  - User를 생성하자.
    <br><img width="617" height="198" alt="image" src="https://github.com/user-attachments/assets/423135b2-87fa-49df-b37e-e1838a315166" />
  - 테스트 재실행
    <img width="1327" height="696" alt="image" src="https://github.com/user-attachments/assets/1390e97d-e6b0-4a1c-9cb1-d5d5c7d74ef1" />
  - 예외를 예상했으나 예외가 발생하지 않아 테스트 실패
  - User 클래스에서 이름을 검증하여 공백일 경우 예외를 발생하는 코드 추가하자.
    <img width="734" height="330" alt="image" src="https://github.com/user-attachments/assets/ac01118a-752b-4455-887b-7c2347a7361f" />
  - 테스트 재실행 -> 성공!
    <br><img width="565" height="126" alt="image" src="https://github.com/user-attachments/assets/eb1c7b5c-ddc2-4143-a516-91eabfe4a413" />
- 쉼표 외의 다른 문자를 구분자로 한 경우를 검증하기 위해 검증 클래스를 만들어야 해.
  - 쉼표로 문자열을 구분하는 클래스니까 CommaSplitter를 클래스명으로 하고, CommaSpliiterTest를 만들자.
    <img width="713" height="132" alt="image" src="https://github.com/user-attachments/assets/3b90f1fe-e6fb-4e7f-abc7-9aeecc6e0d9e" />
  - 테스트 케이스를 생각하자.
    1. 공백이 입력되는 경우 예외 발생
    2. 구분자가 쉼표가 아닌 경우 예외 발생 -> 이건 User 클래스에서 이름 검증할 때 하자. ex) 이름에 특수문자가 포함될 수 없습니다.
    3. 문자열을 쉼표로 올바르게 구분하여 리스트로 반환 테스트
  - 입력값이 공백일 경우 예외를 발생시키는 테스트를 작성하자.
    <img width="1005" height="266" alt="image" src="https://github.com/user-attachments/assets/62259a03-2bae-4399-a8ac-5cfaaa0bb7d0" />
    - CommaSplitter 클래스가 존재하지 않아 컴파일 에러 발생
      <img width="1276" height="241" alt="image" src="https://github.com/user-attachments/assets/0b34a27a-7010-4538-89b7-73f00562371e" />
    - CommaSpliiter를 생성하자.
      <br><img width="663" height="256" alt="image" src="https://github.com/user-attachments/assets/2e06c4d7-7ede-47b4-8f61-b48ab00b2153" />
    - 테스트 재실행 -> split() 메서드가 존재하지 않아 컴파일 에러 발생
      <img width="1276" height="156" alt="image" src="https://github.com/user-attachments/assets/a13a86b5-052d-40ce-8e2b-8ad60ba0d578" />
    - CommaSplitter에 split() 메서드 생성
      <br><img width="484" height="133" alt="image" src="https://github.com/user-attachments/assets/54b87401-79ee-4445-9821-30671093e4d3" />
    - 테스트 재실행 -> 예외가 발생하는 것을 예상했으나 예외가 발생하지 않아 테스트 실패
      <img width="1133" height="346" alt="image" src="https://github.com/user-attachments/assets/1f5f0556-879c-4397-b316-918ff49331df" />
    - split() 메서드에 입력값이 공백일 경우 예외를 발생시키는 코드를 추가하자.
      <img width="692" height="263" alt="image" src="https://github.com/user-attachments/assets/a400a6f2-b8f0-4b30-b873-5b93ed33c9f1" />
    - 테스트 재실행 -> 성공!
      <br><img width="605" height="123" alt="image" src="https://github.com/user-attachments/assets/a122f411-a5d1-4042-8e08-1a5f56ec6b5f" />
  - 문자열을 쉼표로 구분하여 리스트로 올바르게 반환하는지 테스트하자.
    - 실패하는 테스트 작성
      <br><img width="727" height="333" alt="image" src="https://github.com/user-attachments/assets/ad59bfde-cea3-4166-8d9e-8e727104c937" />
    - split() 메서드가 List를 반환할 것을 기대했으나 현재 반환 타입이 void라서 테스트 실패
      <img width="1349" height="104" alt="image" src="https://github.com/user-attachments/assets/8f9ec38d-d6d4-4402-8389-37b435081593" />
    - CommaSplitter.split()의 반환 타입을 List로 변경
      <img width="640" height="157" alt="image" src="https://github.com/user-attachments/assets/a8071478-a057-4b87-8dfc-d31c7d976015" />
    - 테스트 재실행 -> 반환하는 리스트의 길이가 0으로 고정되어 있어 테스트 실패
      <img width="1087" height="493" alt="image" src="https://github.com/user-attachments/assets/492e97ab-e88c-4968-a26d-dcc6befc1317" />
    - 테스트가 통과하도록 CommaSplitter.split() 메서드 로직 수정하자.
      <img width="637" height="176" alt="image" src="https://github.com/user-attachments/assets/84777cff-99e1-4aad-9373-37bb4d9d2d30" />
    - 테스트 재시도 -> 입력값이 공백인 경우에는 검증 로직에서 걸렬 테스트 실패
      <img width="1029" height="196" alt="image" src="https://github.com/user-attachments/assets/6e0f4e3d-65fd-40a3-a2f2-e86c844acbe8" />
    - 테스트 케이스 수정
      <br><img width="707" height="307" alt="image" src="https://github.com/user-attachments/assets/f20d5e76-88bd-4feb-9d3d-bc288dd3b112" />
    - 테스트 재시도 -> 성공!
      <br><img width="310" height="152" alt="image" src="https://github.com/user-attachments/assets/aa359ed5-ef3c-4ae7-8f0c-4b06614eed1f" />
  - 구현하다 보니 CommaSplitter에서 `pobi  ,   jason`을 입력받는 경우 User에 공백이 포함된 이름이 들어간다. User 생성자로 들어오는 input에 대해 문자열 양 쪽 공백을 제거하는 코드를 추가하자.

### 기능 목록 2
- 배팅 금액의 클래스명은 BettingAmount로 하자.
- 우선 BettingAmountTest 클래스를 생성하자.
  <br><img width="322" height="44" alt="image" src="https://github.com/user-attachments/assets/ddb81642-137a-42c0-a21a-24da5b4b27bd" />
- 배팅 금액이 공백인 경우를 테스트하자.
  - 실패 테스트 작성
    <br><img width="642" height="245" alt="image" src="https://github.com/user-attachments/assets/841ac6db-0ff9-4cc5-a835-56609cffd29a" />
  - BettingAmount가 존재하지 않아 테스트 실패
    <img width="1251" height="112" alt="image" src="https://github.com/user-attachments/assets/2657a323-afce-4671-bde1-5b7287738223" />
  - BettingAmount를 생성하고 문자열을 파라미터로 받는 생성자를 생성하자.
    <br><img width="455" height="177" alt="image" src="https://github.com/user-attachments/assets/7a1b5c1d-197c-43e9-872d-daa085b3bfe3" />
  - 테스트 재시도 -> 예외 발생을 예상했으나 예외가 발생하지 않아 테스트 실패
    <img width="1214" height="156" alt="image" src="https://github.com/user-attachments/assets/091af54c-65eb-42ce-880a-bbde288f6df3" />
  - 입력값이 공백일 경우 예외를 발생하는 코드를 작성하자.
    <img width="711" height="219" alt="image" src="https://github.com/user-attachments/assets/1e42013b-f418-4f1b-9bd0-360297723a82" />
  - 테스트 재시도 -> 성공!
    <br><img width="311" height="132" alt="image" src="https://github.com/user-attachments/assets/60ab56cd-18f7-47d6-b7d7-7758c44f26c9" />
- 배팅 금액이 숫자 타입이 아닐 경우를 테스트하자.
  - 실패 테스트 작성
    <img width="1024" height="199" alt="image" src="https://github.com/user-attachments/assets/3860c2b1-022e-48c2-9ed9-45995d658057" />
  - 예외가 발생하는 것을 예상했으나 예외가 발생하지 않아 테스트 실패
    <img width="1263" height="163" alt="image" src="https://github.com/user-attachments/assets/67fbd911-28f1-4370-b4da-0e5deca82dd5" />
  - 배팅 금액이 숫자 타입이 아닐 경우 예외를 발생시키는 로직을 추가하자.
    <img width="765" height="421" alt="image" src="https://github.com/user-attachments/assets/51cf5917-e421-4fe4-b652-f271fce31f8d" />
  - 테스트 재시도 -> 성공!
    <br><img width="310" height="120" alt="image" src="https://github.com/user-attachments/assets/4ae25d23-fa5e-4adc-aafd-a90523adbb6e" />
- 배팅 금액이 0 이하인 경우를 테스트하자.
  - 실패 테스트 작성
    <img width="1034" height="203" alt="image" src="https://github.com/user-attachments/assets/d7761802-85dd-4ea0-8657-16308431a2c8" />
  - 예외가 발생하는 것을 예상했으나 예외가 발생하지 않아 테스트 실패
    <img width="1292" height="142" alt="image" src="https://github.com/user-attachments/assets/54272725-26e0-424f-8700-28b8f1b573c5" />
  - 배팅 금액이 0 이하일 경우 예외를 발생시키는 로직을 추가하자.
    <img width="710" height="110" alt="image" src="https://github.com/user-attachments/assets/041a74ed-be38-44d0-9ce8-c1500d6adf54" />

### 기능 목록 3
- 어, 기능 목록 3에서 나오는 도메인은 카드라고 생각하면 될 거 같은데, 카드 도메인에는 딱히 로직이 없는데 어떻게 TDD로 구현하지? 얘는 그냥 바로 만들어도 되나?
- **별다른 도메인 로직이 존재하지 않는 값객체는 도메인 규칙을 정의하는 용도로 TDD를 진행하자.**
- Card 객체는 필드로 Rank와 Suit을 가지고 있다. 이 두 클래스 먼저 TDD를 진행하자.(사전에 한 설계를 가지고 TDD를 하는 것이기 때문에 이렇게 바로 필드 구조가 나온 것. 만약 처음 설계를 진행했다면 Card의 필드로 Rank와 Suit을 두는 것을 바로 생각하지는 못 했을 것.)
- Rank를 먼저 테스트하자. Rank는 Card의 숫자를 나타내는 클래스로 enum 클래스로 만들 것이다.
  - enum 클래스도 값객체다. 특별한 도메인 로직은 존재하지 않지만, 도메인 규칙은 존재하기 때문에 이를 정의하는 용도로 테스트를 작성해보자.
  - 도메인 규칙을 정의해보자.
     1. 2 ~ 9 Rank는 점수로 2 ~ 9를 각각 반환한다.
     2. Ace Rank는 점수로 1을 반환한다.
     3. J, Q, K는 점수로 10을 반환한다.
  - RankTest라는 이름으로 테스트 클래스를 생성하자.
    <br><img width="333" height="68" alt="image" src="https://github.com/user-attachments/assets/3e3173f4-5ac0-4ba5-975e-256275697e73" />
  - 1번 규칙 먼저 테스트를 작성하자.
    <img width="577" height="417" alt="image" src="https://github.com/user-attachments/assets/abaa51d6-69e6-45c5-b0b4-760d5f1a0226" />
  - 이젠 돌려보지 않아도 알겠지만 그래도 테스트를 돌려보자.
    <img width="1165" height="108" alt="image" src="https://github.com/user-attachments/assets/0b59c9f4-5f82-489a-ae6d-9f84b471b92f" />
     - Rank 클래스가 존재하지 않아서 테스트 실패
  - Rank 클래스를 생성하자.
    <br><img width="264" height="63" alt="image" src="https://github.com/user-attachments/assets/00a351fe-ccae-4832-945b-338b39529537" />
  - 테스트 재시도 -> getScore()라는 메서드가 존재하지 않아서 테스트 실패
    <img width="1166" height="113" alt="image" src="https://github.com/user-attachments/assets/8e7af180-d438-4b91-8b39-cc7b40a7dd93" />
  - getScore()메서드를 생성하자.
    <br><img width="334" height="109" alt="image" src="https://github.com/user-attachments/assets/15094481-a7de-4dc3-ad41-19ae5d5e49b1" />
  - 테스트 재시도 -> score 필드가 존재하지 않아서 컴파일 에러 발생
    <img width="1203" height="334" alt="image" src="https://github.com/user-attachments/assets/64d0ca1f-6b9b-4e44-9dc3-b2e923cd0cc6" />
  - 테스트 코드에서 정의한 score 필드를 추가하자.
    <br><img width="355" height="264" alt="image" src="https://github.com/user-attachments/assets/d304c325-41f9-4e27-b530-c3201e9eea74" />
    - score를 final로 설정하여 생성자도 같이 추가했음
  - 테스트 재시도 -> Rank enum 객체가 존재하지 않아서 컴파일 에러 발생
    <img width="1196" height="233" alt="image" src="https://github.com/user-attachments/assets/694178b4-9ed6-40eb-aba8-1272fb03b846" />
  - 테스트에 정의한 Rank enum 객체들을 추가하자.
    <br><img width="353" height="482" alt="image" src="https://github.com/user-attachments/assets/300ba417-0128-432e-acba-bf1f5cb6afc4" />
  - 테스트 재시도 -> 성공!
    <br><img width="310" height="275" alt="image" src="https://github.com/user-attachments/assets/469f09d5-5222-48a4-a089-41548d02a4f7" />
  
  - 2번 규칙(ACE Rank)의 테스트 코드를 작성하자.
    <br><img width="495" height="221" alt="image" src="https://github.com/user-attachments/assets/2755fe7a-4589-47f0-a244-331eac377cff" />
  - 테스트 실행 -> ACE 객체가 없어서 테스트 실패
    <img width="1165" height="107" alt="image" src="https://github.com/user-attachments/assets/6919c828-3d31-40f8-b78c-b45d71d8deb6" />
  - ACE 객체를 추가하자.
    <br><img width="295" height="226" alt="image" src="https://github.com/user-attachments/assets/4e51c03f-00b2-485f-8b0b-6eace2b2032d" />
  - 테스트 재시도 -> 성공!
    <br><img width="313" height="73" alt="image" src="https://github.com/user-attachments/assets/7d7e8bcc-0279-4060-bae0-1e6cded2d03c" />
    
  - 3번 규칙(J, Q, K)의 테스트 코드를 작성하자.
    <br><img width="533" height="243" alt="image" src="https://github.com/user-attachments/assets/f19a7d6e-9c04-4526-a434-757cd230cb3a" />
  - 테스트 실행 -> J, Q, K 객체가 존재하지 않아 테스트 실패
    <img width="1333" height="310" alt="image" src="https://github.com/user-attachments/assets/237d3b8d-13c6-4524-8306-7f7d607d030a" />
  - J, Q, K 객체를 추가하자.
    <br><img width="295" height="265" alt="image" src="https://github.com/user-attachments/assets/cc3db0df-fee4-491a-9178-ac57e45d495d" />
  - 테스트 재시도 -> 성공!
- 이렇게 Card의 숫자를 나타내는 Rank 클래스를 도메인 규칙에 맞게 생성했다. 누군가가 J가 11을 반환하도록 코드를 수정해도 테스트에서 잡아낼 수 있게 되었다.
- +) view에서 각 Rank를 숫자로 표현해야 하는 요구사항을 발견했다. 각 Rank마다 어울리는 format을 반환하도록 필드를 추가하자. (이것은 view를 위한 필드이므로 테스트 코드를 작성하지 않아도 된다고 판단했다. TDD는 로직을 테스트하는 것이지, 값 자체를 테스트하는 것이 아니기 때문)
  <img width="420" height="468" alt="image" src="https://github.com/user-attachments/assets/3812a3d6-5d2d-44fe-aafe-8c2632180e5f" />

- 다음으로 Suit을 생성하자.
  - Suit은 Card의 모양을 나타내는 객체이다. 특별한 도메인 규칙이 존재하지 않고, 단순히 view를 위한 format 필드가 필요하기 때문에 TDD를 진행하지 않고 바로 생성하자.
    <br><img width="378" height="310" alt="image" src="https://github.com/user-attachments/assets/11e4b2c6-8e93-41c2-be1f-b2004dbdd2d3" />

- 다음으로 Rank와 Suit을 필드로 가지는 Card를 생성하자.
  - 테스트를 짜기에 앞서, Card의 도메인 로직이나 규칙이 존재하는지 고민하자.
  - 고민한 결과, 아직 Card의 도메인 로직이 떠오르지 않는다.
  - 도메인 규칙은 Rank와 Suit에서 적용해서 Card에서 따로 적용할 건 없어보이지만, 한 가지 테스트를 해야 한다.
  - 동등성 테스트이다. 기본적으로 Card는 식별자가 존재하지 않고, Rank와 Suit을 기준으로 식별하기 때문에 Rank와 Suit이 같다면 같은 Card로 봐야 한다.
  - 또한 Card는 Rank와 Suit을 파라미터로 받아 생성하도록 할 예정이다.
  - 따라서 두 가지의 테스트 케이스를 짤 수 있다.
    1. Card는 Rank와 Suit으로 생성할 수 있다.
    2. Card는 Rank와 Suit이 같다면 같은 객체이다.
   - 이제 첫 번째 테스트 케이스부터 짜자.
   - CardTest라는 이름의 테스트 클래스를 생성하고 Card 정상 생성 테스트 코드를 짰다.
     <img width="535" height="263" alt="image" src="https://github.com/user-attachments/assets/a311204f-d5f5-408f-bd6b-a489c6bdcd2f" />
   - Card 클래스가 존재하지 않아 컴파일 에러가 발생하므로 Card 클래스를 생성하자.(필드인 Rank와 Suit도 한 번에 만들어줬다.)
     <br><img width="430" height="218" alt="image" src="https://github.com/user-attachments/assets/065cce6a-847d-4ffe-8de2-f1606a9a889a" />
   - 테스트 실행 -> 성공!
     <br><img width="311" height="80" alt="image" src="https://github.com/user-attachments/assets/adda3d76-7388-4613-ab1c-75ba5bebd131" />
   - 이제 두 번째 테스트 케이스를 짜자.
     <br><img width="505" height="223" alt="image" src="https://github.com/user-attachments/assets/f7524b95-6c4a-4ba3-80d2-7d7c8984335e" />
  - 테스트 실행 -> 두 객체가 달라 테스트 실패
    <img width="538" height="146" alt="image" src="https://github.com/user-attachments/assets/0ba18506-3655-4f5e-ac7d-cea4383dde7c" />
    - Card 클래스에서 equals&hashcode를 오버라이딩하지 않아 필드가 같은 두 객체를 같다고 보지 않는다.
  - Card 클래스 내에 equals&hashcode를 오버라이딩하자.
    <img width="578" height="485" alt="image" src="https://github.com/user-attachments/assets/0cf56c5d-784a-4a07-9436-d95fa8daa21e" />
  - 테스트 재시도 -> 성공!
    <br><img width="310" height="73" alt="image" src="https://github.com/user-attachments/assets/c45b5772-f4c9-4667-8e47-c5aaab5ccdba" />

- 이제 Card도 만들었으니, 모든 카드들을 가지고 있는 객체가 필요하다. 이 객체의 이름은 Deck으로 하자.(블랙잭에서 덱은 카드 한 더미를 의미하며, 조커를 제외한 52장의 카드로 구성되어 있음)
- 이 Deck의 역할을 생각해보자.
  1. Deck 초기화(52장의 Card 객체들을 생성하여 가지고 있어야 한다.)
  2. Card 셔플(52장의 Card 객체들을 순서대로 가지고 있는 것이 아니라 섞어야 한다.)
  3. Card 드로우(플레이어와 딜러에게 카드를 한 장씩 나눠줘야 한다.)
  4. Deck에 Card가 없는데 드로우할 경우 예외 처리
- 첫 번째 역할부터 테스트 코드를 짜자.
  - Deck은 처음 생성될 때 52장의 카들르 생성하여 가지고 있어야 한다.
