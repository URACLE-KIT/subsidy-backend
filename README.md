# 보조 알리미(backend)
## 목차 
  - [Introduction](#introduction)
  - [Environment](#environment)
  - [Function](#function)
  - [API](#api)
  - [Demovideo](#demovideo)


## Introduction
1. 보조 알리미는 사용자에게 해당하는 정보를 이용하여 사용자 맞춤 보조금 정보를 볼 수 있는 애플리케이션입니다.

2. 사용자는 로그인을 통해 회원기능을 이용할 수 있으며 카테고리 저장, 후기글 작성, 후기 글 댓글 작성, 스크랩 <br />  등등 기능을 이용할수 있습니다.

3. 카테고리별 사용자 맞춤 보조금 랭킹과 보조금 랭킹순위를 사용하여 사용자는 본인에 해당하는 성별, 연령에  <br /> 맞게 최대 3개의 랭킹별로 순위를 보여주게 됩니다. 


## Environment 
  - spring boot -> version : 2.7.16 (0.0.1-SNAPSHOT) , Gradle
  - Java -> version : 15

## Function
1. **회원 관리**
   1. 회원가입
   2. 회원 정보 수정
   3. 회원 탈퇴
   4. 로그인
   5. 로그아웃
   6. 비밀번호 재설정
   7. 맞춤 카테고리 등록 <br /><br />
   
2. **게시글 관리**
   1. 후기 작성
   2. 후기 조회
   3. 후기 수정
   4. 후기 삭제
   5. 후기 댓글 작성
   6. 후기 댓글 수정
   7. 후기 댓글 삭제 <br /><br />
  
3. **스크랩 관리**
   1. 스크랩 등록
   2. 스크랩 조회
   3. 스크랩 삭제 <br /><br />
  
4. **랭킹 리스트 관리**
   1. 회원 성별에 맞는 카테고리 랭킹  
   2. 회원 연령대에 맞는 카테고리 랭킹 
   3. 이번주 조회수 랭킹 
   4. 회원의 동일 성별 조회수 랭킹
   5. 회원의 동일 연령대 조회수 랭킹
   6. 기혼자 랭킹(기혼인 회원만) <br /><br />



## API 
  - 해당 API는 첫번째 버전임을 알려주기 위해 v1임을 명시하였습니다.
  - 각각의 기능에 맞게 API를 작성하였습니다.
  - v1/users : 유저 
  - v1/subsidies : 보조금 정보 
  - v1/subsidies-review : 보조금 후기 
  - v1/subisidies-scrap : 보조금 스크랩
  - v1/subsidies-reviewcomments : 보조금 후기 댓글
  - v1/subsidiesViewRankings : 보조금 전체 조회 순위
  - v1/subsidiesMaleViewRankings : 보조금 남성 조회 순위
  - v1/subsidiesFemaleViewRankings : 보조금 여성 조회 순위
  - v1/subsidiesCategory : 보조금 카테고리 조회 순위 관련부분은 조회 증가 기능만 있어 따로 API로 명세하지 않았습니다.
<br /><br /><br />

| Index | Method | Uri                                     | Description                                    |
|-------|--------|-----------------------------------------|------------------------------------------------|
| 1     | POST   | v1/users/signin                         | 로그인 (Login)                                  |
| 2     | POST   | v1/users/signup                         | 회원 가입 (Membership Registration)            |
| 3     | PATCH  | v1/users/update                         | 회원 정보 수정 (Member Information Modification) |
| 4     | DELETE | v1/users/delete                         | 회원 탈퇴 (Membership Withdrawal)              |
| 5     | POST   | v1/users/update/password                | 비밀번호 재설정 (Password Reset)               |
| 6     | GET    | v1/users/find/userId                    | 사용자 ID 찾기 (Find user ID)                  |
| 7     | GET    | v1/users/check/email                    | 이메일 중복 확인 (Email Redundant Confirmation) |
| 8     | POST   | v1/users/add-category                   | 사용자 카테고리 추가 (Add User Category)       |
| 9     | DELETE | v1/users/delete-category                | 사용자 카테고리 삭제 (User Category Deletion)  |
| 10    | GET    | v1/users/category-list                  | 사용자 카테고리 조회 (User Category Inquiry)  |
| 11    | GET    | v1/subsidies/all                        | 모든 보조금 조회 (Support Funds All Inquiry) |
| 12    | GET    | v1/subsidies/subsidyId                  | 보조금 ID 조회 (Subsidy ID Inquiry)        |
| 13    | GET    | v1/subsidies/search/title               | 제목으로 검색 (Search by Title)               |
| 14    | GET    | v1/subsidies/search/description         | 내용으로 검색 (Search by Content)             |
| 15    | GET    | v1/subsidies/search/category            | 카테고리 검색 (Category Search)               |
| 16    | PUT    | v1/subsidies/increment-views            | 보조금 조회 증가 (Increase Number of Support Grant Inquiries) |
| 17    | POST   | v1/subsidies-review/create              | 보조금 리뷰 등록 (Subsidy Review Registration) |
| 18    | PATCH  | v1/subsidies-review/update              | 리뷰 수정 - 지원 리뷰 수정 (Reviews Update - Grants Reviews Update) |
| 19    | DELETE | v1/subsidies-review/delete              | 리뷰 삭제 - 자산 (Delete Review - Asset)     |
| 20    | GET    | v1/subsidies-review/search/userId       | 보조금 사용자 리뷰 조회 (Search for Support User Reviews) |
| 21    | GET    | v1/subsidies-review/search/subsidyId    | 리뷰 조회 (Search Reviews by Grant ID)       |
| 22    | GET    | v1/subsidies-review/search/reviewId     | ID로 조회 (Search Reviews by Review ID)      |
| 23    | GET    | v1/subsidies-review/all                 | 모든 지원 자금 리뷰 조회 (View All Support Fund Reviews) |
| 24    | PUT    | v1/subsidies-review/increment-views     | 지원 리뷰 조회 증가 (Increase in Support Review Views) |
| 25    | PUT    | v1/subsidies-review/increment-likes     | 리뷰 좋아요 증가 (Increase Review Likes - Grants Reviews Increase) |
| 26    | POST   | v1/subsidies-scrap/create               | 보조금 스크랩 등록 (Subsidy Scrap Registration) |
| 27    | DELETE | v1/subsidies-scrap/delete               | 스크랩 삭제 (Scrap Deletion)                 |
| 28    | GET    | v1/subsidies-scrap/find/subsidyinfo    | 보조금 스크랩 사용자 스크랩 조회 (Subsidy Scrap User Scrap Search) |
| 29    | POST   | v1/subsidy-reviewcomments/create        | 보조금 리뷰 코멘트 등록 (Subsidy Review Comment Registration) |
| 30    | PATCH  | v1/subsidy-reviewcomments/update        | 보조금 리뷰 코멘트 수정 (Review Review Comments Update) |
| 31    | DELETE | v1/subsidy-reviewcomments/delete        | 보조금 리뷰 코멘트 삭제 (Review Review Comments Deleted) |
| 32    | GET    | v1/subsidy-reviewcomments/search/userId | 보조금 코멘트 사용자 코멘트 조회 (Review Comment User Comment Search) |
| 33    | GET    | v1/subsidy-reviewcomments/search/subsidyReviewId | 보조금 리뷰 코멘트 검색 (Subsidy Review Comments Subsidy Comment Search) |
| 34    | GET    | v1/subsidy-reviewcomments/all           | 모든 보조금 리뷰 코멘트 조회 (View All Support Review Comments) |
| 35    | GET    | v1/subsidyViewRankings/create           | 보조금 조회 순위 생성 (Create Ranking of Support Grant Views) |
| 36    | POST   | v1/subsidyViewRankings/increment-views  | 보조금 조회 수 증가 (Increased Number of Support Grant Views) |
| 37    | GET    | v1/subsidyViewRankings/top-3-subsidy-info | 보조금 조회 순위 정보 (Ranking Information on Support Grant Views) |
| 38    | GET    | v1/subsidyMaleViewRankings/create       | 보조금 남성 조회 수 순위 생성 (Generate Support Male View Count Ranking) |
| 39    | POST   | v1/subsidyMaleViewRankings/increment-views | 보조금 남성 조회 순위 조회 증가 (Increase in Number of Support Male Ranking Views) |
| 40    | GET    | v1/subsidyMaleViewRankings/subsidyRanking_Info | 보조금 조회 남성 순위 TOP 3 (Top 3 Support Male Views Ranking) |
| 41    | GET    | v1/subsidyFemaleViewRankings/create     | 보조금 여성 조회 순위 생성 (Generate Support Ranking for Women's Views) |
| 43 | GET | v1/subsidyFemaleViewRankings/subsidyRanking_Info | 보조금 여성 조회 순위 TOP 3 (Grants) |

## Demovideo
  - https://youtu.be/czUIvmaSM90
