![header](https://capsule-render.vercel.app/api?type=rounded&color=gradient&height=200&section=header&text=MovieHub&fontSize=60)

## 프로젝트 소개
> 영화에 대한 평점을 기록하고 유저 간 소통할 수 있는 영화 커뮤니티 사이트 ***MovieHub*** 입니다.  
> 왓챠피디아를 참고하여 UI를 구현했고 TMDB의 API를 활용했습니다.

***Notion***   [MovieHub Notion](https://javanote.notion.site/MovieHub-6ab8cd9ceabb4ab8a7d5f23075efd4a3?pvs=4)  
***Tistory***   [MovieHub Tistory](https://catbeom.tistory.com/67)
  
<br/>    

개발 환경
---
![](https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white)  
<br/>    

기술 스택
---
**Frontend**

![html](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white
) ![css](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white) ![js](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=JavaScript&logoColor=white) ![bootstrap](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)

**Backend**

![spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white) ![java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) ![jQuery](https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white) ![Git](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white
)
<br/><br/> 

## 구현 기능
- 계정 관련
     - 로그인, 로그아웃, 회원가입, 회원탈퇴
  
     - 관리자 페이지를 통한 영화 조회, 유저 관리, 코멘트/댓글 삭제 및 상세 검색 기능
  
- 코멘트
     - 코멘트 CRUD
  
     - 댓글, 대댓글 CRUD
  
     - 유저의 코멘트 내용 검색
  
     - 최신순, 댓글순, 조회수 순 정렬
  
- 평점
     - 코멘트와 별개로 별점으로 평가 가능(0.5점~5.0점)
  
- 영화 관련
     - 키워드와 일치하는 영화 검색
  
- 마이 페이지
     - 내가 남긴 평점, 코멘트 리스트 확인
  
     - 캘린더 기능
<br/>

## 주요 기능 구현 화면

![0 회원가입](https://github.com/seungHee-cat/MovieHub/assets/141723511/05fa1b35-c2a5-4716-89d6-98710ee35309)
AJAX를 통해 유효성 검사 후 회원가입 할 수 있는 회원가입 모달 창 입니다.

![1 영화_검색](https://github.com/seungHee-cat/MovieHub/assets/141723511/6299e8d2-927b-4312-93e0-174b4e43580c)
AJAX를 이용해 일치하는 키워드의 영화를 검색할 수 있는 검색 기능입니다.

![4 코멘트_댓글](https://github.com/seungHee-cat/MovieHub/assets/141723511/6a90cdfb-0fbd-416d-ae1d-0d1c6f0cc72f)
영화의 코멘트에 댓글 남길 수 있는 댓글창입니다.  
자신의 댓글은 맨 상단에 고정되어 확인 가능하고 수정, 삭제가 가능합니다.

![5 코멘트_대댓글](https://github.com/seungHee-cat/MovieHub/assets/141723511/cb476445-ad97-4774-bcb2-99a7aefe842a)
다른 사용자의 댓글에 의견을 남길 수 있는 대댓글 기능입니다.  
한 댓글 당 여러개의 대댓글을 달 수 있습니다.

![7 관리자_페이지](https://github.com/seungHee-cat/MovieHub/assets/141723511/a0f84f4f-8914-4960-a7f9-35a91e637e81)
기본적인 삭제 기능만 간단하게 구현한 관리자 페이지입니다.






