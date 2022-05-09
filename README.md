# JavaProgrammingToyProject


## 📄 프로젝트 정보

- **[프로젝트 명]**  회원관리 프로그램
- **[프로젝트 기간]**  2022/05/02 ~ 2022/05/04
- **[개발 환경]**  Java, SQL, JDBC, H2, IntelliJ, Mac OS
- **[기본 기능]**  회원 목록 조회, 회원 등록, 회원 정보 수정, 회원 삭제
- **[설명]**  무한루프를 돌면서 사용자가 입력한 숫자를 읽어들이고, 숫자에 따라 다양한 기능을 제공. 사용자가 입력한 회원 정보는 DB에 저장하고, 관리하는 프로그램 개발


## 🟧 다이어그램
![](https://velog.velcdn.com/images/wijoonwu/post/a14f93b3-1748-48bd-aa5f-1fe7255549c3/image.png)

## 😺 소스 코드
깃허브 소스코드 : https://github.com/wijoonwu/JavaProgrammingToyProject

## 💻 결과물

![](https://velog.velcdn.com/images/wijoonwu/post/df05157a-6aa2-4266-ba06-c288c97260dd/image.gif)

### (1) 기본 기능

#### 사용자가 1번 입력 : 회원 목록조회
- 회원 목록이 없다면 **_"등록된 회원이 없습니다."_** 

- 회원 목록이 있다면 **_"현재 등록된 회원 목록입니다." + 회원 목록_ **

#### 사용자가 2번 입력 : 회원 신규등록
- 사용자에게 ID, 이름, 휴대폰번호를 입력받고 DB 저장

#### 사용자가 3번 입력 : 회원 정보수정
- 사용자에게 수정할 회원 ID를 입력받고 휴대폰 번호 수정

#### 사용자가 4번 입력 : 회원 삭제
- 사용자에게 삭제할 회원 ID를 입력받고 회원 삭제

### (2) 추가 기능

![](https://velog.velcdn.com/images/wijoonwu/post/800927a1-647a-4aa2-8cac-d06efa2a52fb/image.gif)

- ID, 이름, 휴대폰 번호 미입력 시 _**data + "는 필수 입력 항목입니다."**_


![](https://velog.velcdn.com/images/wijoonwu/post/836bf5c7-f887-4023-a0e6-7ebaf942ed9b/image.gif)

- 회원 등록 시 입력한 ID가 이미 등록되어있다면 _**id + "가 이미 존재합니다."**_

- 회원 수정 시 입력한 ID가 DB에 없다면 **_"수정할 회원 정보가 존재하지 않습니다."_** 

- 회원 삭제 시 입력한 ID가 DB에 없다면 **_"삭제할 회원 정보가 존재하지 않습니다."_** 


![](https://velog.velcdn.com/images/wijoonwu/post/08f2d02b-4119-44fc-a25d-160e0c4a2761/image.gif)

- 입력한 ID가 지정된 형식과 다른 경우 _**"아이디는 'M-'로 시작해야 하며, M-를 포함하여 7개의 문자로 구성해야 합니다."**_ 

- 전화번호가 지정된 형식과 다른 경우 _**"전화번호는 두 개의 '-'를 포함하여 총 13개의 문자로 구성해야 합니다."**_ 



