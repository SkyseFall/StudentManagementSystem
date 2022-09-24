import axios from "axios"
import { useState } from "react"
import { useHistory } from "react-router"

const StudentAttendanceRow = ({s}) =>{
    const [status,setStatus] = useState("A")
    const url = "http://localhost:8080"
    const history = useHistory()

    const PresentStudent = () =>{
        const body = {
            "studentId":s.studentId,
            "attendanceStatus":"P"
        }
        axios.post(url+"/studentAttendance/addAttendance",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                window.alert("Student "+s.studentName+" is present")
                history.push('/AdminHome')
            }
        })
    }
    const AbsentStudent = () =>{
        const body = {
            "studentId":s.studentId,
            "attendanceStatus":"A"
        }
        axios.post(url+"/studentAttendance/addAttendance",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                window.alert("Student "+s.studentName+" is Absent")
                history.push('/AdminHome')
            }
        })
    }
    return (
        <tr>
            <td>{s.studentId}</td>
            <td>{s.studentName}</td>
            <td>{s.section}</td>
            <td>
                <button className="button-small" value="P" onClick={PresentStudent}>Present</button>
            </td>
            <td>
                <button className="button-delete"  value="A" onClick={AbsentStudent}>Absent</button>
            </td>
        </tr>
    )
}
export default StudentAttendanceRow