## 안드로이드 인스타그램 클론 프로젝트

### 주요기능

#### 1. 처음 화면

![ezgif com-gif-maker (9)](https://user-images.githubusercontent.com/53509789/101726543-185c4c80-3af6-11eb-8fcf-7fd817db68dd.gif)
- 맨 처음 로고 splash 띄우기 -> 로그인이 되어있는지 확인(jwt token 이용) -> 로그인이 되어있지않으면 로그인페이지 / 로그인이 되어있으면 자동 로그인(메인피드 화면 이동)



#### 2-1. 메인 피드 (가장 최근 반영하여 디자인이 아래 영상들과 약간 상이함.)

![ezgif com-gif-maker (10)](https://user-images.githubusercontent.com/53509789/101726550-1abea680-3af6-11eb-95c5-4a6ba75997a5.gif) ![ezgif com-gif-maker (11)](https://user-images.githubusercontent.com/53509789/101726555-1c886a00-3af6-11eb-8289-332829d1a2a3.gif)
- recyclerview 이용 피드 나열
- viewpager 이용 사진 여러장 넘기기
- 좋아요 기능 (눌렀을때의 즉각 반영을 위해 변수 따로 생성)
- 댓글 기능



#### 2-2. 메인 피드

![ezgif com-gif-maker (12)](https://user-images.githubusercontent.com/53509789/101726560-1e522d80-3af6-11eb-9d07-0622d0f5b3c6.gif) ![ezgif com-gif-maker (13)](https://user-images.githubusercontent.com/53509789/101726572-227e4b00-3af6-11eb-8053-6afaf873a14f.gif) ![ezgif com-gif-maker (14)](https://user-images.githubusercontent.com/53509789/101726573-24480e80-3af6-11eb-91db-030c4212d047.gif)
- 팔로우 한 user + 자신 피드 나열
- 팔로우 한 user 이름 클릭 시 그 user의 account 페이지로 넘어감 -> 팔로우 취소 -> 메인 피드에서 그 user의 피드 사라짐
- 검색을 통해 가입한 user의 account page 찾기 -> 팔로우 요청 가능
- account page의 피드 클릭시 해당 피드만 확인 가능



#### 3. 본인의 account page

![ezgif com-gif-maker (17)](https://user-images.githubusercontent.com/53509789/101726886-bbad6180-3af6-11eb-88eb-96faf7022aee.gif)
- 가입시 설정한 프로필 정보 출력
- 프로필에 지정한 웹사이트 클릭시 바로 연결
- 프로필 정보 편집
- 프로필 사진 편집 -> 메인 피드 댓글 작성의 프로필 이미지, bottom navigation의 Circle imageview, 이전 게시물의 프로필 사진 모두 변경



#### 4. 업로드 기능

![ezgif com-gif-maker (15)](https://user-images.githubusercontent.com/53509789/101726575-2611d200-3af6-11eb-8b94-dac216e14266.gif)
- 사진 :  firebase 이용 저장 -> 이미지 url 받기
- image url , comment 서버에 전송하여 업로드



#### 5. 회원가입

![ezgif com-gif-maker (16)](https://user-images.githubusercontent.com/53509789/101726581-27db9580-3af6-11eb-8617-3d7ba4f04633.gif)
- 모든 정보 입력 받아 user account page에 출력
