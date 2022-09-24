import { useHistory } from "react-router";

const TeacherAssignmentUploades = ({r}) =>{
    const url = "http://localhost:8080"
    const histroy = useHistory();

    const uploadAssignmentSolution = () =>{
       histroy.push({
                        pathname:'/uploadSolution',
                        search: '?query=abc',
                        state: r
                    }) 
    }

    return(
        <tr>
            <td>{r.assignmentId}</td>
            <td>{r.subjectCode}</td>
            <td>{r.subjectName}</td>
            <td>{r.assignmentDue}</td>
            <td>{r.submissionTime}</td>
            <td><a href={url+"/teacherAssignment/"+r.addedAssignment} target="_blank">Download</a></td>
            <td>
            <button className="button-show" onClick={uploadAssignmentSolution}>Upload Solution</button>
            </td>

        </tr>
    )
}
export default TeacherAssignmentUploades