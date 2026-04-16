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
