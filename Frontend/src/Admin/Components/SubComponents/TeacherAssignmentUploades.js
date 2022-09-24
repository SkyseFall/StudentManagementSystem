const TeacherAssignmentUploades = ({r}) =>{
    const url = "http://localhost:8080"
    return(
        <tr>
            <td>{r.std}</td>
            <td>{r.assignmentId}</td>
            <td>{r.subjectCode}</td>
            <td>{r.subjectName}</td>
            <td>{r.assignmentDue}</td>
            <td>{r.submissionTime}</td>
            <td><a href={url+"/teacherAssignment/"+r.addedAssignment} target="_blank">Download</a></td>
        </tr>
    )
}
export default TeacherAssignmentUploades