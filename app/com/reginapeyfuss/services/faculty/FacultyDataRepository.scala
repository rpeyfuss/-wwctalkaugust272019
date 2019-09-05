package com.reginapeyfuss.services.faculty

trait FacultyDataRepository {

    def getFaculty(facultyName: FacultyType): List[Faculty]

    def saveFaculty(facultyObj: Faculty): List[Faculty]

    def getAllFaculty: List[Faculty]
}

object FacultyDataRepository {
    //this would/could come from a db or from somewhere else
    val faculty: List[Faculty] = List(
        Teacher("1000","Josh", "Griffin", "josh.griffin@example.com", 200008, "Social Studies",
            "Social Studies Teacher", "Teacher"),
        Teacher("1001","Angela", "Markel", "angela.markel@example.com", 200008, "Language Arts",
            "Language Arts Teacher", "Teacher"),
        Teacher("1002","Joe", "Smith", "joe.smith@example.com", 200008, "Mathematics",
            "Algebra I Teacher", "Teacher"),
        Administrator("1003","Josh", "Griff", "josh.griff@example.com", 200008, "Administrator",
            "Assistant Principal", "Administrator"),
        Administrator("1003","Alex", "Dejonero", "alex.dejonero@example.com", 200008, "Administrator",
            "Assistant Principal", "Administrator")
    )
}
