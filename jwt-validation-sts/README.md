# JWT Validation Demo (Spring Boot / STS)

## Requirements
- Java 17
- Spring Tool Suite (STS) with Maven support

## Import into STS
1. Extract `jwt-validation-sts.zip`.
2. Open STS.
3. Select **File -> Import -> Maven -> Existing Maven Projects**.
4. Browse to the extracted `jwt-validation-sts` folder.
5. Select `pom.xml`, then click **Finish**.
6. Wait for Maven dependencies to download.
7. Run `DemoApplication.java` as **Spring Boot App**.

## application.properties
The project uses port `8080`. It reads the JWT signing key from `JWT_SECRET`.
A demo key is supplied as a fallback so the project runs immediately. Do not use
that demo key in a real application. Set a private Base64-encoded key of at least
32 bytes in the `JWT_SECRET` environment variable.

## Test

### 1. Generate a demo token
Send this request using Postman:

`POST http://localhost:8080/auth/token`

Header:
`Content-Type: application/json`

Body (raw JSON):
```json
{"username":"Pavan"}
```

Copy the `token` value from the JSON response.

### 2. Access the protected resource
Send:

`GET http://localhost:8080/profile`

Header:
`Authorization: Bearer YOUR_COPIED_TOKEN`

Expected response:
`Welcome Pavan`

### 3. Invalid or missing token
- Change one or more characters in the token: response is `401 Unauthorized`.
- Remove the Authorization header: response is `401 Unauthorized`.

## How it works
- `JwtFilter` reads the Bearer token from the Authorization header.
- `JwtService` verifies the HMAC signature and token expiration.
- If valid, the username (JWT subject) is extracted and placed on the request.
- The `/profile` controller returns the extracted username.

## Important
The `/auth/token` endpoint is for classroom demonstration only. It does not
authenticate a password. In a real application, authenticate the user first,
store the signing key securely, and use HTTPS.
