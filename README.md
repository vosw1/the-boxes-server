# Project

Java를 이용해서 만드는 간단 재고  Server

- Intelli J 로 개발
- Java 사용
- Local Storage를 이용한 데이터 관리
- Geolocation API, Weather API 사용
- 화면 비율에 따른 화면 구성
  
---

# Tech Stack
|Tech|Content|
| :-------: | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Framework** | ![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white) ![Spring Boot](https://img.shields.io/badge/-Spring%20Boot-brightgreen?logo=spring&logoColor=white) ![HTML](https://img.shields.io/badge/-HTML5-E34F26.svg?style=flat&logo=html5&logoColor=white) ![JPA](https://img.shields.io/badge/JPA-7F5C5C.svg?style=flat&logo=spring&logoColor=white) ![JSON](https://img.shields.io/badge/json-0078D4.svg?style=flat&logo=json&logoColor=white) ![Rest API](https://img.shields.io/badge/RestAPI-0A0A0A.svg?style=flat&logo=restapi&logoColor=white) |
|    **DB**    | ![H2](https://img.shields.io/badge/H2-0073C6.svg?style=flat&logo=h2&logoColor=white) |
|   **Tools**   | ![IntelliJ](https://img.shields.io/badge/-IntelliJ-FF2D54?logo=intellij-idea&logoColor=white) ![Notion](https://img.shields.io/badge/-Notion-000000.svg?style=flat&logo=notion&logoColor=white) ![Git](https://img.shields.io/badge/-Git-F05032.svg?style=flat&logo=git&logoColor=white)  |

---

# Service

| 아이디 중복체크 및 회원가입 및 토큰 생성 | 로그인 및 토큰 생성 |
|:-----------------:|:-------------------:|
| <p align="center"><img src="https://github.com/user-attachments/assets/65808c81-60fb-4ff2-a55f-2e22658c41c8" width="400" height="300"/></p> | <p align="center"><img src="https://github.com/user-attachments/assets/df0d4111-6773-4d33-8d08-baaeca10b42e" width="400" height="300"/></p> |
| 품목 추가하기 | 품목 수정하기 |
| <p align="center"><img src="https://github.com/user-attachments/assets/e9a7aaab-8407-430a-81d3-39e70e218502" width="400" height="300"/></p> | <p align="center"><img src="https://github.com/user-attachments/assets/a2b3aba4-3e3a-4445-ad36-305c9595a3b6" width="400" height="300"/></p> |
| 재고 조회하기 | 입고 |
| <p align="center"><img src="https://github.com/user-attachments/assets/bf2297a4-383a-484d-b293-fc9373d439b3" width="400" height="300"/></p> | <p align="center"><img src="https://github.com/user-attachments/assets/142c5ca9-83b5-4189-b0e5-b0b1c0dff5b7" width="400" height="300"/></p> |
| 출고 | 히스토리 전체 조회 |
| <p align="center"><img src="https://github.com/user-attachments/assets/a92fcac0-b78f-494b-85d8-989f35a90150" width="400" height="300"/></p> | <p align="center"><img src="https://github.com/user-attachments/assets/c2060063-d0e8-4f8a-b45c-539f2a5ca381" width="400" height="300"/></p> |
| 히스토리 날짜 조회 | 히스토리 날짜 범위 조회 |
| <p align="center"><img src="https://github.com/user-attachments/assets/bdbd09f9-cbd0-41a6-89c4-a3af3286326e" width="400" height="300"/></p> | <p align="center"><img src="https://github.com/user-attachments/assets/e45dc4c7-3553-4c2d-97e8-2de9b524c398" width="400" height="300"/></p> |
| 히스토리 사용중 조회 | 히스토리 사용중단 조회 |
| <p align="center"><img src="https://github.com/user-attachments/assets/4da927f5-fe64-4862-a9b2-fea75aa090b5" width="400" height="300"/></p> | <p align="center"><img src="https://github.com/user-attachments/assets/f4559eba-8175-43f0-8587-08d4e5223b0e" width="400" height="300"/></p> |

---

#  Features implemented by me
| 테이블 설계 | 기능 | 테스트 |
|:--:|:---------------:|:---------------:|
|사용자<br/>품목<br/>입출고<br/>재고<br/>히스토리|패키지 구성<br/>품목 추가, 수정, 삭제<br/>품목 상태별(사용중인지 아닌지) 조회<br/>히스토리 날짜, 기간, 상태별(사용중인지 아닌지)  조회<br/>입고 수, 출고 수에 따른 과거 재고수, 현재 재고수 자동 적용|POSTMAN|
