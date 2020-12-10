## 안드로이드 인스타그램 클론
- This is android instagram clone project.

### 주요기능
#### 1. 처음 화면

![1](https://user-images.githubusercontent.com/53509789/101725256-a551d680-3af3-11eb-9b5c-17d0404c50e7.gif)
- 맨 처음 로고 splash 띄우기 -> 로그인이 되어있는지 확인(jwt token 이용) -> 로그인이 되어있지않으면 로그인페이지 / 로그인이 되어있으면 자동 로그인(메인피드 화면 이동)


#### 2-1. 메인 피드 (가장 최근 반영하여 디자인이 아래 영상들과 약간 상이함.)

![ezgif com-gif-maker (18)](https://user-images.githubusercontent.com/53509789/101725300-b69ae300-3af3-11eb-9661-b6600fd94970.gif) 
![ezgif com-gif-maker (19)](https://user-images.githubusercontent.com/53509789/101725304-b7cc1000-3af3-11eb-8f81-413dcb786f2f.gif)
- recyclerview 이용 피드 나열
- viewpager 이용 사진 여러장 넘기기
- 좋아요 기능 (눌렀을때의 즉각 반영을 위해 변수 따로 생성)
- 댓글 기능


#### 2-2. 메인 피드


![ezgif com-gif-maker (15)](https://user-images.githubusercontent.com/53509789/101725264-aa168a80-3af3-11eb-9e08-34d86523c079.gif) ![ezgif com-gif-maker (16)](https://user-images.githubusercontent.com/53509789/101725272-abe04e00-3af3-11eb-9de8-cfecda285188.gif) ![ezgif com-gif-maker (17)](https://user-images.githubusercontent.com/53509789/101725276-ad117b00-3af3-11eb-838e-45b53994d00a.gif)
- 팔로우 한 user + 자신 피드 나열
- 팔로우 한 user 이름 클릭 시 그 user의 account 페이지로 넘어감 -> 팔로우 취소 -> 메인 피드에서 그 user의 피드 사라짐
- 검색을 통해 가입한 user의 account page 찾기 -> 팔로우 요청 가능
- account page의 피드 클릭시 해당 피드만 확인 가능

#### 3. 본인의 account page

![ezgif com-gif-maker (12)](https://user-images.githubusercontent.com/53509789/101725539-32952b00-3af4-11eb-8d33-800617eba40d.gif)
- 가입시 설정한 프로필 정보 출력
- 프로필에 지정한 웹사이트 클릭시 바로 연결
- 프로필 정보 편집
- 프로필 사진 편집 -> 메인 피드 댓글 작성의 프로필 이미지, bottom navigation의 Circle imageview, 이전 게시물의 프로필 사진 모두 변경


#### 4. 업로드 기능

![ezgif com-gif-maker (9)](https://user-images.githubusercontent.com/53509789/101725504-214c1e80-3af4-11eb-87f4-20b1b3c8f658.gif)
- 사진 :  firebase 이용 저장 -> 이미지 url 받기
- image url , comment 서버에 전송하여 업로드


#### 5. 회원가입

![ezgif com-gif-maker (14)](https://user-images.githubusercontent.com/53509789/101725557-3759df00-3af4-11eb-85fa-4c2ff57f0d50.gif)
- 모든 정보 입력 받아 user account page에 출력
