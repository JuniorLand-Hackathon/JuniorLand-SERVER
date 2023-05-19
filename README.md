# API
요청 도메인은 비밀!

### 자녀 페이지 링크 설정 값 받기

* GET /childrens/{id}
* Response: [선물 리스트(id, 이미지 url)], [교육 영상(동영상 id, 동영상 길이)]
* <img width="908" alt="image" src="https://github.com/JuniorLand-Hackathon/JuniorLand-SERVER/assets/93072571/bb419a37-2bc2-479a-842b-5844f4bf9f27">


### 자녀 페이지 링크 설정 값 추가 or 수정

* PUT /childrens/{id}
* Request: [선물 리스트(id, 이미지 url)], [교육 영상(동영상 id)]
* Response: 204
* ![image](https://github.com/JuniorLand-Hackathon/JuniorLand-SERVER/assets/93072571/70d01a70-4ea9-47ed-aa31-fd9777e9e35a)
