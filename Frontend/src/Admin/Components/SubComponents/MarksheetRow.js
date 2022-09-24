const MarksheetRow = ({m}) =>{
    return(
       
        <tr>
            <td>{m.subjectCode}</td>
            <td>{m.subjectName}</td>
            <td><b>{m.marks}</b>/{m.maxMarks}</td>
            <td><b>{m.assignmentMarks}</b>/{m.maxAssignmentMarks}</td>
            <td><b>{m.status}</b></td>
        </tr>
    
    )
}
export default MarksheetRow