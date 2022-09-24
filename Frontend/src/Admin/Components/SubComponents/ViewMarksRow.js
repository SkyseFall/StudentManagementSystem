const ViewMarksRow = ({m}) =>{
    return(
        <tr>
            <td>{m.subjectCode}</td>
            <td>{m.subjectName}</td>
            <td>{m.marks}/{m.maxMarks}</td>
            <td>{m.assignmentMarks}/{m.maxAssignmentMarks}</td>
        </tr>
    )
}
export default ViewMarksRow