import axios from "axios"
import { useEffect, useState } from "react"

const ViewTeacherAttendance = () =>{

    const [teacherList,setTeacherList] = useState([])
    const [teacher,setTeacher] = useState(0)
    const [attendanceList,setAttendanceList] = useState([])
    const [percentage,setPercentage] = useState(0)
    const url = "http://localhost:8080"

    useEffect(() =>{
        getAllTeachers()
    },[])

    const getAllTeachers = () =>{
        axios.post(url+"/teacher/all").then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setTeacherList(result.data)
            }
        })
    }

    const getAttendance = () =>{
        if(teacher == 0){
            window.alert("Please Select the teacher")
        }else{
            const body ={
                "teacherId":teacher
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
    }

    return (
        <div className="container">
            <br/>
            Select Teacher : 

            <select onChange={e=>{setTeacher(e.target.value)}}>
            <option value={0}>None</option>
            {                    
                teacherList.map((t) =>{
                return (
                    <option value={t.teacherId}>Id:{t.teacherId} - {t.teacherName}</option>
                    )
                })
            }
            </select>
                <button className="button-show" onClick={getAttendance}>Show Attendance</button>
                <br/><br/>
            <table class="table">
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