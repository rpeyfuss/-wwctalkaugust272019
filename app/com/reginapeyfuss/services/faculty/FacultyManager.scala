package com.reginapeyfuss.services.faculty

import com.reginapeyfuss.services.faculty.FacultyDataRepository.faculty
import com.reginapeyfuss.services.utilities.FacultyUtilities


class FacultyManager extends FacultyDataRepository {

    def getFaculty(facultyName: FacultyType): List[Faculty] = {
        faculty.filter(p => FacultyUtilities.parseFacultyType(p.facultyType) == facultyName)
    }

    def saveFaculty(facultyObj: Faculty): List[Faculty] = facultyObj :: faculty

    def getAllFaculty: List[Faculty] = faculty
}
