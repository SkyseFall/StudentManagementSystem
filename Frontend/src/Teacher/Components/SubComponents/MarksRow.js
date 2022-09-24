import axios from "axios"
import { useEffect, useState } from "react"
import { useHistory } from "react-router"

const MarksRow = ({s}) =>{
    const [marks,setMarks] = useState(s.marks)
    const [aMarks,setAMarks] = useState(s.assignmentMarks)
    const url = "http://localhost:8080"
    const history = useHistory()

    const addMarks = () =>{
        const body ={
            "studentId":s.studentId,
            "studentName":s.studentName,
            "rollNo":s.rollNo,
            "subjectCode":s.subjectCode,
            "marks":marks,
            "maxMarks":s.maxMarks,
            "assignmentMarks":aMarks,
            "maxAssignmentMarks":s.maxAssignmentMarks
        }
        axios.post(url+"/marks/addMarks",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                window.alert("Marks added successfully")
                history.push("/TeacherHome")
            }
        })
    }
    return (
        <tr>
            <td>{s.studentName}</td>
            <td>{s.rollNo}</td>
            <td>{s.marks}/{s.maxMarks}</td>
            <td>{s.assignmentMarks}/{s.maxAssignmentMarks}</td>
            <td>
                <input type="number" onChange={e=>{setMarks(e.target.value)}} />
            </td>
            <td>
                <input type="number" onChange={e=>{setAMarks(e.target.value)}} />
            </td>
            <td id="submission">
                <a href={url+"/teacherAssignment/"+s.assignmentSolution} target="_blank">Download</a>
            </td>
            <td >
                {s.submissionTime}
            </td>
            <td>
                <button className="button-add"  onClick={addMarks}>ADD</button>
            </td>
        </tr>
    )
}
export default MarksRow