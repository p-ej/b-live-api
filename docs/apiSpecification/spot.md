# 여행지 API 명세서

- 버전: v1
- 기본 URL: https://api.example.com/v1
- 인증: Bearer Token

## 1. 현재 위치 기반 여행지 조회

- **URL:** `/spots`
- **Method:** `GET`
- **Query Parameters:**

| Name      | Type  | Required | Description        |
|-----------|-------|----------|--------------------|
| latitude  | float | Yes      | 사용자 위치 위도          |
| longitude | float | Yes      | 사용자 위치 경도          |
| radius    | int   | No       | 검색 반경 (m), 기본 1000 |

## 2. 인기 여행지 조회
- **URL:** `/spots/popular`
- **Method:** `GET`
- **Query Parameters:**

[index](../index.md)