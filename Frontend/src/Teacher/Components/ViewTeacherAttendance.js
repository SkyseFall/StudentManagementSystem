import axios from "axios"
import { useEffect, useState } from "react"

const ViewTeacherAttendance = (props) =>{
    const userId = props.location.aboutProps.id.user
    const [attendanceList,setAttendanceList] = useState([])
    const [percentage,setPercentage] = useState(0)
    const url = "http://localhost:8080"

    useEffect(() =>{
        getAttendance()
    },[])

    const getAttendance = () =>{
            const body ={
                "teacherId":userId
            }
            axios.post(url+"/teacherAttendance/getAttendance",body).then(Response =>{
                const result = Response.data
                if(result.status == "success"){
                    setAttendanceList(result.data)
                    setPercentage(result.percentage)
                }else{
                    window.alert(result.error)
                    setAttendanceList([])
                    setPercentage("Not Available")
                }
            })
    }

    return (
        <div className="container"><h4>TeacherAttendance </h4>
            <br/>
            <table className="table">
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                {                    
                    attendanceList.map((a) =>{
                    return (
                        <tr>
                            <td>{a.date}</td>
                            <td>{a.status}</td>
                        </tr>
                    )
                    })
                }
                </tbody>
            </table>
            <br/><br/>
            <br/><br/>
            <br/><br/>
            Present Percentage = <b>{percentage}</b>%
            <br/><br/>
            <br/><br/>
            <br/><br/>
            <br/><br/>
        </div>
    )
}
export default ViewTeacherAttendance