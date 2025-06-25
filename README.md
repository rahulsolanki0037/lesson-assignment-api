# Lesson Assignment API

API for assigning lessons to students and tracking assignment completion.

---

### 🔹 Assign a Lesson to a Student

**Method**: POST  
**URL**: `/api/assignments`  
**Request Body**:

```json
{
  "teacher_id": "t01",
  "student_id": "s01",
  "lesson_id": "l01"
}
