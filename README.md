___
## API Features Overview
1. **Authentication management endpoints:**
    * Available for everybody:\
      ```POST: /api/auth/register``` - registers a new user.\
      ```POST: /api/auth/login``` - sign in for existing user.
2. **Course management endpoints:**
    * User available:\
      ```GET: /api/courses/all```  - retrieves all user`s courses.\
      ```GET: /api/courses/{id}``` - retrieves course by id.\
      ```POST: /api/courses/add``` - add course.
      ```POST: /api/courses/add/{id}``` - add task to course.\
      ```PATCH:  /api/courses/{id}``` - updates course.\
      ```DELETE: /api/courses/{id}``` - deletes course.
3. **Default Course management endpoints:**
    * User available:\
      ```GET: /api/default-course/all``` - retrieves all default courses.\
4. **Task cart management endpoints:**
    * User available:\
      ```POST:   /api/tasks``` - add task.\
      ```GET:    /api/tasks``` - retrieves all user`s tasks.\
      ```PATCH:  /api/tasks/{id}``` - updates task.\
      ```DELETE: /api/tasks/{id}``` - deletes task.
5. **User Profile management endpoints:**
   * User available:\
     ```GET:    /api/user-profile``` - retrieves user profile info.\
