## 설명

```
이 프로젝트는 jwt 기초 설계를 생성하고 이해를 도울수있는 간단한 Spring Security with jwt 프로젝트 입니다.
누구나 쉽게 따라 할수 있습니다.
```

## Postman

### 가입
```
POST /api/signup

{
    "userName": {user ID},
    "password": {user Password},
    "nickName": {user NickName}
}
```

### 로그인

```
POST /api/authenticate

{
    "username": {login ID},
    "password": {login Password}
}
```

### 유저검색

```
GET /api/user

토큰 정보가 필요하므로 로그인 API에서 받은 토큰을 헤더에 담고 진행해야합니다. (Postman Tests 이용)

```

