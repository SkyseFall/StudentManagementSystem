import axios from "axios"
import { useHistory } from "react-router"

const TeacherAttendanceRow = ({t}) =>{
    const url = "http://localhost:8080"
    const history = useHistory()
    const PresentTeacher = () =>{
        const body = {
            "teacherId":t.teacherId,
            "attendanceStatus":"P"
        }
        axios.post(url+"/teacherAttendance/addAttendance",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                window.alert("Teacher "+t.teacherName+" is present")
                history.push('/AdminHome')
            }
        })
    }

    const AbsentTeacher = () =>{
        const body = {
            "teacherId":t.teacherId,
            "attendanceStatus":"A"
        }
        axios.post(url+"/teacherAttendance/addAttendance",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                window.alert("Teacher "+t.teacherName+" is absent")
                history.push('/AdminHome')
            }
        })
    }
    return(
        <tr>
            <td>{t.teacherId}</td>
            <td>{t.teacherName}</td>
            <td>{t.designation}</td>
            <td>
                <button className="button-small" value="P" onClick={PresentTeacher} >Present</button>
            </td>
            <td>
                <button className="button-delete" value="A" onClick={AbsentTeacher}>Absent</button>
            </td>
        </tr>
    )
}
export default TeacherAttendanceRow