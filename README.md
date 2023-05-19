# API

### 자녀 페이지 링크 설정 값 받기

* GET /childrens/{id}
* Response: [선물 리스트(id, 이미지 url)], [교육 영상(동영상 id, 동영상 길이)]

### 자녀 페이지 링크 설정 값 추가 or 수정

* PUT /childrens/{id}
* Request: [선물 리스트(id, 이미지 url)], [교육 영상(동영상 id)]
* Response: 204
