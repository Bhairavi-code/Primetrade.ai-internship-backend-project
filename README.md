# Internship Backend Project

## Features
- ✅ User registration & login with JWT authentication
- ✅ Role-based access control (USER: create/read, ADMIN: update/delete)
- ✅ CRUD APIs for tasks
- ✅ API versioning ('/api/v1/tasks')
- ✅ Validation & global error handling
- ✅ API documentation via Postman collection

## Setup
1. Clone the repository:
   git clone https://github.com/<your-username>/internship-backend-project.git
2. Navigate into the project folder:
   cd internship-backend-project
3. Run the application:
   mvn spring-boot:run
4. Backend runs at:
   http://localhost:8083
   
--------------------------------------------------------------------------------
📃 API Documentation :-

  Import the file Internship_Backend.postman_collection.json into Postman.
  
  The collection includes:
  
  ✅ Register User/Admin  
      POST /api/auth/register  
      Example body:
      json
      { "username": "bhairavi", "password": "mypassword", "role": "USER" }
  
  ➡️ Login → Get JWT  
      POST /api/auth/login  
      Example body:
      json
      { "username": "bhairavi", "password": "mypassword" }
      Response:
      json
      { "token": "eyJhbGciOi..." }
  
  ➕ Create Task (USER role)  
      POST /api/v1/tasks  
      Headers: Authorization: Bearer <token>  
      Example body:
      json
      { "taskName": "Shopping", "description": "Buy groceries" }
  
  👓 Read Tasks (USER role)  
      GET /api/v1/tasks  
      Headers: Authorization: Bearer <token>
  
  🔁 Update Task (ADMIN role)  
      PUT /api/v1/tasks/{id}  
      Headers: Authorization: Bearer <admin_token>  
      Example body:
      json
      { "taskName": "Shopping", "description": "Buy groceries and cleaning supplies" }
  
  ❌ Delete Task (ADMIN role)  
      DELETE /api/v1/tasks/{id}  
      Headers: Authorization: Bearer <admin_token>

---------------------------------------------------------------------------------
📊 Database :-

  Using MySQL/Postgres with JPA/Hibernate
  Task entity fields:
  id (primary key)
  taskName (string, required)
  description (string)

---------------------------------------------------------------------------------
♐ Scalability Note :-

  This backend can be extended into a production‑ready system:
  Split into microservices for auth and task management
  JWT authentication scales horizontally across services
  Add caching (Redis) for performance
  Containerize with Docker for deployment
