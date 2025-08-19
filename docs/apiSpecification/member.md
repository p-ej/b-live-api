# 회원 API 명세서

- 버전: v1
- 기본 URL: https://api.example.com/v1
- 인증: Bearer Token

## 1. 카카오 로그인

## 1. 회원정보 조회
- **URL:** `/members/me`
- **Method:** `GET`
- **Query Parameters:**

## 2. 회원정보 수정
- **URL:** `/members`
- **Method:** `PATCH`
- **Query Parameters:**
- **Request Body:**
```json
{
  
}
```

## 3. 회원탈퇴
- **URL:** `/members`
- **Method:** `DELETE`
- **Query Parameters:**

## 4. 로그아웃
- **URL:** `/logout`
- **Method:** `POST`
- **Query Parameters:**

## 5. 내 코스 조회
- **URL:** `members/me/courses/`
- **Method:** `GET`
- **Query Parameters:**

## 6. 대표 설정
- **URL:** `members/me/courses/{memberCourseId}/representative`
- **Method:** `PATCH`
- **Query Parameters:**


## 7. 코스 이름 수정
- **URL:** `members/me/courses/{memberCourseId}`
- **Method:** `PATCH`
- **Query Parameters:**
- **Request Body:**
```json
{
  "name": "newName"
}
```

## 8. 코스 삭제
- **URL:** `members/me/courses/{memberCourseId}`
- **Method:** `DELETE`
- **Query Parameters:**

## 9. 여행 기록 저장
- **URL:** `members/me/courses/{memberCourseId}/feedback`
- **Method:** `POST`
- **Query Parameters:**
```json
{
  "feedback": "feedback"
}
```

## 10. 여행 기록 수정
- **URL:** `members/me/courses/{memberCourseId}/feedback`
- **Method:** `PATCH`
- **Query Parameters:**
```json
{
"feedback": "feedback"
}
```

## 11. 가고싶은 곳

## 12. 나의 리뷰

## 13. 코스 상세 조회

## 14. 코스 이어가기


[index](../index.md)