# SkillSync API Postman Collection

This folder contains the Postman collection for testing the SkillSync API endpoints.

## 📁 Files

- `SkillSync_API.postman_collection.json` - Complete Postman collection with all API endpoints

## 📥 How to Import

1. Open Postman
2. Click "Import" button
3. Select the `SkillSync_API.postman_collection.json` file
4. The collection will be imported with all endpoints organized in folders

## 🚀 Features

### Automatic JWT Token Management

- Login requests automatically save JWT tokens
- All protected endpoints use the saved token automatically
- No manual token copying required

### Organized Endpoint Folders

- **Authentication** - Register and login endpoints
- **Test Endpoints** - Various authentication test scenarios
- **Admin Endpoints** - Admin-only routes (`@PreAuthorize("hasRole('ADMIN')")`)
- **Freelancer Endpoints** - Freelancer-only routes (`@PreAuthorize("hasRole('FREELANCER')")`)
- **Client Endpoints** - Client-only routes (`@PreAuthorize("hasRole('CLIENT')")`)

### Pre-configured Variables

- `{{base_url}}` = `http://localhost:8080`
- `{{jwt_token}}` = Automatically managed JWT token

## 🧪 Testing Workflow

1. **Register Users** (if needed):

   ```json
   {
     "username": "testuser",
     "email": "test@example.com",
     "password": "password123",
     "role": "FREELANCER"
   }
   ```

2. **Login** (token auto-saves):

   - Admin: `username: admin`, `password: admin`
   - Test User: Use credentials from registration

3. **Test Role-Based Access**:

   - Try accessing admin endpoints with different user roles
   - Observe 403 Forbidden responses for unauthorized access

4. **Switch Between Users**:
   - Login with different credentials
   - Token automatically updates for the new user

## 📋 Available Roles

- **ADMIN** - Can access all endpoints
- **FREELANCER** - Can access freelancer endpoints and user-only endpoints
- **CLIENT** - Can access client endpoints and user-only endpoints

## 🔗 Endpoint Summary

### Public Endpoints (No Auth Required)

- `POST /api/auth/register` - User registration
- `POST /api/auth/login` - User login
- `GET /api/hello` - Hello world

### Protected Endpoints (JWT Required)

- `GET /api/test/protected` - Any authenticated user
- `GET /api/test/authenticated` - Any authenticated user
- `GET /api/test/user-only` - FREELANCER or CLIENT roles
- `GET /api/test/admin-only` - ADMIN role only

### Role-Specific Endpoints

- `GET /api/admin/*` - ADMIN role only
- `GET /api/freelancer/*` - FREELANCER role only
- `GET /api/client/*` - CLIENT role only

## 🛠️ Backend Setup

Make sure your SkillSync backend is running on `http://localhost:8080` before testing the collection.

```bash
docker-compose up -d
```
